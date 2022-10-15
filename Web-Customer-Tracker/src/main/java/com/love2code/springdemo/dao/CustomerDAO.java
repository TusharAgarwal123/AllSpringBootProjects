package com.love2code.springdemo.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.love2code.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

}
