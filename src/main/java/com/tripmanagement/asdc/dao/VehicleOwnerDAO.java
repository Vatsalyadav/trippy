package com.tripmanagement.asdc.dao;

import java.util.List;
import com.tripmanagement.asdc.model.VehicleOwner;

public interface VehicleOwnerDAO {

	public List<VehicleOwner> getVehicleOwners();

	public void saveVehicleOwner(VehicleOwner carOwner);

	public VehicleOwner getVehicleOwner(int theId);

	
}