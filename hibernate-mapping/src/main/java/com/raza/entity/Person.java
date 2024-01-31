package com.raza.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "home_street")),
			@AttributeOverride(name = "city", column = @Column(name = "home_city")),
			@AttributeOverride(name = "zipCode", column = @Column(name = "home_zip_code")) })
	private Address shippingAddress;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "billing_street")),
			@AttributeOverride(name = "city", column = @Column(name = "billing_city")),
			@AttributeOverride(name = "zipCode", column = @Column(name = "billing_zip_code")) })
	private Address billingAddress;

	public Person() {
		// Auto-generated constructor stub
	}

	public Person(String name, Address shippingAddress, Address billingAddress) {
		this.name = name;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
	}
}
