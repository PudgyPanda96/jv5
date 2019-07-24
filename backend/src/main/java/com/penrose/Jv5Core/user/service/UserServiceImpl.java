package com.penrose.Jv5Core.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.penrose.Jv5Core.model.User;
import com.penrose.Jv5Core.user.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	private User currentUser;

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = userRepository.findAll();

		if (allUsers == null || allUsers.size() == 0) {
			throw new RuntimeException("no users");
		}

		LOGGER.info("*** Found {} total users in database", allUsers.size());
		return allUsers; 
	}

	@Override
	public User createUser(User user) {
		if (user.getUserId() != null) {
			throw new RuntimeException("Bad user. User should not have UserId definied when creating new user");
		}		
		
		List<User> users = userRepository.findByEmail(user.getEmail());

		if (users.size() != 0) {
			throw new RuntimeException("User already exists");
		}

		User newUser = userRepository.save(user);
		LOGGER.info("*** New user made successfully:", newUser.toString());
		return newUser;
	}

	@Override
	public User getUserByUserId(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(RuntimeException :: new);
		LOGGER.info("*** Found user:", user.toString());
		return user; 
	}

}
