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

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor(access=AccessLevel.PRIVATE)
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
@Entity(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	
	@ToString.Exclude
	private byte[] avatar; 
	
	@ToString.Exclude
	private Date createdDate;
	
	@ToString.Exclude
	private Date lastUpdatedDate; 
	
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
