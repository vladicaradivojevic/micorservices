package com.siv.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.siv.user.dao.User;
import com.siv.user.dao.UserRepository;
import com.siv.user.dto.UserDto;
import com.siv.user.mvc.UserAdapter;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDto findUser(long id) {
		return UserAdapter.transform(userRepository.findById(id).orElseThrow());
	}

	@Override
	public UserDto createUser(UserDto user) {
		return UserAdapter.transform(userRepository.save(UserAdapter.transform(user)));
	}

	@Override
	public void deleteUser(long id) {
		if (findUser(id) != null) {
			userRepository.deleteById(id);
		} else {
			throw new IllegalStateException("Trying to delete non existing user with id: " + id);
		}
	}

	@Override
	public List<UserDto> getUsers() {
		return UserAdapter.transform(userRepository.findAll());
	}

	@Override
	public UserDto findUserByUserName(String userName) {
		User probe = new User();
		probe.setUserName(userName);
		return UserAdapter.transform(userRepository.findOne(Example.of(probe)).orElseThrow());
	}
	
}
