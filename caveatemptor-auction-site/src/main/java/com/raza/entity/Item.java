package com.raza.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@org.hibernate.annotations.GenericGenerator(name = "ID_GENERATOR", strategy = "enhanced_sequence", parameters = {
		@org.hibernate.annotations.Parameter(name = "sequence_name", value = "ITEM_SEQUENCE"),
		@org.hibernate.annotations.Parameter(name = "initial_value", value = "1000") })

public class Item {
	@Id
	@GeneratedValue(generator = "ID_GENERATOR")
	protected Long id;

	public Long getId() {
		return id;
	}
}
