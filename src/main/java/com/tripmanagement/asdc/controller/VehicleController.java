package com.tripmanagement.asdc.controller;

import com.tripmanagement.asdc.model.Booked_Rides;
import com.tripmanagement.asdc.model.FuelEconomy;
import com.tripmanagement.asdc.model.VehicleOwner;
import com.tripmanagement.asdc.service.BookedRidesService;
import com.tripmanagement.asdc.service.TripService;
import com.tripmanagement.asdc.service.VehicleOwnerService;
import com.tripmanagement.asdc.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    BookedRidesService bookedRidesService;

    @Autowired
    TripService tripService;

    @Autowired
    VehicleOwnerService vehicleOwnerService;
//
//    @PostMapping("/add-vehicle")
//    public String addVehicle(Vehicle vehicle, Model model) {
//        Boolean addVehicleStatus = vehicleService.addVehicle(vehicle);
//        model.addAttribute("addVehicleStatus",addVehicleStatus);
//        return "owner-dashboard";
//    }
//
//    @PostMapping("/delete-vehicle")
//    public String deleteVehicle(Vehicle vehicle, Model model) {
//        Boolean deleteVehicleStatus = vehicleService.deleteVehicle(vehicle.getVehicle_id());
//        model.addAttribute("deleteVehicleStatus",deleteVehicleStatus);
//        return "owner-dashboard";
//    }

    @PostMapping("add-fuel-economy")
    public String addTripDetails(FuelEconomy fuelEconomy, Model model) {
        System.out.println("yolo 1 "+fuelEconomy.getFuel_consumed());
        System.out.println("yolo 2 "+fuelEconomy.getKms_travelled());
        vehicleService.saveFuelEconomy(fuelEconomy);
        System.out.println(model.toString());
        VehicleOwner vehicleOwner = vehicleOwnerService.getVehicleOwnerByOwnerId(5);
        model.addAttribute("vehicleOwner", vehicleOwner);
        model.addAttribute("listOfVehicle", vehicleService.getVehicles(vehicleOwner.getVehicleOwner_id()));
        model.addAttribute("previousRides", tripService.getPreviousTripsForVehicleOwner(vehicleOwner.getVehicleOwner_id()));
        model.addAttribute("upcomingRides", tripService.getUpcomingTripsForVehicleOwner(vehicleOwner.getVehicleOwner_id()));

//        model.addAttribute("addVehicleStatus",addVehicleStatus);
        return "owner-dashboard";
    }


    @GetMapping("/test")
    public String testController(Model model) {
//        System.out.println(vehicleService.saveFuelEconomy(6));
        System.out.println(vehicleService.updateFuelEconomy(3, 6, 2));
        System.out.println(tripService.getAvailableTripsList("Halifax", "Lucknow").size());
        System.out.println(tripService.getPreviousTripsForVehicleOwner(5).size());
        System.out.println(tripService.getUpcomingTripsForVehicleOwner(5).size());
        Booked_Rides booked_Rides = new Booked_Rides();
        booked_Rides.setCustomer_id(3);
        booked_Rides.setSource("a");
        booked_Rides.setDestination("b");
        //System.out.println(bookedRidesService.saveRide(booked_Rides));
        System.out.println(bookedRidesService.getPreviousRidesForCustomer(3).size());
        System.out.println(bookedRidesService.getUpcomingRidesForCustomer(3).size());

        model.addAttribute("sourceList", "sources");
        System.out.println("I'm in test controller");
        return "test";
    }


}
