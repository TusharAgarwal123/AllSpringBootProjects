package com.spring.security.demo.dao;

import com.spring.security.demo.entity.User;

public interface UserDao {

	User findByUserName(String userName);

	void save(User user);
}
