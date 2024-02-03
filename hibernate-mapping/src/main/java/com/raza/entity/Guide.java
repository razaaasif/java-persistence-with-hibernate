package com.raza.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Guide {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String staffId;
	@Column
	private Integer salary;

	@OneToMany(mappedBy = "guide", cascade = { CascadeType.PERSIST })
	private Set<Student> students = new HashSet<>();

	public Guide() {
		// Auto-generated constructor stub
	}

	public Guide(Long id, String name, String staffId, Integer salary) {
		this.id = id;
		this.name = name;
		this.staffId = staffId;
		this.salary = salary;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Guide [id=" + id + ", name=" + name + ", staffId=" + staffId + ", salary=" + salary + ", students="
				+ students + "]";
	}
	
	

}