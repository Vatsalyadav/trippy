package com.tripmanagement.asdc.dao;

import com.tripmanagement.asdc.model.Customer;
import com.tripmanagement.asdc.model.VehicleOwner;
import com.tripmanagement.asdc.stringsAndConstants.Constants;
import com.tripmanagement.asdc.stringsAndConstants.StringMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class RegistrationDAOImpl implements RegistrationDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    Logger logger = LoggerFactory.getLogger(RegistrationDAOImpl.class);


    @Override
    public boolean checkUserExistByEmail(String email) {
        try{
        int emailCount = jdbcTemplate.queryForObject("select count(*) from vehicleowner where email='" + email + "'"
                , Integer.class);
        System.out.println(emailCount);
        if (emailCount <= 0)
        {
            emailCount = jdbcTemplate.queryForObject("select count(*) from customer where email='" + email + "'"
                , Integer.class);
            if(emailCount<=0)
            {
                return false;
            }
            else 
                return true;
        }
        else
            return true;
    }
    catch(Exception e)
    {
        logger.error("Error getting user by email",e);
        return false;
    }
    }


    @Override
    public String checkEmailPassword(String email, String password) {
        if(email==null||password==null||password.isEmpty()||email.isEmpty())
            return StringMessages.INCORRECT_AUTH;
        try{
        String fetchCustomer = "select * from customer where email='" + email + "' and password='" + password + "'";
        String fetchVehicleOwner = "select * from vehicleowner where email='" + email + "' and password='" + password + "'";
        Customer customer = jdbcTemplate.query(fetchCustomer, new ResultSetExtractor<Customer>() {
            @Override
            public Customer extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Customer cust = new Customer();
                    cust.setEmail(rs.getString("email"));
                    return cust;
                } else return null;
            }
        });

        VehicleOwner vehicleOwner = jdbcTemplate.query(fetchVehicleOwner, new ResultSetExtractor<VehicleOwner>() {
            @Override
            public VehicleOwner extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    VehicleOwner vo = new VehicleOwner();
                    vo.setEmail(rs.getString("email"));
                    return vo;
                } else return null;
            }
        });

        if (vehicleOwner != null && !vehicleOwner.getEmail().isEmpty())
            return Constants.USER_TYPE_VEHICLE_OWNER;
        else if (customer != null && !customer.getEmail().isEmpty())
            return Constants.USER_TYPE_CUSTOMER;
        else
            return StringMessages.INCORRECT_AUTH;
    }
    catch(Exception e)
    {
        logger.error("Error checking email and password",e);
        return null;
    }
    }


    @Override
    public boolean checkEmailExists(String email, String userType) {
        if(email==null||email.isEmpty()||userType==null||userType.isEmpty())
        return false;
        try{
        if (userType == Constants.USER_TYPE_CUSTOMER) {
            Customer customer = jdbcTemplate.queryForObject("select * from customer where email='" + email + "'",
                    BeanPropertyRowMapper.newInstance(Customer.class));
            if (customer != null && !customer.getEmail().isEmpty())
                return true;
            else
                return false;
        } else if (userType == Constants.USER_TYPE_VEHICLE_OWNER) {
            VehicleOwner carOwner = jdbcTemplate.queryForObject("select * from vehicleowner where email='" + email + "'",
                    BeanPropertyRowMapper.newInstance(VehicleOwner.class));
            if (carOwner != null && !carOwner.getEmail().isEmpty())
                return true;
            else
                return false;
        } else return false;
    }
    catch(Exception e)
    {
        logger.error("Error checking user exist by email",e);
        return false;
    }
    }

}
