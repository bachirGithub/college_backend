package com.example.demo.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	private final StudentDTOMapper studentDTOMapper;

	@Autowired
	public StudentService(StudentRepository studentRepository, 
			StudentDTOMapper studentDTOMapper) {
		this.studentRepository = studentRepository;
		this.studentDTOMapper =studentDTOMapper;
	}
	
	public List<StudentDTO> getStudents() {
		return studentRepository.findAll()
				.stream()
				.map(studentDTOMapper)
				.collect(Collectors.toList());
	}
	
	public void addNewStudent(Student student) {
		Optional<Student> optionalStudent = studentRepository.findStudentByEmail(student.getEmail());
		if(optionalStudent.isPresent()) {
			throw new IllegalStateException("Email taken");
		}
		studentRepository.save(student);
 	}
	public void deleteStudent(Long studentID) {
		boolean optionalStudent = studentRepository.existsById(studentID);
		if(!optionalStudent) {
			throw new IllegalStateException("This student do not exist");
		}
		studentRepository.deleteById(studentID);
 	}
	
	@Transactional
	public void updateStudent(Long studentId, String name, String email, int age) {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(()-> new IllegalStateException(
						"Student with "+studentId+" does'nt"));
		if(name != null &&
				name.length() > 0 &&
				!Objects.equals(student.getName(), name)) {
			student.setName(name);
		}
		if(email != null &&
				email.length() > 0 &&
				!Objects.equals(student.getEmail(), name)) {
//			Optional<Student> optionalStudent = studentRepository.findStudentByEmail(email);
//			if(optionalStudent.isPresent()) {
//				throw new IllegalStateException("Email taken");
//			}
			student.setEmail(email);
		}
		if(age > 0 &&
				student.getAge() != age) {
			student.setAge(age);			
		}
//	studentRepository.save(student);

	}

}
