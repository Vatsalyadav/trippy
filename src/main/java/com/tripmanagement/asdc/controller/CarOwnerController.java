package com.tripmanagement.asdc.controller;

import com.tripmanagement.asdc.model.CarOwner;
import com.tripmanagement.asdc.service.CarOwnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class CarOwnerController {
    @Autowired
    CarOwnerService carOwnerService;

    @GetMapping("/carOwner")
    public String carOwner(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "carOwner";
    }

    @GetMapping("/getOwner")
    public String getCarOwner(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        CarOwner carOwner=carOwnerService.getCarOwner(101);
        model.addAttribute("id", carOwner.getId());
        model.addAttribute("fname", carOwner.getFirstName());
        model.addAttribute("lname", carOwner.getLastName());
        model.addAttribute("email", carOwner.getEmail());
        return "carOwner";
    }
    @RequestMapping(value = "/saveOwner", method = RequestMethod.GET)
    public String saveCarOwner(@ModelAttribute("carOwner") CarOwner formData, BindingResult 
    result) {
        System.out.println(formData.toString());
       carOwnerService.saveCarOwner(formData);
        return "carOwner";
    }

    //show the add employee form and also pass an empty backing bean object to store the form field values
	/*@RequestMapping(value = "/addNewOwner", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addOwner", "owner", new CarOwner());
	}
    //Get the form field vaues which are populated using the backing bean and store it in db
	@RequestMapping(value = "/addNewOwner", method = RequestMethod.POST)
	public void processRequest(@ModelAttribute("owner") CarOwner carOwner) {
		carOwnerService.saveCarOwner(carOwner);
		
	}*/
}
