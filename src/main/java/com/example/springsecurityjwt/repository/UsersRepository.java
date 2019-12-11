package com.example.springsecurityjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springsecurityjwt.model.User;

public interface UsersRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String username);
}
