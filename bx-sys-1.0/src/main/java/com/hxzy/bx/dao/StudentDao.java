package com.hxzy.bx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hxzy.bx.entity.Student;

public interface StudentDao {
	
	//根据班级名字（classname）查找该班的学生
	public List<Student> getStudentNames(String classname);
	
	//根据学生姓名(studentname)修改学生状态(state)
	public void updateStudentStatesByName(@Param("studentname")String studentname,@Param("state")String state);
}
