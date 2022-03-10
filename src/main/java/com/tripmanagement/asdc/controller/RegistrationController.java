package com.tripmanagement.asdc.controller;

import com.tripmanagement.asdc.model.UserLogin;
import com.tripmanagement.stringsAndConstants.StringMessages;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {

    @RequestMapping("/")
    public String basePage() {
        return "login";
    }

    @RequestMapping("/login")
    public String userLogin(UserLogin userLogin, Model model) {
        // TODO : Add registrationService
        // registrationService.loginUserWithEmailAndPassword(model.email, model.password);
        // registrationService.isEmailValid()
        String message = "getMessageFrom";
            if(message.equalsIgnoreCase(StringMessages.SUCCESS))
                return "dashboard";
            else {
                model.addAttribute("error_message", message);
                return "login";
            }
    }

}
