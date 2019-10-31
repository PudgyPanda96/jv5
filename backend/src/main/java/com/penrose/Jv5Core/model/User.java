package com.penrose.Jv5Core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity(name="user")
@JsonIgnoreProperties(ignoreUnknown=true)
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	private String alias;
	
	@NotNull
	private String email;
	
	private String country;
	private String state;
	private String city;

	private byte[] profileImage; 
		
	private Date createdDate;
	
	private Date lastUpdatedDate; 
	
	private String password;
	
	private String game;
	private String gameRole;
	private String about;
	private byte[] resumePdf;
	
	@OneToMany
	@JoinColumn(name="userId", referencedColumnName="userId")
	List<Accomplishment> accomplishmentList = new ArrayList<Accomplishment>();
	
	@OneToMany
	@JoinColumn(name="userId", referencedColumnName="userId")
	List<Experience> experienceList = new ArrayList<Experience>();
	
	@OneToMany
	@JoinColumn(name="userId", referencedColumnName="userId")
	List<UserSocialMedia> userSocialMediaList = new ArrayList<UserSocialMedia>();
	
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public byte[] getResumePdf() {
		return resumePdf;
	}

	public void setResumePdf(byte[] resumePdf) {
		this.resumePdf = resumePdf;
	}

	public List<Accomplishment> getAccomplishmentList() {
		return accomplishmentList;
	}

	public void setAccomplishmentList(List<Accomplishment> accomplishmentList) {
		this.accomplishmentList = accomplishmentList;
	}

	public List<Experience> getExperienceList() {
		return experienceList;
	}

	public void setExperienceList(List<Experience> experienceList) {
		this.experienceList = experienceList;
	}

	public List<UserSocialMedia> getUserSocialMediaList() {
		return userSocialMediaList;
	}

	public void setUserSocialMediaList(List<UserSocialMedia> userSocialMediaList) {
		this.userSocialMediaList = userSocialMediaList;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", alias=" + alias
				+ ", email=" + email + ", country=" + country + ", state=" + state + ", city=" + city + ", createdDate="
				+ createdDate + ", lastUpdatedDate=" + lastUpdatedDate + "]";
	}

	@PrePersist
	void preInsert() {
		Date now = new Date();
		if (this.createdDate == null) {
			this.createdDate = now;
		}
		this.lastUpdatedDate = now;
	}
	
	@PreUpdate
	void preUpdate() {
		this.lastUpdatedDate = new Date();
	}
	
}
