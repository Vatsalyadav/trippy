package com.tripmanagement.asdc.service;

import com.tripmanagement.asdc.dao.CustomerDAO;
import com.tripmanagement.asdc.model.Customer;
import com.tripmanagement.asdc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public boolean saveCustomer(User user) {
		if(user==null||user.getFirst_name()==null)
		return false;
		try{
		Customer customer = new Customer();
		customer.setCustomer_fname(user.getFirst_name());
		customer.setCustomer_lname(user.getLast_name());
		customer.setEmail(user.getEmail());
		customer.setPassword(user.getPassword());
		return customerDAO.saveCustomer(customer);
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		if(email==null||email.isEmpty())
		return null;
		try{
		Customer customer= customerDAO.getCustomerByEmail(email);
		return customer;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public Customer getCustomerById(int id) {
		try{
			Customer customer= customerDAO.getCustomerById(id);
			return customer;
		}
		catch(Exception e)
		{
			return null;
		}
	}

}





