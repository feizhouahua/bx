package com.hxzy.bx.service;

import com.hxzy.bx.entity.User;

public interface UserService {
	
	//登录
	public User getLogin(User user);
	
	//添加登录用户
	public void addUser(User user);

}
