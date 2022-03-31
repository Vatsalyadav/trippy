package com.tripmanagement.asdc.service;

import com.tripmanagement.asdc.dao.BookingDAO;
import com.tripmanagement.asdc.dao.CustomerDAO;
import com.tripmanagement.asdc.dao.TripDAO;
import com.tripmanagement.asdc.model.Booking;
import com.tripmanagement.asdc.model.Trip;
import com.tripmanagement.asdc.stringsAndConstants.StringMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

	Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

	@Override
	public boolean saveRide(Booking booking) {
		try {
			logger.debug("Inside saveRide method of BookingServiceImpl");
			Trip trip = tripDAO.getTripDetails(booking.getTrip_id());
			if (trip.getAvailable_seats() - booking.getSeats_booked() >= 0) {
				booking.setCost(trip.getCost());
				booking.setTimestamp(String.valueOf(System.currentTimeMillis()));
				booking.setIsPaid(0);
				logger.debug("There are available seats in the vehicle, attempting to book "+booking.getSeats_booked()+" seats now");
				boolean isSuccess = bookedRidesDAO.saveRide(booking);
				if (isSuccess) {
					logger.debug("Successfully booked seats");
					notificationService.sendEmail(StringMessages.RIDE_BOOKED_SUCCESSFULLY, StringMessages.RIDE_BOOKED, customerDAO.getCustomerById(booking.getCustomer_id()).getEmail());
					tripDAO.updateAvailableSeats(trip.getTrip_id(), booking.getSeats_booked());
					logger.debug("Successfully sent notification");
				}
				return isSuccess;
			}
			logger.debug("Seats not available");
			return false;
		} catch (Exception e) {
			logger.error("Unable to book seats", e);
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
