package com.tripmanagement.asdc.dao.vehicleOwner;

import com.tripmanagement.asdc.model.users.VehicleOwner;

public interface VehicleOwnerDAO {

	public boolean saveVehicleOwner(VehicleOwner carOwner);

	public VehicleOwner getVehicleOwnerByEmail(String email);

	public VehicleOwner getVehicleOwnerById(int vehicleOwnerId);

	public boolean updateAvaialableCredits(int vehicleOwnerId, int available_credits);


}