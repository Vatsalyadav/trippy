package com.tripmanagement.asdc.service;

import com.tripmanagement.asdc.dao.CustomerDAO;
import com.tripmanagement.asdc.model.Customer;
import com.tripmanagement.asdc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;


	@Override
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

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
	public Customer getCustomer(int theId) {
		return customerDAO.getCustomer(theId);
	}

}





