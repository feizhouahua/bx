package com.hxzy.bx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hxzy.bx.entity.Permission;
import com.hxzy.bx.entity.Role;
import com.hxzy.bx.entity.User;

public interface UserDao {
	
	//登录
	public User getLogin(User user);
	
	//添加登录用户
	public void addUser(User user);
	
	//查询根据username当前用户对象
	public User getUserByName(String username);
		
	//查询当前用户拥有的权限
	public List<Permission> getPermissionByUsername(String username);
	
	//<!-- 添加一个用户信息并返回一个id -->
	public void addUserGetId(User user);
	
	//<!--根据添加员工的所在部门，查询角色表相对应的角色名（即部门名称）,找到相对应的roleid -->
	public Role getRoleIdByDepartName(String roleName);
	
	//<!-- 因为每个用户都有角色信息，添加一个用户信息，用户角色表也应该添加一条信息 -->
	public void addUserRole(@Param(value="user")User user,@Param(value="role")Role role);
	
	//根据id更改密码
	public void updateUserById(User user);
}
