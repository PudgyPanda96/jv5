package com.penrose.Jv5Core.service;

import java.util.List;

import com.penrose.Jv5Core.dto.AccomplishmentResponse;
import com.penrose.Jv5Core.dto.ExperienceResponse;
import com.penrose.Jv5Core.model.Accomplishment;
import com.penrose.Jv5Core.model.Experience;

public interface ExperienceService {

	public List<ExperienceResponse> getUserExperiences(Long userId);

	public ExperienceResponse updateUserExperience(ExperienceResponse experienceResponse);
	
	public boolean deleteUserExperience(Long experienceId);

}
