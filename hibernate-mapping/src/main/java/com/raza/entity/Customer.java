package com.raza.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "custom_table")
	@TableGenerator(name = "custom_table", pkColumnName = "seq_column", pkColumnValue = "seq_customer", table = "seq_table", allocationSize = 99, valueColumnName = "seq_value", initialValue = 0)
	private Long id;
	@Column(unique = true)
	private String name;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "passport_id", nullable = false)
	private Passport passport;

	public Customer() {
		// Auto-generated constructor stub
	}

	public Customer(String name, Passport passport) {
		super();
		this.name = name;
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}

}
