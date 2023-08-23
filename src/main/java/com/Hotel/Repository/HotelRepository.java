package com.Hotel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hotel.Entity.Hotels;

public interface HotelRepository extends JpaRepository<Hotels,Integer> {

}
