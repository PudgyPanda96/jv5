package com.penrose.Jv5Core.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.penrose.Jv5Core.model.User;
import com.penrose.Jv5Core.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
	
	private JavaMailSender javaMailSender;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	public EmailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	
	public void sendEmailToRegisteredUser(User user) throws MailException {
		
		//construct the actual email
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("JV5 Registration");
		mail.setText("Thank you for registering for JV5.gg!");
		
		javaMailSender.send(mail);
		
		LOGGER.info("*** Email Sent to {}", user.getEmail());
	}
	
}
