package com.tripmanagement.asdc.service;

import java.util.List;

import com.tripmanagement.asdc.dao.VehicleDAO;
import com.tripmanagement.asdc.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleDAO vehicleDAO;
	
	@Override
	@Transactional
	public boolean addVehicle(Vehicle vehicle) {
		vehicle.setFuel_economy(setFuel_economy(vehicle.getKms_driven(), vehicle.getFuel_consumed()));
		return vehicleDAO.addVehicle(vehicle);
	}

	@Override
	@Transactional
	public Vehicle getVehicleDetails(int vehicle_id) {
		Vehicle vehicle=vehicleDAO.getVehicleDetails(vehicle_id);
		return vehicle;
	}

	@Override
	@Transactional
	public List<Vehicle> getVehicles(int vehicleOwnerId) {
		List<Vehicle> vehicles=vehicleDAO.getVehicles(vehicleOwnerId);
		return vehicles;
	}

	@Override
	@Transactional
	public void updateFuelEconomy(int vehicle_id, float kms_driven, float fuel_consumed) {
		float fuelEconomy=setFuel_economy(kms_driven, fuel_consumed);
		vehicleDAO.updateFuelEconomy(vehicle_id, fuelEconomy);
	}

	@Override
	@Transactional
	public boolean deleteVehicle(int vehicleId) {
		return vehicleDAO.deleteVehicle(vehicleId);
	}

	@Override
	public float setFuel_economy(float kms_driven, float fuel_consumed) {
		float fuelEconomy=0.00f;
		if((int)fuel_consumed!=0){
			fuelEconomy=fuel_consumed/kms_driven;
		}
		return fuelEconomy;
	}

}





