package com.Microservices.External_Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Microservices.Entities.Hotels;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
	
	@GetMapping("get/{id}")
	public Hotels getHotel(@PathVariable String id);

}
