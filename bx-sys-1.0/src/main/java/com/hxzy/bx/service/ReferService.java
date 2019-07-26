package com.hxzy.bx.service;

import java.util.List;

import com.hxzy.bx.entity.Refer;

public interface ReferService {
	//姓名，qq，电话模糊查询意向学员
	public List<Refer> getRefer(String text,int start,int count);
	
	//数量
	public int getRefernum(String text);
	
	//通过id查询学员
	public Refer chakan(Integer id);
	
	//编辑咨询学生
	public void uprefer(Refer refer);
	
	//查询已报名学员
	public List<Refer> queryStu(String text,int start,int count);
	
	//数量
	public int queryStunum(String text);
	
	//学生报名
	public void upstate(int id);
}
