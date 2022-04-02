package com.tripmanagement.asdc.controller;

import com.tripmanagement.asdc.model.Customer;
import com.tripmanagement.asdc.model.Ride;
import com.tripmanagement.asdc.model.User;
import com.tripmanagement.asdc.model.VehicleOwner;
import com.tripmanagement.asdc.service.*;
import com.tripmanagement.asdc.stringsAndConstants.Constants;
import com.tripmanagement.asdc.stringsAndConstants.StringMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @Autowired
    VehicleOwnerService vehicleOwnerService;

    @Autowired
    CustomerService customerService;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    TripService tripService;

    @Autowired
    BookingService bookedRidesService;

    @RequestMapping("/")
    public String basePage() {
        return "login";
    }

    @PostMapping("/dashboard")
    public String userLogin(User user, HttpSession httpSession, Model model) {
        String message = registrationService.checkEmailPassword(user.getEmail(), user.getPassword());
        if (message.equalsIgnoreCase(StringMessages.INCORRECT_AUTH)){
            httpSession.setAttribute("error_message", message);
            return "login";
        }
        else {
            if (message.equalsIgnoreCase(Constants.USER_TYPE_VEHICLE_OWNER)) {
                VehicleOwner vehicleOwner = vehicleOwnerService.getVehicleOwnerByEmail(user.getEmail());
                httpSession.setAttribute("vehicleOwner", vehicleOwner);
                model.addAttribute("listOfVehicle", vehicleService.getVehicles(vehicleOwner.getVehicleOwner_id()));
                httpSession.setAttribute("previousRides", tripService.getPreviousTripsForVehicleOwner(vehicleOwner.getVehicleOwner_id()));
                httpSession.setAttribute("upcomingRides", tripService.getUpcomingTripsForVehicleOwner(vehicleOwner.getVehicleOwner_id()));
                return "owner-dashboard";
            }
            else {
                Customer customer = customerService.getCustomerByEmail(user.getEmail());
                httpSession.setAttribute("source", "");
                httpSession.setAttribute("destination", "");
                httpSession.setAttribute("customer", customer);

                model.addAttribute("listOfRides", new ArrayList<Ride>());
                httpSession.setAttribute("previousRides", bookedRidesService.getPreviousRidesForCustomer(customer.getCustomer_id()));

                httpSession.setAttribute("upcomingRides", bookedRidesService.getUpcomingRidesForCustomer(customer.getCustomer_id()));
                httpSession.setAttribute("sourceList", tripService.getSources());
                httpSession.setAttribute("destinationList", tripService.getDestinations());
                return "customer-dashboard";
            }
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


    @PostMapping("/register-user")
    public String registerUser(User user, BindingResult result, Model model) {
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
