package com.ohjelmisto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.ohjelmisto.domain.Music;
import com.ohjelmisto.domain.MusicRepository;
import com.ohjelmisto.storage.StorageService;
import com.ohjelmisto.storage.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class LopputyoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LopputyoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(MusicRepository repository) {
		return (args) -> {
			//repository.save(new Music("Be somebody", "Leevi Vesa", "13.1.2017", "../music/VSA - Be somebody.mp3"));
			//repository.save(new Music("Momentum", "Leevi Vesa", "30.8.2017","../music/VSA - Momentum.mp3"));
		};
	}
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.init();
		};
	}
}
