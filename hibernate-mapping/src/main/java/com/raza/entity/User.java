package com.raza.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@EmbeddedId
	private UserId userId;
	@Column
	private String email;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	public User() {
	}

	public User(UserId userId, String email) {
		super();
		this.userId = userId;
		this.email = email;
	}

	public UserId getUserId() {
		return userId;
	}

	public void setUserId(UserId userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
