package com.hxzy.bx.service;

import java.util.List;

import com.hxzy.bx.entity.Student;

public interface StudentService {
	public List<Student> queryStus(String text,String course,
			 String classname, Integer start, Integer count);
	
	public int stuNum(String text,String course,String classname);
}
