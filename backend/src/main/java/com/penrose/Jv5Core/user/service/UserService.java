package com.penrose.Jv5Core.user.service;

import java.util.List;

import com.penrose.Jv5Core.dto.UserResponse;
import com.penrose.Jv5Core.model.User;

public interface UserService {

	List<User> getAllUsers();
	
	User registerUser(User user);
	
//	User loginUser(User user);
	
	User verifyUserCredentials(User user);

	UserResponse getUserProfile(Long userId);

	
}
