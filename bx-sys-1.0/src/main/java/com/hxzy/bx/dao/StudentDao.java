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
	
}
