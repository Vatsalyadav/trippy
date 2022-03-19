package com.tripmanagement.asdc.dao;

import com.tripmanagement.asdc.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
	public List<Trip> getTripsList(int vehicleOwnerId) {
		List<Trip> trips= jdbcTemplate.queryForList("select * from trip where vehicleOwner_id="+vehicleOwnerId,
		Trip.class);
		return trips;
	}


	@Override
	public void deleteTrip(int trip_id) {
		String sql = "delete from Trip where trip_id="+trip_id;
        jdbcTemplate.update(sql);
		
	}

	@Override
	public List<Trip> getTripsList(String source, String destination) {
		List<Trip> trips= jdbcTemplate.query("select * from trip where source='"+source+"' and destination='"+destination+"'",
				BeanPropertyRowMapper.newInstance(Trip.class));
		return trips;
	}

	
}










