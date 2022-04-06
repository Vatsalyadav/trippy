package com.tripmanagement.asdc.dao.user;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.tripmanagement.asdc.dao.customer.CustomerDAO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

import com.tripmanagement.asdc.model.users.Customer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("/application-test.properties")
class CustomerDAOImplTest {

@Autowired
CustomerDAO customerDAO;

    @Test
    void testSaveNullCustomer() {
        assertFalse(customerDAO.saveCustomer(null));
    }

    @Test
    void testSaveEmptyCustomer() {
        Customer customer = new Customer();
        customer.setCustomer_fname("");
        assertFalse(customerDAO.saveCustomer(customer));
    }

    @Test
    void testSaveCustomer() {
        if(customerDAO.getCustomerByEmail("abc@gmail.com")==null)

        assertTrue(customerDAO.saveCustomer(new Customer(10,"test","case","885858585","test case street","test@case.com","1","123456667",22)));
    }

    @Test
    void testGetCustomerByCorrectEmail() {
    assertTrue(customerDAO.getCustomerByEmail("test@case.com")!=null);
    }

    @Test
    void testGetCustomerByWrongEmail() {
    assertNull(customerDAO.getCustomerByEmail("fjvnfk.vfjnvjf"));
    }

    @Test
    void testGetCustomerBybadEmail() {
    assertNull(customerDAO.getCustomerByEmail("dsd@dskal.com\'"));
    }

    @Test
    void testGetCustomerByEmptyEmail() {
    assertNull(customerDAO.getCustomerByEmail(""));
    }

    @Test
    void testGetCustomerByWrongId(){
        assertNull(customerDAO.getCustomerById(-1));
    }
    @Test
    void testGetCustomerByCorrectId(){
        assertNotNull(customerDAO.getCustomerById(40));

    }
    @Test
    void testupdateAvaialableCredits(){
        assertTrue(customerDAO.updateAvaialableCredits(9,22));
    }
}