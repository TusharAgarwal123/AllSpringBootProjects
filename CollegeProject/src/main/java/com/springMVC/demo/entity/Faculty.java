package com.springMVC.demo.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Faculty {

	private String name;

	private String email;

	private int id;

	private String password;

	private String gender;

	private String city;

	private int pinCode;

	public Faculty() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Faculty [name=" + name + ", email=" + email + ", id=" + id + ", password=" + password + ", gender="
				+ gender + ", city=" + city + ", pinCode=" + pinCode + "]";
	}

}
