package com.tripmanagement.asdc.service.customer;

import com.tripmanagement.asdc.model.users.Customer;
import com.tripmanagement.asdc.model.users.User;

public interface CustomerService {


	public boolean saveCustomer(User user);

	public Customer getCustomerByEmail(String email);

	public Customer getCustomerById(int id);

	public boolean buyCredits(int customer_id, int credits);

	
}