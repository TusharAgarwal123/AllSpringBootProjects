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
@RequestMapping("/customer")
public class CustomerController {

	@RequestMapping("/showForm")
	public String showForm(Model md) {
		md.addAttribute("customer", new Customer());
		return "customer-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer cs, BindingResult br) {

		System.out.println("BindingResult: " + br);
		System.out.println("\n\n\n");

		if (br.hasErrors()) {
			return "customer-form";
		} else {
			return "customer-confirmation";
		}
	}

	// for removing leading and trailing white spaces
	@InitBinder
	public void initBinder(WebDataBinder db) {
		StringTrimmerEditor st = new StringTrimmerEditor(true);
		db.registerCustomEditor(String.class, st);
	}

}
