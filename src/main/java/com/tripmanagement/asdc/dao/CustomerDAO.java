package com.tripmanagement.asdc.dao;

import com.tripmanagement.asdc.model.Customer;

public interface CustomerDAO {

	public boolean saveCustomer(Customer customer);

	public Customer getCustomerById(int theId);

	public Customer getCustomerByEmail(String email);

	public boolean updateAvaialableCredits(int customer_id, int available_credits);


    
}
