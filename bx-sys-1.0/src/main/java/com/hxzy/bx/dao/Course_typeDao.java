package com.hxzy.bx.dao;

import java.util.List;

import com.hxzy.bx.entity.Class;

public interface Course_typeDao {
	
	//通过course查班级
	public List<Class> queryClass(String course);

}
