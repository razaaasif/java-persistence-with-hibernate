package com.raza.entity;

import java.io.Serializable;

import javax.persistence.Column;

public class UserId implements Serializable {
	private static final long serialVersionUID = -6818200539923644984L;

	@Column(name = "username_cpk_col1")
	private String username;
	@Column(name = "department_id_cpk_col2")
	private Long departmentId;

	public UserId() {
	}

	public UserId(String username, Long departmentId) {
		super();
		this.username = username;
		this.departmentId = departmentId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

}
