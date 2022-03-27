package com.tripmanagement.asdc.dao;

import com.tripmanagement.asdc.model.FuelEconomy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class FuelEconomyDAOImpl implements FuelEconomyDAO {


	@Autowired
	JdbcTemplate jdbcTemplate;

	Logger logger = LoggerFactory.getLogger(FuelEconomyDAOImpl.class);


	@Override
	public boolean saveFuelEconomy(FuelEconomy fuel_economy) {
		try{
			String sql = "insert into fuel_economy values("+null+","+fuel_economy.getTrip_id()+","+fuel_economy.getKms_travelled()+","+fuel_economy.getFuel_consumed()+","+fuel_economy.getFuel_economy()+",'"+fuel_economy.getTimestamp()+"',"+fuel_economy.getVehicle_id()+");";
			jdbcTemplate.update(sql);
			return true;
		}
		catch(Exception e)
		{
			logger.error("Error saving fuel_economy",e);
			return false;

		}
	}


}










