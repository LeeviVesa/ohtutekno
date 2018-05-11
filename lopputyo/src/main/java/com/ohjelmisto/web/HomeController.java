package com.ohjelmisto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ohjelmisto.domain.Music;
import com.ohjelmisto.domain.MusicRepository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class HomeController {
    @Autowired
    private MusicRepository repository;

    @RequestMapping(value = "/add")
    public String addSong() {
        return "addSong";
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    //restfull haku listaan
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public @ResponseBody
    List<Music> musicListRest() {
        return (List<Music>) repository.findAll();
    }
    //delete
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteMusic(@PathVariable("id") Long id, Model model) {
        repository.delete(id);
        return "redirect:../";
    }

}
