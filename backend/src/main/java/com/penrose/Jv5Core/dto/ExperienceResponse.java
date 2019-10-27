package com.penrose.Jv5Core.dto;

import java.util.Date;


public class ExperienceResponse {

	private String game;
	private String title;
	private String team;
	private Date startDate;
	private Date endDate;
	private String description;
	
	public String getGame() {
		return game;
	}
	public void setGame(String game) {
		this.game = game;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "ExperienceResponse [game=" + game + ", title=" + title + ", team=" + team + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", description=" + description + "]";
	}
	
	
}
