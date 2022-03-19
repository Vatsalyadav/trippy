package com.tripmanagement.asdc.controller;

import com.tripmanagement.asdc.model.Vehicle;
import com.tripmanagement.asdc.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VehicleController {

    @Autowired
    VehicleService vehicleService;
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

}
