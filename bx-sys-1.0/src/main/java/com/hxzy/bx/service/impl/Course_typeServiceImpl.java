package com.hxzy.bx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.bx.dao.Course_typeDao;
import com.hxzy.bx.entity.Class;
import com.hxzy.bx.entity.Course_type;
import com.hxzy.bx.service.Course_typeService;

@Component("course_typeServiceImpl")
public class Course_typeServiceImpl implements Course_typeService{

	@Resource
	private Course_typeDao course_typeDao;
	public void setCourse_typeDao(Course_typeDao course_typeDao) {
		this.course_typeDao = course_typeDao;
	}
	
	
	@Override
	public List<Class> queryClass(String course) {
		// TODO Auto-generated method stub
		return course_typeDao.queryClass(course);
	}

	//查询学科
	@Override
	public List<Course_type> quCourse() {
		// TODO Auto-generated method stub
		return course_typeDao.quCourse();
	}

	@Override
	public List<Course_type> getListByCourse_type(Double gcourse_cost,Integer gtotal_hours,Course_type course_type, int start, int count) {
		// TODO Auto-generated method stub
		return course_typeDao.getListByCourse_type(gcourse_cost, gtotal_hours, course_type, start, count);
	}


	@Override
	public int getCountByCourse_type(Double gcourse_cost,Integer gtotal_hours,Course_type course_type) {
		// TODO Auto-generated method stub
		return course_typeDao.getCountByCourse_type(gcourse_cost, gtotal_hours, course_type);
	}


	@Override
	public int getPages(Double gcourse_cost,Integer gtotal_hours,int pagecount,Course_type course_type) {
		// TODO Auto-generated method stub
		int counts=getCountByCourse_type(gcourse_cost, gtotal_hours, course_type);
		if(counts%pagecount==0) {			
			return counts/pagecount;
		}else {			
			return counts/pagecount+1;
		}
	}


	@Override
	public void addCourse_type(Course_type course_type) {
		course_typeDao.addCourse_type(course_type);
		
	}


	@Override
	public void updateCourse_type(Course_type course_type) {
		// TODO Auto-generated method stub
		course_typeDao.updateCourse_type(course_type);
	}


	@Override
	public Course_type getCourse_typeById(int id) {
		// TODO Auto-generated method stub
		return course_typeDao.getCourse_typeById(id);
	}

	
	
	 
}
