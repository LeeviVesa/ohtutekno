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
import com.ohjelmisto.domain.UserRepository;
import com.ohjelmisto.domain.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class LopputyoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LopputyoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(MusicRepository repository) {
		return (args) -> {
		};
	}
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.init();
		};
	}

}
