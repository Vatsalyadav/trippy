package com.tripmanagement.asdc.service;

import java.util.List;

import com.tripmanagement.asdc.model.FuelEconomy;
import com.tripmanagement.asdc.model.Vehicle;

public interface VehicleService {

	public boolean addVehicle(Vehicle vehicle);
	public Vehicle getVehicleDetails(int vehicle_id);
	public List<Vehicle> getVehicles(int vehicleOwnerId);
	public boolean updateFuelEconomy(int vehicle_id, float kms_driven, float fuel_consumed);
	public float setFuel_economy(float kms_driven, float fuel_consumed);
	public boolean deleteVehicle(int vehicleId);
	public boolean saveFuelEconomy(FuelEconomy fuelEconomy);
	
}