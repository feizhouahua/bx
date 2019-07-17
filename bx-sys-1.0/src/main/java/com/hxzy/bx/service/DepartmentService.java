package com.hxzy.bx.service;

import java.util.List;

import com.hxzy.bx.entity.Department;

public interface DepartmentService {
	
		//查询部门列表集合(start 表示从第几条记录开始 count表示每页显示几条记录)
		public List<Department> getDepartments(int start,int count);
		
		//添加部门
		public void addDepartment(Department department);
		
		//编辑部门
		public void updateDepartment(Department department);
		
		//查询有多少条记录
		public int getCounts();
		
		//根据每页显示记录数获得页数
		public int getPages(int pagecount);
		
		//根据id查找对象
		public Department getDepartmentById(int id);
		
		//查询所有部门
		public List<Department> getDepart_names(); 
}
