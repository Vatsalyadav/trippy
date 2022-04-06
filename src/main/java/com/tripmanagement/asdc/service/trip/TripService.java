package com.tripmanagement.asdc.service.trip;
import java.util.List;

import com.tripmanagement.asdc.model.rideSharing.Ride;
import com.tripmanagement.asdc.model.rideSharing.Trip;
import com.tripmanagement.asdc.model.vehicle.Vehicle;

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