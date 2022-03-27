package com.tripmanagement.asdc.service;

import com.tripmanagement.asdc.dao.BookedRidesDAO;
import com.tripmanagement.asdc.model.Booked_Rides;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

}
