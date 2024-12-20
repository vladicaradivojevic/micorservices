package com.siv.user.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String userName;
	
	private String password;
	
	public User() {
	}

	public User(Long id, String userName, String password) {
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
