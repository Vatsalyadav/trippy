package com.tripmanagement.asdc.service;

import com.tripmanagement.asdc.model.Customer;

import java.util.List;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int theId);

	//public void deleteCustomer(int theId);
	
}