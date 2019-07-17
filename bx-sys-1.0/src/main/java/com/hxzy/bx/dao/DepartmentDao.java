package com.hxzy.bx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hxzy.bx.entity.Department;

public interface DepartmentDao {
	
	//查询部门列表集合(start 表示从第几条记录开始 count表示每页显示几条记录)
	public List<Department> getDepartments(@Param(value = "start") int start,@Param(value = "count")int count);
	
	//添加部门
	public void addDepartment(Department department);
	
	//编辑部门
	public void updateDepartment(Department department);
	
	//查询有多少条记录
	public int getCounts();
	
	//根据id查找对象
	public Department getDepartmentById(int id);
	
	//查询所有部门
	public List<Department> getDepart_names(); 
	
	//根据depart_name查找对象
	public Department getDepartmentByName(String depart_name);
}
