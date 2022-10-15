package com.security.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.demo.model.AppUser;
import com.security.demo.model.Role;
import com.security.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserResource {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<AppUser>> getUsers() {
		return ResponseEntity.ok().body(userService.getUsers());
		// here response will be 200 ok.
	}

	@PostMapping("/user/save")
	public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user) {
		return ResponseEntity.ok().body(userService.saveUser(user));
	}

	@PostMapping("/role/save")
	public ResponseEntity<Role> saveRole(@RequestBody Role role) {
		return ResponseEntity.ok().body(userService.saveRole(role));
	}

	@PostMapping("/role/addtouser/{rolename}/{username}")
	public ResponseEntity<?> addRoleToUser(@PathVariable("rolename") String rolename,
			@PathVariable("username") String username) {
		userService.addRoleToUser(username, rolename);
		return ResponseEntity.ok().build();
	}
	

}
