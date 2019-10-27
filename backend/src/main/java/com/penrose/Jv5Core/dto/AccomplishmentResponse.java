package com.penrose.Jv5Core.dto;

import java.util.Date;

public class AccomplishmentResponse {

	private String title;
	private String game;
	private String issuer;
	private Date date;
	private String description;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGame() {
		return game;
	}
	public void setGame(String game) {
		this.game = game;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "AccomplishmentResponse [title=" + title + ", game=" + game + ", issuer=" + issuer + ", date=" + date
				+ ", description=" + description + "]";
	}
	
	
}
