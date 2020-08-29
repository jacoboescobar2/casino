package com.casino.app.models.dao;

import java.util.List;

import com.casino.app.models.entity.User;

public interface IUserDao {

	public List<User> findAll();
	
	public User findById(int id);
}
