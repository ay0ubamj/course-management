package com.coureM.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coureM.entities.Teacher;
import com.coureM.repositories.TeacherRepository;
import com.coureM.services.TeacherService;

@Service
public class TeacherServiceImp implements TeacherService {

	private TeacherRepository teacherRepository;

	public TeacherServiceImp(TeacherRepository teacherRepository) {
		super();
		this.teacherRepository = teacherRepository;
	}

	@Override
	public List<Teacher> getAllTeachers() {
		return teacherRepository.findAll();
	}

	@Override
	public Teacher getTeacherById(Long id) {
		return teacherRepository.findById(id).get();
	}

	@Override
	public Teacher saveTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	public void deleteTeacherById(Long id) {
		teacherRepository.deleteById(id);
	}
}
