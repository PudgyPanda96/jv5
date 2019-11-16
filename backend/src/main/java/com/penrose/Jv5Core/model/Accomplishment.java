package com.penrose.Jv5Core.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity(name="accomplishment")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Accomplishment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long accomplishmentId;
	
	@NotNull
	private Long userId;
	
	@NotNull
	private String title;

	private String game;
	private String issuer;
	private Date date;
	private String description;
	private Date createdDate;
	private Date lastUpdatedDate; 
	
	
	public Long getAccomplishmentId() {
		return accomplishmentId;
	}

	public void setAccomplishmentId(Long accomplishmentId) {
		this.accomplishmentId = accomplishmentId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

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
		return "Accomplishment [accomplishmentId=" + accomplishmentId + ", userId=" + userId + ", title=" + title
				+ ", game=" + game + ", issuer=" + issuer + ", date=" + date + ", description=" + description
				+ ", createdDate=" + createdDate + ", lastUpdatedDate=" + lastUpdatedDate + "]";
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
