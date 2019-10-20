package com.penrose.Jv5Core.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.penrose.Jv5Core.Utill.JSONUtil;
import com.penrose.Jv5Core.model.User;
import com.penrose.Jv5Core.user.service.UserService;

@RestController
@RequestMapping(path="/users")
@CrossOrigin
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService; 

	@GetMapping(value="", produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<User> getAllUsers() {		
		List<User> allUsers = userService.getAllUsers(); 
		LOGGER.debug("*** Returning userResources={}", allUsers);
		return allUsers;
	}
	
	@PostMapping(value="/registerUser", produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public User registerUser(@RequestBody User user) throws Exception {
		LOGGER.info("Registering User: {}", JSONUtil.convertToJson(user));
		User registeredUser = userService.registerUser(user);
		return registeredUser;
	}
	
	@PostMapping(value="/loginUser", produces="application/json")
	@ResponseBody
	public ResponseEntity<User> loginUser(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
		User isValidUser = userService.verifyUserCredentials(user);
		//userService.loginUser(user);
		if(isValidUser == null) {
			//response.SC_UNAUTHORIZED;
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		}
		request.getSession().setAttribute("user", user.getAlias());
		return new ResponseEntity<>(isValidUser, HttpStatus.OK);
	}
	
	@PostMapping(value="/logoutUser", produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void logoutUser(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute("user");
		request.getSession().invalidate();
	}
}
