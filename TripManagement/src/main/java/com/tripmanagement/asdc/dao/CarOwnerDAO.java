package com.tripmanagement.asdc.dao;

//import java.util.List;
import com.tripmanagement.asdc.model.CarOwner;

public interface CarOwnerDAO {

	//public List<CarOwner> getCustomers();

	public void saveCarOwner(CarOwner carOwner);

	public CarOwner getCarOwner(int theId);

	//public void deleteCustomer(int theId);
	
}