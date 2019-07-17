package com.hxzy.bx.service;

import java.util.List;

import com.hxzy.bx.entity.Refer;

public interface ReferService {
	//姓名，qq，电话模糊查询意向学员
	public List<Refer> getRefer(String text);
	
	//查询全部意向学员
	public List<Refer> getRefers();
	
	//通过id查询学员
	public Refer chakan(Integer id);
	
	//编辑咨询学生
	public void uprefer(Refer refer);
}
