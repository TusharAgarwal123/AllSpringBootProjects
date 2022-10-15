package com.security.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.demo.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

	Role findByname(String name);

}
