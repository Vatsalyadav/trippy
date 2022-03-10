package com.tripmanagement.asdc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

//import java.util.List;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tripmanagement.asdc.model.VehicleOwner;

@Repository
public class VehicleOwnerDAOImpl implements VehicleOwnerDAO {


    @Autowired
    JdbcTemplate jdbcTemplate;



	@Override
	public void saveCarOwner(VehicleOwner carOwner) {

        String sql = "insert into vehicleowner values("+carOwner.getVehicleowner_id()+","+carOwner.getVehicleowner_name()+","+carOwner.getPhone()+","+carOwner.getAddress()+","+carOwner.getEmail()+","+carOwner.getVehicle_id()+");";
        jdbcTemplate.update(sql);
		
	}

	@Override
	public VehicleOwner getCarOwner(int theId) {
	   VehicleOwner carOwner=jdbcTemplate.queryForObject("select * from vehicleowner where vehicleowner_id="+theId,
       BeanPropertyRowMapper.newInstance(VehicleOwner.class));
	  return carOwner;
	}
    


    
    


}










