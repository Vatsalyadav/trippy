package com.tripmanagement.asdc.dao;

import java.util.List;

import com.tripmanagement.asdc.model.Trip;

public interface TripDAO {

	public void saveTrip(Trip trip);
	public Trip getTripDetails(int trip_id);
	public List<Trip> getTripsList(int vehicleOwnerId);
	public void deleteTrip(int trip_id);
	
}