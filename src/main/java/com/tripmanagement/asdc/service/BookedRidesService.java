package com.tripmanagement.asdc.service;

import java.util.List;

import com.tripmanagement.asdc.model.Booked_Rides;


public interface BookedRidesService {

	public boolean saveRide(Booked_Rides booked_rides);
	public List<Booked_Rides> getUpcomingRidesForCustomer(int customer_id);
	public List<Booked_Rides> getPreviousRidesForCustomer(int customer_id);

	
}