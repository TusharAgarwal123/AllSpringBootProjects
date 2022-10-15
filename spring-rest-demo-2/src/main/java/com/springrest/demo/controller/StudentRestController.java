package com.springrest.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.demo.config.StudentErrorResponse;
import com.springrest.demo.config.StudentNotFoundException;
import com.springrest.demo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> st;

	// define the @postConstruct to load the student data..only once.

	@PostConstruct
	public void loadData() {
		st = new ArrayList<Student>();
		st.add(new Student("Tushar", "Agarwal"));
		st.add(new Student("Rohit", "Sharma"));
		st.add(new Student("Virat", "Kohli"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {

		return st;
	}

	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable int id) {

		if (id >= st.size() || id < 0) {
			throw new StudentNotFoundException("Student id not found: " + id);
		}

		return st.get(id);
	}

}
