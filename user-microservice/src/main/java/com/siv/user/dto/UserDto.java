package com.siv.user.dto;

public class UserDto {

	private final Long id;

	private final String userName;

	private final String password;

	public UserDto(String userName, String password) {
		this.id = null;
		this.userName = userName;
		this.password = password;
	}
	
	public UserDto(Long id, String userName, String password) {
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public static UserDto of(String userName, String password) {
		return new UserDto(userName, password);
	}
}
