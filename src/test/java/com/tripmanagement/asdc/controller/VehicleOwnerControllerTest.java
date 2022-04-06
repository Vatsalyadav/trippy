package com.tripmanagement.asdc.controller;

import com.tripmanagement.asdc.controller.user.VehicleOwnerController;
import com.tripmanagement.asdc.service.trip.TripService;
import com.tripmanagement.asdc.service.vehicle.VehicleService;
import com.tripmanagement.asdc.service.vehicleOwner.VehicleOwnerService;
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
import com.tripmanagement.asdc.model.rideSharing.Trip;
import com.tripmanagement.asdc.model.vehicle.Vehicle;
import com.tripmanagement.asdc.model.users.VehicleOwner;

import org.mockito.Mock;


import java.util.ArrayList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
class VehicleOwnerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    private VehicleOwnerController vehicleOwnerController;

    @Mock
    TripService tripService;

    @Mock
    Trip trip;

    @Mock
    VehicleService vehicleService;

    @Mock
    VehicleOwnerService vehicleOwnerService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        Object[] controllers;
        mockMvc = MockMvcBuilders.standaloneSetup(vehicleOwnerController).build();
    }

  
    @Test
    public void testShowRideHistory() throws Exception{
        mockMvc.perform(post("/ride-history").sessionAttr("vehicleOwner", new VehicleOwner()).sessionAttr("listOfVehicle", new ArrayList<Vehicle>()).sessionAttr("previousRides", new ArrayList<Trip>()).sessionAttr("upcomingRides", new ArrayList<Trip>()))
        .andExpect(status().isOk())
        .andExpect(view().name("ride-history"));
    }

    @Test
    public void testShowOwnerDashboard() throws Exception {
        mockMvc.perform(post("/owner-dashboard").sessionAttr("vehicleOwner", new VehicleOwner())
                .sessionAttr("listOfVehicle", new ArrayList<Vehicle>())
                .sessionAttr("previousRides", new ArrayList<Trip>())
                .sessionAttr("upcomingRides", new ArrayList<Trip>()))
                .andExpect(status().isOk())
                .andExpect(view().name("owner-dashboard"));
    }

 

    
    
}
    

     