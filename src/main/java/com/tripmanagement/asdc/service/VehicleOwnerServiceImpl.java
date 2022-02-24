package com.tripmanagement.asdc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tripmanagement.asdc.dao.VehicleOwnerDAO;
import com.tripmanagement.asdc.model.VehicleOwner;

@Service
public class VehicleOwnerServiceImpl implements VehicleOwnerService {

	// need to inject customer dao
	@Autowired
	private VehicleOwnerDAO carOwnerDAO;
	
	
	@Override
	@Transactional
	public void saveCarOwner(VehicleOwner carOwner) {

		carOwnerDAO.saveCarOwner(carOwner);
	}

	@Override
	@Transactional
	public VehicleOwner getCarOwner(int theId) {
		
		return carOwnerDAO.getCarOwner(theId);
	}

}





