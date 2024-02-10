package com.raza.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class Child {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "firstname_fk", referencedColumnName = "firstname"),
			@JoinColumn(name = "lastname_fk", referencedColumnName = "lastname") })
	private Parent parent;

	public Child() {
	}

	public Child(String name) {
		this.name = name;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

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

	public Parent getParent() {
		return parent;
	}
	
	
}
