package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfiguration {
	
	@Bean
	CommandLineRunner studentcommandLineRunner(StudentRepository studentRepository) {
		return args -> {
			studentRepository.save(new Student("Ali", "Zaki", 20));
			studentRepository.save(new Student("Ramatou", "Issa", 32));
			studentRepository.save(new Student("Sani", "Habou", 32));
			studentRepository.save(new Student("Mariama", "Kadri", 32));
			
		};
	}

}
