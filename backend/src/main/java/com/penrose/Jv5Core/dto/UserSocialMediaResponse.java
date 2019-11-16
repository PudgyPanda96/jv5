package com.penrose.Jv5Core.dto;

public class UserSocialMediaResponse {

	private Long userSocialMediaId;
	private String type;
	private String link;
	
	public Long getUserSocialMediaId() {
		return userSocialMediaId;
	}
	public void setUserSocialMediaId(Long userSocialMediaId) {
		this.userSocialMediaId = userSocialMediaId;
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
	
	@Override
	public String toString() {
		return "UserSocialMediaResponse [type=" + type + ", link=" + link + "]";
	}
	
	
}