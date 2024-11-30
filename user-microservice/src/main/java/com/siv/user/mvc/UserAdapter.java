package com.siv.user.mvc;

import java.util.List;
import java.util.stream.Collectors;

import com.siv.user.dao.User;
import com.siv.user.dto.UserDto;

public class UserAdapter {

	public static User transform(UserDto userDto) {
		return new User(userDto.getId(), userDto.getUserName(), userDto.getPassword());
	}

	public static UserDto transform(User user) {
		return new UserDto(user.getId(), user.getUserName(), user.getPassword());
	}

	public static List<UserDto> transform(List<User> users) {
		return users.stream().map(u -> transform(u)).collect(Collectors.toList());
	}
}
