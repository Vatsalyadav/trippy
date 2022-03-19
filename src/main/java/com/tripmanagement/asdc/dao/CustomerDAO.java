package com.tripmanagement.asdc.dao;

import com.tripmanagement.asdc.model.Customer;

public interface CustomerDAO {

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int theId);

	public Customer getCustomer(String email);

    //public void deleteCustomer(int theId);

    
}
