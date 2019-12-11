package com.example.springsecurityjwt.utils;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.stream.Collectors;

import com.example.springsecurityjwt.model.Authorities;
import com.example.springsecurityjwt.model.User;

public class CustomeUserDetails implements UserDetails{
	
	private User user;
	public CustomeUserDetails() {	}
	
	public CustomeUserDetails(User u) {
		this.user=u;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.user.getMappedAuthorities().stream().map((t)->new SimpleGrantedAuthority(t.getRole())).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.user.isEnabled();
	}

}
