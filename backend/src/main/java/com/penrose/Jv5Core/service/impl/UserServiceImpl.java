package com.penrose.Jv5Core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.penrose.Jv5Core.Utill.ResponseHelper;
import com.penrose.Jv5Core.dto.AccomplishmentResponse;
import com.penrose.Jv5Core.dto.ExperienceResponse;
import com.penrose.Jv5Core.dto.UserResponse;
import com.penrose.Jv5Core.dto.UserSocialMediaResponse;
import com.penrose.Jv5Core.model.Accomplishment;
import com.penrose.Jv5Core.model.Experience;
import com.penrose.Jv5Core.model.User;
import com.penrose.Jv5Core.model.UserSocialMedia;
import com.penrose.Jv5Core.repository.UserRepository;
import com.penrose.Jv5Core.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = userRepository.findAll();
		
		if (allUsers == null || allUsers.size() == 0) {
			throw new RuntimeException("no users");
		}
		
		LOGGER.info("*** Found {} total users in database", allUsers.size());
		return allUsers; 
	}
	
	public User registerUser(User user) {
		if (user == null || user.getAlias() == null) {
			return null;
		}
		List<User> allUsers = userRepository.findAll();
		
		for(User u: allUsers) {
			if(u.getAlias().equals(user.getAlias())) {
				throw new RuntimeException("User " + user.getAlias() + " already created");
			}
		}
		
		LOGGER.info("User " + user.getAlias() + " created");
		userRepository.save(user);
		return user;
	}
	
//	public User loginUser(User user) {
//		
//		
//		return user;
//	}
	
	public User verifyUserCredentials(User user) { //TODO: rework
		List<User> allUsers = userRepository.findAll();
		LOGGER.debug("Finding User={}, Password={}", user.getEmail(), user.getPassword());
		for(User u: allUsers) {
			if(u.getEmail().equals(user.getEmail())) {
				LOGGER.debug("Found existing User={}",user.getEmail());
				if(u.getPassword().equals(user.getPassword())) {
					LOGGER.debug("Found matching password for User={}", user.getAlias());
					return u;
				} else {
					LOGGER.debug("Incorrect password for User={}", user.getAlias());
					return null;
				}
			}
		}
		LOGGER.debug("Cannot find User={}",user.getAlias());
		
		return null;
	}

	public UserResponse getUserProfile(Long userId) {
		if (userId == null) {
			return null;
		}
		User user = userRepository.findById(userId).get();
		UserResponse userResponse = ResponseHelper.buildUserResponse(user);
		return userResponse; 
	}

	public User updateUserProfile(UserResponse userResponse) {
		if (userResponse == null || userResponse.getUserId() == null) {
			return null;
		}
		User user = userRepository.findById(userResponse.getUserId()).get();
		user.setUserId(userResponse.getUserId());
		user.setFirstName(userResponse.getFirstName());
		user.setLastName(userResponse.getLastName());
		user.setAlias(userResponse.getAlias());
		user.setEmail(userResponse.getEmail());
		user.setCountry(userResponse.getCountry());
		user.setState(userResponse.getState());
		user.setCity(userResponse.getCity());
		user.setProfileImage(userResponse.getProfileImage());
		user.setGame(userResponse.getGame());
		user.setGameRole(userResponse.getGameRole());
		user.setAbout(userResponse.getAbout());
		User savedUser = userRepository.save(user); 
		return savedUser; 
	}
	
	public boolean deleteUserProfile(Long userId) {
		if (userId == null) {
			return false;
		}
		User user = userRepository.findById(userId).get(); 
		userRepository.delete(user); 
		return true;
	}

	

}
