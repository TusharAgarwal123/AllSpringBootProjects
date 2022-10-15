package com.security.demo.service;

import java.util.List;

import com.security.demo.model.AppUser;
import com.security.demo.model.Role;

public interface UserService {

	AppUser saveUser(AppUser appUser);

	Role saveRole(Role role);

	void addRoleToUser(String username, String rolename);

	AppUser getUser(String username);

	List<AppUser> getUsers();

}
