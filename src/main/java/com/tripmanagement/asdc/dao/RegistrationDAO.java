package com.tripmanagement.asdc.dao;

public interface RegistrationDAO {
    public boolean checkEmailExists(String email);
    public boolean checkEmailExists(String email,String userType);
    public boolean checkEmailPassword(String email, String password);
   
}
