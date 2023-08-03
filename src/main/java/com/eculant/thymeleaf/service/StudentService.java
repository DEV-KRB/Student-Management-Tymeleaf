package com.eculant.thymeleaf.service;

import java.util.List;

import com.eculant.thymeleaf.entity.Student;

public interface StudentService {

	public List<Student> findAll();
	
	public Student findByRno(int theRno);
	
	public void saveStudent(Student theStudent);
	
	public void deleteStudent(int theRno);
}
