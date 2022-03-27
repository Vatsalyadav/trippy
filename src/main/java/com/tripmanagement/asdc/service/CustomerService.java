package com.tripmanagement.asdc.service;

import com.tripmanagement.asdc.model.Customer;
import com.tripmanagement.asdc.model.User;

public interface CustomerService {


	public boolean saveCustomer(User user);

	public Customer getCustomerByEmail(String email);

	public Customer getCustomerById(int id);

	//public void deleteCustomer(int theId);

//	public List<Ride> searchRides(Ride rideData);


	
}