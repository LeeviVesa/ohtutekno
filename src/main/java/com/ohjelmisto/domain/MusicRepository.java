package com.ohjelmisto.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


import javax.transaction.Transactional;
import java.nio.file.Path;
import java.util.stream.Stream;

@Transactional
public interface MusicRepository extends CrudRepository<Music, Long> {
    List<Music> findByArtistName(String artistName);

}
