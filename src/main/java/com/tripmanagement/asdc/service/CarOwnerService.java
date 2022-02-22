package com.tripmanagement.asdc.service;

//import java.util.List;

import com.tripmanagement.asdc.model.CarOwner;;

public interface CarOwnerService {

	//public List<CarOwner> getCustomers();

	public void saveCarOwner(CarOwner carOwner);

	public CarOwner getCarOwner(int theId);

	//public void deleteCustomer(int theId);
	
}