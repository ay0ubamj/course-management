package com.coureM.services;

import java.util.List;
import com.coureM.entities.Teacher;

public interface TeacherService {
	
	List<Teacher> getAllTeachers();
	
	Teacher getTeacherById(Long id);
	
	Teacher saveTeacher(Teacher teacher);
	
	Teacher updateTeacher(Teacher teacher);
	
	void deleteTeacherById(Long id);
}
