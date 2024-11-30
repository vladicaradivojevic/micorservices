package com.siv.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.siv.user.dto.UserDto;

@Service
public interface UserService {
	
	List<UserDto> getUsers();

	UserDto findUser(long id);
	
	UserDto createUser(UserDto user);
	
	void deleteUser(long id);

	UserDto findUserByUserName(String userName);
}
