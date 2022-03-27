package com.tripmanagement.asdc.dao;

import java.sql.Date;
import java.util.List;

import com.tripmanagement.asdc.model.Trip;

public interface TripDAO {

	public boolean saveTrip(Trip trip);
	public Trip getTripDetails(int trip_id);
	public List<Trip> getUpcomingTripsForVehicleOwner(int vehicleOwnerId, String timestamp);
	public List<Trip> getPreviousTripsForVehicleOwner(int vehicleOwnerId, String timestamp);
	public boolean deleteTrip(int trip_id);
	public List<Trip> getAvailableTripsList(String source, String destination, String timestamp);
	public List<String> getSources();
	public List<String> getDestinations();
	
}