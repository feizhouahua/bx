package com.hxzy.bx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.bx.dao.UserDao;
import com.hxzy.bx.entity.User;
import com.hxzy.bx.service.UserService;

@Component("userServiceImpl")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public User getLogin(User user) {
		return userDao.getLogin(user);
	}
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	
	
}
