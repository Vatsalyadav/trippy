package com.tripmanagement.asdc.dao;

import com.tripmanagement.asdc.model.VehicleOwner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class VehicleOwnerDAOImpl implements VehicleOwnerDAO {


    @Autowired
    JdbcTemplate jdbcTemplate;

	Logger logger = LoggerFactory.getLogger(VehicleOwnerDAOImpl.class);


	@Override
	public boolean saveVehicleOwner(VehicleOwner vehicleOwner) {
		try{
        String sql = "insert into vehicleowner values("+null+",'"+vehicleOwner.getVehicleowner_fname()+"','"+vehicleOwner.getVehicleowner_lname()+"','"+vehicleOwner.getPhone()+"','"+vehicleOwner.getEmail()+"','"+vehicleOwner.getPassword()+"',"+vehicleOwner.getAvailable_credits()+");";
        jdbcTemplate.update(sql);
			return true;
	}
		catch(Exception e)
		{
			logger.error("Error saving vehicleOwner",e);
			return false;

		}
		
	}

	@Override
	public VehicleOwner getVehicleOwnerByEmail(String email) {
		if(email==null)
		return null;
		try{
			String selectvehicleOwnerQuery = "select * from vehicleowner where email='" + email + "'";
			VehicleOwner vehicleOwner = jdbcTemplate.query(selectvehicleOwnerQuery, new ResultSetExtractor<VehicleOwner>() {
				@Override
				public VehicleOwner extractData(ResultSet rs) throws SQLException,
						DataAccessException {
					if (rs.next()) {
						VehicleOwner v = new VehicleOwner();
						v.setEmail(rs.getString("email"));
						v.setVehicleowner_fname(rs.getString("vehicleowner_fname"));
						v.setVehicleowner_lname(rs.getString("vehicleowner_lname"));
						v.setPhone(rs.getString("phone"));
						v.setAvailable_credits(rs.getInt("available_credits"));
						v.setVehicleOwner_id(rs.getInt("vehicleowner_id"));
						return v;
					} else return null;
				}
			});
	  return vehicleOwner;
		}
		catch(Exception e)
		{
			logger.error("Error getting vehicleOwner by email ",e);
			return null;

		}
	}

	@Override
	public VehicleOwner getVehicleOwnerById(int vehicleOwnerId) {
		try{
			String selectVehicleOwnerQuery = "select * from vehicleowner where vehicleOwner_id=" + vehicleOwnerId;
			return jdbcTemplate.queryForObject(selectVehicleOwnerQuery,
				BeanPropertyRowMapper.newInstance(VehicleOwner.class));
		}
		catch(Exception e)
		{
			logger.error("Error getting vehicleOwner by id ",e);
			return null;

		}
	}

	@Override
    public boolean updateAvaialableCredits(int vehicleOwnerId, int available_credits) {
        try{
			String sql = "update vehicleowner set available_credits="+available_credits+" where vehicleowner_id="+vehicleOwnerId;
			jdbcTemplate.update(sql);
			return true;
			}
			catch(Exception e)
			{
				logger.error("Error updating available credits in VehicleOwner",e);
				return false;
	
			}
    }

}










