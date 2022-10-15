package com.boot.demo.model;

public class Employee {

	private int id;
	private String firstName;
	private String lasstName;
	private String email;

	public Employee() {

	}

	public Employee(int id, String firstName, String lasstName, String email) {

		this.id = id;
		this.firstName = firstName;
		this.lasstName = lasstName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLasstName() {
		return lasstName;
	}

	public void setLasstName(String lasstName) {
		this.lasstName = lasstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lasstName=" + lasstName + ", email=" + email
				+ "]";
	}

}
