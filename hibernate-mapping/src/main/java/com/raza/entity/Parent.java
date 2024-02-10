package com.raza.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Parent {
	@EmbeddedId
	private ParentPrimaryKey parentPrimaryKey;
	@OneToMany(mappedBy = "parent", cascade = { CascadeType.PERSIST })
	Set<Child> children = new HashSet<>();

	public Parent() {
	}

	public Parent(ParentPrimaryKey pk) {
		this.parentPrimaryKey = pk;
	}

	public void addChild(Child child) {
		this.children.add(child);
		child.setParent(this);
	}
}
