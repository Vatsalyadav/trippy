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

import com.tripmanagement.asdc.model.CarOwner;

@Repository
public class CarOwnerDAOImpl implements CarOwnerDAO {


    @Autowired
    JdbcTemplate jdbcTemplate;



	@Override
	public void saveCarOwner(CarOwner carOwner) {

        String sql = "insert into car_owner values("+carOwner.getId()+","+carOwner.getFirstName()+","+carOwner.getLastName()+","+carOwner.getEmail()+");";
        jdbcTemplate.update(sql);
		
	}

	@Override
	public CarOwner getCarOwner(int theId) {
	   CarOwner carOwner=jdbcTemplate.queryForObject("select * from car_owner where ID="+theId,
       BeanPropertyRowMapper.newInstance(CarOwner.class));
	  return carOwner;
	}
    


    
    


}










