package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeJPAImple implements EmployeeDAO {

	private EntityManager em;

	@Autowired
	public EmployeeJPAImple(EntityManager tem) {
		this.em = tem;
	}

	@Override
	public List<Employee> findAll() {

		Query q = em.createQuery("from Employee", Employee.class);
		// this time we are using the javax.persistence.Query;
		List<Employee> emp = q.getResultList();
		return emp;

	}

	@Override
	public Employee findById(int id) {

		Employee emp = em.find(Employee.class, id);

		return emp;
	}

	@Override
	public void save(Employee emp) {
		// save or update the employee

		Employee ee = em.merge(emp);
		// if id is 0 then it will save other wise update.

		// update with id from db ... so can get generated id for save/insert.

		emp.setId(ee.getId());

	}

	@Override
	public void deletebyId(int id) {

		Query q = em.createQuery("delete from Employee where id=:empId");
		q.setParameter("empId", id);
		q.executeUpdate();

	}

}
