package com.tripmanagement.asdc.controller;

import com.tripmanagement.asdc.model.VehicleOwner;
import com.tripmanagement.asdc.service.VehicleOwnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class VehicleOwnerController {
    @Autowired
    VehicleOwnerService carOwnerService;

    @GetMapping("/vehicleOwner")
    public String vehicleOwner(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "vehicleOwner";
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
        return "vehicleOwner";
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
