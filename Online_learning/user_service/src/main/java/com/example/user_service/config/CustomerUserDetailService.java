package com.example.user_service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.user_service.repository.UserRepository;

public class CustomerUserDetailService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.example.user_service.model.User user = userRepository.findByName(username)
	            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

	        return org.springframework.security.core.userdetails.User.builder()
	            .username(user.getName())
	            .password(user.getPassword()) 
	            .roles(user.getRole().name()) 
	            .build();
	}

}
