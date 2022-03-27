package com.tripmanagement.asdc.service;

import com.tripmanagement.asdc.model.Booked_Rides;

import java.util.List;


public interface BookedRidesService {

	public boolean saveRide(Booked_Rides booked_rides);
	public List<Booked_Rides> getUpcomingRidesForCustomer(int customer_id);
	public List<Booked_Rides> getPreviousRidesForCustomer(int customer_id);

	
}