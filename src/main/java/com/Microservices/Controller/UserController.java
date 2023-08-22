package com.Microservices.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Microservices.Entities.User;
import com.Microservices.Service.UserServive;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServive us;
	
	@PostMapping("/add")
	public ResponseEntity<User> createUser(@RequestBody User user){
		 User save = us.save(user);
		 return ResponseEntity.status(HttpStatus.CREATED).body(save);
	}
	
	@GetMapping("/get/{userId}")
	public ResponseEntity<User> get(@PathVariable int userId){
		User user = us.getUser(userId);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> allUser(){
		List<User> all = us.getAll();
		return ResponseEntity.ok(all);
	}
	
	
	
}
