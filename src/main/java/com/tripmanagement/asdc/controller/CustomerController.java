package com.tripmanagement.asdc.controller;

import com.tripmanagement.asdc.model.Booking;
import com.tripmanagement.asdc.model.Ride;
import com.tripmanagement.asdc.model.Trip;
import com.tripmanagement.asdc.model.VehicleOwner;
import com.tripmanagement.asdc.service.BookingService;
import com.tripmanagement.asdc.service.CustomerService;
import com.tripmanagement.asdc.service.TripService;
import com.tripmanagement.asdc.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

    @Autowired
    TripService tripService;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    CustomerService customerService;

    @Autowired
    BookingService bookedRidesService;

    @PostMapping("/search-rides")
    public String searchRides(Trip trip, Model model) {
        model.addAttribute("listOfRides", tripService.getAvailableTripsList(trip.getSource(),trip.getDestination()));
        return "customer-dashboard";
    }
//
//    @GetMapping("/get-booked-rides")
//    public String getBookedRides(String customerId, Model model) {
//        // call service with rideData
//        return "";
//    }
//
//    @GetMapping("/ride-history")
//    public String getRideHistory(String customerId, Model model) {
//
//        return "";
//    }

    @PostMapping("/book-ride")
    public String bookRide(BindingResult result, Model model) {
        System.out.println(model);
        Trip trip = (Trip) model.getAttribute("trip");
        //Booked_Rides bookRide=new Booked_Rides(0,trip.getSource(), trip.getDestination() ,trip.getEstimated_kms(), trip.getVehicle_id(), trip.getVehicleowner_id(), trip.getCustomer_id(), trip.getTimestamp(), tripService.calculateCost(vehicleService.getVehicleDetails(trip.getVehicle_id()),trip), vehicleService.getVehicleDetails(trip.getVehicle_id()).getFuel_economy());
        //bookedRidesService.saveRide(bookRide);
        //tripService.saveTrip(tripData);
        return "customer-dashboard";
    }

}
