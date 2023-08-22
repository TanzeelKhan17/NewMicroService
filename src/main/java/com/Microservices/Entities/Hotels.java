package com.Microservices.Entities;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Hotels {
   
	private int id;
	private String name;
	private String location;
	private String about;
	
	
}
