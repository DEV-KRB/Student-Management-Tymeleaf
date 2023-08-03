package com.eculant.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eculant.thymeleaf.dao.StudentRepository;
import com.eculant.thymeleaf.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;
	
	@Autowired
	public StudentServiceImpl (StudentRepository theStudentRepository) {
		
		studentRepository = theStudentRepository;
	}
	@Override
	public List<Student> findAll() {
	
		return studentRepository.findAll();
	}

	@Override
	public Student findByRno(int theRno) {	
		
		Optional<Student> result = studentRepository.findById(theRno);
		Student theStudent = null;
		if(result.isPresent()) {
			return result.get();
		}
		else {
			System.out.println("not found");
		}
		return theStudent ;
	}

	@Override
	public void saveStudent(Student theStudent) {
		
		studentRepository.save(theStudent);
	}

	@Override
	public void deleteStudent(int theRno) {
		
		studentRepository.deleteById(theRno);
	}

}
