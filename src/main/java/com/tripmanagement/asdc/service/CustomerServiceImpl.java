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
	public void saveCustomer(User user) {
		Customer customer = new Customer();
		customer.setCustomer_fname(user.getFirst_name());
		customer.setCustomer_lname(user.getLast_name());
		customer.setEmail(user.getEmail());
		customer.setPassword(user.getPassword());
		customerDAO.saveCustomer(customer);
	}

	@Override
	public Customer getCustomer(String email) {
		return customerDAO.getCustomer(email);
	}

	@Override
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}

}





