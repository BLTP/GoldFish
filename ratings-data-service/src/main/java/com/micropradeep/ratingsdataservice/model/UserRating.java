package com.micropradeep.ratingsdataservice.model;

import java.util.ArrayList;
import java.util.List;
public class UserRating {

	private int id;
    private List<Rating> ratings=new ArrayList<Rating>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	public UserRating(int id, List<Rating> ratings) {
		super();
		this.id = id;
		this.ratings = ratings;
	}
	public UserRating() {
		super();
	}

    
}
