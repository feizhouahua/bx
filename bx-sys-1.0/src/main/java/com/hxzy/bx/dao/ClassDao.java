package com.hxzy.bx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hxzy.bx.entity.Class;
import com.hxzy.bx.entity.Course_type;

public interface ClassDao {
	
	//查询所有班级
	public List<Class> getClass_names(); 
	
	//分页查询所有数据
	public List<Class> getClasses(@Param(value="start")int start,@Param(value="count")int count);
	
	//查询数据库记录条数
	public int getCounts();
	
	//查询所有的类别名
	public List<Course_type> getCourse_Names();
	
	//添加一个班级
	public void addClass(Class class1);
	
	////根据类别名查询获得类别id
	public int getCourseIdByName(String course_name);
	
	//根据id查询class
	public Class getClassById(int id);
	
	//修改class
	public void updateClass(Class class1);
	
	//根据id修改上传课表状态
	public void updateUploadState(Class class1);
	
}
