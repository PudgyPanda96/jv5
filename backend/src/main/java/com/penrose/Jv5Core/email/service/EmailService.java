package com.penrose.Jv5Core.email.service;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.penrose.Jv5Core.model.User;
import com.penrose.Jv5Core.user.service.UserService;

@Service
public class EmailService {

	private JavaMailSender javaMailSender;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

	@Autowired
	private Environment env;

	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
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

	public void deleteAccount(User user) {
		//construct the actual email
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("JV5 Registration");
		mail.setText("Your account has been deleted");

		javaMailSender.send(mail);
		LOGGER.info("*** Email Sent to {}", user.getEmail());
	}
	
	public void updatePassword(User user) {
		
	}
	
	public void updateEmail(User user) {
		
	}
	
	public void updateAlias(User user) {
		
	}

}
