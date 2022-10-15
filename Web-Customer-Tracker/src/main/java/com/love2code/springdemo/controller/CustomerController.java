package com.love2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.love2code.springdemo.dao.CustomerDAO;
import com.love2code.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerDAO cd;

	@GetMapping("/list")
	public String listCustomer(Model m) {

		List<Customer> ll = cd.getCustomers();

		// add customer to the model

		m.addAttribute("customer", ll);

		return "list-customer";

	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

}
