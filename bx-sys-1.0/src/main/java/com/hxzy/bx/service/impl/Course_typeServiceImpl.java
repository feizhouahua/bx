package com.hxzy.bx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.bx.dao.Course_typeDao;
import com.hxzy.bx.service.Course_typeService;

@Component("course_typeServiceImpl")
public class Course_typeServiceImpl implements Course_typeService{

	@Resource
	private Course_typeDao course_typeDao;
	public void setCourse_typeDao(Course_typeDao course_typeDao) {
		this.course_typeDao = course_typeDao;
	}
	
	 
}
