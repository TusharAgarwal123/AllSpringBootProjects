package com.security.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.security.demo.model.AppUser;
import com.security.demo.model.Role;
import com.security.demo.repo.RoleRepo;
import com.security.demo.repo.UserRepo;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

	private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RoleRepo roleRepo;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public AppUser saveUser(AppUser appUser) {
		logger.info("saving new user {} to database", appUser);
		appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
		return userRepo.save(appUser);
	}

	@Override
	public Role saveRole(Role role) {
		logger.info("saving new role {} to database", role.getName());
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String rolename) {

		logger.info("adding role {} to user {}", rolename, username);
		AppUser user = userRepo.findByUsername(username);
		Role role = roleRepo.findByname(rolename);
		user.getRoles().add(role);

	}

	@Override
	public AppUser getUser(String username) {
		logger.info("fetching user {}", username);
		return userRepo.findByUsername(username);
	}

	@Override
	public List<AppUser> getUsers() {
		logger.info("fetching all the user from database");
		return userRepo.findAll();
	}

	// when we pass username and password for login so this method is execute.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// User class of security is implementation of UserDetails interface.

		AppUser user = userRepo.findByUsername(username);
		if (user == null) {
			logger.error("User not found in the database");
			throw new UsernameNotFoundException("User not found in the database");
		} else {
			logger.error("User found in the database: {}", username);
		}

		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});

		return new User(user.getUsername(), user.getPassword(), authorities);
	}

}
