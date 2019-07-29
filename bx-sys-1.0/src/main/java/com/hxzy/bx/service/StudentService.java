package com.hxzy.bx.service;

import java.util.List;

import com.hxzy.bx.entity.RunOff;
import com.hxzy.bx.entity.Station;
import com.hxzy.bx.entity.Student;

public interface StudentService {

	//根据班级名字（classname）查找该班的学生
	public List<Student> getStudentNames(String classname);
	
	//根据学生姓名修改学生状态
	public void updateStudentStatesByName(String studentname,String state);

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
	
	public String queCourse(String name);
	
	public void updatacla(Station station,String classname,int id);
	
	//delStuById
	public void delStuById(RunOff runOff,int id);

}
