package com.springMVC.demo.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springMVC.demo.entity.Faculty;
import com.springMVC.demo.entity.User;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional
	public void save(User u) {

		Session ss = sf.getCurrentSession();
		ss.save(u);

	}

	@Override
	@Transactional
	public void save(Faculty f) {
		Session ss = sf.getCurrentSession();
		ss.save(f);

	}

}
