package com.coureM.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coureM.entities.Course;
import com.coureM.entities.Teacher;
import com.coureM.repositories.TeacherRepository;
import com.coureM.services.CourseService;
import com.coureM.services.StudentService;
import com.coureM.services.TeacherService;

@Controller
public class CourseController {

	private CourseService courseService;
	private TeacherService teacherService;
	private StudentService studentService;

	public CourseController(CourseService courseService, TeacherService teacherService, StudentService studentService) {
		super();
		this.courseService = courseService;
		this.teacherService = teacherService;
		this.studentService = studentService;
	}
	
	@GetMapping("/courses")
	public String listcourses(Model model) {
		model.addAttribute("courses", courseService.getAllCourses());
		return "courses";
	}
	
	@GetMapping("/courses/add")
	public String courseForm(Model model) {
		Course course = new Course();
		model.addAttribute("course", course);
		model.addAttribute("teachers", teacherService.getAllTeachers());
		return "addCourse";
	}
	
	@PostMapping("/courses")
	public String saveCourse(@ModelAttribute("course") Course course) {
		courseService.saveCourse(course);
		return "redirect:/courses";
	}
	
	@GetMapping("/courses/edit/{id}")
	public String editCourseForm(@PathVariable Long id, Model model) {
		model.addAttribute("course", courseService.getCourseById(id));
		model.addAttribute("teachers", teacherService.getAllTeachers());
		return "editCourse";
	}

	@PostMapping("/courses/{id}")
	public String updateCourse(@PathVariable Long id, @ModelAttribute("course") Course course, Model model) {
		Course getCourse = courseService.getCourseById(id);
		
		getCourse.setId(id);
		getCourse.setNomCours(course.getNomCours());
		getCourse.setDomaine(course.getDomaine());
		getCourse.setDuree(course.getDuree());
		getCourse.setTeacher(course.getTeacher());
		
		courseService.updateCourse(getCourse);
		return "redirect:/courses";		
	}
	
	@GetMapping("/courses/delete/{id}")
	public String deleteCourse(@PathVariable Long id) {
		courseService.deleteCourseById(id);
		return "redirect:/courses";
	}
	
	@GetMapping("/courses/showCourseStudents/{id}")
	public String showStudents(@PathVariable Long id, Model model) {
		model.addAttribute("course", courseService.getCourseById(id));
		return "showCourseStudents";
	}
}
