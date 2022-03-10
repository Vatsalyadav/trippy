package com.tripmanagement.asdc.dao;

//import java.util.List;
import com.tripmanagement.asdc.model.VehicleOwner;

public interface VehicleOwnerDAO {

	//public List<CarOwner> getCustomers();

	public void saveCarOwner(VehicleOwner carOwner);

	public VehicleOwner getCarOwner(int theId);

	//public void deleteCustomer(int theId);
	
}