package com.tripmanagement.asdc.service;

import com.tripmanagement.asdc.model.Customer;
import com.tripmanagement.asdc.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class CustomerServiceImplTest {

    @Autowired
    CustomerService customerService;

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
        user.setLast_name("case");
        user.setEmail("test@case.com");
        user.setPassword("123456");
        user.setUserType("CUSTOMER");

            assertTrue(customerService.saveCustomer(user));
    }
    @Test
    void testSaveCustomerIllegaleName() {

        User user = new User();
        user.setFirst_name("test\'");
        user.setLast_name("case");
        user.setEmail("test@case.com");
        user.setPassword("123456");
        user.setUserType("CUSTOMER");
            assertFalse(customerService.saveCustomer(user));
    }

    @Test
    void testGetCustomerByCorrectEmail() {
        assertTrue(customerService.getCustomerByEmail("svt@gmail.com")!=null);
    }
  @Test
    void testGetCustomerByIllegalEmail() {
        assertNull(customerService.getCustomerByEmail("svt@gmail.com\'"));
    }

    @Test
    void testGetCustomerByWrongEmail() {
        assertNull(customerService.getCustomerByEmail("fjvnfk.vfjnvjf"));
    }

    @Test
    void testGetCustomerByNullEmail() {
        assertNull(customerService.getCustomerByEmail(null));
    }

    @Test
    void testGetCustomerByEmptyEmail() {
        assertNull(customerService.getCustomerByEmail(""));
    }

    @Test
    void testGetCustomerByWrongId(){
        assertNull(customerService.getCustomerById(-1));
    }
    @Test
    void testGetCustomerByCorrectId(){
        assertNotNull(customerService.getCustomerById(1));

    }
    @Test
    void testupdateAvaialableCredits(){
        assertTrue(customerService.buyCredits(9,22));
    }
}