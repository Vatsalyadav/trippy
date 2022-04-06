package com.tripmanagement.asdc.controller;

import com.tripmanagement.asdc.controller.vehicle.VehicleController;
import com.tripmanagement.asdc.service.booking.BookingService;
import com.tripmanagement.asdc.service.trip.TripService;
import com.tripmanagement.asdc.service.vehicle.VehicleService;
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

import com.tripmanagement.asdc.model.vehicle.ChartData;
import com.tripmanagement.asdc.model.rideSharing.Trip;
import com.tripmanagement.asdc.model.vehicle.Vehicle;
import com.tripmanagement.asdc.model.users.VehicleOwner;

import org.mockito.Mock;


import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
class VehicleControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    private VehicleController vehicleController;

    @Mock
    TripService tripService;

    @Mock
    Trip trip;
    
    @Mock
    BookingService bookingService;

    @Mock
    VehicleService vehicleService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        Object[] controllers;
        mockMvc = MockMvcBuilders.standaloneSetup(vehicleController).build();
    }

   
    @Test
    public void testShowAllVehicles() throws Exception{
        mockMvc.perform(post("/show-all-vehicles").sessionAttr("vehicleOwner", new VehicleOwner()).sessionAttr("listOfVehicle", new ArrayList<Vehicle>()).sessionAttr("previousRides", new ArrayList<Trip>()).sessionAttr("upcomingRides", new ArrayList<Trip>()))
                .andExpect(status().isOk())
                .andExpect(view().name("all-vehicles"));
    }


    @Test
    public void testGetChartData() throws Exception{
        when(vehicleService.getFuelConsumedChart(anyInt())).thenReturn(new ArrayList<ChartData>());
    }

}   