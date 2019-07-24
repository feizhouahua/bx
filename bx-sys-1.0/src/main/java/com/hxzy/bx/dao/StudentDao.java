package com.hxzy.bx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hxzy.bx.entity.Student;

public interface StudentDao {
	
	//根据班级名字（classname）查找该班的学生
	public List<Student> getStudentNames(String classname);
	
	//根据学生姓名(studentname)修改学生状态(state)
	public void updateStudentStatesByName(@Param("studentname")String studentname,@Param("state")String state);
	/* 查询学生信息 */
	public List<Student> queryStus(@Param("text")String text,@Param("course")String course,
			@Param("classname") String classname,@Param("start") int start,@Param("count") int count);
	
	//查询记录条数
	public int stuNum(@Param("text")String text,@Param("course")String course,
			@Param("classname") String classname);
	
	//添加学生
	public void addStu(@Param("student") Student student,@Param(value = "id") int id);
	
	//通过classname查询class_id
	public int queryid(String classname);
	
	//更新数据
	public void upStudent(@Param(value="student")Student student,@Param(value="id")Integer id);
	
	//通过id查询学生信息
	public Student getStubyid(Integer id);
}
