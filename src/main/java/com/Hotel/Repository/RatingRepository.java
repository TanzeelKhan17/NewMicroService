package com.Hotel.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hotel.Entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, String>{

	//Custom Finder Method
	
	List<Rating> findByUserId(String userId);
	List<Rating> findByHotelId(String hotelId);
	
}
