package com.tripmanagement.asdc.dao;

import java.util.List;

import com.tripmanagement.asdc.model.Customer;

public interface CustomerDAO {

    public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int theId);

    	//public void deleteCustomer(int theId);

    
}
