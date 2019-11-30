package com.penrose.Jv5Core.service;

import java.util.List;

import com.penrose.Jv5Core.dto.AccomplishmentResponse;
import com.penrose.Jv5Core.model.Accomplishment;

public interface AccomplishmentService {

	public List<AccomplishmentResponse> getUserAccomplishments(Long userId);

	public AccomplishmentResponse updateUserAccomplishment(AccomplishmentResponse accomplishmentResponse);
	
	public boolean deleteUserAccomplishment(Long accomplishmentId);

}
