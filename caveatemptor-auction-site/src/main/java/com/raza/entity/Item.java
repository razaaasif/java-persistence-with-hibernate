package com.raza.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {
	@Id
	protected Long id;
	protected String name;

	public Long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
