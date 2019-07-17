package com.hxzy.bx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.bx.dao.StudentDao;
import com.hxzy.bx.service.StudentService;

@Component("studentServiceImpl")
public class StudentServiceImpl implements StudentService{

	@Resource
	private StudentDao studentDao;
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
}
