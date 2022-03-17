package com.tripmanagement.asdc.controller;

import com.tripmanagement.asdc.model.User;
import com.tripmanagement.asdc.service.CustomerService;
import com.tripmanagement.asdc.service.RegistrationService;
import com.tripmanagement.asdc.service.VehicleOwnerService;
import com.tripmanagement.asdc.stringsAndConstants.Constants;
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

    @Autowired
    VehicleOwnerService vehicleOwnerService;

    @Autowired
    CustomerService customerService;

    @RequestMapping("/")
    public String basePage() {
        return "login";
    }

    @PostMapping("/dashboard")
    public String userLogin(User user, BindingResult result, Model model) {
        String message = registrationService.checkEmailPassword(user.getEmail(), user.getPassword());
        if (message.equalsIgnoreCase(StringMessages.INCORRECT_AUTH)){
            model.addAttribute("error_message", message);
            return "login";
        }
        else {
            if (message.equalsIgnoreCase(Constants.USER_TYPE_VEHICLE_OWNER))
                return "dashboard";
            else
                return "customer-dashboard";

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
     * Will return Registration Page
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

    @PostMapping("/register-user")
    public String registerUser(User user, BindingResult result, Model model) {
        System.out.println("Name: "+ user.getFirst_name());
        System.out.println("Last Name: "+ user.getLast_name());
        System.out.println("User Type: "+ user.getUserType());
        System.out.println("Email: "+ user.getEmail());
        System.out.println("Password: "+ user.getPassword());

        if(!registrationService.checkUserExistByEmail(user.getEmail())) {
            if (user.getUserType().equals("Vehicle Owner"))
                vehicleOwnerService.saveVehicleOwner(user);
            else
                customerService.saveCustomer(user);
            return "login";
        }
        else {
            model.addAttribute("error_message", StringMessages.USER_ALREADY_EXIST);
            return "register";
        }

    }

}
