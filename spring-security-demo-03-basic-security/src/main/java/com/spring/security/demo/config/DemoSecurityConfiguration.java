package com.spring.security.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// add users for in memory authentications

		UserBuilder user = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
				.withUser(user.username("Tushar").password("Tushar@12345").roles("Employee", "Leader", "Developer",
						"Batsman"))
				.withUser(user.username("Agarwal").password("Agarwal@12345").roles("Employee", "Manager", "Designer"))
				.withUser(user.username("Rohit").password("Sharma@12345").roles("Employee", "Batsman"));

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/").hasRole("Employee")
		.antMatchers("/leaders/**").hasRole("Batsman")
		.antMatchers("/admin/**").hasRole("Designer")
		.and()
		.exceptionHandling()
		.accessDeniedPage("/access-denied");

	}

}
