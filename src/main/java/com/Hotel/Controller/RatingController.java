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

import com.Hotel.Entity.Rating;
import com.Hotel.Service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	@Autowired
	private RatingService rs;
	
	@PostMapping("/add")
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(rs.create(rating));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Rating>> allRating(){
		return ResponseEntity.ok(rs.getAll());
	}
	
	// UserId Rating
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> allRatingByUserId(@PathVariable String userId){
		return ResponseEntity.ok(rs.getRatingByUserId(userId));
	}
	
	// HitelId Rating
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> allRatingByHotelId(@PathVariable String hotelId){
		return ResponseEntity.ok(rs.getRatingByUserId(hotelId));
	}
	
	
	
	
}
