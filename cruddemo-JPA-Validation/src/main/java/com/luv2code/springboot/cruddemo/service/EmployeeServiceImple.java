package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImple implements EmployeeService {

	private EmployeeDAO dao;

	@Autowired
	public EmployeeServiceImple(@Qualifier("employeeJPAImple") EmployeeDAO tdao) {
		// we are using @Qualifier bcoz there are two implementation of EmployeeDao so
		// we need to tell
		// spring that which bean we want to use.
		this.dao = tdao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {

		return dao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {

		return dao.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee emp) {
		dao.save(emp);

	}

	@Override
	@Transactional
	public void deletebyId(int id) {
		dao.deletebyId(id);

	}

}
