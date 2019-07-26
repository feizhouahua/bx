package com.hxzy.bx.service;

import java.util.List;

import com.hxzy.bx.entity.Class;
import com.hxzy.bx.entity.Course_type;

public interface Course_typeService {
	//通过course查班级
	public List<Class> queryClass(String course);
	
	//查询学科
	public List<Course_type> quCourse();
}
