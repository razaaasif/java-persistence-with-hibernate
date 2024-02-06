package com.raza.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name="movie_actor",
			joinColumns={ @JoinColumn(name = "movie_id") },
			inverseJoinColumns={@JoinColumn(name = "actor_id")}
	)
	private Set<Actor> actors = new HashSet<>();

	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(String name) {
		this.name = name;
	}

	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

}
