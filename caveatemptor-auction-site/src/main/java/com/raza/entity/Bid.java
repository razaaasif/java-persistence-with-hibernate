package com.raza.entity;

public class Bid {
	protected Item item;

	public Bid(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}