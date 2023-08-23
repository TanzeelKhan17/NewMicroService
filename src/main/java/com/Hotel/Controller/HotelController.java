package com.Hotel.Controller;

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

import com.Hotel.Entity.Hotels;
import com.Hotel.Services.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private HotelService hs;
	
	@PostMapping("/add")
	public ResponseEntity<Hotels> createHotel(@RequestBody Hotels hotels){
		return ResponseEntity.status(HttpStatus.CREATED).body(hs.create(hotels));
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Hotels> getHotel(@PathVariable int id){
		return ResponseEntity.status(HttpStatus.OK).body(hs.get(id));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Hotels>> getAll(){
		return ResponseEntity.ok(hs.getAll());
	}
	
	
	
}
