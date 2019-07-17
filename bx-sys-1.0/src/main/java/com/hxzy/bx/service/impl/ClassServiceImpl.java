package com.hxzy.bx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.bx.dao.ClassDao;
import com.hxzy.bx.service.ClassService;

@Component("classServiceImpl")
public class ClassServiceImpl implements ClassService {
	
	@Resource
	private ClassDao classDao;
	public void setClassDao(ClassDao classDao) {
		this.classDao = classDao;
	}
	
	
}
