package com.ohjelmisto.web;

import java.io.IOException;
import java.util.stream.Collectors;


import com.ohjelmisto.domain.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ohjelmisto.storage.StorageFileNotFoundException;
import com.ohjelmisto.storage.StorageService;
import com.ohjelmisto.domain.AddMusicForm;
import com.ohjelmisto.domain.Music;

import javax.validation.Valid;

@Controller
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    private MusicRepository repository;
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/upload")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "serveFile", path.getFileName().toString()).build().toString())
                .collect(Collectors.toList()));
        model.addAttribute("addMusicForm", new AddMusicForm());
        return "addSong";
    }


    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes,
                                   @Valid @ModelAttribute("addmusicForm") AddMusicForm AddMusicForm) {

        storageService.store(file);
        Music newMusic = new Music();
        newMusic.setArtistName(AddMusicForm.getartistName());
        newMusic.setSongName(AddMusicForm.getsongName());
        newMusic.setDate(AddMusicForm.getDate());
        newMusic.setPath("/files/" + file.getOriginalFilename());
        repository.save(newMusic);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/upload";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }



}