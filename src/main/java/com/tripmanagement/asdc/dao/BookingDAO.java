package com.tripmanagement.asdc.dao;

import java.util.List;

import com.tripmanagement.asdc.model.Booking;

public interface BookingDAO {

	public boolean saveRide(Booking booking);

	public List<Booking> getAllRidesForCustomer(int customer_id);
}