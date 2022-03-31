package com.tripmanagement.asdc.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Component;

@Component
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private JavaMailSender javaMailSender;

	// @Bean
	public void sendEmail(String message, String subject, String email) {
		// JavaMailSender javaMailSender=new JavaMailSenderImpl();
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("tripmanagementasdc@gmail.com");
		msg.setTo(email);

		msg.setSubject(subject);
		msg.setText(message);

		javaMailSender.send(msg);

	}
}
