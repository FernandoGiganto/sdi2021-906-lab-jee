package com.uniovi.entities;

import javax.persistence.*;

@Entity
public class Professor {

	@Id 
	@GeneratedValue
	private Long id;
	private String name;
	private String surname;
	private String category;
	
	public Professor(Long id,String name,String surname,String category) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.category = category;
	}
	
	public Professor() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", name=" + name + ", surname=" + surname + ", category=" + category + "]";
	}
	
	
	
	
}
