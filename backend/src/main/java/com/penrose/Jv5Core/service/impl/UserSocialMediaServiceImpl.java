package com.penrose.Jv5Core.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.penrose.Jv5Core.Utill.ResponseHelper;
import com.penrose.Jv5Core.dto.UserSocialMediaResponse;
import com.penrose.Jv5Core.model.UserSocialMedia;
import com.penrose.Jv5Core.repository.UserSocialMediaRepository;
import com.penrose.Jv5Core.service.UserSocialMediaService;

@Service
@Transactional
public class UserSocialMediaServiceImpl implements UserSocialMediaService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserSocialMediaServiceImpl.class);
	
	@Autowired
	private UserSocialMediaRepository userSocialMediaRepository;

	public List<UserSocialMediaResponse> getUserSocialMedias(Long userId) {
		if (userId == null) {
			return null;
		}
		List<UserSocialMedia> UserSocialMediaList = userSocialMediaRepository.findAllByUserId(userId); 
		List<UserSocialMediaResponse> UserSocialMediaResponseList = ResponseHelper.buildUserSocialMediaResponseList(UserSocialMediaList);
		
		return UserSocialMediaResponseList; 
	}

	public UserSocialMediaResponse updateUserSocialMedia(UserSocialMediaResponse userSocialMediaResponse) {
		if (userSocialMediaResponse == null || userSocialMediaResponse.getUserSocialMediaId() == null) {
			return null;
		}
		UserSocialMedia userSocialMedia = userSocialMediaRepository.findById(userSocialMediaResponse.getUserSocialMediaId()).get(); 
		userSocialMedia.setUserSocialMediaId(userSocialMediaResponse.getUserSocialMediaId());
		userSocialMedia.setType(userSocialMediaResponse.getType());
		userSocialMedia.setLink(userSocialMediaResponse.getLink());
		userSocialMedia = userSocialMediaRepository.save(userSocialMedia); 
		
		return ResponseHelper.buildUserSocialMediaResponse(userSocialMedia); 
	}
	
	public boolean deleteUserSocialMedia(Long userSocialMediaId) {
		if (userSocialMediaId == null) {
			return false;
		}
		UserSocialMedia userSocialMedia = userSocialMediaRepository.findById(userSocialMediaId).get(); 
		userSocialMediaRepository.delete(userSocialMedia); 
		return true;
	}

	

}
