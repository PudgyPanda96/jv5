package com.penrose.Jv5Core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.penrose.Jv5Core.Utill.ResponseHelper;
import com.penrose.Jv5Core.dto.AccomplishmentResponse;
import com.penrose.Jv5Core.dto.ExperienceResponse;
import com.penrose.Jv5Core.dto.UserResponse;
import com.penrose.Jv5Core.dto.UserSocialMediaResponse;
import com.penrose.Jv5Core.model.Accomplishment;
import com.penrose.Jv5Core.model.Experience;
import com.penrose.Jv5Core.model.User;
import com.penrose.Jv5Core.model.UserSocialMedia;
import com.penrose.Jv5Core.repository.AccomplishmentRepository;
import com.penrose.Jv5Core.repository.UserRepository;
import com.penrose.Jv5Core.service.AccomplishmentService;
import com.penrose.Jv5Core.service.UserService;

@Service
@Transactional
public class AccomplishmentServiceImpl implements AccomplishmentService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccomplishmentServiceImpl.class);
	
	@Autowired
	private AccomplishmentRepository accomplishmentRepository;

	public List<AccomplishmentResponse> getUserAccomplishments(Long userId) {
		if (userId == null) {
			return null;
		}
		List<Accomplishment> accomplishmentList = accomplishmentRepository.findAllByUserId(userId); 
		List<AccomplishmentResponse> accomplishmentResponseList = ResponseHelper.buildAccomplishmentResponseList(accomplishmentList);
		
		return accomplishmentResponseList; 
	}

	public AccomplishmentResponse updateUserAccomplishment(AccomplishmentResponse accomplishmentResponse) {
		if (accomplishmentResponse == null || accomplishmentResponse.getAccomplishmentId() == null) {
			return null;
		}
		Accomplishment accomplishment = accomplishmentRepository.findById(accomplishmentResponse.getAccomplishmentId()).get(); 
		accomplishment.setAccomplishmentId(accomplishmentResponse.getAccomplishmentId());
		accomplishment.setTitle(accomplishmentResponse.getTitle());
		accomplishment.setIssuer(accomplishmentResponse.getIssuer());
		accomplishment.setGame(accomplishmentResponse.getGame());
		accomplishment.setDescription(accomplishmentResponse.getDescription());
		accomplishment.setDate(accomplishmentResponse.getDate());
		accomplishment = accomplishmentRepository.save(accomplishment); 
		
		return ResponseHelper.buildAccomplishmentResponse(accomplishment);
	}
	
	public boolean deleteUserAccomplishment(Long accomplishmentId) {
		if (accomplishmentId == null) {
			return false;
		}
		Accomplishment accomplishment = accomplishmentRepository.findById(accomplishmentId).get(); 
		accomplishmentRepository.delete(accomplishment); 
		return true;
	}

	

}
