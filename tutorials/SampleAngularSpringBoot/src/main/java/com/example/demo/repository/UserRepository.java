package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.User;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
public interface UserRepository extends CrudRepository<User, Integer> {

}