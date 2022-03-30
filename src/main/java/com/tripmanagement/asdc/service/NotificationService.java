package com.tripmanagement.asdc.service;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.context.annotation.Bean;

public interface NotificationService {

    public void sendEmail(String message, String subject, String email);

}