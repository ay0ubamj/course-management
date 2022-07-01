package com.coureM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coureM.repositories.StudentRepository;


@SpringBootApplication
public class CourseManagementApplication{

	public static void main(String[] args) {
		SpringApplication.run(CourseManagementApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	
}
