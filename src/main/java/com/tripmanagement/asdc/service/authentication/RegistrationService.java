package com.tripmanagement.asdc.service.authentication;

public interface RegistrationService{

    public String checkEmailPassword(String email, String password);
    public boolean checkUserExistByEmail(String email);

}