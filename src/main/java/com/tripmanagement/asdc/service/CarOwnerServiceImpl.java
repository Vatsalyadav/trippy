package com.tripmanagement.asdc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tripmanagement.asdc.dao.CarOwnerDAO;
import com.tripmanagement.asdc.model.CarOwner;

@Service
public class CarOwnerServiceImpl implements CarOwnerService {

	// need to inject customer dao
	@Autowired
	private CarOwnerDAO carOwnerDAO;
	
	
	@Override
	@Transactional
	public void saveCarOwner(CarOwner carOwner) {

		carOwnerDAO.saveCarOwner(carOwner);
	}

	@Override
	@Transactional
	public CarOwner getCarOwner(int theId) {
		
		return carOwnerDAO.getCarOwner(theId);
	}

}





