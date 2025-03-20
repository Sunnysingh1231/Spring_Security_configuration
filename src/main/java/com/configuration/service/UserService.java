package com.configuration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.configuration.model.User;
import com.configuration.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public String saveNewUser(User u1) {
		userRepository.save(u1);
		return "User added successful.";
	}
	
	public List<User> findAllUser() {
		return userRepository.findAll();
	}
}
