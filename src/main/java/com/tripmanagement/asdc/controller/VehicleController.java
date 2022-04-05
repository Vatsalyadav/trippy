package com.tripmanagement.asdc.controller;

import com.tripmanagement.asdc.model.FuelEconomy;
import com.tripmanagement.asdc.model.VehicleOwner;
import com.tripmanagement.asdc.service.BookingService;
import com.tripmanagement.asdc.service.TripService;
import com.tripmanagement.asdc.service.VehicleOwnerService;
import com.tripmanagement.asdc.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    BookingService bookingService;

    @Autowired
    TripService tripService;

    @Autowired
    VehicleOwnerService vehicleOwnerService;


    @PostMapping("/add-fuel-economy")
    public String addTripDetails(FuelEconomy fuelEconomy, Model model) {
        vehicleService.saveFuelEconomy(fuelEconomy);
        System.out.println(model.toString());
        VehicleOwner vehicleOwner = vehicleOwnerService.getVehicleOwnerByOwnerId(5);
        model.addAttribute("vehicleOwner", vehicleOwner);
        model.addAttribute("listOfVehicle", vehicleService.getVehicles(vehicleOwner.getVehicleOwner_id()));
        model.addAttribute("previousRides", tripService.getPreviousTripsForVehicleOwner(vehicleOwner.getVehicleOwner_id()));
        model.addAttribute("upcomingRides", tripService.getUpcomingTripsForVehicleOwner(vehicleOwner.getVehicleOwner_id()));
    return "owner-dashboard";
    }

    @RequestMapping("/show-all-vehicles")
    public String showAllVehicles(HttpSession session, Model model){
        return "all-vehicles";
    }


}
