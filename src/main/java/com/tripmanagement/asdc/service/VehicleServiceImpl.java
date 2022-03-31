package com.tripmanagement.asdc.service;

import java.util.ArrayList;
import java.util.List;

import com.tripmanagement.asdc.dao.FuelEconomyDAO;
import com.tripmanagement.asdc.dao.VehicleDAO;
import com.tripmanagement.asdc.model.FuelEconomy;
import com.tripmanagement.asdc.model.Vehicle;
import com.tripmanagement.asdc.stringsAndConstants.FuelEconomyStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleDAO vehicleDAO;

	@Autowired
	FuelEconomyDAO fuelEconomyDAO;

	@Override
	@Transactional
	public boolean addVehicle(Vehicle vehicle) {
		try {
			float economy = setFuel_economy(vehicle.getKms_driven(), vehicle.getFuel_consumed());
			vehicle.setFuel_economy(economy);
			vehicle.setFuel_economy_status(getFuelEconomyStatus(economy));
			vehicleDAO.addVehicle(vehicle);
			FuelEconomy fuelEconomy = new FuelEconomy();
			fuelEconomy.setFuel_consumed(vehicle.getFuel_consumed());
			fuelEconomy.setKms_travelled(vehicle.getKms_driven());
			fuelEconomy.setFuel_economy(economy);
			fuelEconomy.setVehicle_id(vehicle.getVehicle_id());
			saveFuelEconomy(fuelEconomy);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public Vehicle getVehicleDetails(int vehicle_id) {
		try{
		Vehicle vehicle=vehicleDAO.getVehicleDetails(vehicle_id);
		return vehicle;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	@Transactional
	public List<Vehicle> getVehicles(int vehicleOwnerId) {
		try{
		List<Vehicle> vehicles=vehicleDAO.getVehicles(vehicleOwnerId);
		return vehicles;
		}
		catch(Exception e)
		{
			return new ArrayList<Vehicle>();
		}
	}

	@Override
	@Transactional
	public boolean updateFuelEconomy(int vehicle_id, float kms_driven, float fuel_consumed) {
		try{
		float fuelEco=setFuel_economy(kms_driven, fuel_consumed);
		vehicleDAO.updateFuelEconomy(vehicle_id, fuelEco);
		FuelEconomy fuelEconomy = new FuelEconomy();
		fuelEconomy.setFuel_consumed(fuel_consumed);
		fuelEconomy.setKms_travelled(kms_driven);
		fuelEconomy.setFuel_economy(fuelEco);
		fuelEconomy.setVehicle_id(vehicle_id);
		saveFuelEconomy(fuelEconomy);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	@Transactional
	public boolean deleteVehicle(int vehicleId) {
		try{
		return vehicleDAO.deleteVehicle(vehicleId);
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public float setFuel_economy(float kms_driven, float fuel_consumed) {
		float fuelEconomy = 0.00f;
		if ((int) fuel_consumed != 0) {
			fuelEconomy = kms_driven / fuel_consumed;
		}
		return (float) Math.round(fuelEconomy * 100.0) / 100.0f;
	}

	private String getFuelEconomyStatus(float fuelEconomy) {
		if (fuelEconomy > 16)
			return FuelEconomyStatus.GOOD.name();
		else if (fuelEconomy < 8)
			return FuelEconomyStatus.BAD.name();
		else return FuelEconomyStatus.AVERAGE.name();
	}

	@Override
	public boolean saveFuelEconomy(FuelEconomy fuelEconomy) {
		try{
		fuelEconomyDAO.saveFuelEconomy(fuelEconomy);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	

}





