package com.boot.demo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/hello")
	public String sayHello(Model m) {

		m.addAttribute("theDate", new java.util.Date());
		m.addAttribute("name", "tushar");
		return "helloworld";

	}

	@GetMapping("/iterate")
	// handling iteration
	public String iterateHandler(Model m) {

		List<Integer> ll = List.of(1, 2, 3, 4, 5);

		m.addAttribute("list", ll);

		return "iterate";
	}

	@GetMapping("/condition")
	public String conditionHandler(Model m) {

		m.addAttribute("isActive", true);
		return "condition";
	}

	@GetMapping("/fragments")
	public String serviceHandler(Model m) {
		m.addAttribute("title", "i like to eat pizza");
		m.addAttribute("subtitle", LocalDateTime.now().toString());
		return "service";
	}

	@GetMapping("/about")
	public String about() {
		return "aboutNew";
	}

}
