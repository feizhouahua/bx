package com.hxzy.bx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hxzy.bx.entity.Student;

public interface StudentDao {
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
	
	//根据班级名称查课程
	public String queCourse(String name);
	
	//升级/转班 根据班级名称修改学生的class_id
	public void updatacla(@Param(value="classname")String classname,@Param(value="id") int id);
	
	//delStuById
	public void delStuById(int id);
}
