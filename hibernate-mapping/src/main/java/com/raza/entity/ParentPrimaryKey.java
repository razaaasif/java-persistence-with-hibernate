package com.raza.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class ParentPrimaryKey implements Serializable {

	private static final long serialVersionUID = -1361724145863299668L;
	private String firstName;
	private String lastName;

	public ParentPrimaryKey() {
	}

	public ParentPrimaryKey(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParentPrimaryKey other = (ParentPrimaryKey) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName);
	}

}
