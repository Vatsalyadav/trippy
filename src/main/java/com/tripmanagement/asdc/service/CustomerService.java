package com.tripmanagement.asdc.service;

import com.tripmanagement.asdc.model.Customer;
import com.tripmanagement.asdc.model.User;

import java.util.List;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(User user);

	public Customer getCustomer(int theId);

	//public void deleteCustomer(int theId);

//	public List<Ride> searchRides(Ride rideData);


	
}