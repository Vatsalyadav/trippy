package com.tripmanagement.asdc.dao;

public interface RegistrationDAO {
    public boolean checkUserExistByEmail(String email);

    public boolean checkEmailExists(String email, String userType);

    public String checkEmailPassword(String email, String password);
}
