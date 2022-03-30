package com.tripmanagement.asdc.dao;

import java.util.List;

import com.tripmanagement.asdc.model.Booking;

public interface BookingDAO {

	public boolean saveRide(Booking booked_rides);
	public List<Booking> getUpcomingRidesForCustomer(int customer_id, String timestamp);
	public List<Booking> getPreviousRidesForCustomer(int customer_id, String timestamp);

}