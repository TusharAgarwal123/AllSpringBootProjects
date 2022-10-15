package com.spring.security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring.security.demo.entity.User;
import com.spring.security.demo.user.CrmUser;

public interface UserService extends UserDetailsService {

	User findByUserName(String userName);

	void save(CrmUser crmUser);

}
