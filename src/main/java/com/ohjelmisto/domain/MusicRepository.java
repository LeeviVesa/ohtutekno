package com.ohjelmisto.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface MusicRepository extends CrudRepository<Music, Long> {
    List<Music> findByArtistName(String artistName);

}
