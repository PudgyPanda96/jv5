package com.penrose.Jv5Core.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.penrose.Jv5Core.model.User;
import com.penrose.Jv5Core.user.service.UserService;

@RestController
@RequestMapping(path="/users")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService; 
	
	@GetMapping(value="/", produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<User> getAllUsers() {		
		List<User> allUsers = userService.getAllUsers(); 
		
		LOGGER.debug("*** Returning userResources={}", allUsers);
		return allUsers;
	}
}
