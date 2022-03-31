package com.tripmanagement.asdc.service;

import com.tripmanagement.asdc.dao.CustomerDAO;
import com.tripmanagement.asdc.model.Customer;
import com.tripmanagement.asdc.model.User;
import com.tripmanagement.asdc.stringsAndConstants.StringMessages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private NotificationService notificationService;

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
		boolean isSuccess= customerDAO.saveCustomer(customer);
		if(isSuccess)
		notificationService.sendEmail("Hey "+customer.getCustomer_fname()+StringMessages.USER_REGISTERED_SUCCESSFULLY,StringMessages.AUTH_SUCCESSFUL,customer.getEmail());
		return isSuccess;
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





