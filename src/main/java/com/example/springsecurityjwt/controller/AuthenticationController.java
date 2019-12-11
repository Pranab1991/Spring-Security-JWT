package com.example.springsecurityjwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurityjwt.configs.SpringSecurityConfig;
import com.example.springsecurityjwt.model.AthenticationOutput;
import com.example.springsecurityjwt.model.AuthenticateInput;
import com.example.springsecurityjwt.service.JpaDataUserDetailsService;
import com.example.springsecurityjwt.utils.JwtUtil;

@RestController
public class AuthenticationController {

	private AuthenticationManager authManager;
	private JpaDataUserDetailsService customeUserDetails;
	private JwtUtil jwtutils;

	public AuthenticationController(JpaDataUserDetailsService customeUserDetails, AuthenticationManager authManager, JwtUtil jwtutils) {
		this.authManager = authManager;
		this.customeUserDetails = customeUserDetails;
		this.jwtutils=jwtutils;
	}

	@PostMapping(value = "/authenticate")
	public ResponseEntity<AthenticationOutput> getJwtToken(@RequestBody AuthenticateInput authenticateIn) throws Exception {
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateIn.getUsername(),
					authenticateIn.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		customeUserDetails.loadUserByUsername(authenticateIn.getUsername());
		String jwt=jwtutils.generateToken(customeUserDetails.loadUserByUsername(authenticateIn.getUsername()));
		return ResponseEntity.ok(new AthenticationOutput(jwt));
	}
}
