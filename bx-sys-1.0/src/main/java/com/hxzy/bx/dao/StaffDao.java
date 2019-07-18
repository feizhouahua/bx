package com.hxzy.bx.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.hxzy.bx.entity.Staff;

public interface StaffDao {

	//查询员工列表+分页(start 表示从第几条记录开始 count表示每页显示几条记录)
	public List<Staff> getStaffs(@Param(value = "start") int start,@Param(value = "count")int count);
	
	//高级查询+查询员工列表+分页
	public List<Staff> getStaffsByCondition(@Param("staff")Staff staff,@Param("start") int start,@Param("count")int count);
	
	//查询条件查询有多少条记录
	public int getStaffsByConditionCounts(@Param("staff")Staff staff);
	
	//添加职务
	public void addStaff(Staff staff);
	
	//编辑职务
	public void updateStaff(Staff staff);
		
	//查询有多少条记录
	public int getCounts();
			
	//根据id查找对象
	public Staff getStaffById(int id);
}
