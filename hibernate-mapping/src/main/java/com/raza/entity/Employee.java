package com.raza.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.raza.common.Constants.EmployeeType;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Enumerated(EnumType.STRING)
	private EmployeeType employeetype;

	public Employee() {

	}

	public Employee(String name, EmployeeType employeeType) {
		this.name = name;
		this.employeetype = employeeType;
	}
}
