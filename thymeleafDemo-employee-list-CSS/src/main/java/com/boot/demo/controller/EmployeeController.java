package com.boot.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.demo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private List<Employee> empList;

	@PostConstruct
	public void loadData() {

		empList = new ArrayList<Employee>();
		empList.add(new Employee(1, "Tushar", "Agarwal", "agarwaltusha2016@gmail.com"));
		empList.add(new Employee(2, "Rohit", "Sharma", "rohitsharma2016@gmail.com"));
		empList.add(new Employee(3, "Virat", "Kohli", "viratkohli2016@gmail.com"));

	}

	@GetMapping("/list")
	public String getList(Model m) {
		m.addAttribute("theList", empList);
		return "list-employees";
	}

}
