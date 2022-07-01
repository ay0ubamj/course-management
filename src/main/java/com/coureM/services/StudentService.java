package com.coureM.services;

import java.util.List;
import com.coureM.entities.Student;

public interface StudentService {

	List<Student> getAllStudents();
	
	Student getStudentById(Long id);
	
	Student saveStudent(Student student);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);
}
