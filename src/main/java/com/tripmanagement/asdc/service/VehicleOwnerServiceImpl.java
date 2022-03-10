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
	private VehicleOwnerDAO carOwnerDAO;
	
	
	@Override
	@Transactional
	public void saveVehicleOwner(VehicleOwner carOwner) {

		carOwnerDAO.saveVehicleOwner(carOwner);
	}

	@Override
	@Transactional
	public VehicleOwner getVehicleOwner(int theId) {
		
		return carOwnerDAO.getVehicleOwner(theId);
	}

}





