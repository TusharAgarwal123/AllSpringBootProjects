package com.springMVC.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class SudentController {

	@RequestMapping("/showForm")
	public String showForm(Model mm) {
		Student ss = new Student();
		mm.addAttribute("std", ss);
		return "student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("std") Student ss) {
 
		System.out.println(ss.getFirstName()+" "+ss.getLastName());
		return "std-confirmation";
	}
}
