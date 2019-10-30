package com.penrose.Jv5Core.user.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.penrose.Jv5Core.dto.AccomplishmentResponse;
import com.penrose.Jv5Core.dto.ExperienceResponse;
import com.penrose.Jv5Core.dto.UserResponse;
import com.penrose.Jv5Core.dto.UserSocialMediaResponse;
import com.penrose.Jv5Core.model.Accomplishment;
import com.penrose.Jv5Core.model.Experience;
import com.penrose.Jv5Core.model.User;
import com.penrose.Jv5Core.model.UserSocialMedia;
import com.penrose.Jv5Core.user.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = userRepository.findAll();
		
		if (allUsers == null || allUsers.size() == 0) {
			throw new RuntimeException("no users");
		}
		
		LOGGER.info("*** Found {} total users in database", allUsers.size());
		return allUsers; 
	}
	
	public User registerUser(User user) {
		if (user == null || user.getAlias() == null) {
			return null;
		}
		List<User> allUsers = userRepository.findAll();
		
		for(User u: allUsers) {
			if(u.getAlias().equals(user.getAlias())) {
				throw new RuntimeException("User " + user.getAlias() + " already created");
			}
		}
		
		LOGGER.info("User " + user.getAlias() + " created");
		userRepository.save(user);
		return user;
	}
	
//	public User loginUser(User user) {
//		
//		
//		return user;
//	}
	
	public User verifyUserCredentials(User user) { //TODO: rework
		List<User> allUsers = userRepository.findAll();
		LOGGER.debug("Finding User={}, Password={}", user.getEmail(), user.getPassword());
		for(User u: allUsers) {
			if(u.getEmail().equals(user.getEmail())) {
				LOGGER.debug("Found existing User={}",user.getEmail());
				if(u.getPassword().equals(user.getPassword())) {
					LOGGER.debug("Found matching password for User={}", user.getAlias());
					return u;
				} else {
					LOGGER.debug("Incorrect password for User={}", user.getAlias());
					return null;
				}
			}
		}
		LOGGER.debug("Cannot find User={}",user.getAlias());
		
		return null;
	}

	public UserResponse getUserProfile(Long userId) {
		if (userId == null) {
			return null;
		}
		User user = userRepository.getOne(userId);
		UserResponse userResponse = buildUserResponse(user);
		
		return userResponse; 
	}

	private UserResponse buildUserResponse(User user) {
		if (user == null) {
			return null;
		}
		UserResponse userResponse = new UserResponse();
		userResponse.setFirstName(user.getFirstName());
		userResponse.setLastName(user.getLastName());
		userResponse.setAlias(user.getAlias());
		userResponse.setEmail(user.getEmail());
		userResponse.setCountry(user.getCountry());
		userResponse.setState(user.getState());
		userResponse.setCity(user.getCity());
		userResponse.setProfileImage(user.getProfileImage());
		userResponse.setGame(user.getGame());
		userResponse.setGameRole(user.getGameRole());
		userResponse.setAbout(user.getAbout());
		userResponse.setAccomplishmentList(buildAccomplishmentResponseList(user.getAccomplishmentList()));
		userResponse.setExperienceList(buildExperienceResponseList(user.getExperienceList()));
		userResponse.setUserSocialMediaList(buildUserSocialMediaResponseList(user.getUserSocialMediaList()));

		return userResponse; 
	}



	private List<AccomplishmentResponse> buildAccomplishmentResponseList(List<Accomplishment> accomplishmentList) {
		if (accomplishmentList == null) {
			return new ArrayList<AccomplishmentResponse>();
		}
		List<AccomplishmentResponse> accomplishmentResponseList = new ArrayList<AccomplishmentResponse>();
		accomplishmentList.parallelStream().forEach(accomplishment -> {
			AccomplishmentResponse accomplishmentResponse = new AccomplishmentResponse();
			accomplishmentResponse.setTitle(accomplishment.getTitle());
			accomplishmentResponse.setIssuer(accomplishment.getIssuer());
			accomplishmentResponse.setGame(accomplishment.getGame());
			accomplishmentResponse.setDescription(accomplishment.getDescription());
			accomplishmentResponse.setDate(accomplishment.getDate());
			accomplishmentResponseList.add(accomplishmentResponse);
		});
		return accomplishmentResponseList;
	}
	
	private List<ExperienceResponse> buildExperienceResponseList(List<Experience> experienceList) {
		if (experienceList == null) {
			return new ArrayList<ExperienceResponse>();
		}
		List<ExperienceResponse> experienceResponseList = new ArrayList<ExperienceResponse>();
		experienceList.parallelStream().forEach(experience -> {
			ExperienceResponse experienceResponse = new ExperienceResponse();
			experienceResponse.setTitle(experience.getTitle());
			experienceResponse.setTeam(experience.getTeam());
			experienceResponse.setGame(experience.getGame());
			experienceResponse.setDescription(experience.getDescription());
			experienceResponse.setStartDate(experience.getStartDate());
			experienceResponse.setEndDate(experience.getEndDate());
			experienceResponseList.add(experienceResponse);
		});
		return experienceResponseList;
	}
		
	private List<UserSocialMediaResponse> buildUserSocialMediaResponseList(List<UserSocialMedia> userSocialMediaList) {
		if (userSocialMediaList == null) {
			return new ArrayList<UserSocialMediaResponse>();
		}
		List<UserSocialMediaResponse> userSocialMediaResponseList = new ArrayList<UserSocialMediaResponse>();
		userSocialMediaList.stream().forEach(socialMedia -> {
			UserSocialMediaResponse userSocialMediaResponse = new UserSocialMediaResponse(); 
			userSocialMediaResponse.setType(socialMedia.getType());
			userSocialMediaResponse.setLink(socialMedia.getLink());
			userSocialMediaResponseList.add(userSocialMediaResponse);
		});
		return userSocialMediaResponseList;
	}
}
