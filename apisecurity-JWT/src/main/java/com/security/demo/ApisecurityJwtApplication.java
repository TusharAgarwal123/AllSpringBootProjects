package com.security.demo;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.security.demo.model.AppUser;
import com.security.demo.model.Role;
import com.security.demo.service.UserService;

@SpringBootApplication
public class ApisecurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApisecurityJwtApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userServeice) {
		return args -> {

			userServeice.saveRole(new Role(null, "ROLE_USER"));
			userServeice.saveRole(new Role(null, "ROLE_MANAGER"));
			userServeice.saveRole(new Role(null, "ROLE_ADMIN"));
			userServeice.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userServeice.saveUser(new AppUser(null, "Tushar", "Tush", "Tushar@12345", new ArrayList<>()));
			userServeice.saveUser(new AppUser(null, "Agarwal", "Agr", "Agarwal@12345", new ArrayList<>()));
			userServeice.saveUser(new AppUser(null, "Rohit", "hitman", "Rohit@12345", new ArrayList<>()));
			userServeice.saveUser(new AppUser(null, "Sharma", "sharmaji", "Sharma@12345", new ArrayList<>()));

			userServeice.addRoleToUser("Tush", "ROLE_USER");
			userServeice.addRoleToUser("Tush", "ROLE_ADMIN");
			userServeice.addRoleToUser("hitman", "ROLE_USER");
			userServeice.addRoleToUser("hitman", "ROLE_MANAGER");
			userServeice.addRoleToUser("Agr", "ROLE_USER");
			userServeice.addRoleToUser("sharmaji", "ROLE_SUPER_ADMIN");

		};
	}

}
