package com.hxzy.bx.service;

import java.util.List;

import com.hxzy.bx.entity.Student;

public interface StudentService {

	//根据班级名字（classname）查找该班的学生
	public List<Student> getStudentNames(String classname);
	
	//根据学生姓名修改学生状态
	public void updateStudentStatesByName(String studentname,String state);
}
