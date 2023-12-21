package com.webApp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
@Component
public class EmailService {
	@Autowired
	private JavaMailSender jms;
	public void sendEmail(String to, String subject, String message) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(to);
		sm.setSubject(subject);
		sm.setText(message);
		jms.send(sm);
		
	}

}
