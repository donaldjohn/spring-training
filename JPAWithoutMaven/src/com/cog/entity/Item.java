package com.cog.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//@Entity
public class Item {
	
	@Id
	@GeneratedValue
	@Column(name="item_id")
	private Long id;
	
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="item")
	private Set<Bid> bids = new HashSet<>();
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Bid> getBids() {
		return bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}

	

}
