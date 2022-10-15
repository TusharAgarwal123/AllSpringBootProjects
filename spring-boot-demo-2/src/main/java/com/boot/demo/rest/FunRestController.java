package com.boot.demo.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@GetMapping("/")
	public String sayHello() {
		return "Hello time on the server is " + LocalDateTime.now();
	}

	@GetMapping("/hello")
	public String sayHelloTushar() {
		return "Hello Tushar Agarwal";
	}

	@GetMapping("/home")
	public String home() {
		return "hureeee";
	}

}
