package com.boot.demo.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@Value("${coach.name}")
	private String coachName;
	@Value("${team.name}")
	private String teamName;

	@GetMapping("/teamInfo")
	public String gettingTeamInfo() {
		return "Coach Name:" + coachName + " Team Name: " + teamName;
	}

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
