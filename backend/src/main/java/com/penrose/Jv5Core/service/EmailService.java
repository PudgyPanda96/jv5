package com.penrose.Jv5Core.service;

import org.springframework.mail.MailException;

import com.penrose.Jv5Core.model.User;

public interface EmailService {
	
	public void sendEmailToRegisteredUser(User user) throws MailException;
	
}
