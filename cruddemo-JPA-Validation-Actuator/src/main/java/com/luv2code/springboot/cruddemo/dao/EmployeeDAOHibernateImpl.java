package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entitymanager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override

	public List<Employee> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();

		// return the results
		return employees;
	}

	@Override

	public Employee findById(int id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		Employee emp = currentSession.get(Employee.class, id);
		return emp;
	}

	@Override
	public void save(Employee emp) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(emp);
		// if emp id is 0 then it will save otherwise it will update.

	}

	@Override
	public void deletebyId(int id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		Query q = currentSession.createQuery("delete from Employee where id=:empid");
		q.setParameter("empid", id);
		q.executeUpdate();

	}

}
