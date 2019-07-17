package com.hxzy.bx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.bx.dao.CurriculumDao;
import com.hxzy.bx.service.CurriculumService;

@Component("curriculumServiceImpl")
public class CurriculumServiceImpl implements CurriculumService {

	@Resource
	private CurriculumDao curriculumDao;
	public void setCurriculumDao(CurriculumDao curriculumDao) {
		this.curriculumDao = curriculumDao;
	}
	
}
