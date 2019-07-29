package com.hxzy.bx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hxzy.bx.entity.Class;
import com.hxzy.bx.entity.Course_type;

public interface Course_typeDao {
	
	//通过course查班级
	public List<Class> queryClass(String course);
	
	//查询学科
	public List<Course_type> quCourse();

	//条件查询+分页
	public List<Course_type> getListByCourse_type(@Param(value="gcourse_cost")Double gcourse_cost,@Param(value="gtotal_hours")Integer gtotal_hours,@Param(value="course_type")Course_type course_type,@Param(value="start")int start,@Param(value="count")int count);
	
	//查询再带条件的情况下数据库有多少条记录
	public int getCountByCourse_type(@Param(value="gcourse_cost")Double gcourse_cost,@Param(value="gtotal_hours")Integer gtotal_hours,@Param(value="course_type")Course_type course_type);
	
	//添加课程类别
	public void addCourse_type(Course_type course_type);
	
	//修改课程类别
	public void updateCourse_type(Course_type course_type);
	
	//根据id查找course_type
	public Course_type getCourse_typeById(int id);
}
