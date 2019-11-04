package com.penrose.Jv5Core.user.service;

import com.penrose.Jv5Core.model.User;

public interface SettingsService {
	
	User updatePassword(User user, Long id );
	
	User updateAlias(User user, Long id);
	
	User updateEmail(User user, Long id);
	
	User deleteAccount(Long id);
}
