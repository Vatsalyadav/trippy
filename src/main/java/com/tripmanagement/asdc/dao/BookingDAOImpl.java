package com.tripmanagement.asdc.dao;

import com.tripmanagement.asdc.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingDAOImpl implements BookingDAO {


    @Autowired
    JdbcTemplate jdbcTemplate;

	Logger logger = LoggerFactory.getLogger(BookingDAOImpl.class);


	@Override
	public boolean saveRide(Booking booked_rides) {
		try{
		String sql = "insert into booked_rides values("+null+","+booked_rides.getCustomer_id()+","+booked_rides.getTimestamp()+","+booked_rides.getCost()+","+booked_rides.getSeats_booked()+","+booked_rides.getTrip_id()+","+booked_rides.getIsPaid()+");";
        jdbcTemplate.update(sql);
		return true;
		}
		catch(Exception e)
		{
			logger.error("Error while adding Rides", e);
			return false;

		}
	}

	@Override
	public List<Booking> getUpcomingRidesForCustomer(int customer_id, String timestamp) {
		List<Booking> rides=new ArrayList<>();
		try{
		rides= jdbcTemplate.queryForList("select * from booked_rides where customer_id="+customer_id,
		Booking.class);
		return rides;
		}
		catch(Exception e)
		{
			logger.error("Error while getting upcoming rides for customer", e);
			return rides;

		}
	}

	@Override
	public List<Booking> getPreviousRidesForCustomer(int customer_id, String timestamp) {
		List<Booking> rides=new ArrayList<>();
		try{
		rides= jdbcTemplate.queryForList("select * from booked_rides where customer_id="+customer_id,
		Booking.class);
		return rides;
		}
		catch(Exception e)
		{
			logger.error("Error while getting previous ride for customer", e);
			return rides;
		}
	}

	
}










