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
	public List<Student> getStudentNames(String classname) {
		// TODO Auto-generated method stub
		return studentDao.getStudentNames(classname);
	}
	@Override
	public void updateStudentStatesByName(String studentname,String state) {
		// TODO Auto-generated method stub
		studentDao.updateStudentStatesByName(studentname,state);
	}
	
}
