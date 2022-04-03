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
import com.tripmanagement.asdc.util.Utility;
import com.tripmanagement.asdc.stringsAndConstants.ServiceStringMessages;

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
		if(trip==null||trip.getSource()==null)
			return false;
		try {
			trip.setCost(calculateCost(vehicleDAO.getVehicleDetails(trip.getVehicle_id()), trip));
			trip.setSeats_remaining(trip.getAvailable_seats());
			boolean isSuccess = tripDAO.saveTrip(trip);
			if (isSuccess) {
				String message = ServiceStringMessages.RIDE_CREATED_SUCCESSFULLY + trip.getSource() + "-->" + trip.getDestination();
				int vehicleowner_id = vehicleDAO.getVehicleDetails(trip.getVehicle_id()).getVehicleowner_id();
				String email = vehicleOwnerDAO
						.getVehicleOwnerById(
								vehicleowner_id)
						.getEmail();
				notificationService.sendEmail(message, ServiceStringMessages.RIDE_CREATED,
						email);
			}
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
				String current_time = Utility.getCurrentTime();
				trip.setStart_time(Utility.convertDate(trip.getStart_time()));
				trip.setEnd_time(Utility.convertDate(trip.getEnd_time()));
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
			List<Trip> tripList = tripDAO.getAvailableTripsList(source, destination, Utility.getCurrentTime().toString());
			for (Trip trip : tripList) {
				Vehicle vehicle = vehicleDAO.getVehicleDetails(trip.getVehicle_id());
				int vehicleowner_id = vehicleDAO.getVehicleDetails(trip.getVehicle_id()).getVehicleowner_id();
				VehicleOwner vehicleOwner = vehicleOwnerDAO.getVehicleOwnerById(vehicleowner_id);
				String start_time = trip.getEnd_time().replace("T", " ");
				//Float value
				trip.setStart_time(Utility.convertDate(trip.getStart_time()));
				trip.setEnd_time(Utility.convertDate(trip.getEnd_time()));
				int id = vehicle.getVehicle_id();
				String number_plate = vehicle.getNumber_plate();
				float economy = vehicle.getFuel_economy();
				String fname = vehicleOwner.getVehicleowner_fname();
				int ownerId = vehicle.getVehicleowner_id();
				String phone = vehicleOwner.getPhone();
				float cost = calculateCost(vehicle, trip);
				int seats = trip.getAvailable_seats();
				Ride ride = new Ride(trip, id, number_plate,
						economy, fname, ownerId,
						phone, cost, seats);
				if(trip.getSeats_remaining()>0)
				{
				String current_time = Utility.getCurrentTime();
				Date start = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH).parse(start_time);
				Date current = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH).parse(current_time);
				if (current.compareTo(start) < 0) {
					rideList.add(ride);
				}
				}
			}
			return rideList;
		} catch (Exception e) {
			return new ArrayList<Ride>();

		}
	}

	@Override
	@Transactional
	public float calculateCost(Vehicle vehicle, Trip trip) {
		if (vehicle == null || trip == null) {
			return 0;
		} else if (vehicle.getAvailable_seats() == 0) {
			return 0;
		} else {
			return 1.2f * (trip.getEstimated_kms() / (vehicle.getFuel_economy() * vehicle.getAvailable_seats())); //Magic number that was predetermined by stakeholders to ensure that the vehicle owner reaps profit
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
				trip.setStart_time(Utility.convertDate(trip.getStart_time()));
				trip.setEnd_time(Utility.convertDate(trip.getEnd_time()));
				String current_time = Utility.getCurrentTime();
				Date start = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH).parse(end_time);
				Date current = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH).parse(current_time);
				if (current.compareTo(start) > 0) {
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



}
