package com.Hotel.Service;

import java.util.List;

import com.Hotel.Entity.Rating;

public interface RatingService {
	
	//create 
	
	Rating create(Rating rating);
	
	// getAll
	List<Rating> getAll();
	
	// Get all By UserId
	List<Rating> getRatingByUserId(String userId);
	
	// Get all By hotelId
		List<Rating> getRatingByHotelId(String userId);

}
