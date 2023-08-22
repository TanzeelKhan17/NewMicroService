package com.Microservices.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Microservices.Entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
