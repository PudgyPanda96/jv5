package com.penrose.Jv5Core.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.penrose.Jv5Core.email.service.EmailService;
import com.penrose.Jv5Core.model.User;
import com.penrose.Jv5Core.user.service.SettingsService;
import com.penrose.Jv5Core.user.service.UserService;

@RestController
@RequestMapping(path="/settings")
@CrossOrigin
public class SettingsController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SettingsController.class);
	
	@Autowired
	private SettingsService settingsService; 
	
	@Autowired 
	EmailService emailService;
	
	@DeleteMapping(value="delete/{id}", produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void deleteAccount(@PathVariable("id") Long id) {		
		User user = settingsService.deleteAccount(id);
		LOGGER.debug("Deleted user account for user id " + id);
		if(user != null) {
			emailService.deleteAccount(user);
		}
	}
}
