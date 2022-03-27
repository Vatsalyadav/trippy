package com.tripmanagement.asdc.dao;

import java.util.List;

import com.tripmanagement.asdc.model.Booked_Rides;

public interface BookedRidesDAO {

	public boolean saveRide(Booked_Rides booked_rides);
	public List<Booked_Rides> getUpcomingRidesForCustomer(int customer_id, String timestamp);
	public List<Booked_Rides> getPreviousRidesForCustomer(int customer_id, String timestamp);

}