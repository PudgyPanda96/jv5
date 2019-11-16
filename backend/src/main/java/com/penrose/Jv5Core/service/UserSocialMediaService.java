package com.penrose.Jv5Core.service;

import java.util.List;

import com.penrose.Jv5Core.dto.UserSocialMediaResponse;
import com.penrose.Jv5Core.model.UserSocialMedia;

public interface UserSocialMediaService {

	public List<UserSocialMediaResponse> getUserSocialMedias(Long userId);

	public UserSocialMediaResponse updateUserSocialMedia(UserSocialMediaResponse userSocialMediaResponse);
	
	public boolean deleteUserSocialMedia(Long userSocialMediaId);

}
