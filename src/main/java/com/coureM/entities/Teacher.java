package com.coureM.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nom;
	private String prenom;
	private String domaine;
	
	@OneToMany(mappedBy="teacher")
	private List<Course> courses;
	
	public Teacher() {
		
	}
	
	public Teacher(Long id, String nom, String prenom, String domaine) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.domaine = domaine;
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

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	@Override
	public String toString() {
		return nom + " " + prenom;
	}
	
	
}
