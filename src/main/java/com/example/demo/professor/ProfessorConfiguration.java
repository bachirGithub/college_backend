package com.example.demo.professor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfessorConfiguration {
	
	@Bean
	CommandLineRunner commandLineRunner( ProfessorRepository professorRepository) {
		return args -> {
			professorRepository.save(new Professor("Salim", "sal@gmail.com", "Pr"));
			professorRepository.save(new Professor("Khadija", "khadija@gmail.com", "M.C"));
			professorRepository.save(new Professor("Adel", "ad@gmail.com", "Pr"));
		};
	}

}
