package com.raza.entity.advanced;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@org.hibernate.annotations.Immutable
@org.hibernate.annotations.Subselect(value = "select i.ID as ITEMID, i.ITEM_NAME as NAME, "
		+ "count(b.ID) as NUMBEROFBIDS " + "from ITEM i left outer join BID b on i.ID = b.ITEM_ID "
		+ "group by i.ID, i.ITEM_NAME")
public class ItemBidSummary {

	@Id
	private long itemId;
	private String name;
	private long numberOfBirds;

	public ItemBidSummary() {
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getNumberOfBirds() {
		return numberOfBirds;
	}

	public void setNumberOfBirds(long numberOfBirds) {
		this.numberOfBirds = numberOfBirds;
	}

}
