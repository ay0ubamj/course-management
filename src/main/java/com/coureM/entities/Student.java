package com.coureM.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	private String prenom;
	private String email;
	
	@ManyToMany
	@JoinTable(
			name="course_students",
			joinColumns=@JoinColumn(name="student_id", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="course_id", referencedColumnName="id")
			)
	private List<Course> studentCourses;
	
	public Student() {
		
	}
	
	public Student(String nom, String prenom, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public List<Course> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(List<Course> studentCourses) {
		this.studentCourses = studentCourses;
	}

	@Override
	public String toString() {
		return nom + " " + prenom + " - " + email;
	}
	
	

}
