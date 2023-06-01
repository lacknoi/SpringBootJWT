package com.imporve.skill.userservice.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.imporve.skill.userservice.model.User;
import com.imporve.skill.userservice.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DatabaseUserDetailsService implements UserDetailsService {
	private final UserRepository userRepository;
	
	@Override
    public UserDetails loadUserByUsername(String userName) {
        User user = userRepository.findByUserName(userName);
        
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUserName())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}
