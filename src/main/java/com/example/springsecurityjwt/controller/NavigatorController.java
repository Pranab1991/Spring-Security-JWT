package com.example.springsecurityjwt.controller;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurityjwt.model.User;
import com.example.springsecurityjwt.repository.UsersRepository;

@RestController
public class NavigatorController {
	
	@Autowired
	UsersRepository repo;

	@RequestMapping("/test")
	public String welcome(@RequestParam String username) {
		System.out.println(username);
		Optional<User> user=repo.findByUsername(username);
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
