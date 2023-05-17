package com.adjecti.oexam.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.adjecti.oexam.entity.User;
import com.adjecti.oexam.repository.UserRepository;	

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUserName(username);
		

		CustomUserDetails customUserDetails = null;
		if (user == null) {
			throw new UsernameNotFoundException("User does not exist with name : " + user.getUserName());
		}
		customUserDetails = new CustomUserDetails(user);
		return customUserDetails;

	}
	
}
