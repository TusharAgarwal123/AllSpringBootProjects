package com.springMVC.demo.service;

import org.springframework.stereotype.Service;

import com.springMVC.demo.entity.Faculty;
import com.springMVC.demo.entity.User;

public interface UserService {

	void save(User u);
	void save(Faculty f);

}
