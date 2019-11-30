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
	public User updatePassword(String email, String password, String newPassword) {
		User u = userRepository.findUserByEmailAndPassword(email, password);
		if(u == null) {
			LOGGER.debug("***User not found to update password");
			return null;
		}
		else {
			u.setPassword(newPassword);;
			userRepository.save(u);
			return u;
		}
	}

	@Override
	public User updateAlias(String email, String password, String newAlias) {
		User u = userRepository.findUserByEmailAndPassword(email, password);
		if(u == null) {
			LOGGER.debug("***User not found to update alias");
			return null;
		}
		else {
			u.setAlias(newAlias);
			userRepository.save(u);
			return u;
		}
	}

	@Override
	public User deleteAccount(String email, String password) {
		User u = userRepository.findUserByEmailAndPassword(email, password);
		if(u == null) {
			LOGGER.debug("***User does not exist. Account not deleted");
			return null;
		} else {
			userRepository.delete(u);
			return u;
		}
	}

	@Override
	public User updateEmail(String email, String password, String newEmail) {
		User u = userRepository.findUserByEmailAndPassword(email, password);
		if(u == null) {
			LOGGER.debug("***User not found to update email");
			return null;
		}
		else {
			u.setAlias(newEmail);
			userRepository.save(u);
			return u;
		}
	}



}
