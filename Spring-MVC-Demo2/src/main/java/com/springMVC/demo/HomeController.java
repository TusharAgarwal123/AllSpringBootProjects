package com.springMVC.demo;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HomeController {

	@RequestMapping("/showForm")
	public String showForm(Model mm) {
		mm.addAttribute("std", new Student());
		return "helloForm";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("std") Student st, BindingResult br) {

		// System.out.println(st.getFirstName());
		if (br.hasErrors()) {
			return "helloForm";
		} else {
			return "processForm";
		}
	}

	// for removing leading and trailing white spaces
	@InitBinder
	public void initBinder(WebDataBinder db) {
		StringTrimmerEditor st = new StringTrimmerEditor(true);
		db.registerCustomEditor(String.class, st);
	}

}
