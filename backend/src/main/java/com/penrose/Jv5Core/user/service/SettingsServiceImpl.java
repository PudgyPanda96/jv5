package com.penrose.Jv5Core.user.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.penrose.Jv5Core.model.User;
import com.penrose.Jv5Core.user.repository.UserRepository;

@Service
@Transactional
public class SettingsServiceImpl implements SettingsService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SettingsService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User updatePassword(User user, Long id) {
		Optional<User> u = userRepository.findById(id);
		if(u.isEmpty()) {
			LOGGER.debug("User by id {} does not exist. Password not updated.", id);
			return null;
		} else {
			userRepository.delete(u.get());
			userRepository.save(user);
			return user;
		}
	}

	@Override
	public User updateAlias(User user, Long id) {
		Optional<User> u = userRepository.findById(id);
		if(u.isEmpty()) {
			LOGGER.debug("User by id {} does not exist. Alias not updated", id);
			return null;
		} else {
			userRepository.delete(u.get());
			userRepository.save(user);
			return user;
		}
	}

	@Override
	public User deleteAccount(Long id) {
		Optional<User> u = userRepository.findById(id);
		if(u.isEmpty()) {
			LOGGER.debug("***User by id {} does not exist. Account not deleted", id);
			return null;
		} else {
			userRepository.delete(u.get());
			return u.get();
		}
	}

	@Override
	public User updateEmail(User user, Long id) {
		Optional<User> u = userRepository.findById(id);
		List<User> allUsers = userRepository.findAll();
		if(u.isEmpty()) {
			LOGGER.debug("***User by id {} does not exist. Email not updated.", id);
			return null;
		}
		else {
			for(User userCheck: allUsers) {
				if(userCheck.getEmail().equals(user.getEmail())) {
					LOGGER.debug("***Email {} is already in use. Email not updated", user.getEmail());
					return null;
				}
			}
			userRepository.delete(u.get());
			userRepository.save(user);
			return user;
		}
	}



}
