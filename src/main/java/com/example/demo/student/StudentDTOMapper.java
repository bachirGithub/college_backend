package com.example.demo.student;

import java.util.function.Function;

import org.springframework.stereotype.Service;

@Service
public class StudentDTOMapper implements Function<Student, StudentDTO>{

	@Override
	public StudentDTO apply(Student student) {
		// TODO Auto-generated method stub
		return new StudentDTO(
				student.getId(),
				student.getName(),
				student.getEmail()
				);
	}

}
