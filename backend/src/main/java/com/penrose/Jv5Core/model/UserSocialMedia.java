package com.penrose.Jv5Core.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity(name="user_social_media")
@JsonIgnoreProperties(ignoreUnknown=true)
public class UserSocialMedia {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userSocialMediaId;
	
	@NotNull
	private Long userId;
	
	@NotNull
	private String type;
	
	@NotNull
	private String link;

	private Date createdDate;
	private Date lastUpdatedDate; 
	
	
	public Long getUserSocialMediaId() {
		return userSocialMediaId;
	}

	public void setUserSocialMediaId(Long userSocialMediaId) {
		this.userSocialMediaId = userSocialMediaId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
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

	@Override
	public String toString() {
		return "UserSocialMedia [userSocialMediaId=" + userSocialMediaId + ", userId=" + userId + ", type=" + type
				+ ", link=" + link + ", createdDate=" + createdDate + ", lastUpdatedDate=" + lastUpdatedDate + "]";
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
