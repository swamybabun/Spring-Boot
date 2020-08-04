package com.springboot.actuator.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {

	@GetMapping("/example")
	public String example() {
		return "Hello User, Welcome to the Spring Boot Actuator- Spring Boot Management !! " + new Date();
	}
}
