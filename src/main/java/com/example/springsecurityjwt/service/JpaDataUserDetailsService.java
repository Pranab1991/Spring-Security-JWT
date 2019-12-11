package com.example.springsecurityjwt.service;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springsecurityjwt.model.User;
import com.example.springsecurityjwt.repository.UsersRepository;
import com.example.springsecurityjwt.utils.CustomeUserDetails;

@Service
public class JpaDataUserDetailsService implements UserDetailsService{
	
	@Autowired
	UsersRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=repo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("Unable to find user"));
		return new CustomeUserDetails(user);
	}

}
