package com.security.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.demo.model.AppUser;

@Repository
public interface UserRepo extends JpaRepository<AppUser, Long> {

	AppUser findByUsername(String username);

}
