package com.boot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/hello")
	public String sayHello(Model m) {

		m.addAttribute("theDate", new java.util.Date());
		return "helloworld";

	}

}
