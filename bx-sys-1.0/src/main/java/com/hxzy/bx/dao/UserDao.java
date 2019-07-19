package com.hxzy.bx.dao;

import com.hxzy.bx.entity.User;

public interface UserDao {
	
	//登录
	public User getLogin(User user);
	
	//添加登录用户
	public void addUser(User user);
}
