package com.penrose.Jv5Core.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
	
	@PostMapping(value="/registerUser", produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public User registerUser(@RequestBody User user) {
		userService.registerUser(user);
		return user;
	}
	
	@PostMapping(value="/loginUser", produces="application/json")
	@ResponseBody
	public ResponseEntity<User> loginUser(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
		boolean isValidPassword = userService.verifyUserCredentials(user);
		//userService.loginUser(user);
		if(!isValidPassword) {
			//response.SC_UNAUTHORIZED;
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		}
		request.getSession().setAttribute("user", user.getAlias());
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping(value="/logoutUser", produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void logoutUser(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute("user");
		request.getSession().invalidate();
	}
}
