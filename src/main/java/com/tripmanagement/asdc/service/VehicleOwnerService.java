package com.tripmanagement.asdc.service;

import java.util.List;

//import java.util.List;

import com.tripmanagement.asdc.model.VehicleOwner;;

public interface VehicleOwnerService {

	public List<VehicleOwner> getVehicleOwners();

	public void saveCarOwner(VehicleOwner carOwner);

	public VehicleOwner getCarOwner(int theId);

	//public void deleteCustomer(int theId);
	
}