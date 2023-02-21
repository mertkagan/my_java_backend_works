package com.school.student.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.school.student.business.abstracts.StudentService;
import com.school.student.business.responses.GetAllStudentResponses;
import com.school.student.dataAccess.abstracts.StudentRepository;
import com.school.student.entities.concretes.Student;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class StudentManager implements StudentService{
	
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getAll() {
//		List<Student> students = studentRepository.findAll();
//		List<GetAllStudentResponses> studentResponses = new ArrayList<GetAllStudentResponses>();
//		
//		for (Student student : students) {
//			GetAllStudentResponses response = new GetAllStudentResponses();
//			
//			
//		}
		return studentRepository.findAll();
	}

	@Override
	public void add(Student student) {
		
		studentRepository.save(student);
		
	}

	@Override
	public void delete(int id) {
		
		studentRepository.deleteById(id);
		
	}

	@Override
	public void update(Student student) {
	
		studentRepository.save(student);
		
	}

	@Override
	public Optional <Student> getById(int id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id);
	}

	

}
