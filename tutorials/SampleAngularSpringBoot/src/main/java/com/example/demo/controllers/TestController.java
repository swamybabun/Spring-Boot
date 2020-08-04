package com.example.demo.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@RestController
@RequestMapping(value = "/testMama")
public class TestController {

	@JsonInclude(Include.NON_NULL)
	private class HealthCheckResponse {
		private String currentTime;
		private String application;
		private String status;

		public String getCurrentTime() {
			return currentTime;
		}

		public void setCurrentTime(String currentTime) {
			this.currentTime = currentTime;
		}

		public String getApplication() {
			return application;
		}

		public void setApplication(String application) {
			this.application = application;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
	}

	@GetMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public HealthCheckResponse get(@RequestParam String format) {
		HealthCheckResponse healthCheckResponse = new HealthCheckResponse();
		FormatType formatType = FormatType.forName(format);
		if (formatType != null) {
			switch (formatType) {
			case FULL:
				healthCheckResponse.setApplication(HttpStatus.OK.name());
				LocalDateTime localDateTime = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String formatDateTime = localDateTime.format(formatter);
				healthCheckResponse.setCurrentTime(formatDateTime);
				break;
			case SHORT:
				healthCheckResponse.setStatus(HttpStatus.OK.name());
				break;
			default:
				healthCheckResponse.setStatus(HttpStatus.BAD_REQUEST.name());
				break;
			}
		} else {
			healthCheckResponse.setStatus(HttpStatus.BAD_REQUEST.name());
		}
		return healthCheckResponse;
	}

	@PutMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
	public void put() {

	}

	private enum FormatType {
		FULL, SHORT;

		private static final FormatType[] copyOfValues = values();

		public static FormatType forName(String name) {
			for (FormatType value : copyOfValues) {
				if (value.name().equalsIgnoreCase(name)) {
					return value;
				}
			}
			return null;
		}
	}
}
