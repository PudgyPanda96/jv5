package com.penrose.Jv5Core.user.service;

import java.util.List;

import com.penrose.Jv5Core.model.User;

public interface UserService {

	List<User> getAllUsers();
	
	User createUser(User user);

	User getUserByUserId(Long userId); //void loginUser(String alias);
	
}
