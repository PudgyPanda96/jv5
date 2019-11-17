package com.penrose.Jv5Core.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.penrose.Jv5Core.Utill.JSONUtil;
import com.penrose.Jv5Core.dto.AccomplishmentResponse;
import com.penrose.Jv5Core.dto.ExperienceResponse;
import com.penrose.Jv5Core.dto.UserResponse;
import com.penrose.Jv5Core.dto.UserSocialMediaResponse;
import com.penrose.Jv5Core.model.User;
import com.penrose.Jv5Core.model.UserSocialMedia;
import com.penrose.Jv5Core.service.AccomplishmentService;
import com.penrose.Jv5Core.service.ExperienceService;
import com.penrose.Jv5Core.service.UserService;
import com.penrose.Jv5Core.service.UserSocialMediaService;
import com.penrose.Jv5Core.service.impl.EmailServiceImpl;

@RestController
@RequestMapping(path="/user")
@CrossOrigin
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService; 
	
	@Autowired
	private ExperienceService experienceService; 
	
	@Autowired
	private AccomplishmentService accomplishmentService; 
	
	@Autowired
	private UserSocialMediaService userSocialMediaService; 
	
	@Autowired 
	EmailServiceImpl emailService;

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
		emailService.sendEmailToRegisteredUser(registeredUser);
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
	
	// USER
	@GetMapping(value="/getUserProfile/{userId}", produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public UserResponse getUserProfile(@PathVariable("userId") Long userId, HttpServletRequest request, HttpServletResponse response) {
		UserResponse userResponse = userService.getUserProfile(userId);
		return userResponse;
	}
	
	@PutMapping(value="/updateUserProfile", produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public User updateUserProfile(@RequestBody UserResponse userResponse, HttpServletRequest request, HttpServletResponse response) {
		User updatedUser = userService.updateUserProfile(userResponse);
		return updatedUser;
	}
	
	@DeleteMapping(value="/deleteUserProfile/{userId}", produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public boolean deleteUserProfile(@PathVariable("userId") Long userId, HttpServletRequest request, HttpServletResponse response) {
		boolean isDeleted = userService.deleteUserProfile(userId);
		return isDeleted;
	}
	
	// ACCOMPLISHMENTS
	@GetMapping(value="/getUserAccomplishments/{userId}", produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<AccomplishmentResponse> getUserAccomplishments(@PathVariable("userId") Long userId, HttpServletRequest request, HttpServletResponse response) {
		List<AccomplishmentResponse> accomplishmentResponseList = accomplishmentService.getUserAccomplishments(userId);
		return accomplishmentResponseList;
	}
	
	@PutMapping(value="/updateUserAccomplishment", produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public AccomplishmentResponse updateUserAccomplishment(@RequestBody AccomplishmentResponse accomplishmentResponse, HttpServletRequest request, HttpServletResponse response) {
		AccomplishmentResponse updatedAccomplishmentResponse = accomplishmentService.updateUserAccomplishment(accomplishmentResponse);
		return updatedAccomplishmentResponse;
	}
	
	@DeleteMapping(value="/deleteUserAccomplishment/{userId}", produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public boolean deleteUserAccomplishment(@PathVariable("userId") Long userId, HttpServletRequest request, HttpServletResponse response) {
		boolean isDeleted = accomplishmentService.deleteUserAccomplishment(userId);
		return isDeleted;
	}
	
	// EXPERIENCES
	@GetMapping(value="/getUserExperiences/{userId}", produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<ExperienceResponse> getUserExperiences(@PathVariable("userId") Long userId, HttpServletRequest request, HttpServletResponse response) {
		List<ExperienceResponse> experienceResponseList = experienceService.getUserExperiences(userId);
		return experienceResponseList;
	}
	
	@PutMapping(value="/updateUserExperience", produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ExperienceResponse updateUserExperience(@RequestBody ExperienceResponse experienceResponse, HttpServletRequest request, HttpServletResponse response) {
		ExperienceResponse updatedExperienceResponse = experienceService.updateUserExperience(experienceResponse);
		return updatedExperienceResponse;
	}
	
	@DeleteMapping(value="/deleteUserExperience/{userId}", produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public boolean deleteUserExperience(@PathVariable("userId") Long userId, HttpServletRequest request, HttpServletResponse response) {
		boolean isDeleted = experienceService.deleteUserExperience(userId);
		return isDeleted;
	}	
	
	// USER SOCIAL MEDIA
	@GetMapping(value="/getUserSocialMedias/{userId}", produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<UserSocialMediaResponse> getUserSocialMedias(@PathVariable("userId") Long userId, HttpServletRequest request, HttpServletResponse response) {
		List<UserSocialMediaResponse> userSocialMediasResponseList = userSocialMediaService.getUserSocialMedias(userId);
		return userSocialMediasResponseList;
	}
	
	@PutMapping(value="/updateUserSocialMedia", produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public UserSocialMediaResponse updateUserSocialMedia(@RequestBody UserSocialMediaResponse userSocialMediaResponse, HttpServletRequest request, HttpServletResponse response) {
		UserSocialMediaResponse updatedUserSocialMediaResponse = userSocialMediaService.updateUserSocialMedia(userSocialMediaResponse);
		return updatedUserSocialMediaResponse;
	}
	
	@DeleteMapping(value="/deleteUserSocialMedia/{userId}", produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public boolean deleteUserSocialMedia(@PathVariable("userId") Long userId, HttpServletRequest request, HttpServletResponse response) {
		boolean isDeleted = userSocialMediaService.deleteUserSocialMedia(userId);
		return isDeleted;
	}
}
