package com.tripmanagement.asdc.service;

import com.tripmanagement.asdc.model.Customer;
import com.tripmanagement.asdc.model.User;

public interface CustomerService {


	public void saveCustomer(User user);

	public Customer getCustomer(String email);

	public Customer getCustomer(int id);

	//public void deleteCustomer(int theId);

//	public List<Ride> searchRides(Ride rideData);


	
}