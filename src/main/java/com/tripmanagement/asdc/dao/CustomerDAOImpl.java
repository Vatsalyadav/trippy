package com.tripmanagement.asdc.dao;

import java.util.List;

import com.tripmanagement.asdc.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> getCustomers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveCustomer(Customer customer) {
        String sql = "insert into vehicleowner values("+customer.getCustomer_id()+","+customer.getCustomer_name()+","+customer.getMobile_no()+","+customer.getAddress()+","+customer.getEmail()+");";
        jdbcTemplate.update(sql);
        
    }

    @Override
    public Customer getCustomer(int theId) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
