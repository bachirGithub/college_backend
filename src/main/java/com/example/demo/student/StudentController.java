package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;import jakarta.websocket.server.PathParam;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/student")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@GetMapping
	public List<StudentDTO> getStudents() {
		return studentService.getStudents();
	}
	
	@PostMapping
	public void registerNewStudent(@RequestBody Student student) {
		studentService.addNewStudent(student);
	}
	@DeleteMapping(path = "{id}")
	public void deleteStudent(@PathVariable("id") Long studentId) {
		studentService.deleteStudent(studentId);
	}
	@PutMapping(path = "{id}")
	public void updateStudent(@PathVariable("id") Long studentId, 
			@RequestBody Student student) {
		studentService.updateStudent(studentId, student.getName(), student.getEmail(), student.getAge());
	}

}
