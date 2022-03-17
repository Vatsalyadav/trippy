package com.tripmanagement.asdc.service;

import java.util.List;

import com.tripmanagement.asdc.model.Vehicle;

public interface VehicleService {

	public Boolean addVehicle(Vehicle vehicle);
	public Vehicle getVehicleDetails(int vehicle_id);
	public List<Vehicle> getVehicles(int vehicleOwnerId);
	public void updateFuelEconomy(int vehicle_id, float kms_driven, float fuel_consumed);
	public Boolean deleteVehicle(int vehicleId);
	
}