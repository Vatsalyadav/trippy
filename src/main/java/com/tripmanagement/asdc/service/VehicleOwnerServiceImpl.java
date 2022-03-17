package com.tripmanagement.asdc.service;

import com.tripmanagement.asdc.dao.VehicleOwnerDAO;
import com.tripmanagement.asdc.model.User;
import com.tripmanagement.asdc.model.VehicleOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VehicleOwnerServiceImpl implements VehicleOwnerService {

	@Autowired
	private VehicleOwnerDAO vehicleOwnerDAO;
	
	
	@Override
	@Transactional
	public void saveVehicleOwner(User user) {
		VehicleOwner vehicleOwner = new VehicleOwner();
		vehicleOwner.setVehicleowner_fname(user.getFirst_name());
		vehicleOwner.setVehicleowner_lname(user.getLast_name());
		vehicleOwner.setEmail(user.getEmail());
		vehicleOwner.setPassword(user.getPassword());
		vehicleOwnerDAO.saveVehicleOwner(vehicleOwner);
	}

	@Override
	@Transactional
	public VehicleOwner getVehicleOwner(int theId) {
		
		return vehicleOwnerDAO.getVehicleOwner(theId);
	}

}





