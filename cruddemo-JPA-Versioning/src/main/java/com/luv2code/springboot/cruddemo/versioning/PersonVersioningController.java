package com.luv2code.springboot.cruddemo.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	@GetMapping("/v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Tushar", "Agarwal");
	}

	@GetMapping("/v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Rohit", "Sharma"));
	}

	@GetMapping(value = "/person/param", params = "Version=1")
	// to hit this uri we have to write /person/param?Version=1
	public PersonV1 paramV1() {
		return new PersonV1("Tushar", "Agarwal");
	}

	@GetMapping(value = "/person/param", params = "Version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Rohit", "Sharma"));
	}

	@GetMapping(value = "/person/header", headers = "Version=1")
	// now this time we have to give version in header
	public PersonV1 headerV1() {
		return new PersonV1("Tushar", "Agarwal");
	}

	@GetMapping(value = "/person/header", headers = "Version=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Rohit", "Sharma"));
	}

}
