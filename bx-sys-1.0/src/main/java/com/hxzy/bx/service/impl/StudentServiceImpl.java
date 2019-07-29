package com.hxzy.bx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hxzy.bx.dao.RunOffDao;
import com.hxzy.bx.dao.StationDao;
import com.hxzy.bx.dao.StudentDao;
import com.hxzy.bx.entity.RunOff;
import com.hxzy.bx.entity.Station;
import com.hxzy.bx.entity.Student;
import com.hxzy.bx.service.StudentService;


@Component("studentServiceImpl")
public class StudentServiceImpl implements StudentService{

	@Resource
	private StudentDao studentDao;
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	@Resource
	private StationDao stationDao;
	public void setStationDao(StationDao stationDao) {
		this.stationDao = stationDao;
	}
	
	@Resource
	private RunOffDao runOffDao;
	public void setRunOffDao(RunOffDao runOffDao) {
		this.runOffDao = runOffDao;
	}
	

	@Override
	public List<Student> getStudentNames(String classname) {
		// TODO Auto-generated method stub
		return studentDao.getStudentNames(classname);
	}

	@Override
	public void updateStudentStatesByName(String studentname,String state) {
		// TODO Auto-generated method stub
		studentDao.updateStudentStatesByName(studentname,state);
	}
	public List<Student> queryStus(String text, String course, String classname, Integer start, Integer count) {
		// TODO Auto-generated method stub
		return studentDao.queryStus(text, course, classname, start, count);
	}
	@Override
	public int stuNum(String text, String course, String classname) {
		// TODO Auto-generated method stub
		return studentDao.stuNum(text, course, classname);
	}
	
	@Override
	public void addStu(Student student, int id) {
		// TODO Auto-generated method stub
		studentDao.addStu(student,id);
	}
	@Override
	public int queryid(String classname) {
		// TODO Auto-generated method stub
		return studentDao.queryid(classname);
	}
	@Override
	public void upstudent(Student student, int id) {
		// TODO Auto-generated method stub
		studentDao.upStudent(student, id);
	}
	@Override
	public Student getStubyid(Integer id) {
		// TODO Auto-generated method stub
		return studentDao.getStubyid(id);
	}
	@Override
	public String queCourse(String name) {
		// TODO Auto-generated method stub
		return studentDao.queCourse(name);
	}
	
	@Transactional
	@Override
	public void updatacla(Station station,String classname, int id) {
		// TODO Auto-generated method stub
		stationDao.addSta(station);
		studentDao.updatacla(classname, id);
	}
	
	@Transactional
	@Override
	public void delStuById(RunOff runOff,int id) {
		// TODO Auto-generated method stub
		runOffDao.addrunOff(runOff);
		studentDao.delStuById(id);
	}
}
