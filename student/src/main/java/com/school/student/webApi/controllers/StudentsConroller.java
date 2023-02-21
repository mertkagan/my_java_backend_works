package com.school.student.webApi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.student.business.abstracts.StudentService;
import com.school.student.entities.concretes.Student;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentsConroller {
	
	private StudentService studentService;
	
	@GetMapping("/getall")
	public List<Student> getAll() {
		return studentService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody Student student) {
		studentService.add(student);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Student student) {
		studentService.update(student);
	}
	
	@GetMapping("/{id}")
	public Optional <Student> getById(@PathVariable int id){
		return studentService.getById(id);
	}
	
	
	@DeleteMapping("/deletestudent/{id}")
	public void delete(@PathVariable int id) {
		studentService.delete(id);
	}
}
