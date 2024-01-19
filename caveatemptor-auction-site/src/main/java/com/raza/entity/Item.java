package com.raza.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

@Entity
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
public class Item {
	protected Set<Bid> bids = new HashSet<>();

	public Set<Bid> getBids() {
		return bids;
	}

	public void addBid(Bid bid) {
		if (bid == null)
			throw new NullPointerException("Can't add null Bid");
		if (bid.getItem() != null)
			throw new IllegalStateException("Bid is already assigned to an Item");
		getBids().add(bid);
		bid.setItem(this);
	}

}
