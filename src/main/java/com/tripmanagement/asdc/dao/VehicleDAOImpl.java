package com.tripmanagement.asdc.dao;

import com.tripmanagement.asdc.model.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleDAOImpl implements VehicleDAO {

	Logger logger = LoggerFactory.getLogger(VehicleDAOImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

	@Override
	public boolean addVehicle(Vehicle vehicle) {
		try {
			String sql = "insert into vehicle values(" + null + "," + vehicle.getVehicleowner_id() + ",'" + vehicle.getNumber_plate() + "','" + vehicle.getVehicle_name() + "','" + vehicle.getType() + "'," + vehicle.getTrips() + "," + vehicle.getKms_driven() + "," + vehicle.getAvailable_seats() + "," + vehicle.getFuel_economy() + "," + vehicle.getFuel_consumed()+ ",'"+vehicle.getBrand() +"','"+vehicle.getFuel_economy_status() + "');";
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
		try{
		Vehicle vehicle=jdbcTemplate.queryForObject("select * from vehicle where vehicle_id="+vehicle_id,
		BeanPropertyRowMapper.newInstance(Vehicle.class));
	   return vehicle;
		}
		catch(Exception e)
		{
			logger.error("Error getting vehicle details",e);
			return null;

		}
	}

	@Override
	public List<Vehicle> getVehicles(int vehicleOwnerId) {
		List<Vehicle> vehicles=new ArrayList<>();
		try{
		vehicles= jdbcTemplate.query("select * from vehicle where vehicleOwner_id="+vehicleOwnerId,
				BeanPropertyRowMapper.newInstance(Vehicle.class));
		return vehicles;
		}
		catch(Exception e)
		{
			logger.error("Error getting list of vehicles",e);
			return vehicles;

		}
	}

	@Override
	public boolean updateVehicleFuelEconomy(Vehicle vehicle) {
		try{
		String sql = "update vehicle set fuel_economy="+vehicle.getFuel_economy()+",kms_driven="+vehicle.getKms_driven()+",fuel_consumed="+vehicle.getFuel_consumed()+",fuel_economy_status='"+vehicle.getFuel_economy_status()+"' where vehicle_id="+vehicle.getVehicle_id();
        jdbcTemplate.update(sql);
		return true;
		}
		catch(Exception e)
		{
			logger.error("Error updating fuel economy",e);
			return false;

		}

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










