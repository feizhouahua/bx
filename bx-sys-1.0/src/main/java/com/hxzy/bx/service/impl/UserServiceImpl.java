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
import org.springframework.transaction.annotation.Transactional;

import com.hxzy.bx.dao.UserDao;
import com.hxzy.bx.entity.Permission;
import com.hxzy.bx.entity.Role;
import com.hxzy.bx.entity.Staff;
import com.hxzy.bx.entity.User;
import com.hxzy.bx.service.StaffService;
import com.hxzy.bx.service.UserService;

@Component("userServiceImpl")
public class UserServiceImpl implements UserService,UserDetailsService {
	
	@Resource(name="staffServiceImpl")
	private StaffService staffService;
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	
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
	@Transactional(rollbackFor=Exception.class)
	public void addUserGetId(User user) {
		// TODO Auto-generated method stub
		userDao.addUserGetId(user);
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public Role getRoleIdByDepartName(String roleName) {
		// TODO Auto-generated method stub
		return userDao.getRoleIdByDepartName(roleName);
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void addUserRole(User user, Role role) {
		userDao.addUserRole(user, role);
		
	}
	@Override
	public void updateUserById(User user) {
		userDao.updateUserById(user);
		
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void tx(User user,String roleName,Staff staff){
		//向user表添加一条数据并返回添加数据的user_id给user对象
		addUserGetId(user);
		//根据角色(部门名字)获得角色id（role_id）
		//因为权限是按照部门来分配的
		//所以根据部门名查找相对应的roleid
		Role role=getRoleIdByDepartName(roleName);	
		//向用户角色中间表添加一条数据
		//绑定用户角色，角色绑定权限
		addUserRole(user, role);
		//向员工表添加一条数据
		staffService.addStaff(staff);

	}
	
}
