package com.casino.app.models.service;

import java.util.List;

import com.casino.app.models.entity.User;

public interface IUserService {
	
	public List<User> findAll();
	
	public User findById(int id);

}
