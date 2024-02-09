package com.raza.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Friend {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String email;
	@ElementCollection
	@CollectionTable(name = "friends_nickname")
	@Column(name = "nickname")
	private Collection<String> nicknames = new ArrayList<>();

	public Friend() {
	}

	public Friend(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public Collection<String> getNickNames() {
		return this.nicknames;
	}

	@Override
	public String toString() {
		return "Friend [id=" + id + ", name=" + name + ", email=" + email + ", nicknames=" + nicknames + "]";
	}

}
