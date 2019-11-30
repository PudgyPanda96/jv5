package com.penrose.Jv5Core.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@DeleteMapping(value="delete", produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<Object> deleteAccount(@RequestParam String email, @RequestParam String password) {		
		User u = settingsService.deleteAccount(email, password);
		
		if(u == null) {
			LOGGER.info("***Returning null user with unauthorized");
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@PutMapping(value="changeAlias", produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<Object> changeAlias(@RequestParam String email, @RequestParam String password, @RequestParam String newAlias) {
		User u = settingsService.updateAlias(email, password, newAlias);
		if(u == null) {
			LOGGER.info("***Returning null user with unauthorized. Cant change alias");
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
	}
	
	@PutMapping(value="changePassword", produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<Object> changePassword(@RequestParam String email, @RequestParam String password, @RequestParam String newPassword) {
		User u = settingsService.updatePassword(email, password, newPassword);
		if(u == null) {
			LOGGER.info("***Returning null user with unauthorized. Cant change password");
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
	}
	
	@PutMapping(value="changeEmail", produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<Object> changeEmail(@RequestParam String email, @RequestParam String password, @RequestParam String newEmail) {
		User u = settingsService.updateEmail(email, password, newEmail);
		if(u == null) {
			LOGGER.info("***Returning null user with unauthorized. Cant change email");
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
	}
}
