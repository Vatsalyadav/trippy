package com.tripmanagement.asdc.dao.trip;

import java.util.List;

import com.tripmanagement.asdc.model.rideSharing.Trip;

public interface TripDAO {

	public boolean saveTrip(Trip trip);

	public Trip getTripDetails(int trip_id);

	public List<Trip> getAllTripsForVehicleOwner(int vehicleOwnerId);

	public boolean deleteTrip(int trip_id);

	public List<Trip> getAvailableTripsList(String source, String destination, String timestamp);

	public List<String> getSources();

	public List<String> getDestinations();

	public boolean updateAvailableSeats(int trip_id, int available_seats);

}