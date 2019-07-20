package com.hxzy.bx.dao;

import java.util.List;

public interface Course_typeDao {
	
	//通过course查班级
	public List<String> queryClass(String course);

}
