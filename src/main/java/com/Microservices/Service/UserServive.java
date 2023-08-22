package com.Microservices.Service;

import java.util.List;

import com.Microservices.Entities.User;

public interface UserServive {

	//Saving the data
	User save(User us);
	
	// getting all user
	List<User> getAll();
	
	// getting single user
	User getUser(int uid);
	
	// Update 
	
	
}
