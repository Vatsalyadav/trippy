package com.tripmanagement.asdc.dao;

import com.tripmanagement.asdc.model.VehicleOwner;

public interface VehicleOwnerDAO {

	public boolean saveVehicleOwner(VehicleOwner carOwner);

	public VehicleOwner getVehicleOwnerByEmail(String email);

	public VehicleOwner getVehicleOwnerById(int vehicleOwnerId);

	public boolean updateAvaialableCredits(int vehicleOwnerId, int available_credits);


}