package com.coureM.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coureM.services.CourseService;
import com.coureM.services.StudentService;
import com.coureM.entities.Student;

@Controller
public class StudentController {

	private StudentService studentService;
	private CourseService courseService;

	public StudentController(StudentService studentService, CourseService courseService) {
		super();
		this.studentService = studentService;
		this.courseService = courseService;
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/add")
	public String studentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		model.addAttribute("courses", courseService.getAllCourses());
		return "addStudent";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		model.addAttribute("courses", courseService.getAllCourses());
		return "editStudent";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		Student getStudent = studentService.getStudentById(id);
		
		getStudent.setId(id);
		getStudent.setNom(student.getNom());
		getStudent.setPrenom(student.getPrenom());
		getStudent.setEmail(student.getEmail());
		getStudent.setStudentCourses(student.getStudentCourses());
		
		studentService.updateStudent(getStudent);
		return "redirect:/students";		
	}
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
	@GetMapping("/students/showStudentCourses/{id}")
	public String showStudents(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "showStudentCourses";
	}
}
