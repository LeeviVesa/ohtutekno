package com.ohjelmisto;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.ohjelmisto.domain.Music;
import com.ohjelmisto.domain.MusicRepository;

@SpringBootApplication
public class LopputyoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LopputyoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(MusicRepository repository) {
		return (args) -> {
			repository.save(new Music("Be somebody", "Leevi Vesa", "13.1.2017", "../music/VSA - Be somebody.mp3"));
			repository.save(new Music("Momentum", "Leevi Vesa", "30.8.2017","../music/VSA - Momentum.mp3"));
		};
	}
}
