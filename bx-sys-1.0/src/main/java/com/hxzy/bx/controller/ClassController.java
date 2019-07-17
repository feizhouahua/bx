package com.hxzy.bx.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.hxzy.bx.service.ClassService;

@Controller
public class ClassController {

	@Resource(name="classServiceImpl")
	private ClassService classService;
	public void setClassService(ClassService classService) {
		this.classService = classService;
	}
	
}
