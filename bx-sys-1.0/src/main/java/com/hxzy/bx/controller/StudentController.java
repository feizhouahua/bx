package com.hxzy.bx.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.hxzy.bx.service.StudentService;

@Controller
public class StudentController {

	@Resource(name="studentServiceImpl")
	private StudentService studentService;
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
}
