package com.wipro.security.jwt.service;

import java.util.Optional;

import com.wipro.security.jwt.entity.User;

public interface IUserService {

	Integer saveUser(User user);
	
	Optional<User> findByUsername(String username);
}
