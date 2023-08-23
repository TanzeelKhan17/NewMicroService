package com.Hotel.Services;

import java.util.List;

import com.Hotel.Entity.Hotels;

public interface HotelService {

	// create
	
	Hotels create(Hotels hotel);
	
	// getAll
	List<Hotels> getAll();
	
	
	// get Single
	
	Hotels get(int id);
	
	
}
