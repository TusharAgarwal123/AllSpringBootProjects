package com.springMVC.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.springMVC.demo.entity.Faculty;
import com.springMVC.demo.entity.User;
import com.springMVC.demo.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService us;

	@GetMapping("/login")
	public String showPage() {
		return "first";
	}

	@GetMapping("/login2")
	public String showPage2() {
		return "facultyLogin";
	}

	@GetMapping("/processForm")
	public String processPage(@RequestParam("rollNo") String no, @RequestParam("pass") String pass) {

		int x = Integer.parseInt(no);

//		System.out.println(x);
//		System.out.println(pass);
		return "second";
	}

	@GetMapping("/registrationFrom")
	public String registrationPage(Model mm) {

		mm.addAttribute("user", new User());
		return "registration";
	}

	@GetMapping("/registrationFrom2")
	public String registrationPage2(Model mm) {

		mm.addAttribute("faculty", new Faculty());
		return "facultyRegistration";
	}

	@GetMapping("/processForm2")

	public String processPage2(@ModelAttribute("user") User u) {

		us.save(u);

		return "second";
	}

	@GetMapping("/processForm3")

	public String processPage3(@ModelAttribute("faculty") Faculty f) {

		us.save(f);

		// System.out.println(f.getCity());

		return "second";
	}

}
