package com.tripmanagement.asdc.dao;

import com.tripmanagement.asdc.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

	Logger logger = LoggerFactory.getLogger(CustomerDAOImpl.class);

    @Override
    public boolean saveCustomer(Customer customer) {
        try{
        String sql = "insert into customer values("+null+",'"+customer.getCustomer_fname()+"','"+customer.getCustomer_lname()+"','"+customer.getMobile_no()+"','"+customer.getAddress()+"','"+customer.getEmail()+"','"+customer.getOwner_tag()+"','"+customer.getPassword()+"');";
        jdbcTemplate.update(sql);
        return true;
        //notificationService.sendEmail(customer.getCustomer_fname()+ StringMessages.USER_REGISTERED_SUCCESSFULLY,StringMessages.AUTH_SUCCESSFUL,customer.getEmail());
        }
        catch(Exception e)
        {
            logger.error("Error saving customers",e);
            return false;
        }
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        if(email==null||email.isEmpty())
        return null;
        try{
        Customer customer=jdbcTemplate.queryForObject("select * from customer where email='"+email+"'",
        BeanPropertyRowMapper.newInstance(Customer.class));
        return customer;
        }
        catch(Exception e)
        {
            logger.error("Error getting customer by email",e);
            return null;
        }
    }

    @Override
    public Customer getCustomerById(int id) {
        try{
        Customer customer=jdbcTemplate.queryForObject("select * from customer where customer_id="+id,
        BeanPropertyRowMapper.newInstance(Customer.class));
        return customer;
        }
        catch(Exception e)
        {
            logger.error("Error getting customer by Id",e);
            return null;
        }
    }
    
}
