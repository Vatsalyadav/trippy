package com.tripmanagement.asdc.controller;

import com.tripmanagement.asdc.model.Booking;
import com.tripmanagement.asdc.model.Trip;
import com.tripmanagement.asdc.service.BookingService;
import com.tripmanagement.asdc.service.CustomerService;
import com.tripmanagement.asdc.service.TripService;
import com.tripmanagement.asdc.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CustomerController {

    @Autowired
    TripService tripService;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    CustomerService customerService;

    @Autowired
    BookingService bookingService;

    @PostMapping("/search-rides")
    public String searchRides(Trip trip, Model model) {
        System.out.println("Available rides: "+tripService.getAvailableTripsList(trip.getSource(),trip.getDestination()).size());
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
    public String bookRide(Booking booking, HttpSession session, Model model) {
        bookingService.saveRide(booking);
        session.setAttribute("upcomingRides", bookingService.getUpcomingRidesForCustomer(booking.getCustomer_id()));
        System.out.println("up: "+bookingService.getUpcomingRidesForCustomer(booking.getCustomer_id()).size());
        return "customer-dashboard";
    }

    @RequestMapping(value = "/open-credit")
    public String openCredit( Model model) {
        return "payment";
    }

}
