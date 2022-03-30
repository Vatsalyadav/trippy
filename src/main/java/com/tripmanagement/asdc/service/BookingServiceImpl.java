package com.tripmanagement.asdc.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tripmanagement.asdc.dao.BookingDAO;
import com.tripmanagement.asdc.dao.CustomerDAO;
import com.tripmanagement.asdc.dao.TripDAO;
import com.tripmanagement.asdc.model.Booking;
import com.tripmanagement.asdc.model.Trip;
import com.tripmanagement.asdc.stringsAndConstants.StringMessages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingDAO bookedRidesDAO;

	@Autowired
	TripDAO tripDAO;

	@Autowired
	CustomerDAO customerDAO;
	
	@Autowired
	NotificationService notificationService;

	@Override
	public boolean saveRide(Booking booking) {
		try{
		Trip trip= tripDAO.getTripDetails(booking.getTrip_id());
		if(trip.getAvailable_seats()-booking.getSeats_booked()>=0){
		boolean isSuccess=bookedRidesDAO.saveRide(booking);
		if(isSuccess){
			notificationService.sendEmail(StringMessages.RIDE_BOOKED_SUCCESSFULLY,StringMessages.RIDE_BOOKED,customerDAO.getCustomerById(booking.getCustomer_id()).getEmail());
			tripDAO.updateAvailableSeats(trip.getTrip_id(), booking.getSeats_booked());
		}
			return isSuccess;
				}
		return false;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Booking> getUpcomingRidesForCustomer(int customer_id) {
		try{
		return bookedRidesDAO.getUpcomingRidesForCustomer(customer_id, getCurrentTime().toString());
		}
		catch(Exception e)
		{
			return new ArrayList<Booking>();
		}
	}

	@Override
	public List<Booking> getPreviousRidesForCustomer(int customer_id) {
		try{
		return bookedRidesDAO.getPreviousRidesForCustomer(customer_id, getCurrentTime().toString());
		}
		catch(Exception e)
		{
			return new ArrayList<Booking>();
		}

}
public Date getCurrentTime()
	{
		long millis = System.currentTimeMillis(); 
    	Date currentDateTime = new Date(millis);
		return currentDateTime;
	}
}
