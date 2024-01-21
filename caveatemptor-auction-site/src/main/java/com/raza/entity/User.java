package com.raza.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class User implements Serializable {
	private static final long serialVersionUID = 1143880903673683863L;
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
