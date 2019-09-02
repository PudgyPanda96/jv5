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
	
	public boolean verifyUserCredentials(User user) {
		List<User> allUsers = userRepository.findAll();
		
		for(User u: allUsers) {
			if(u.getAlias().equals(user.getAlias())) {
				if(u.getPassword().equals(user.getPassword())) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
		
}
