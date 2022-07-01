package com.coureM.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nomCours;
	private String domaine;
	private String duree;
	
	@ManyToMany(mappedBy = "studentCourses")
	private List<Student> courseStudents;
	
	@ManyToOne
	@JoinColumn(name = "idTeacher", referencedColumnName="id")
	private Teacher teacher;
	
	public Course() {
		
	}
	
	public Course(String nomCours, String domaine, String duree) {
		super();
		this.nomCours = nomCours;
		this.domaine = domaine;
		this.duree = duree;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomCours() {
		return nomCours;
	}

	public void setNomCours(String nomCours) {
		this.nomCours = nomCours;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public List<Student> getCourseStudents() {
		return courseStudents;
	}

	public void setCourseStudents(List<Student> courseStudents) {
		this.courseStudents = courseStudents;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Course name: " + nomCours + ", Domain: " + domaine + ", Duration: " + duree + ", Teacher: " + teacher;
	}
	
	
}
