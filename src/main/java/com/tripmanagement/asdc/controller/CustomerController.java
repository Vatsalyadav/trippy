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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String bookRide(Booking booking, BindingResult result, Model model) {
//        Booking booking = new Booking();
//        booking.setCustomer_id(4);
//        booking.setTrip_id(3); // Halifax -> Lucknow
        System.out.println("YOLO 1: "+booking.getCustomer_id());
        System.out.println("YOLO 2: "+booking.getTrip_id());
        booking.setSeats_booked(1);
        System.out.println(bookingService.saveRide(booking));

        return "customer-dashboard";
    }

}
