package com.Hotel.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hotel.Entity.Rating;
import com.Hotel.Repository.RatingRepository;

@Service
public class RatingService_impl implements RatingService {
	
	@Autowired
	 private RatingRepository rr;

	@Override
	public Rating create(Rating rating) {
		/*
		 * String randomUUID = UUID.randomUUID().toString();
		 * rating.setUserId(randomUUID);
		 */
		return rr.save(rating);
	}

	@Override
	public List<Rating> getAll() {
		// TODO Auto-generated method stub
		return rr.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		
		return rr.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return rr.findByHotelId(hotelId);
	}

}
