package com.hxzy.bx.service;

import java.util.List;

import com.hxzy.bx.entity.Class;

public interface Course_typeService {
	//通过course查班级
	public List<Class> queryClass(String course);
}
