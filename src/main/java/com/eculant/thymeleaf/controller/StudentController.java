package com.eculant.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eculant.thymeleaf.entity.Student;
import com.eculant.thymeleaf.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService theStudentService) {
		studentService = theStudentService;
	}
	
	@GetMapping("/list")
	public String ListStudents(Model theModel) {
		
		//get students from db
		List<Student> theStudent = studentService.findAll();
		theModel.addAttribute("student", theStudent);
		return "student/list-student";
	}	
	
	@GetMapping("/showFormToAdd")
	public String showFormToAdd (Model theModel) {
		
		Student theStudent = new Student();
		
		theModel.addAttribute("student", theStudent);
		return "student/student-form";
	}
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student theStudent) {
		
		//save the student
		studentService.saveStudent(theStudent);
		
		return "redirect:/students/list";
	}
	
	@GetMapping("/showFormToUpdate")
	public String showFormToUpdate(@RequestParam("rno") int rno, Model theModel) {
		
		//get student
		Student theStudent = studentService.findByRno(rno);
		
		//set student as model attribute to pre-populate the form
		theModel.addAttribute("student", theStudent);
		
		//sent data to form
		return "student/student-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("rno")int rno) {
		
		//delete the student
		studentService.deleteStudent(rno);
		return "redirect:/students/list";
	}

}
