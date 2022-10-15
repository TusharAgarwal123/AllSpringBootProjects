package com.spring.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/home")
	public String showHome() {
		return "home";
	}

	@GetMapping("/leaders")
	public String onlyForLeaders() {
		return "leaders";
	}
	
	@GetMapping("/admin")
	public String onlyForAdmins() {
		return "admin";
	}

	// get mapping for access-denied page

	@GetMapping("/access-denied")
	public String accessDenied() {
		return "access-denied";
	}

}
