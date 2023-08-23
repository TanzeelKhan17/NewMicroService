package com.Hotel.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hotel.Entity.Hotels;
import com.Hotel.Exception.ResourceNotFoundException;
import com.Hotel.Repository.HotelRepository;
@Service
public class HotelService_impl implements HotelService{

	@Autowired
	private HotelRepository hr;
	
	
	@Override
	public Hotels create(Hotels hotel) {
		/*
		 * String sid = UUID.randomUUID().toString(); hotel.setId(sid);
		 */
			
		return hr.save(hotel);
	}

	@Override
	public List<Hotels> getAll() {
		return hr.findAll();
	}

	@Override
	public Hotels get(int id) {
		// TODO Auto-generated method stub
		return hr.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Hotel With Given Id NOt Found"));
				
	}

}
