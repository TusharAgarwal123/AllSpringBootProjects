package com.spring.security.demo.dao;

import com.spring.security.demo.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);

}
