package com.tripmanagement.asdc.dao;

import com.tripmanagement.asdc.model.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationDAOImpl implements LocationDAO {

	Logger logger = LoggerFactory.getLogger(LocationDAOImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

	@Override
	public boolean addLocation(Location location) {
		try {
			String sql = "insert into location values(" + null + "," + location.getVehicle_id() + ",'" + location.getCurrent_location() + "','" + location.getDestination() + "'," + location.getEstimated_kms()+");";
			jdbcTemplate.update(sql);
			logger.info("Location successfully added.");
			return true;
		} catch (Exception exception){
			logger.error("Error while adding location", exception);
			return false;
		}
	}

	@Override
	public List<String> getSources() {
		List<String> sources= jdbcTemplate.queryForList("select distinct current_location from location",String.class);
		return sources;
	}

	@Override
	public List<String> getDestinations() {
		List<String> destinations= jdbcTemplate.queryForList("select distinct destination from location",String.class);
		return destinations;
	}

	
}










