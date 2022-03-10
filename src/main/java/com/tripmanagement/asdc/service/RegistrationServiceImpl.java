package com.tripmanagement.asdc.service;

import com.tripmanagement.asdc.dao.RegistrationDAO;
import com.tripmanagement.stringsAndConstants.StringMessages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RegistrationServiceImpl implements RegistrationService{

    
    @Autowired
    RegistrationDAO RegistrationDAO;
    
    @Override
    public String checkEmailPassword(String email, String password) {
        if(!RegistrationDAO.checkEmailExists(email))
        return StringMessages.NO_USER_FOUND;
        else if(!RegistrationDAO.checkEmailPassword(email, password))
        return StringMessages.INCORRECT_AUTH;
        else return StringMessages.SUCCESS;
    }

    @Override
    public boolean checkUserExistByEmail(String email)
    {
        return RegistrationDAO.checkEmailExists(email);
    }

    
}
