package com.siv.user.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siv.user.dto.UserDto;
import com.siv.user.service.UserService;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {
    
	@Value("${pod.ip}")
    private String podIp;
    
	@Autowired
	private UserService userService;

	@GetMapping
	public List<UserDto> getUsers() {
		return userService.getUsers();
	}
	
	@GetMapping("/ip")
	public String getPodIp() {
		return podIp;
	}
	
	@GetMapping("/{id}")
	public UserDto findUser(long id) {
		return userService.findUser(id);
	}
	
	@PostMapping
	public String createUser(String userName, String password) {
		UserDto user = UserDto.of(userName, password);
		user = userService.createUser(user);
		return podIp;
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(Long id) {
		userService.deleteUser(id);
	}
}
