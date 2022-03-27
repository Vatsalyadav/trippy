package com.tripmanagement.asdc.service;

//import java.util.List;

import com.tripmanagement.asdc.model.User;
import com.tripmanagement.asdc.model.VehicleOwner;

public interface VehicleOwnerService {

	public boolean saveVehicleOwner(User user);

	public VehicleOwner getVehicleOwner(String email);

	public VehicleOwner getVehicleOwnerByOwnerId(int vehicleOwnerId);

}