package com.tripmanagement.asdc.dao;

import java.util.List;

import com.tripmanagement.asdc.model.Vehicle;

public interface VehicleDAO {

	public Boolean addVehicle(Vehicle vehicle);
	public Vehicle getVehicleDetails(int vehicle_id);
	public List<Vehicle> getVehicles(int vehicleOwnerId);
	public void updateFuelEconomy(int vehicle_id, float fuelEconomy);
	public Boolean deleteVehicle(int vehicleId);
	
}