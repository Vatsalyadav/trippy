package com.tripmanagement.asdc.service;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import com.tripmanagement.asdc.dao.TripDAO;
import com.tripmanagement.asdc.dao.VehicleDAO;
import com.tripmanagement.asdc.dao.VehicleOwnerDAO;
import com.tripmanagement.asdc.model.Ride;
import com.tripmanagement.asdc.model.Trip;
import com.tripmanagement.asdc.model.Vehicle;
import com.tripmanagement.asdc.model.VehicleOwner;
import com.tripmanagement.asdc.stringsAndConstants.StringMessages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TripServiceImpl implements TripService {

	@Autowired
	TripDAO tripDAO;

	@Autowired
	VehicleDAO vehicleDAO;

	@Autowired
	VehicleOwnerDAO vehicleOwnerDAO;

	@Autowired
	NotificationService notificationService;

	@Override
	@Transactional
	public boolean saveTrip(Trip trip) {
		try {
			trip.setCost(calculateCost(vehicleDAO.getVehicleDetails(trip.getVehicle_id()), trip));
			boolean isSuccess = tripDAO.saveTrip(trip);
			if (isSuccess)
				notificationService.sendEmail(StringMessages.RIDE_CREATED_SUCCESSFULLY+trip.getSource()+"-->"+trip.getDestination(), StringMessages.RIDE_CREATED,
						vehicleOwnerDAO
								.getVehicleOwnerById(
										vehicleDAO.getVehicleDetails(trip.getVehicle_id()).getVehicleowner_id())
								.getEmail());
			return isSuccess;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public Trip getTripDetails(int trip_id) {
		try {
			Trip trip = tripDAO.getTripDetails(trip_id);
			return trip;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public List<Trip> getUpcomingTripsForVehicleOwner(int vehicleOwnerId) {
		try {
			List<Trip> allTrips = tripDAO.getAllTripsForVehicleOwner(vehicleOwnerId);
			List<Trip> upcomingTrips = new ArrayList<>();
			for (Trip trip : allTrips) {
				String start_time = trip.getStart_time().replace("T", " ");
				String current_time = getCurrentTime();
				Date start = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH).parse(start_time);
				Date current = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH).parse(current_time);
				if (current.compareTo(start) < 0) {
					upcomingTrips.add(trip);
				}

			}
			return upcomingTrips;
		} catch (Exception e) {
			return new ArrayList<Trip>();
		}
	}

	@Override
	@Transactional
	public boolean deleteTrip(int trip_id) {
		try {
			return tripDAO.deleteTrip(trip_id);
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public List<Ride> getAvailableTripsList(String source, String destination) {
		if (source == null || destination == null)
			return null;
		try {
			List<Ride> rideList = new ArrayList<>();
			List<Trip> tripList = tripDAO.getAvailableTripsList(source, destination, getCurrentTime().toString());
			for (Trip trip : tripList) {
				Vehicle vehicle = vehicleDAO.getVehicleDetails(trip.getVehicle_id());
				VehicleOwner vehicleOwner = vehicleOwnerDAO
						.getVehicleOwnerById(vehicleDAO.getVehicleDetails(trip.getVehicle_id()).getVehicleowner_id());
				Ride ride = new Ride(trip.getTrip_id(), vehicle.getVehicle_id(), vehicle.getNumber_plate(),
						vehicle.getFuel_economy(), vehicleOwner.getVehicleowner_fname(), vehicle.getVehicleowner_id(),
						vehicleOwner.getPhone(), calculateCost(vehicle, trip), trip.getAvailable_seats());
				rideList.add(ride);
			}
			return rideList;
		} catch (Exception e) {
			return new ArrayList<Ride>();

		}
	}

	@Override
	@Transactional
	public float calculateCost(Vehicle vehicle, Trip trip) {
		if (trip == null || vehicle == null || vehicle.getAvailable_seats() == 0)
			return 0;
		else {
			return 1.2f * (trip.getEstimated_kms() / (vehicle.getFuel_economy() * vehicle.getAvailable_seats()));
		}
	}

	@Override
	@Transactional
	public List<Trip> getPreviousTripsForVehicleOwner(int vehicleOwnerId) {
		try {
			List<Trip> allTrips = tripDAO.getAllTripsForVehicleOwner(vehicleOwnerId);
			List<Trip> previousTrips = new ArrayList<>();
			for (Trip trip : allTrips) {
				String end_time = trip.getEnd_time().replace("T", " ");
				String current_time = getCurrentTime();
				Date end = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH).parse(end_time);
				Date current = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH).parse(current_time);
				if (current.compareTo(end) > 0) {
					previousTrips.add(trip);
				}

			}
			return previousTrips;
		} catch (Exception e) {
			return new ArrayList<Trip>();
		}
	}

	@Override
	@Transactional
	public List<String> getSources() {
		return tripDAO.getSources();
	}

	@Override
	@Transactional
	public List<String> getDestinations() {
		return tripDAO.getDestinations();

	}

	public String getCurrentTime() {
		long millis = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date resultdate = new Date(millis);
		sdf.setTimeZone(TimeZone.getTimeZone("America/Halifax"));
		return sdf.format(resultdate);
	}

}
