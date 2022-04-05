package com.tripmanagement.asdc.controller;

import com.tripmanagement.asdc.model.ChartData;
import com.tripmanagement.asdc.model.FuelEconomy;
import com.tripmanagement.asdc.model.Vehicle;
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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping("/add-fuel-economy")
    public String updateFuelEconomy(FuelEconomy fuelEconomy, ModelAndView model, HttpSession httpSession) {
        vehicleService.updateFuelEconomy(fuelEconomy);
        int vehicleOwnerId = vehicleService.getVehicleDetails(fuelEconomy.getVehicle_id()).getVehicleowner_id();
        httpSession.setAttribute("listOfVehicle", vehicleService.getVehicles(vehicleOwnerId));
    return "owner-dashboard";
    }

    @PostMapping("/add-trip")
    public String addTripDetailsAll(FuelEconomy fuelEconomy, ModelAndView model, HttpSession httpSession) {
        vehicleService.updateFuelEconomy(fuelEconomy);
        int vehicleOwnerId = vehicleService.getVehicleDetails(fuelEconomy.getVehicle_id()).getVehicleowner_id();
        httpSession.setAttribute("listOfVehicle", vehicleService.getVehicles(vehicleOwnerId));
        return "all-vehicles";
    }

    @RequestMapping("/show-all-vehicles")
    public String showAllVehicles(HttpSession session, Model model){
        ArrayList<ChartData> vehicleUseChart = vehicleService.getFuelConsumedChart( ((VehicleOwner)session.getAttribute("vehicleOwner")).getVehicleOwner_id());
        model.addAttribute("vehicleKmChartDataset",vehicleUseChart.get(0));
        model.addAttribute("vehicleFuelChartDataset",vehicleUseChart.get(1));
        return "all-vehicles";
    }


}
