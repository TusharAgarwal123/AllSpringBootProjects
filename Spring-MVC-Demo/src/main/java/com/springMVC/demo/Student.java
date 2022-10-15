package com.springMVC.demo;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	
	private String lastName;
	private String country;
	// private LinkedHashMap<String, String> countryOptions;
	private String favouriteLanguage;
	private String favouriteOS[];

	public Student() {

//		countryOptions = new LinkedHashMap<String, String>();
//		countryOptions.put("br", "brazil");
//		countryOptions.put("in", "India");
//		countryOptions.put("pak", "pakistan");
	}

	public String[] getFavouriteOS() {
		return favouriteOS;
	}

	public void setFavouriteOS(String[] favouriteOS) {
		this.favouriteOS = favouriteOS;
	}

	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}

	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
