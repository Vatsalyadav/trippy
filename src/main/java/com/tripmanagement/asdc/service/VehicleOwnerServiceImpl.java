package com.tripmanagement.asdc.service;

import com.tripmanagement.asdc.dao.VehicleOwnerDAO;
import com.tripmanagement.asdc.model.VehicleOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VehicleOwnerServiceImpl implements VehicleOwnerService {

	// need to inject customer dao
	@Autowired
	private VehicleOwnerDAO vehicleOwnerDAO;
	
	
	@Override
	@Transactional
	public void saveVehicleOwner(VehicleOwner carOwner) {

		vehicleOwnerDAO.saveVehicleOwner(carOwner);
	}

	@Override
	@Transactional
	public VehicleOwner getVehicleOwner(int theId) {
		
		return vehicleOwnerDAO.getVehicleOwner(theId);
	}

}





