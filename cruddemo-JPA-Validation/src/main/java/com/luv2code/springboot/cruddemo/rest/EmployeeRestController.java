package com.luv2code.springboot.cruddemo.rest;

import java.util.List;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService es;

	@Autowired
	public EmployeeRestController(EmployeeService tes) {
		this.es = tes;
	}

	// expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return es.findAll();
	}

	@GetMapping("/employee/{empId}")
	public Resource<Employee> findById(@PathVariable int empId) {
//		Employee emp = es.findById(empId);
//		if (emp == null) {
//			throw new EmployeeNotFoundException("Employee id not found: " + empId);
//		}

		// return emp;

		// now we are adding some hateoas to this method now it will return the details
		// employee and
		// link for access all employee as well.

		Employee emp = es.findById(empId);
		if (emp == null) {
			throw new EmployeeNotFoundException("Employee id not found: " + empId);
		}

		Resource<Employee> rs = new Resource<Employee>(emp);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAll());
		rs.add(linkTo.withRel("all-users"));

		return rs;

	}

	@PostMapping("/employee")
	public Employee save(@Valid @RequestBody Employee emp) {

		// also just in case they pass an id in json...set id to 0
		// this is to force for save a new item..instead of update

		// when we pass json obejct of employee we will not pass id bcoz we want to save
		// it.

		emp.setId(0); // for saving we need to set id to 0.
		es.save(emp);
		return emp;
	}

	@PutMapping("/employee")
	public Employee update(@RequestBody Employee emp) {

		// now when we pass json object of employee we need to pass the id also, it will
		// update on the basis
		// of id.
//
//		if (emp.getId() < 1 || es.findAll().size() < emp.getId()) {
//			throw new RuntimeException("Employee id not found: " + emp.getId());
//		}

		es.save(emp);
		return emp;

	}

	@DeleteMapping("/employee/{empId}")
	public String delete(@PathVariable int empId) {
		Employee emp = es.findById(empId);
		if (emp == null) {
			throw new EmployeeNotFoundException("Employee id not found: " + empId);
		}

		es.deletebyId(empId);
		return "Employee id " + empId + " deleted";
	}

}
