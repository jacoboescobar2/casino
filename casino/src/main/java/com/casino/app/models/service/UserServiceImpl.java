package com.casino.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casino.app.models.dao.IUserDao;
import com.casino.app.models.entity.User;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDao userDao;

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}
	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}

}
