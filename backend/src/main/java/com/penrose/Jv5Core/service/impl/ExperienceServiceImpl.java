package com.penrose.Jv5Core.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.penrose.Jv5Core.Utill.ResponseHelper;
import com.penrose.Jv5Core.dto.ExperienceResponse;
import com.penrose.Jv5Core.model.Experience;
import com.penrose.Jv5Core.repository.ExperienceRepository;
import com.penrose.Jv5Core.service.ExperienceService;

@Service
@Transactional
public class ExperienceServiceImpl implements ExperienceService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExperienceServiceImpl.class);
	
	@Autowired
	private ExperienceRepository experienceRepository;

	public List<ExperienceResponse> getUserExperiences(Long userId) {
		if (userId == null) {
			return null;
		}
		List<Experience> experienceList = experienceRepository.findAllByUserId(userId); 
		List<ExperienceResponse> experienceResponseList = ResponseHelper.buildExperienceResponseList(experienceList);
		
		return experienceResponseList; 
	}

	public ExperienceResponse updateUserExperience(ExperienceResponse experienceResponse) {
		if (experienceResponse == null || experienceResponse.getExperienceId() == null) {
			return null;
		}
		Experience experience = experienceRepository.findById(experienceResponse.getExperienceId()).get(); 
		experience.setExperienceId(experienceResponse.getExperienceId());
		experience.setTitle(experienceResponse.getTitle());
		experience.setTeam(experienceResponse.getTeam());
		experience.setGame(experienceResponse.getGame());
		experience.setDescription(experienceResponse.getDescription());
		experience.setStartDate(experienceResponse.getStartDate());
		experience.setEndDate(experienceResponse.getEndDate());
		experience = experienceRepository.save(experience); 
		
		return ResponseHelper.buildExperienceResponse(experience); 
	}
	
	public boolean deleteUserExperience(Long experienceId) {
		if (experienceId == null) {
			return false;
		}
		Experience experience = experienceRepository.findById(experienceId).get(); 
		experienceRepository.delete(experience); 
		return true;
	}

	

}
