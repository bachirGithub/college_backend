package com.example.demo.professor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.student.Student;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/professor")
public class ProfessorController {
	@Autowired
	ProfessorService professorService;
	
		@GetMapping
		public List<Professor> getProfessor() {
			return professorService.getProfessor();
		}
}
