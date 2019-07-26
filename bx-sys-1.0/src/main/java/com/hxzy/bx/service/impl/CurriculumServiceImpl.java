package com.hxzy.bx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.bx.dao.CurriculumDao;
import com.hxzy.bx.entity.Curriculum;
import com.hxzy.bx.service.CurriculumService;

@Component("curriculumServiceImpl")
public class CurriculumServiceImpl implements CurriculumService {

	@Resource
	private CurriculumDao curriculumDao;
	public void setCurriculumDao(CurriculumDao curriculumDao) {
		this.curriculumDao = curriculumDao;
	}
	@Override
	public List<Curriculum> getCurriculumById(int class_id) {
		// TODO Auto-generated method stub
		return curriculumDao.getCurriculumById(class_id);
	}
	@Override
	public void addCurriculum(Curriculum curriculum) {
		curriculumDao.addCurriculum(curriculum);
		
	}
	
	
	
}
