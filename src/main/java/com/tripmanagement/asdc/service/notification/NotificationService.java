package com.tripmanagement.asdc.service.notification;

public interface NotificationService {

    public boolean sendEmail(String message, String subject, String email);

}