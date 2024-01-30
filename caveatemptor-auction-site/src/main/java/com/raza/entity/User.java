package com.raza.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1143880903673683863L;
	@Id
	private Long id;
	protected String username;

	public User() {
	}

	public String getUserName() {
		return this.username;
	}

	public void serUserName(String username) {
		this.username = username;
	}

//	public BigDecimal calcShippingCosts(Address fromLocation) {
//		return null;
//	}

}
