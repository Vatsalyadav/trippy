package com.tripmanagement.asdc.dao.customer;

import com.tripmanagement.asdc.model.users.Customer;

public interface CustomerDAO {

	public boolean saveCustomer(Customer customer);

	public Customer getCustomerById(int theId);

	public Customer getCustomerByEmail(String email);

	public boolean updateAvaialableCredits(int customer_id, int available_credits);


    
}
