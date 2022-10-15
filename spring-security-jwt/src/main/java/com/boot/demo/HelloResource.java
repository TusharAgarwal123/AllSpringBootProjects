package com.boot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.demo.util.JWtUtil;

import model.AuthenticationRequest;
import model.AuthenticationResponse;

@RestController
public class HelloResource {

	@Autowired
	private AuthenticationManager am;

	@Autowired
	private MyUserDetailService ms;

	@Autowired
	private JWtUtil ju;

	@GetMapping("/hello")
	public String hello() {
		return "hello-world";
	}

	// when we hit this uri so we will not see the form bcoz we have authorize that
	// request in
	// our SecurityConfigure.java
	@PostMapping("/authenticate")
	public ResponseEntity<?> createToken(@RequestBody AuthenticationRequest ar) throws Exception {
		try {
			am.authenticate(new UsernamePasswordAuthenticationToken(ar.getUsername(), ar.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails details = ms.loadUserByUsername(ar.getUsername());

		final String jwt = ju.generateToken(details);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
