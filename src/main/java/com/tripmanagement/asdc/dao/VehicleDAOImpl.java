package com.tripmanagement.asdc.dao;

import com.tripmanagement.asdc.model.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehicleDAOImpl implements VehicleDAO {

	Logger logger = LoggerFactory.getLogger(VehicleDAOImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

	@Override
	public boolean addVehicle(Vehicle vehicle) {
		try {
			String sql = "insert into vehicle values(" + null + "," + vehicle.getVehicleowner_id() + ",'" + vehicle.getNumber_plate() + "','" + vehicle.getVehicle_name() + "','" + vehicle.getType() + "'," + vehicle.getTrips() + "," + vehicle.getKms_driven() + "," + vehicle.getAvailable_seats() + "," + vehicle.getFuel_consumed() + "," + vehicle.getFuel_consumed() + ");";
			jdbcTemplate.update(sql);
			logger.info("Vehicle successfully added.");
			return true;
		} catch (Exception exception){
			logger.error("Error while adding Vehicle", exception);
			return false;
		}

	}

	@Override
	public Vehicle getVehicleDetails(int vehicle_id) {
		Vehicle vehicle=jdbcTemplate.queryForObject("select * from vehicle where vehicle_id="+vehicle_id,
		BeanPropertyRowMapper.newInstance(Vehicle.class));
	   return vehicle;
	}

	@Override
	public List<Vehicle> getVehicles(int vehicleOwnerId) {
		List<Vehicle> vehicles= jdbcTemplate.query("select * from vehicle where vehicleOwner_id="+vehicleOwnerId,
				BeanPropertyRowMapper.newInstance(Vehicle.class));
		return vehicles;
	}

	@Override
	public void updateFuelEconomy(int vehicle_id, float fuelEconomy) {
		String sql = "update Vehicle set fuel_economy="+fuelEconomy+" where vehicle_id="+vehicle_id;
        jdbcTemplate.update(sql);

	}

	@Override
	public boolean deleteVehicle(int vehicleId) {
		try {
			String sql = "delete from Vehicle where vehicle_id=" + vehicleId;
			jdbcTemplate.update(sql);
			logger.info("Vehicle successfully deleted.");
			return true;
		} catch (Exception exception){
			logger.error("Error while deleting Vehicle", exception);
			return false;
		}
	}

	
}










