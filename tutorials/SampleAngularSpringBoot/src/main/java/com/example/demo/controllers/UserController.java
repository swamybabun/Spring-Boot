package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public @ResponseBody Iterable<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable int id) {
		Optional<User> userData = userRepository.findById(id);
		return new ResponseEntity<User>(userData.isPresent() ? userData.get() : null, HttpStatus.OK);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		user = userRepository.save(user);
		return new ResponseEntity<User>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable int id) {
		// Retrieving Existing user
		Optional<User> existingUser = userRepository.findById(id);

		// Updating the object with the new information
		existingUser.get().setEmail(user.getEmail());
		existingUser.get().setName(user.getName());

		// Updating in database
		userRepository.save(existingUser.get());

		// Sending response (OK if updated, 201 CREATED if created, 204 NO CONTENT, 202
		// if queued for update
		return new ResponseEntity<User>(HttpStatus.OK);
	}
}