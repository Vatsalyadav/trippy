package com.tripmanagement.asdc.dao;

import com.tripmanagement.asdc.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class TripDAOmpl implements TripDAO {


    @Autowired
    JdbcTemplate jdbcTemplate;

	@Override
	public void saveTrip(Trip trip) {
		String sql = "insert into trip values("+null+",'"+trip.getSource()+"','"+trip.getDestination()+"',"+trip.getEstimated_kms()+","+trip.getLocation_id()+","+trip.getVehicle_id()+","+trip.getVehicleowner_id()+","+trip.getCustomer_id()+","+trip.getTimestamp()+","+trip.getKms_travelled()+");";
        jdbcTemplate.update(sql);
		
	}

	@Override
	public Trip getTripDetails(int trip_id) {
		Trip trip=jdbcTemplate.queryForObject("select * from trip where trip_id="+trip_id,
		BeanPropertyRowMapper.newInstance(Trip.class));
	   return trip;
	}

	@Override
	public List<Trip> getUpcomingTripsForVehicleOwner(int vehicleOwnerId, Date timestamp) {
		List<Trip> trips= jdbcTemplate.queryForList("select * from trip where vehicleOwner_id="+vehicleOwnerId+" and timestamp >"+timestamp,
		Trip.class);
		return trips;
	}


	@Override
	public void deleteTrip(int trip_id) {
		String sql = "delete from Trip where trip_id="+trip_id;
        jdbcTemplate.update(sql);
		
	}

	@Override
	public List<Trip> getAvailableTripsList(String source, String destination, Date timestamp) {
		List<Trip> trips= jdbcTemplate.query("select * from trip where source='"+source+"' and destination='"+destination+"'"+" and timestamp >"+timestamp,
				BeanPropertyRowMapper.newInstance(Trip.class));
		return trips;
	}

	@Override
	public List<Trip> getUpcomingTripsForCustomer(int customer_id, Date timestamp) {
		List<Trip> trips= jdbcTemplate.queryForList("select * from trip where customer_id="+customer_id+" and timestamp >"+timestamp,
		Trip.class);
		return trips;
	}

	@Override
	public List<Trip> getPreviousTripsForVehicleOwner(int vehicleOwnerId, Date timestamp) {
		List<Trip> trips= jdbcTemplate.queryForList("select * from trip where vehicleOwner_id="+vehicleOwnerId+" and timestamp <="+timestamp,
		Trip.class);
		return trips;
	}

	@Override
	public List<Trip> getPreviousTripsForCustomer(int customer_id, Date timestamp) {
		List<Trip> trips= jdbcTemplate.queryForList("select * from trip where customer_id="+customer_id+" and timestamp <="+timestamp,
		Trip.class);
		return trips;
	}

	
}










