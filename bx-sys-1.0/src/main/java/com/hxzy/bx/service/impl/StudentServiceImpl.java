package com.hxzy.bx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.bx.dao.StudentDao;
import com.hxzy.bx.entity.Student;
import com.hxzy.bx.service.StudentService;

@Component("studentServiceImpl")
public class StudentServiceImpl implements StudentService{

	@Resource
	private StudentDao studentDao;
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	@Override
	public List<Student> queryStus(String text, String course, String classname, Integer start, Integer count) {
		// TODO Auto-generated method stub
		return studentDao.queryStus(text, course, classname, start, count);
	}
	@Override
	public int stuNum(String text, String course, String classname) {
		// TODO Auto-generated method stub
		return studentDao.stuNum(text, course, classname);
	}
	
	
}
