package com.tripmanagement.asdc.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class RegistrationServiceImplTest {

    @Autowired
    RegistrationService registrationService;

    @Test
    void testCheckUserExistByEmailnull() {
        assertFalse(registrationService.checkUserExistByEmail(null));
    }

    @Test
    void testCheckUserExistByWrongEmail() {
        assertFalse(registrationService.checkUserExistByEmail("test1@test1.test1"));
    }

    @Test
    void testcheckUserExistByCorrectEmail() {
        assertTrue(registrationService.checkUserExistByEmail("svt@gmail.com"));
    }

    @Test
    void testCheckWrongEmailPassword() {
        assertEquals(registrationService.checkEmailPassword("test1@test1.test", "test"),"Incorrect email or password");
    }

    @Test
    void testCheckNullEmailPassword() {
        assertEquals(registrationService.checkEmailPassword(null, "test"),"Incorrect email or password");
    }

    @Test
    void testCheckEmailNullPassword() {
        assertEquals(registrationService.checkEmailPassword("svt@gmail.com", null),"Incorrect email or password");
    }

    @Test
    void testCheckEmptyEmailPassword() {
        assertEquals(registrationService.checkEmailPassword("", "qwerty123"),"Incorrect email or password");
    }

    @Test
    void testCheckEmailEmptyPassword() {
        assertEquals(registrationService.checkEmailPassword("svt@gmailcom", ""),"Incorrect email or password");
    }

    @Test
    void testCheckCorrectEmailPassword() {
        assertTrue(registrationService.checkEmailPassword("test@email.test", "123456") != null);
    }
 @Test
    void testCheckIllegalEmailPassword() {
        assertTrue(registrationService.checkEmailPassword("test@email.test\'", "123456") != null);
    }

    @Test
    void testCheckCorrectEmailExist() {
        assertTrue(registrationService.checkUserExistByEmail("xyz@qwe.com"));
        assertTrue(registrationService.checkUserExistByEmail("test@test.test"));
    }

    @Test
    void testcheckWrongEmailExists() {
        assertFalse(registrationService.checkUserExistByEmail("xyz1@qwe.com"));
        assertFalse(registrationService.checkUserExistByEmail("test1@test.test"));
    }

    @Test
    void testCheckNullEmailExists() {
        assertFalse(registrationService.checkUserExistByEmail(null));
    }

    @Test
    void testCheckEmptyEmailExists() {
        assertFalse(registrationService.checkUserExistByEmail(""));
    }

}