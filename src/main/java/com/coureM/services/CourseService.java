package com.coureM.services;

import java.util.List;
import com.coureM.entities.Course;

public interface CourseService {

	List<Course> getAllCourses();
	
	Course getCourseById(Long id);
	
	Course saveCourse(Course course);
	
	Course updateCourse(Course course);
	
	void deleteCourseById(Long id);
}
