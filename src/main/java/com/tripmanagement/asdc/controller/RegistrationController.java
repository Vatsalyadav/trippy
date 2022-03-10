package com.tripmanagement.asdc.controller;

import com.tripmanagement.asdc.model.UserLogin;
import com.tripmanagement.asdc.model.VehicleOwner;
import com.tripmanagement.asdc.service.RegistrationService;
import com.tripmanagement.stringsAndConstants.StringMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @RequestMapping("/")
    public String basePage() {
        return "login";
    }

    @RequestMapping("/login")
    public String userLogin(UserLogin userLogin, Model model) {
        String message = registrationService.checkEmailPassword(userLogin.getEmail(), userLogin.getPassword());
        if (message.equalsIgnoreCase(StringMessages.SUCCESS))
            return "dashboard";
        else {
            model.addAttribute("error_message", message);
            return "login";
        }
    }

    /*
     * Will return Forget Password Page
     * */
    @RequestMapping("/forgot-password")
    public String forgotPassword() {
        return "forgot-password";
    }

    /*
     * Will return Forget Password Page
     * */
    @RequestMapping("/register-user")
    public String registerUser() {
        return "register";
    }

    /*
     * Will open dashboard depending upon user type
     * */
    @RequestMapping("/dashboard")
    public String dashboard() {
        // TODO: open dashboard depending upon user type
        return "dashboard";
    }

    @PostMapping("/register-vehicle-owner")
    public String registerVehicleOwner(VehicleOwner vehicleOwner, BindingResult result, Model model) {
        // TODO: Link with service
        // service.checkEmailExists(vehicleOwner.email)
        // service.registerVehicleOwner(vehicleOwner)
        System.out.println("Name: "+ vehicleOwner.getVehicleowner_name());
        System.out.println("Phone Number: "+ vehicleOwner.getPhone());
        System.out.println("Email: "+ vehicleOwner.getEmail());
        System.out.println("Address: "+ vehicleOwner.getAddress());
        System.out.println(""+ vehicleOwner.getVehicle_id());

        String message = "return message";
        if(message.equalsIgnoreCase("Success"))
            return "register-user";
        else {
            model.addAttribute("error_message", message);
            return "login";
        }
    }

    @PostMapping("/add-customer")
    public String registerCustomer(VehicleOwner vehicleOwner, BindingResult result, Model model) {
        // TODO: Link with service
        // service.
        System.out.println("YOLO 1"+ vehicleOwner.getVehicleowner_name());
        System.out.println("YOLO 2"+ vehicleOwner.getPhone());
        System.out.println("YOLO 3"+ vehicleOwner.getEmail());
        System.out.println("YOLO 4"+ vehicleOwner.getAddress());
        System.out.println("YOLO 5"+ vehicleOwner.getVehicle_id());

        return "login";
    }

}
