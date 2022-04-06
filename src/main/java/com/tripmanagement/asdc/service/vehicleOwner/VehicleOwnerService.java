package com.tripmanagement.asdc.service.vehicleOwner;

//import java.util.List;

import com.tripmanagement.asdc.model.users.User;
import com.tripmanagement.asdc.model.users.VehicleOwner;

public interface VehicleOwnerService {

	public boolean saveVehicleOwner(User user);

	public VehicleOwner getVehicleOwnerByEmail(String email);

	public VehicleOwner getVehicleOwnerByOwnerId(int vehicleOwnerId);

	public boolean buyCredits(int vehicleOwnerId, int credits);


}