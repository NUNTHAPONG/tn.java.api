package com.tn.java.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EmptyController {

	@GetMapping
	public String Get() {
		return "Server started, api/{controller}/{action}";
	}
}
