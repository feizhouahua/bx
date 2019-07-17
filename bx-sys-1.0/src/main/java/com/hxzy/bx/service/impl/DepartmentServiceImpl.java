package com.hxzy.bx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.bx.dao.DepartmentDao;
import com.hxzy.bx.entity.Department;
import com.hxzy.bx.service.DepartmentService;

@Component("departmentServiceImpl")
public class DepartmentServiceImpl implements DepartmentService{

	@Resource
	private DepartmentDao departmentDao;
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	@Override
	public List<Department> getDepartments(int start, int count) {
		// TODO Auto-generated method stub
		return departmentDao.getDepartments(start, count);
	}
	@Override
	public void addDepartment(Department department) {
		departmentDao.addDepartment(department);
		
	}
	@Override
	public void updateDepartment(Department department) {
		departmentDao.updateDepartment(department);
		
	}
	@Override
	public int getCounts() {
		// TODO Auto-generated method stub
		return departmentDao.getCounts();
	}
	@Override
	public int getPages(int pagecount) {
		int counts=getCounts();
		if(counts%pagecount==0) {
			return counts/pagecount;
		}else {			
			return counts/pagecount+1;
		}
	}
	@Override
	public Department getDepartmentById(int id) {
		// TODO Auto-generated method stub
		return departmentDao.getDepartmentById(id);
	}
	@Override
	public List<Department> getDepart_names() {
		// TODO Auto-generated method stub
		return departmentDao.getDepart_names();
	}
	@Override
	public Department getDepartmentByName(String depart_name) {
		// TODO Auto-generated method stub
		return departmentDao.getDepartmentByName(depart_name);
	}
	
}
