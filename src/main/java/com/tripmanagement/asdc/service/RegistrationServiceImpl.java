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
        try{
        if(email==null||password==null||password.isEmpty()||email.isEmpty())
            return StringMessages.INCORRECT_AUTH;
        else if (!registrationDAO.checkUserExistByEmail(email))
            return StringMessages.NO_USER_FOUND;
        else
            return registrationDAO.checkEmailPassword(email, password);
        }
        catch(Exception e)
        {
            return null;
        }
    }

    @Override
    public boolean checkUserExistByEmail(String email)
    {
        if(email==null||email.isEmpty())
        return false;
        else
        return registrationDAO.checkUserExistByEmail(email);
    }

}
