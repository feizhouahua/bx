package com.hxzy.bx.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.hxzy.bx.service.Course_typeService;

@Controller
public class Course_typeController {

	@Resource(name="course_typeServiceImpl")
	private Course_typeService course_typeService;
	public void setCourse_typeService(Course_typeService course_typeService) {
		this.course_typeService = course_typeService;
	}
	
}
