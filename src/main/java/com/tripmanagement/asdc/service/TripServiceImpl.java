package com.tripmanagement.asdc.service;

import java.util.List;

import com.tripmanagement.asdc.dao.TripDAO;
import com.tripmanagement.asdc.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TripServiceImpl implements TripService {

	@Autowired
	TripDAO tripDAO;
	
	@Override
	@Transactional
	public void saveTrip(Trip trip) {
		tripDAO.saveTrip(trip);
		
	}

	@Override
	@Transactional
	public Trip getTripDetails(int trip_id) {
		Trip trip=tripDAO.getTripDetails(trip_id);
		return trip;
	}

	@Override
	@Transactional
	public List<Trip> getTripsList(int vehicleOwnerId) {
		List<Trip> trips=tripDAO.getTripsList(vehicleOwnerId);
		return trips;
	}

	@Override
	@Transactional
	public void deleteTrip(int trip_id) {
		tripDAO.deleteTrip(trip_id);
		
	}

}





