package com.penrose.Jv5Core.user.service;

import org.springframework.web.bind.annotation.RequestParam;

import com.penrose.Jv5Core.model.User;

public interface SettingsService {
	
	User updatePassword(String email, String password, String newPassword);
	
	User updateAlias(String email, String password, String newAlias);
	
	User updateEmail(String email, String password, String newEmail);
	
	User deleteAccount(String email, String password);
}
