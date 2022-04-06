package com.tripmanagement.asdc.controller.vehicle;

import com.tripmanagement.asdc.model.users.VehicleOwner;
import com.tripmanagement.asdc.model.vehicle.ChartData;
import com.tripmanagement.asdc.model.vehicle.FuelEconomy;
import com.tripmanagement.asdc.model.vehicle.Vehicle;
import com.tripmanagement.asdc.service.vehicle.VehicleService;
import com.tripmanagement.asdc.stringsAndConstants.controller.ControllerStringMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping("/add-fuel-economy")
    public String updateFuelEconomy(FuelEconomy fuelEconomy, Model model, HttpSession httpSession) {
        if(vehicleService.updateFuelEconomy(fuelEconomy)){
            model.addAttribute("messageStatus", ControllerStringMessages.SUCCESS_STATUS);
            model.addAttribute("message",ControllerStringMessages.TRIP_DETAILS);
        }
        else {
            model.addAttribute("messageStatus", ControllerStringMessages.FAILURE_STATUS);
            model.addAttribute("message",ControllerStringMessages.ERROR_OCCURRED);
        }
        int vehicleOwnerId = vehicleService.getVehicleDetails(fuelEconomy.getVehicle_id()).getVehicleowner_id();
        httpSession.setAttribute("listOfVehicle", vehicleService.getVehicles(vehicleOwnerId));
        return "owner-dashboard";
    }

    @PostMapping("/add-trip")
    public String addTripDetailsAll(FuelEconomy fuelEconomy, Model model, HttpSession httpSession) {
        if(vehicleService.updateFuelEconomy(fuelEconomy)){
            model.addAttribute("messageStatus", ControllerStringMessages.SUCCESS_STATUS);
            model.addAttribute("message",ControllerStringMessages.TRIP_DETAILS);
        }
        else {
            model.addAttribute("messageStatus", ControllerStringMessages.FAILURE_STATUS);
            model.addAttribute("message",ControllerStringMessages.ERROR_OCCURRED);
        }
        int vehicleOwnerId = vehicleService.getVehicleDetails(fuelEconomy.getVehicle_id()).getVehicleowner_id();
        httpSession.setAttribute("listOfVehicle", vehicleService.getVehicles(vehicleOwnerId));
        getChartData(vehicleOwnerId, model);
        return "all-vehicles";
    }

    @RequestMapping("/show-all-vehicles")
    public String showAllVehicles(HttpSession session, Model model){
        getChartData(((VehicleOwner)session.getAttribute("vehicleOwner")).getVehicleOwner_id(), model);
        return "all-vehicles";
    }

    @PostMapping("/add-new-vehicle")
    public String addNewVehicle(Vehicle vehicle, Model model, HttpSession session) {
        if(vehicleService.addVehicle(vehicle)){
            model.addAttribute("messageStatus", ControllerStringMessages.SUCCESS_STATUS);
            model.addAttribute("message",ControllerStringMessages.CAR_ADDED);
        }
        else {
            model.addAttribute("messageStatus", ControllerStringMessages.FAILURE_STATUS);
            model.addAttribute("message",ControllerStringMessages.ERROR_OCCURRED);
        }
        session.setAttribute("listOfVehicle", vehicleService.getVehicles(vehicle.getVehicleowner_id()));
        getChartData(vehicle.getVehicleowner_id(), model);
        return "all-vehicles";
    }

    private ArrayList<ChartData> getChartData(int vehicleOwnerId, Model model){
        ArrayList<ChartData> vehicleUseChart = vehicleService.getFuelConsumedChart(vehicleOwnerId);
        model.addAttribute("vehicleKmChartDataset",vehicleUseChart.get(0));
        model.addAttribute("vehicleFuelChartDataset",vehicleUseChart.get(1));
        return vehicleUseChart;
    }


}
