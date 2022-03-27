package com.tripmanagement.asdc.dao;

import com.tripmanagement.asdc.model.Booked_Rides;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookedRidesDAOImpl implements BookedRidesDAO {


	@Autowired
	JdbcTemplate jdbcTemplate;

	Logger logger = LoggerFactory.getLogger(BookedRidesDAOImpl.class);


	@Override
	public boolean saveRide(Booked_Rides booked_rides) {
		try{
			String sql = "insert into booked_rides values("+null+",'"+booked_rides.getSource()+"','"+booked_rides.getDestination()+"',"+booked_rides.getDistance()+booked_rides.getVehicle_id()+","+booked_rides.getVehicleowner_id()+","+booked_rides.getCustomer_id()+","+booked_rides.getTimestamp()+","+booked_rides.getCost()+","+booked_rides.getFuel_economy()+");";
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
	public List<Booked_Rides> getUpcomingRidesForCustomer(int customer_id, String timestamp) {
		List<Booked_Rides> rides=new ArrayList<>();
		try{
			rides= jdbcTemplate.queryForList("select * from booked_rides where customer_id="+customer_id,
					Booked_Rides.class);
			return rides;
		}
		catch(Exception e)
		{
			logger.error("Error while getting upcoming rides for customer", e);
			return rides;

		}
	}

	@Override
	public List<Booked_Rides> getPreviousRidesForCustomer(int customer_id, String timestamp) {
		List<Booked_Rides> rides=new ArrayList<>();
		try{
			rides= jdbcTemplate.queryForList("select * from booked_rides where customer_id="+customer_id,
					Booked_Rides.class);
			return rides;
		}
		catch(Exception e)
		{
			logger.error("Error while getting previous ride for customer", e);
			return rides;
		}
	}


}










