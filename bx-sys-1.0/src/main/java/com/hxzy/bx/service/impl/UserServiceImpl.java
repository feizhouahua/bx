package com.hxzy.bx.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.hxzy.bx.dao.UserDao;
import com.hxzy.bx.entity.Permission;
import com.hxzy.bx.entity.Role;
import com.hxzy.bx.entity.User;
import com.hxzy.bx.service.UserService;

@Component("userServiceImpl")
public class UserServiceImpl implements UserService,UserDetailsService {
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
	@Override
	public User getUserByName(String username) {
		// TODO Auto-generated method stub
		return userDao.getUserByName(username);
	}
	@Override
	public List<Permission> getPermissionByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.getPermissionByUsername(username);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//1、根据用户名查询用户信息
			User user=getUserByName(username);
			//2、根据用户名查询当前用户的所有权限
			List<Permission> permissions=getPermissionByUsername(username);
			//存放所有的用户权限
			List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
			
			for (Permission permission: permissions) {
				 GrantedAuthority authority=new SimpleGrantedAuthority(permission.getPermTag()) ;//得到权限
				 authorities.add(authority);//把等到的权限放入权限集合内
			}
			//把所有权限赋值给user
			user.setAuthorities(authorities);
			
			//因为user实现了UserDetails接口 
			return user;
	}
	@Override
	public void addUserGetId(User user) {
		// TODO Auto-generated method stub
		userDao.addUserGetId(user);
	}
	@Override
	public Role getRoleIdByDepartName(String roleName) {
		// TODO Auto-generated method stub
		return userDao.getRoleIdByDepartName(roleName);
	}
	@Override
	public void addUserRole(User user, Role role) {
		userDao.addUserRole(user, role);
		
	}
	@Override
	public void updateUserById(User user) {
		userDao.updateUserById(user);
		
	}
	
	
	
}
