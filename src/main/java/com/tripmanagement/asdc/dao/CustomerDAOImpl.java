package com.tripmanagement.asdc.dao;

import com.tripmanagement.asdc.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public void saveCustomer(Customer customer) {
        String sql = "insert into customer values("+null+",'"+customer.getCustomer_fname()+"','"+customer.getCustomer_lname()+"','"+customer.getMobile_no()+"','"+customer.getAddress()+"','"+customer.getEmail()+"','"+customer.getOwner_tag()+"','"+customer.getPassword()+"');";
        jdbcTemplate.update(sql);
        //notificationService.sendEmail(customer.getCustomer_fname()+ StringMessages.USER_REGISTERED_SUCCESSFULLY,StringMessages.AUTH_SUCCESSFUL,customer.getEmail());
    }

    @Override
    public Customer getCustomer(String email) {
        Customer customer=jdbcTemplate.queryForObject("select * from customer where email='"+email+"'",
        BeanPropertyRowMapper.newInstance(Customer.class));
       return customer;
    }

    @Override
    public Customer getCustomer(int id) {
        Customer customer=jdbcTemplate.queryForObject("select * from customer where customer_id="+id,
        BeanPropertyRowMapper.newInstance(Customer.class));
       return customer;
    }
    
}
