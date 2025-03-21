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
	public String welcome(Model model) {
		
		User user = new User();
		
		model.addAttribute("user", user);
				
		return "welcome";
	}
	@PostMapping("/registration")
//	@RequestMapping
	public String homepage(@ModelAttribute User u1) {
		u1.setPassword(passwordEncoder.encode(u1.getPassword()));
		System.out.println(u1);
		userService.saveNewUser(u1);
		return "login";
	}
	@GetMapping("/login")
	public String allcss() {
		System.out.println("fff");
		return "login";
	}
	@GetMapping("/logout")
	public String logout() {
		System.out.println("fff");
		return "logout";
	}
	
	@GetMapping("/home")
//	@RequestMapping
//	@ResponseBody
	public String home() {
		return "home";
	}
	
	@GetMapping("allusers")
//	@ResponseBody
	public ResponseEntity<List<User>> allusers() {
		return new ResponseEntity<List<User>>(userService.findAllUsers(),HttpStatus.OK);
	}
	
	
	
}
