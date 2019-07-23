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
	public void createUser(User user) {
		List<User> allUsers = userRepository.findAll();

		if(allUsers.contains(user)) {
			throw new RuntimeException("User already exists");
		}
		else {
			userRepository.save(user);
		}

	}

	@Override
	public void loginUser(String alias) {
		List<User> allUsers = userRepository.findAll();

		for(User u: allUsers) {
			if(u.getAlias().equals("alias")) {
				currentUser = u;
				LOGGER.info("{} has been logged in", u.getAlias());
				return;
			}
		}
		throw new RuntimeException(alias + " is not signed up"); 

	}

}
