package com.example.springsecurityjwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NavigatorController {

	@RequestMapping("/")
	public String welcome() {
		return "<h1>Welcome</h1>";
	}
	
	@RequestMapping("/user")
	public String welcomeUser() {
		return "<h1>Welcome User</h1>";
	}
	
	@RequestMapping("/admin")
	public String welcomeAdmin() {
		return "<h1>Welcome Admin</h1>";
	}
}
