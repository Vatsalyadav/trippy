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
	public boolean saveVehicleOwner(User user) {
		try{
		VehicleOwner vehicleOwner = new VehicleOwner();
		vehicleOwner.setVehicleowner_fname(user.getFirst_name());
		vehicleOwner.setVehicleowner_lname(user.getLast_name());
		vehicleOwner.setEmail(user.getEmail());
		vehicleOwner.setPassword(user.getPassword());
		return vehicleOwnerDAO.saveVehicleOwner(vehicleOwner);
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	@Transactional
	public VehicleOwner getVehicleOwner(String email) {
		if(email==null)
		return null;
		try{
		return vehicleOwnerDAO.getVehicleOwner(email);
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	@Transactional
	public VehicleOwner getVehicleOwnerByOwnerId(int vehicleOwnerId) {
		try{
		return vehicleOwnerDAO.getVehicleOwnerById(vehicleOwnerId);
		}
		catch(Exception e)
		{
			return null;
		}
	}

}





