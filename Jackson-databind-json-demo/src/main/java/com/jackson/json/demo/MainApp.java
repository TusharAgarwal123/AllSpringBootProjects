package com.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MainApp {

	public static void main(String[] args) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			Student std = mapper.readValue(new File("data/sample2.json"), Student.class);
			System.out.println("FirstName: " + std.getFirstName());
			System.out.println("LastName: " + std.getLastName());
			System.out.println("ID: " + std.getId());
			System.out.println("IsActive: " + std.isActive());
			System.out.println("Addresses: " + std.getAddress());
			for (String str : std.getLanguages()) {
				System.out.println(str);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
