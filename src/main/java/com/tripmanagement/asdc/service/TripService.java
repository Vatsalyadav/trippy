package com.tripmanagement.asdc.service;

import java.util.List;

import com.tripmanagement.asdc.model.Ride;
import com.tripmanagement.asdc.model.Trip;
import com.tripmanagement.asdc.model.Vehicle;

public interface TripService {

	public void saveTrip(Trip trip);
	public Trip getTripDetails(int trip_id);
	public List<Trip> getTripsList(int vehicleOwnerId);
	public void deleteTrip(int trip_id);
	public List<Ride> getTripsList(String source, String destination);
	public float calculateCost(Vehicle vehicle,Trip trip);
	
}