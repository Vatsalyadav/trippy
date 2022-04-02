package com.tripmanagement.asdc.service;

import com.tripmanagement.asdc.dao.CustomerDAO;
import com.tripmanagement.asdc.model.Customer;
import com.tripmanagement.asdc.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class CustomerServiceImplTest {

    @Autowired
    CustomerService customerService;

    @Mock
    CustomerDAO customerDAO;


    @Test
    void testSaveNullCustomer() {
        assertFalse(customerService.saveCustomer(null));
    }

    @Test
    void testSaveEmptyCustomer() {
        assertFalse(customerService.saveCustomer(new User()));
    }

    @Test
    void testSaveCustomerCorrect() {

        User user = new User();
        user.setFirst_name("test");
        Customer customer = new Customer();
        customer.setCustomer_fname("Sania");
        customer.setCustomer_id(1);
        customer.setCustomer_lname("kumar");
        customer.setEmail("someemail@dal.ca");
        customer.setPassword("password");
        user.setLast_name("case");
        user.setEmail("test@case.com");
        user.setPassword("123456");
        user.setUserType("CUSTOMER");
        when(customerDAO.saveCustomer(customer)).thenReturn(true);
        boolean result = customerService.saveCustomer(user);
        assertTrue(result);
    }
    @Test
    void testSaveCustomerIllegaleName() {

        User user = new User();
        user.setFirst_name("test\'");
        user.setLast_name("case");
        user.setEmail("test@case.com");
        user.setPassword("123456");
        user.setUserType("CUSTOMER");
        Customer customer = new Customer();
        customer.setCustomer_fname("Sania");
        customer.setCustomer_id(1);
        customer.setCustomer_lname("kumar");
        customer.setEmail("someemail@dal.ca");
        customer.setPassword("password");
        when(customerDAO.saveCustomer(customer)).thenReturn(false);
        boolean result = customerService.saveCustomer(user);
        assertFalse(result);
    }

    @Test
    void testGetCustomerByCorrectEmail() {
        Customer customer = new Customer();
        customer.setCustomer_fname("Sania");
        customer.setCustomer_id(1);
        customer.setCustomer_lname("kumar");
        customer.setEmail("someemail@dal.ca");
        customer.setPassword("password");
        String email= "svt@gmail.com";
        when(customerDAO.getCustomerByEmail(email)).thenReturn(customer);
        Customer result = customerService.getCustomerByEmail(email);
        assertTrue(result!=null);
    }
    @Test
    void testGetCustomerByIllegalEmail() {
        String email= "svt@gmail.com\'";
        when(customerDAO.getCustomerByEmail(email)).thenReturn(null);
        Customer result = customerService.getCustomerByEmail(email);
        assertNull(result);
    }

    @Test
    void testGetCustomerByWrongEmail() {
        String email= "fjvnfk.vfjnvjf";
        when(customerDAO.getCustomerByEmail(email)).thenReturn(null);
        Customer result = customerService.getCustomerByEmail(email);
        assertNull(result);
    }

    @Test
    void testGetCustomerByNullEmail() {
        String email= null;
        when(customerDAO.getCustomerByEmail(email)).thenReturn(null);
        Customer result = customerService.getCustomerByEmail(email);
        assertNull(result);
       // assertNull(customerService.getCustomerByEmail(null));
    }

    @Test
    void testGetCustomerByEmptyEmail() {
        String email= "";
        when(customerDAO.getCustomerByEmail(email)).thenReturn(null);
        Customer result = customerService.getCustomerByEmail(email);
        assertNull(result);
       // assertNull(customerService.getCustomerByEmail(""));
    }

    @Test
    void testGetCustomerByWrongId(){
        int id = -1;
        Customer customer = new Customer();
        when(customerDAO.getCustomerById(id)).thenReturn(customer);
        Customer result= customerService.getCustomerById(id);
        assertNull(result);
       // assertNull(customerService.getCustomerById(-1));
    }
    @Test
    void testGetCustomerByCorrectId(){
        int id = 1;
        Customer customer = new Customer();
        customer.setCustomer_fname("Sania");
        customer.setCustomer_id(1);
        customer.setCustomer_lname("kumar");
        customer.setEmail("test@gmail.com");
        customer.setPassword("password");
        when(customerDAO.getCustomerById(id)).thenReturn(customer);
        Customer result= customerService.getCustomerById(id);
//        assertNotNull(customerService.getCustomerById(1));
        assertTrue(result!=null);
    }

    @Test
    void testupdateAvaialableCredits(){
        int customer_id = 9;
        Customer customer = new Customer();
        customer.setCustomer_fname("Sania");
        customer.setCustomer_id(1);
        customer.setCustomer_lname("kumar");
        customer.setEmail("test@gmail.com");
        customer.setPassword("password");
        when(customerDAO.getCustomerById(customer_id)).thenReturn(customer);
        when(customerDAO.updateAvaialableCredits(customer_id,100)).thenReturn(true);
        boolean result = customerService.buyCredits(customer_id,100);
        assertTrue(result);
        // assertTrue(customerService.buyCredits(9,22));
    }
}