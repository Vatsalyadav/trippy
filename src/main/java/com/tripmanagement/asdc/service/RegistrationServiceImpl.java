package com.tripmanagement.asdc.service;

import com.tripmanagement.asdc.dao.RegistrationDAO;
import com.tripmanagement.asdc.stringsAndConstants.StringMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RegistrationServiceImpl implements RegistrationService{


    @Autowired
    RegistrationDAO registrationDAO;

    @Override
    public String checkEmailPassword(String email, String password) {
        if (!registrationDAO.checkEmailExists(email))
            return StringMessages.NO_USER_FOUND;
        else
            return registrationDAO.checkEmailPassword(email, password);
    }
;
    @Override
    public boolean checkUserExistByEmail(String email)
    {
        return registrationDAO.checkEmailExists(email);
    }

}
