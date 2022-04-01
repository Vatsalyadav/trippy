package com.tripmanagement.asdc.service;

import com.tripmanagement.asdc.dao.BookingDAO;
import com.tripmanagement.asdc.dao.CustomerDAO;
import com.tripmanagement.asdc.dao.TripDAO;
import com.tripmanagement.asdc.dao.VehicleDAO;
import com.tripmanagement.asdc.dao.VehicleOwnerDAO;
import com.tripmanagement.asdc.model.Booking;
import com.tripmanagement.asdc.model.Customer;
import com.tripmanagement.asdc.model.Trip;
import com.tripmanagement.asdc.model.VehicleOwner;
import com.tripmanagement.asdc.stringsAndConstants.StringMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.transaction.Transactional;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingDAO bookedRidesDAO;

	@Autowired
	TripDAO tripDAO;

	@Autowired
	CustomerDAO customerDAO;

	@Autowired
	VehicleOwnerDAO vehicleOwnerDAO;

	@Autowired
	NotificationService notificationService;

	Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

	@Override
	@Transactional
	public boolean saveRide(Booking booking) {
		try {
			logger.debug("Inside saveRide method of BookingServiceImpl");
			Trip trip = tripDAO.getTripDetails(booking.getTrip_id());
			if ((trip.getSeats_remaining()) - booking.getSeats_booked() >= 0) {
				booking.setCost(trip.getCost());
				booking.setTimestamp(String.valueOf(System.currentTimeMillis()));
				booking.setIsPaid(0);
				logger.debug("There are available seats in the vehicle, attempting to book " + booking.getSeats_booked()
						+ " seats now");
				boolean isSuccess = bookedRidesDAO.saveRide(booking);
				if (isSuccess) {
					logger.debug("Successfully booked seats");
					notificationService.sendEmail(StringMessages.RIDE_BOOKED_SUCCESSFULLY+trip.getSource()+"-->"+trip.getDestination(), StringMessages.RIDE_BOOKED,
							customerDAO.getCustomerById(booking.getCustomer_id()).getEmail());
					tripDAO.updateAvailableSeats(trip.getTrip_id(),
							trip.getSeats_remaining() - booking.getSeats_booked());
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
	@Transactional
	public List<Booking> getUpcomingRidesForCustomer(int customer_id) {
		try {
			List<Booking> allRides = bookedRidesDAO.getAllRidesForCustomer(customer_id);
			List<Booking> upcomingRides = new ArrayList<>();
			for (Booking ride : allRides) {
				String start_time = ride.getTimestamp().replace("T", " ");
				ride.setTimestamp(ride.getTimestamp().replace("T", " "));
				String current_time = getCurrentTime();
				Date start = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH).parse(start_time);
				Date current = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH).parse(current_time);
				if (current.compareTo(start) < 0) {
					upcomingRides.add(ride);
				}
			}
			return upcomingRides;
		} catch (Exception e) {
			return new ArrayList<Booking>();
		}
	}

	@Override
	@Transactional
	public List<Booking> getPreviousRidesForCustomer(int customer_id) {
		try {
			List<Booking> allRides = bookedRidesDAO.getAllRidesForCustomer(customer_id);
			List<Booking> previousRides = new ArrayList<>();
			for (Booking ride : allRides) {
				String start_time = ride.getTimestamp().replace("T", " ");
				String current_time = getCurrentTime();
				ride.setTimestamp(ride.getTimestamp().replace("T", " "));
				Date end = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH).parse(start_time);
				Date current = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH).parse(current_time);
				if (current.compareTo(end) > 0) {
					previousRides.add(ride);
				}

			}
			return previousRides;
		} catch (Exception e) {
			return new ArrayList<Booking>();
		}

	}

	public String getCurrentTime() {
		long millis = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date resultdate = new Date(millis);
		sdf.setTimeZone(TimeZone.getTimeZone("America/Halifax"));
		return sdf.format(resultdate);
	}

	@Override
	@Transactional
	public boolean updateIsPaid(int customer_id) {
		return bookedRidesDAO.updateIsPaid(customer_id);
	}

	@Override
	@Transactional
	public String payforRide(Booking booking) {
		Customer customer=customerDAO.getCustomerById(booking.getCustomer_id());
		int cost_credits=(int) Math.ceil(booking.getCost());
		if(customer.getAvailable_credits()>= cost_credits)
		{
			bookedRidesDAO.updateIsPaid(customer.getCustomer_id());
			VehicleOwner vehicleOwner=vehicleOwnerDAO.getVehicleOwnerById(tripDAO.getTripDetails(booking.getTrip_id()).getVehicle_owner_id());
			vehicleOwnerDAO.updateAvaialableCredits(vehicleOwner.getVehicleOwner_id(), vehicleOwner.getAvailable_credits()+cost_credits);
			customerDAO.updateAvaialableCredits(customer.getCustomer_id(), customer.getAvailable_credits()-cost_credits);
			return StringMessages.SUCCESS;
		}
		else
		{
			return StringMessages.PLEASE_BUY_CREDITS;
		}
	}



}
