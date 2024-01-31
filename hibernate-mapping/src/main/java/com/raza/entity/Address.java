package com.raza.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String street;
	private String city;
	private String zipCode;

	public Address() {
		// Auto-generated constructor stub
	}

	public Address(String street, String city, String zipCode) {
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
	}

}
