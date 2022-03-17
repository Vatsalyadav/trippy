package com.tripmanagement.asdc.dao;

import com.tripmanagement.asdc.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehicleDAOImpl implements VehicleDAO {


    @Autowired
    JdbcTemplate jdbcTemplate;

	@Override
	public void saveVehicle(Vehicle vehicle) {
		String sql = "insert into vehicle values("+null+",'"+vehicle.getVehicle_id()+"','"+vehicle.getVehicleowner_id()+"','"+vehicle.getNumber_plate()+"','"+vehicle.getVehicle_name()+"','"+vehicle.getType()+"',"+vehicle.getTrips()+","+vehicle.getKms_driven()+","+vehicle.getAvailable_seats()+","+vehicle.getFuel_consumed()+","+vehicle.getFuel_consumed()+");";
        jdbcTemplate.update(sql);
		
	}

	@Override
	public Vehicle getVehicleDetails(int vehicle_id) {
		Vehicle vehicle=jdbcTemplate.queryForObject("select * from vehicle where vehicle_id="+vehicle_id,
		BeanPropertyRowMapper.newInstance(Vehicle.class));
	   return vehicle;
	}

	@Override
	public List<Vehicle> getVehicles(int vehicleOwnerId) {
		List<Vehicle> vehicles= jdbcTemplate.queryForList("select * from vehicle where id="+vehicleOwnerId,
		Vehicle.class);
		return vehicles;
	}

	@Override
	public void updateFuelEconomy(int vehicle_id, float fuelEconomy) {
		String sql = "update Vehicle set fuel_economy="+fuelEconomy+" where vehicle_id="+vehicle_id;
        jdbcTemplate.update(sql);
		
	}

	@Override
	public void deleteVehicle(int vehicleId) {
		String sql = "delete from Vehicle where vehicle_id="+vehicleId;
        jdbcTemplate.update(sql);
		
	}

	
}










