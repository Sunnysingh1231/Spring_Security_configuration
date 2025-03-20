package com.configuration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.configuration.model.User;
import com.configuration.model.UserPrinciple;
import com.configuration.repository.UserRepository;

@Service
public class myUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		User user = repository.findByuserName(userName);
		
		if(user==null) {
			throw new UsernameNotFoundException("fbrtrtfgntrt");
		}
		System.out.println(user);
		return new UserPrinciple(user);
	}

}
