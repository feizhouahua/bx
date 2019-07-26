package com.hxzy.bx.dao;

import java.util.List;

import com.hxzy.bx.entity.Class;
import com.hxzy.bx.entity.Course_type;

public interface Course_typeDao {
	
	//通过course查班级
	public List<Class> queryClass(String course);
	
	//查询学科
	public List<Course_type> quCourse();

}
