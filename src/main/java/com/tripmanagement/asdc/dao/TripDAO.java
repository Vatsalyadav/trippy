package com.tripmanagement.asdc.dao;

import java.sql.Date;
import java.util.List;

import com.tripmanagement.asdc.model.Trip;

public interface TripDAO {

	public void saveTrip(Trip trip);
	public Trip getTripDetails(int trip_id);
	public List<Trip> getUpcomingTripsForVehicleOwner(int vehicleOwnerId, Date timestamp);
	public List<Trip> getUpcomingTripsForCustomer(int customer_id, Date timestamp);
	public List<Trip> getPreviousTripsForVehicleOwner(int vehicleOwnerId, Date timestamp);
	public List<Trip> getPreviousTripsForCustomer(int customer_id, Date timestamp);
	public void deleteTrip(int trip_id);
	public List<Trip> getAvailableTripsList(String source, String destination, Date timestamp);
	
}