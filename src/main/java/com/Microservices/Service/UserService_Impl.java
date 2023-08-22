package com.Microservices.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Microservices.Entities.Hotels;
import com.Microservices.Entities.Rating;
import com.Microservices.Entities.User;
import com.Microservices.Exception.ResourceNotFoundException;
import com.Microservices.External_Service.HotelService;
import com.Microservices.Repository.UserRepo;

@Service
public class UserService_Impl implements UserServive {
	
	@Autowired
	private UserRepo ur;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	@Override
	public User save(User us) {
		
		// Genete Unique User Id
		/*
		 * String randomUserId = UUID.randomUUID().toString();
		 * us.setUserId(randomUserId);
		 */
		User user = ur.save(us);
		return user ;
	}

	@Override
	public List<User> getAll() {
		List<User> all = ur.findAll();
		return all;
	}

	@Override
	public User getUser(int uid) {
		// TODO Auto-generated method stub
	User u=	ur.findById(uid).orElseThrow(()-> new ResourceNotFoundException("user given Id is Not Found "+uid));
	// calling Rating Service With The help Of RestTemplate	
	Rating[] forObject = restTemplate.getForObject("http://localhost:8083/rating/user/1",Rating[].class);
	//converting array to list
	List<Rating> list = Arrays.stream(forObject).toList();
	
	list.stream().map(rating->{
	//Hotels forObject2 = restTemplate.getForObject("http://localhost:8082/hotel/get/1", Hotels.class);
	
		// Using Feign Client To Call Services
		Hotels hotel = hotelService.getHotel(rating.getHotelId());
		rating.setHotel(hotel);
	return rating;
	}).collect(Collectors.toList());
	u.setRatings(list);
	return u;	
	}

}
