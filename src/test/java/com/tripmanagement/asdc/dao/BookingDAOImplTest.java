package com.tripmanagement.asdc.dao;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import com.tripmanagement.asdc.model.Booking;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BookingDAOImplTest {

    @Autowired
    BookingDAO bookingDAO;

    @Test
    void testSaverideCorrect() {
        Booking booking = new Booking();
        booking.setCustomer_id(4);
        booking.setTimestamp("2022-04-01");
        booking.setCost(1);
        booking.setSeats_booked(0);
        booking.setTrip_id(1);
        booking.setIsPaid(0);
        assertTrue(bookingDAO.saveRide(booking));
    }

    @Test
    void testSaverideIncorrect() {
        Booking booking = new Booking();
        booking.setTimestamp("");
        assertFalse(bookingDAO.saveRide(booking));
    }

    @Test
    void testgetAllridesforCustomerCorrect() {
        assertTrue(bookingDAO.getAllRidesForCustomer(4).size()>0);
    }
    @Test
    void testgetAllridesforCustomerWrong() {
        assertFalse(bookingDAO.getAllRidesForCustomer(-1).size()>0);
    }

    @Test
    void testupdateIsPaidCorrect() {
        assertTrue(bookingDAO.updateIsPaid(4,1));
    }

}
