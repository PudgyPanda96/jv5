package com.penrose.Jv5Core.dto;

import java.util.ArrayList;
import java.util.List;

public class UserResponse {

	private Long userId; 
	private String firstName;
	private String lastName;
	private String alias;
	private String email;
	private String country;
	private String state;
	private String city;
	private byte[] profileImage; 
	private String game;
	private String gameRole;
	private String about;
	List<AccomplishmentResponse> accomplishmentList = new ArrayList<AccomplishmentResponse>();
	List<ExperienceResponse> experienceList = new ArrayList<ExperienceResponse>();
	List<UserSocialMediaResponse> userSocialMediaList = new ArrayList<UserSocialMediaResponse>();
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public byte[] getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}
	public String getGame() {
		return game;
	}
	public void setGame(String game) {
		this.game = game;
	}
	public String getGameRole() {
		return gameRole;
	}
	public void setGameRole(String gameRole) {
		this.gameRole = gameRole;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public List<AccomplishmentResponse> getAccomplishmentList() {
		return accomplishmentList;
	}
	public void setAccomplishmentList(List<AccomplishmentResponse> accomplishmentList) {
		this.accomplishmentList = accomplishmentList;
	}
	public List<ExperienceResponse> getExperienceList() {
		return experienceList;
	}
	public void setExperienceList(List<ExperienceResponse> experienceList) {
		this.experienceList = experienceList;
	}
	public List<UserSocialMediaResponse> getUserSocialMediaList() {
		return userSocialMediaList;
	}
	public void setUserSocialMediaList(List<UserSocialMediaResponse> userSocialMediaList) {
		this.userSocialMediaList = userSocialMediaList;
	}
	
	@Override
	public String toString() {
		return "UserResponse [firstName=" + firstName + ", lastName=" + lastName + ", alias="
				+ alias + ", email=" + email + ", country=" + country + ", state=" + state + ", city=" + city
			    + ", game=" + game + ", gameRole=" + gameRole
				+ ", about=" + about + ", accomplishmentList="
				+ accomplishmentList + ", experienceList=" + experienceList + ", userSocialMediaList="
				+ userSocialMediaList + "]";
	}
	

	
}