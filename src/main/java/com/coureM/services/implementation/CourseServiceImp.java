package com.coureM.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coureM.entities.Course;
import com.coureM.repositories.CourseRepository;
import com.coureM.services.CourseService;

@Service
public class CourseServiceImp implements CourseService{

	private CourseRepository courseRepository;
	
	public CourseServiceImp(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	@Override
	public Course getCourseById(Long id) {
		return courseRepository.findById(id).get();
	}

	@Override
	public Course saveCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public void deleteCourseById(Long id) {
		courseRepository.deleteById(id);
	}

}
