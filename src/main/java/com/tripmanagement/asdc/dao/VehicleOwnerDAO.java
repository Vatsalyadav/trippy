package com.tripmanagement.asdc.dao;

import com.tripmanagement.asdc.model.VehicleOwner;

public interface VehicleOwnerDAO {

	public void saveVehicleOwner(VehicleOwner carOwner);

	public VehicleOwner getVehicleOwner(String email);

	public VehicleOwner getVehicleOwnerById(int vehicleOwnerId);

}