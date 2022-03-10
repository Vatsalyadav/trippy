package com.tripmanagement.asdc.controller;

import com.tripmanagement.asdc.model.UserLogin;
import com.tripmanagement.asdc.service.RegistrationService;
import com.tripmanagement.stringsAndConstants.StringMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

}
