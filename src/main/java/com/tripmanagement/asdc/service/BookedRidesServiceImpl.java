package com.tripmanagement.asdc.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tripmanagement.asdc.dao.BookedRidesDAO;

import com.tripmanagement.asdc.model.Booked_Rides;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookedRidesServiceImpl implements BookedRidesService {

	@Autowired
	BookedRidesDAO bookedRidesDAO;

	@Override
	public boolean saveRide(Booked_Rides booked_rides) {
		try{
		bookedRidesDAO.saveRide(booked_rides);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Booked_Rides> getUpcomingRidesForCustomer(int customer_id) {
		try{
		return bookedRidesDAO.getUpcomingRidesForCustomer(customer_id, getCurrentTime().toString());
		}
		catch(Exception e)
		{
			return new ArrayList<Booked_Rides>();
		}
	}

	@Override
	public List<Booked_Rides> getPreviousRidesForCustomer(int customer_id) {
		try{
		return bookedRidesDAO.getPreviousRidesForCustomer(customer_id, getCurrentTime().toString());
		}
		catch(Exception e)
		{
			return new ArrayList<Booked_Rides>();
		}

}
public Date getCurrentTime()
	{
		long millis = System.currentTimeMillis(); 
    	Date currentDateTime = new Date(millis);
		return currentDateTime;
	}
}
