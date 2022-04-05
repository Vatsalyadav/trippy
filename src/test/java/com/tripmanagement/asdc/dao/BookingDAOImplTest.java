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
        booking.setCustomer_id(4);
        booking.setTimestamp("2022-04-01");
        booking.setCost(1);
        booking.setSeats_booked(0);
        booking.setTrip_id(1);
        booking.setIsPaid(0);
        assertFalse(bookingDAO.saveRide(booking));
    }
//
//
//    @Test
//    void testSaveNullRide() {
//        Booking booking=null;
//        assertFalse(bookingDAO.saveRide(booking));
//
//    }
//    @Test
//    void testSaveEmptyRide() {
//        Booking booking=new Booking();
//        assertFalse(bookingDAO.saveRide(booking));
//
//    }
//    @Test
//    void testSaveCorrectRide() {
//
//        Booking booking = new Booking(100,111,"2022-03-31",55,55,2,111,1);
//        //Booking booking=new Booking(100, "test_source", "test_destination", 2, 4, 3, 3, "2022-01-01", 20, 23);
//        assertTrue(bookingDAO.saveRide(booking));
//
//    }


}
