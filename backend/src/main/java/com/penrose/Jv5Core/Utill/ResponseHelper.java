package com.penrose.Jv5Core.Utill;

import java.util.ArrayList;
import java.util.List;

import com.penrose.Jv5Core.dto.AccomplishmentResponse;
import com.penrose.Jv5Core.dto.ExperienceResponse;
import com.penrose.Jv5Core.dto.UserResponse;
import com.penrose.Jv5Core.dto.UserSocialMediaResponse;
import com.penrose.Jv5Core.model.Accomplishment;
import com.penrose.Jv5Core.model.Experience;
import com.penrose.Jv5Core.model.User;
import com.penrose.Jv5Core.model.UserSocialMedia;

public class ResponseHelper {
	public static UserResponse buildUserResponse(User user) {
		if (user == null) {
			return null;
		}
		UserResponse userResponse = new UserResponse();
		userResponse.setUserId(user.getUserId());
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
		userResponse.setAccomplishmentList(buildAccomplishmentResponseList(user.getAccomplishments()));
		userResponse.setExperienceList(buildExperienceResponseList(user.getExperiences()));
		userResponse.setUserSocialMediaList(buildUserSocialMediaResponseList(user.getUserSocialMedias()));

		return userResponse; 
	}

	public static List<AccomplishmentResponse> buildAccomplishmentResponseList(List<Accomplishment> accomplishmentList) {
		if (accomplishmentList == null) {
			return new ArrayList<AccomplishmentResponse>();
		}
		List<AccomplishmentResponse> accomplishmentResponseList = new ArrayList<AccomplishmentResponse>();
		accomplishmentList.stream().forEach(accomplishment -> {
			accomplishmentResponseList.add(buildAccomplishmentResponse(accomplishment));
		});
		return accomplishmentResponseList;
	}
	
	public static AccomplishmentResponse buildAccomplishmentResponse(Accomplishment accomplishment) {
		if (accomplishment == null) {
			return null;
		}
		AccomplishmentResponse accomplishmentResponse = new AccomplishmentResponse();
		accomplishmentResponse.setAccomplishmentId(accomplishment.getAccomplishmentId());
		accomplishmentResponse.setTitle(accomplishment.getTitle());
		accomplishmentResponse.setIssuer(accomplishment.getIssuer());
		accomplishmentResponse.setGame(accomplishment.getGame());
		accomplishmentResponse.setDescription(accomplishment.getDescription());
		accomplishmentResponse.setDate(accomplishment.getDate());
		return accomplishmentResponse;
	}
	
	public static List<ExperienceResponse> buildExperienceResponseList(List<Experience> experienceList) {
		if (experienceList == null) {
			return new ArrayList<ExperienceResponse>();
		}
		List<ExperienceResponse> experienceResponseList = new ArrayList<ExperienceResponse>();
		experienceList.stream().forEach(experience -> {
			experienceResponseList.add(buildExperienceResponse(experience));
		});
		return experienceResponseList;
	}
	
	public static ExperienceResponse buildExperienceResponse(Experience experience) {
		if (experience == null) {
			return null;
		}
		ExperienceResponse experienceResponse = new ExperienceResponse();
		experienceResponse.setExperienceId(experience.getExperienceId());
		experienceResponse.setTitle(experience.getTitle());
		experienceResponse.setTeam(experience.getTeam());
		experienceResponse.setGame(experience.getGame());
		experienceResponse.setDescription(experience.getDescription());
		experienceResponse.setStartDate(experience.getStartDate());
		experienceResponse.setEndDate(experience.getEndDate());
		return experienceResponse;
	}
		
	public static List<UserSocialMediaResponse> buildUserSocialMediaResponseList(List<UserSocialMedia> userSocialMediaList) {
		if (userSocialMediaList == null) {
			return new ArrayList<UserSocialMediaResponse>();
		}
		List<UserSocialMediaResponse> userSocialMediaResponseList = new ArrayList<UserSocialMediaResponse>();
		userSocialMediaList.stream().forEach(socialMedia -> {
			userSocialMediaResponseList.add(buildUserSocialMediaResponse(socialMedia));
		});
		return userSocialMediaResponseList;
	}
	
	public static UserSocialMediaResponse buildUserSocialMediaResponse(UserSocialMedia socialMedia) {
		if (socialMedia == null) {
			return null;
		}
		UserSocialMediaResponse userSocialMediaResponse = new UserSocialMediaResponse(); 
		userSocialMediaResponse.setUserSocialMediaId(socialMedia.getUserSocialMediaId());
		userSocialMediaResponse.setType(socialMedia.getType());
		userSocialMediaResponse.setLink(socialMedia.getLink());
		return userSocialMediaResponse;
	}

	public static Accomplishment buildAccomplishment(AccomplishmentResponse accomplishmentResponse) {
		if (accomplishmentResponse == null) {
			return null;
		}
		Accomplishment accomplishment = new Accomplishment();
		accomplishment.setAccomplishmentId(accomplishmentResponse.getAccomplishmentId());
		accomplishment.setTitle(accomplishmentResponse.getTitle());
		accomplishment.setIssuer(accomplishmentResponse.getIssuer());
		accomplishment.setGame(accomplishmentResponse.getGame());
		accomplishment.setDescription(accomplishmentResponse.getDescription());
		accomplishment.setDate(accomplishmentResponse.getDate());
		
		return accomplishment; 
	}
	
	public static Experience buildExperience(ExperienceResponse experienceResponse) {
		if (experienceResponse == null) {
			return null;
		}
		Experience experience = new Experience();
		experience.setExperienceId(experienceResponse.getExperienceId());
		experience.setTitle(experienceResponse.getTitle());
		experience.setTeam(experienceResponse.getTeam());
		experience.setGame(experienceResponse.getGame());
		experience.setDescription(experienceResponse.getDescription());
		experience.setStartDate(experienceResponse.getStartDate());
		experience.setEndDate(experienceResponse.getEndDate());
		
		return experience; 
	}
	
	public static UserSocialMedia buildUserSocialMedia(UserSocialMediaResponse socialMediaResponse) {
		if (socialMediaResponse == null) {
			return null;
		}
		UserSocialMedia userSocialMedia = new UserSocialMedia(); 
		userSocialMedia.setUserSocialMediaId(socialMediaResponse.getUserSocialMediaId());
		userSocialMedia.setType(socialMediaResponse.getType());
		userSocialMedia.setLink(socialMediaResponse.getLink());
		
		return userSocialMedia;
	}
}
