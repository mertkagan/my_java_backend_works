package com.school.student.business.abstracts;

import java.util.List;
import java.util.Optional;

import com.school.student.business.responses.GetAllStudentResponses;
import com.school.student.entities.concretes.Student;

public interface StudentService {
	List<Student> getAll();
	
	void add(Student student);
	
	Optional<Student> getById(int id);
	
	void update(Student student);
	
	void delete(int id);
}
