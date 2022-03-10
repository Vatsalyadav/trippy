package com.tripmanagement.asdc.service;

//import java.util.List;

import com.tripmanagement.asdc.model.VehicleOwner;;

public interface VehicleOwnerService {

	//public List<CarOwner> getCustomers();

	public void saveCarOwner(VehicleOwner carOwner);

	public VehicleOwner getCarOwner(int theId);

	//public void deleteCustomer(int theId);
	
}