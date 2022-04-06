package com.tripmanagement.asdc.dao.authentication;

public interface RegistrationDAO {
    public boolean checkUserExistByEmail(String email);

    public String checkEmailPassword(String email, String password);
}
