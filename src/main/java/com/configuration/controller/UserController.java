package com.configuration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.configuration.model.User;
import com.configuration.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String welcome() {
		
		return "welcome";
	}
	
	@GetMapping("/registration")
	public String registrationForm(Model model) {
		
		User user = new User();
		
		model.addAttribute("user", user);
		
		System.out.println(model);
		
		return "Registration";
	}
	
	@PostMapping("/homepage")
	public String homepage(@ModelAttribute User u1) {
		u1.setPassword(passwordEncoder.encode(u1.getPassword()));
		userService.saveNewUser(u1);
		return "homepage";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@GetMapping("/loginsuccess")
	public String loginsuccess() {
		
		return "loginsuccess";
	}
	
	@GetMapping("/allusers")
	public ResponseEntity<List<User>> logout() {
		
		return new ResponseEntity<List<User>>(userService.findAllUser(),HttpStatus.OK);
	}
	
}
