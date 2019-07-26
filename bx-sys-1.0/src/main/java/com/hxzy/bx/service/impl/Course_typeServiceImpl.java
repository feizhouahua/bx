package com.hxzy.bx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.bx.dao.Course_typeDao;
import com.hxzy.bx.entity.Class;
import com.hxzy.bx.entity.Course_type;
import com.hxzy.bx.service.Course_typeService;

@Component("course_typeServiceImpl")
public class Course_typeServiceImpl implements Course_typeService{

	@Resource
	private Course_typeDao course_typeDao;
	public void setCourse_typeDao(Course_typeDao course_typeDao) {
		this.course_typeDao = course_typeDao;
	}
	
	
	@Override
	public List<Class> queryClass(String course) {
		// TODO Auto-generated method stub
		return course_typeDao.queryClass(course);
	}

	//查询学科
	@Override
	public List<Course_type> quCourse() {
		// TODO Auto-generated method stub
		return course_typeDao.quCourse();
	}

	
	
	 
}
