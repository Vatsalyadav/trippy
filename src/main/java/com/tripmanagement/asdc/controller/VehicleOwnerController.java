package com.tripmanagement.asdc.controller;

import com.tripmanagement.asdc.model.VehicleOwner;
import com.tripmanagement.asdc.service.VehicleOwnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class VehicleOwnerController {
    @Autowired
    VehicleOwnerService carOwnerService;

    @GetMapping("/vehicleOwner")
    public String vehicleOwner(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "VehicleOwner";
    }

    @GetMapping("/getVehicleOwner")
    public String getVehicleOwner(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        VehicleOwner carOwner=carOwnerService.getCarOwner(1);
        model.addAttribute("vehicleowner_id", carOwner.getVehicle_id());
        model.addAttribute("vehicleowner_name", carOwner.getVehicleowner_name());
        model.addAttribute("address", carOwner.getAddress());
        model.addAttribute("email", carOwner.getEmail());
        model.addAttribute("phone", carOwner.getPhone());
        model.addAttribute("vehicle_id", carOwner.getVehicle_id());
        return "VehicleOwner";
    }

    @PostMapping("/adduser")
    public String addUser(VehicleOwner vehicleOwner, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
        VehicleOwner carOwner=carOwnerService.getCarOwner(1);
        model.addAttribute("vehicleowner_id", carOwner.getVehicle_id());
        model.addAttribute("vehicleowner_name", carOwner.getVehicleowner_name());
        model.addAttribute("address", carOwner.getAddress());
        model.addAttribute("email", vehicleOwner.getEmail());
        model.addAttribute("phone", vehicleOwner.getPhone());
        model.addAttribute("vehicle_id", carOwner.getVehicle_id());

        return "VehicleOwner";
    }

    /*
    @RequestMapping(value = "/saveVehicleOwner", method = RequestMethod.GET)
    public String saveCarOwner(@ModelAttribute("vehicleOwner") VehicleOwner formData, BindingResult 
    result) {
        System.out.println(formData.toString());
       carOwnerService.saveCarOwner(formData);
        return "vehicleOwner";
    }

    //show the aaddNewOwnerdd employee form and also pass an empty backing bean object to store the form field values
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addOwner", "owner", new CarOwner());
	}
    //Get the form field vaues which are populated using the backing bean and store it in db
	@RequestMapping(value = "/addNewOwner", method = RequestMethod.POST)
	public void processRequest(@ModelAttribute("owner") CarOwner carOwner) {
		carOwnerService.saveCarOwner(carOwner);
		
	}*/
}
