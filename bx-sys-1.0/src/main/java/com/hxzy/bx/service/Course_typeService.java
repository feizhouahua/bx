package com.hxzy.bx.service;

import java.util.List;

import com.hxzy.bx.entity.Class;
import com.hxzy.bx.entity.Course_type;

public interface Course_typeService {
	//通过course查班级
	public List<Class> queryClass(String course);
	
	//条件查询+分页
	public List<Course_type> getListByCourse_type(Double gcourse_cost,Integer gtotal_hours,Course_type course_type,int start,int count);
	
	//查询再带条件的情况下数据库有多少条记录
	public int getCountByCourse_type(Double gcourse_cost,Integer gtotal_hours,Course_type course_type);
	
	//根据每页显示条数求出页数
	public int getPages(Double gcourse_cost,Integer gtotal_hours,int pagecount,Course_type course_type);
	
	//添加课程类别
	public void addCourse_type(Course_type course_type);
		
	//修改课程类别
	public void updateCourse_type(Course_type course_type);
	
	//根据id查找course_type
	public Course_type getCourse_typeById(int id);
}
