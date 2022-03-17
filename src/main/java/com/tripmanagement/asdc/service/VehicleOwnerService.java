package com.tripmanagement.asdc.service;

//import java.util.List;

import com.tripmanagement.asdc.model.User;
import com.tripmanagement.asdc.model.VehicleOwner;

public interface VehicleOwnerService {

	public void saveVehicleOwner(User user);

	public VehicleOwner getVehicleOwner(int theId);

}