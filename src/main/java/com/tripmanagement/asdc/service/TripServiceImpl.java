package com.tripmanagement.asdc.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tripmanagement.asdc.dao.TripDAO;
import com.tripmanagement.asdc.dao.VehicleDAO;
import com.tripmanagement.asdc.dao.VehicleOwnerDAO;
import com.tripmanagement.asdc.model.Ride;
import com.tripmanagement.asdc.model.Trip;
import com.tripmanagement.asdc.model.Vehicle;
import com.tripmanagement.asdc.model.VehicleOwner;

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
	
	@Override
	@Transactional
	public void saveTrip(Trip trip) {
		tripDAO.saveTrip(trip);
		
	}

	@Override
	@Transactional
	public Trip getTripDetails(int trip_id) {
		Trip trip=tripDAO.getTripDetails(trip_id);
		return trip;
	}

	@Override
	@Transactional
	public List<Trip> getUpcomingTripsForVehicleOwner(int vehicleOwnerId) {
		return tripDAO.getUpcomingTripsForVehicleOwner(vehicleOwnerId, getCurrentTime());
	}

	@Override
	@Transactional
	public void deleteTrip(int trip_id) {
		tripDAO.deleteTrip(trip_id);
		
	}

	@Override
	@Transactional
	public List<Ride> getAvailableTripsList(String source, String destination) {
		List<Ride> rideList=new ArrayList<>();
		List<Trip> tripList=tripDAO.getAvailableTripsList(source, destination,getCurrentTime());
		for(Trip trip:tripList)
		{
			Vehicle vehicle=vehicleDAO.getVehicleDetails(trip.getVehicle_id());
			VehicleOwner vehicleOwner=vehicleOwnerDAO.getVehicleOwnerById(trip.getVehicleowner_id());
			Ride ride=new Ride(trip.getTrip_id(), vehicle.getVehicle_name(), vehicle.getNumber_plate(),
					vehicle.getFuel_economy(), vehicleOwner.getVehicleowner_fname(), vehicle.getVehicleowner_id(),
					vehicleOwner.getPhone(), calculateCost(vehicle,trip), trip.getAvailable_seats());
			rideList.add(ride);
		}
		return rideList;
	}

	@Override
	@Transactional
	public float calculateCost(Vehicle vehicle, Trip trip) {

		float cost=(float)(trip.getEstimated_kms()*vehicle.getFuel_economy()*(float)1.20)/vehicle.getAvailable_seats();
		return cost;
	}

	@Override
	@Transactional
	public List<Trip> getUpcomingTripsForCustomer(int customer_id) {
		return tripDAO.getUpcomingTripsForCustomer(customer_id, getCurrentTime());
	}

	@Override
	@Transactional
	public List<Trip> getPreviousTripsForVehicleOwner(int vehicleOwnerId) {
		return tripDAO.getPreviousTripsForVehicleOwner(vehicleOwnerId, getCurrentTime());
	}

	@Override
	@Transactional
	public List<Trip> getPreviousTripsForCustomer(int customer_id) {
		return tripDAO.getPreviousTripsForCustomer(customer_id, getCurrentTime());
	}


	public Date getCurrentTime()
	{
		long millis = System.currentTimeMillis(); 
    	Date currentDateTime = new Date(millis);
		return currentDateTime;
	}

}





