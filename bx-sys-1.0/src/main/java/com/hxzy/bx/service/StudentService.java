package com.hxzy.bx.service;

import java.util.List;

import com.hxzy.bx.entity.Student;

public interface StudentService {
	public List<Student> queryStus(String text,String course,
			 String classname, Integer start, Integer count);
	
	public int stuNum(String text,String course,String classname);
	
	//添加学生
	public void addStu(Student student, int id);
	
	//通过classname查询class_id
	public int queryid(String classname);
	
	//更新学生信息
	public void upstudent(Student student,int id);
	
	//通过id查询学生信息
	public Student getStubyid(Integer id);
}
