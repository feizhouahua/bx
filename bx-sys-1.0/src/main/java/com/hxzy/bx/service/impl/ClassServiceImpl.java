package com.hxzy.bx.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.bx.dao.ClassDao;
import com.hxzy.bx.entity.Class;
import com.hxzy.bx.entity.Course_type;
import com.hxzy.bx.service.ClassService;

@Component("classServiceImpl")
public class ClassServiceImpl implements ClassService {
	
	@Resource
	private ClassDao classDao;
	
	public void setClassDao(ClassDao classDao) {
		this.classDao = classDao;
	}

	@Override
	public List<Class> getClass_names() {
		// TODO Auto-generated method stub
		return classDao.getClass_names();
	}

	@Override
	public List<Class> getClasses(int start, int count) {
		// TODO Auto-generated method stub
		return classDao.getClasses(start, count);
	}

	@Override
	public int getCounts() {
		// TODO Auto-generated method stub
		return classDao.getCounts();
	}

	@Override
	public int getPages(int pagecount) {
		// TODO Auto-generated method stub
		int counts=getCounts();
		if(counts%pagecount==0) {			
			return counts/pagecount;
		}else {			
			return counts/pagecount+1;
		}
	}

	@Override
	public List<Course_type> getCourse_Names() {
		// TODO Auto-generated method stub
		return classDao.getCourse_Names();
	}

	@Override
	public void addClass(Class class1) {
		classDao.addClass(class1);
	}

	@Override
	public int getCourseIdByName(String course_name) {
		// TODO Auto-generated method stub
		return classDao.getCourseIdByName(course_name);
	}

	@Override
	public void setState(Class class1) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		Date date=new Date();//获取当前时间
		Date open=sdf.parse(class1.getOpening_hours());
		//compareTo()方法的返回值，date1小于date2返回-1，date1大于date2返回1，相等返回0
		int com=date.compareTo(open);
		if(com==-1) {
			class1.setState("未开班");
		}else {
			class1.setState("已开班");
		}
		Date over=sdf.parse(class1.getGraduation_time());
		int ov=date.compareTo(over);
		if(ov==-1) {
			class1.setState("已结束");
		}
		
	}

	@Override
	public Class getClassById(int id) {
		// TODO Auto-generated method stub
		return classDao.getClassById(id);
	}

	@Override
	public void updateClass(Class class1) {
		classDao.updateClass(class1);
		
	}

	@Override
	public void updateUploadState(Class class1) {
		classDao.updateUploadState(class1);
		
	}
	
}
