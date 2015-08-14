package com.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("buyer")
public class Buyer extends User{
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="buyer_bid_id")
	private Set<Bid> bids;
	
	@Column(name="fcategory")
	private String favouriteCategory;
	
	public Buyer() {
		// TODO Auto-generated constructor stub
	}
	
	public String getFavouriteCategory() {
		return favouriteCategory;
	}
	
	public void setFavouriteCategory(String favouriteCategory) {
		this.favouriteCategory = favouriteCategory;
	}

	public Set<Bid> getBids() {
		return bids;
	}
	
	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}
	
	

}
