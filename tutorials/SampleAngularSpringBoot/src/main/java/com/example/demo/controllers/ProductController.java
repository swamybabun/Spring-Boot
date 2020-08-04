package com.example.demo.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@GetMapping
	@ResponseBody
	public String getAllOrders() {
		return "All orders";
	}

	@GetMapping(value = "/{orderId}")
	@ResponseBody
	public String getOrder(@PathVariable final String orderId) {
		return "Order ID: " + orderId;
	}

	@GetMapping(value = "/{orderId}/items")
	@ResponseBody
	public String getItemsByOrder(@PathVariable final String orderId) {
		return "Items for Order ID " + orderId;
	}

	@GetMapping(value = "/{orderId}/items/{itemId}")
	@ResponseBody
	public String getItem(@PathVariable final String orderId, @PathVariable final String itemId) {
		return "Order ID: " + orderId + ", Item ID: " + itemId;
	}
}