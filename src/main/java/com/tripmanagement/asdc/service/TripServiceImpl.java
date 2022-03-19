package com.tripmanagement.asdc.service;

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
	public List<Trip> getTripsList(int vehicleOwnerId) {
		List<Trip> trips=tripDAO.getTripsList(vehicleOwnerId);
		return trips;
	}

	@Override
	@Transactional
	public void deleteTrip(int trip_id) {
		tripDAO.deleteTrip(trip_id);
		
	}

	@Override
	public List<Ride> getTripsList(String source, String destination) {
		List<Ride> rideList=new ArrayList<>();
		List<Trip> tripList=tripDAO.getTripsList(source, destination);
		for(Trip trip:tripList)
		{
			Vehicle vehicle=vehicleDAO.getVehicleDetails(trip.getVehicle_id());
			VehicleOwner vehicleOwner=vehicleOwnerDAO.getVehicleOwnerById(trip.getVehicleowner_id());
			Ride ride=new Ride(trip.getTrip_id(), vehicle.getVehicle_name(), vehicle.getFuel_consumed(), vehicleOwner.getVehicleowner_fname(), vehicleOwner.getPhone(), calculateCost(vehicle,trip));
			rideList.add(ride);
		}
		return rideList;
	}

	@Override
	public float calculateCost(Vehicle vehicle, Trip trip) {

		float cost=(float)(trip.getEstimated_kms()*vehicle.getFuel_economy()*(float)1.20)/vehicle.getAvailable_seats();
		return cost;
	}

}





