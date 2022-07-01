package com.coureM.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coureM.entities.Student;
import com.coureM.repositories.StudentRepository;
import com.coureM.services.StudentService;

@Service
public class StudentServiceImp implements StudentService {
	
	private StudentRepository studentRepository;
	
	public StudentServiceImp(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();	
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
	}
}
