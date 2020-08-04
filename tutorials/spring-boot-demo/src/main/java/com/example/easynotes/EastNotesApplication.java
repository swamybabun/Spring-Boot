package com.example.easynotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing 
public class EastNotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EastNotesApplication.class, args);
	}

}
