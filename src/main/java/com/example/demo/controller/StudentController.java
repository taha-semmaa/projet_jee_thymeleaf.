package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Student;
import com.example.demo.services.groupeService;
import com.example.demo.services.studentService;

@Controller
public class StudentController {
	private studentService StudentService;
	private groupeService GroupeService;

	public StudentController(studentService studentService,groupeService groupeService) {
		super();
		StudentService = studentService;
		GroupeService=groupeService;
	}
	@GetMapping("/students")
	public String listStudents(Model model)
	{
		model.addAttribute("students", StudentService.getAllStudents());
		return "students";
	}
	@GetMapping("/students/new")
	public String createStudentFrom(Model model)
	{
		Student student=new Student();
		model.addAttribute("student", student);
		model.addAttribute("groups",GroupeService.getAllgroupe());
		return "create_student";	
	}
	@PostMapping("/students")
	public String SaveStudent(@ModelAttribute("student") Student student, @RequestParam long idGroup)
	{
		student.setGroup(GroupeService.getGroupeById(idGroup));
		StudentService.saveStudent(student);
		
		return "redirect:/students";
	}
	@GetMapping("/students/edit/{id}")
	public String editStudentFrom(@PathVariable Long id,Model model)
	{
		model.addAttribute("student",StudentService.getStudentById(id));
		model.addAttribute("groups",GroupeService.getAllgroupe());
		return "edit_student";
	}
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model,
			@RequestParam long idGroup)
	{
		Student updatingStudent=StudentService.getStudentById(id);
	    updatingStudent.setEmail(student.getFirstName());
	    updatingStudent.setLastName(student.getLastName());
	    updatingStudent.setEmail(student.getEmail());
	    updatingStudent.setGroup(GroupeService.getGroupeById(idGroup));
	    StudentService.updateStudent(updatingStudent);
	    StudentService.saveStudent(updatingStudent);
	    return "redirect:/students";
	}
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id)
	{
		StudentService.deleteStudentById(id);
		return "redirect:/students";
	}

}
