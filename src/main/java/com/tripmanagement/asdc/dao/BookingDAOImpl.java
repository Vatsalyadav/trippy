package com.tripmanagement.asdc.dao;

import com.tripmanagement.asdc.model.Booking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingDAOImpl implements BookingDAO {


    @Autowired
    JdbcTemplate jdbcTemplate;

	Logger logger = LoggerFactory.getLogger(BookingDAOImpl.class);


	@Override
	public boolean saveRide(Booking booking) {
		try{
		String sql = "insert into booking values("+null+","+booking.getCustomer_id()+",'"+booking.getTimestamp()+"',"+booking.getCost()+","+booking.getSeats_booked()+","+booking.getTrip_id()+","+booking.getIsPaid()+");";
        jdbcTemplate.update(sql);
		logger.debug("Ride saved successfully");
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
		rides= jdbcTemplate.queryForList("select * from booking where customer_id="+customer_id,
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
		rides= jdbcTemplate.queryForList("select * from booking where customer_id="+customer_id,
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










