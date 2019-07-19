package com.hxzy.bx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hxzy.bx.entity.Refer;

public interface ReferDao {
	//姓名，qq，电话模糊查询意向学员
	public List<Refer> getRefer(@Param(value = "text") String text,@Param(value = "start") int start,@Param(value = "count") int count);
	 
	//数量
	public int getRefernum(String text);
	
	//查询全部意向学员
	public List<Refer> getRefers(@Param(value = "start") int start,@Param(value = "count")int count);
	
	//数量
	public int getRefersnum();
	
	//通过id查询学员
	public Refer chakan(Integer id);
	
	//编辑咨询学生
	public void uprefer(Refer refer);
	
	//查询已报名学员
	public List<Refer> queryStu(@Param(value = "start") int start,@Param(value = "count")int count);
	
	//数量
	public int queryStunum();
}
