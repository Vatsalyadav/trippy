package com.tripmanagement.asdc.controller;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.tripmanagement.asdc.model.Booking;
import com.tripmanagement.asdc.model.Customer;
import com.tripmanagement.asdc.model.Ride;
import com.tripmanagement.asdc.model.Trip;

import com.tripmanagement.asdc.service.*;

import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    private CustomerController customerController;

    @Mock
    TripService tripService;

    @Mock
    Trip trip;

    @Mock
    Booking booking;

    @Mock
    BookingService bookingService;

    @Mock
    CustomerService customerService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        Object[] controllers;
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }
   @Test
    public void testsearchRides() throws Exception{
        List<Ride> trips=new ArrayList<>();
        Ride trip1 = new Ride();
        Ride trip2 = new Ride();
        trips.add(trip1);
        trips.add(trip2);
        Trip trip = Mockito.mock(Trip.class);
        when(trip.getSource()).thenReturn("source");
        when(trip.getDestination()).thenReturn("destination");
        when(tripService.getAvailableTripsList(anyString(),anyString())).thenReturn(trips);
        mockMvc.perform(post("/search-rides").sessionAttr("source", "").sessionAttr("destination", "").sessionAttr("sourceList", new ArrayList<String>()).sessionAttr("destinationList", new ArrayList<String>()).sessionAttr("previousRides", new ArrayList<Booking>()).sessionAttr("upcomingRides", new ArrayList<Booking>()).sessionAttr("customer", new Customer()))
                .andExpect(status().isOk())
                .andExpect(view().name("customer-dashboard"));
    }

    @Test
    public void testBookRide() throws Exception{
        when(bookingService.getUpcomingRidesForCustomer(anyInt())).thenReturn(new ArrayList<Booking>());
        mockMvc.perform(post("/book-ride").sessionAttr("source", "").sessionAttr("destination", "").sessionAttr("sourceList", new ArrayList<String>()).sessionAttr("destinationList", new ArrayList<String>()).sessionAttr("previousRides", new ArrayList<Booking>()).sessionAttr("upcomingRides", new ArrayList<Booking>()).sessionAttr("customer", new Customer()))
                .andExpect(status().isOk())
                .andExpect(view().name("customer-dashboard"));
    }
   
    @Test
    public void testOpenCredits() throws Exception{
        mockMvc.perform(get("/open-credit-customer").sessionAttr("source", "").sessionAttr("destination", "").sessionAttr("sourceList", new ArrayList<String>()).sessionAttr("destinationList", new ArrayList<String>()).sessionAttr("previousRides", new ArrayList<Booking>()).sessionAttr("upcomingRides", new ArrayList<Booking>()).sessionAttr("customer", new Customer()))
                .andExpect(status().isOk())
                .andExpect(view().name("customer-credits"));
    }

   
    @Test
    public void testShowBookingHistory() throws Exception{
        mockMvc.perform(get("/booking-history").sessionAttr("source", "").sessionAttr("destination", "").sessionAttr("sourceList", new ArrayList<String>()).sessionAttr("destinationList", new ArrayList<String>()).sessionAttr("previousRides", new ArrayList<Booking>()).sessionAttr("upcomingRides", new ArrayList<Booking>()).sessionAttr("customer", new Customer()))
                .andExpect(status().isOk())
                .andExpect(view().name("booking-history"));
    }

   
    @Test
    public void testCustomerDashboard() throws Exception{
        mockMvc.perform(post("/customer-dashboard").sessionAttr("source", "").sessionAttr("destination", "").sessionAttr("sourceList", new ArrayList<String>()).sessionAttr("destinationList", new ArrayList<String>()).sessionAttr("previousRides", new ArrayList<Booking>()).sessionAttr("upcomingRides", new ArrayList<Booking>()).sessionAttr("customer", new Customer()))
                .andExpect(status().isOk())
                .andExpect(view().name("customer-dashboard"));
    }




}   