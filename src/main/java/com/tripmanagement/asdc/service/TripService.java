package com.tripmanagement.asdc.service;
import java.util.List;

import com.tripmanagement.asdc.model.Ride;
import com.tripmanagement.asdc.model.Trip;
import com.tripmanagement.asdc.model.Vehicle;

public interface TripService {

	public boolean saveTrip(Trip trip);
	public Trip getTripDetails(int trip_id);
	public List<Trip> getUpcomingTripsForVehicleOwner(int vehicleOwnerId);
	public List<Trip> getPreviousTripsForVehicleOwner(int vehicleOwnerId);
	public boolean deleteTrip(int trip_id);
	public List<Ride> getAvailableTripsList(String source, String destination);
	public float calculateCost(Vehicle vehicle,Trip trip);
	public List<String> getSources();
	public List<String> getDestinations();
	
}