package com.school.student.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.student.entities.concretes.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
