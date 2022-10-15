package com.love2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.love2code.springdemo.entity.Customer;

@Repository // applied to implementation of dao.
public class CustomerDaoImplementation implements CustomerDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional // automatically begin and end the transaction for your hibernate code.
	public List<Customer> getCustomers() {

		Session ss = sf.getCurrentSession();

		Query<Customer> qq = ss.createQuery("from Customer", Customer.class); // import org.hibernate.query.Query;

		List<Customer> ll = qq.getResultList();

		return ll;
	}

}
