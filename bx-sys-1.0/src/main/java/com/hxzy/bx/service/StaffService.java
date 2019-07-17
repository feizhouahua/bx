package com.hxzy.bx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hxzy.bx.entity.Staff;

public interface StaffService {
	
		//查询员工列表+分页(start 表示从第几条记录开始 count表示每页显示几条记录)
		public List<Staff> getStaffs(int start,int count);
		
		//高级查询+查询员工列表+分页
		public List<Staff> getStaffsByCondition(Staff staff,int start,int count);
		
		//添加
		public void addStaff(Staff staff);
		
		//修改
		public void updateStaff(Staff staff);
			
		//查询有多少条记录
		public int getCounts();
		
		//根据每页显示记录数获得页数
		public int getPages(int pagecount);
		
		//根据id查找对象
		public Staff getStaffById(int id);
}
