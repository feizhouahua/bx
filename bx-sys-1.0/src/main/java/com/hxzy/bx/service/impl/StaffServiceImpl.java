package com.hxzy.bx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.bx.dao.StaffDao;
import com.hxzy.bx.entity.Staff;
import com.hxzy.bx.service.StaffService;

@Component("staffServiceImpl")
public class StaffServiceImpl implements StaffService {

	@Resource
	private StaffDao staffDao;
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}
	@Override
	public List<Staff> getStaffs(int start, int count) {
		// TODO Auto-generated method stub
		return staffDao.getStaffs(start, count);
	}
	@Override
	public List<Staff> getStaffsByCondition(Staff staff, int start, int count) {
		// TODO Auto-generated method stub
		return staffDao.getStaffsByCondition(staff, start, count);
	}
	@Override
	public void addStaff(Staff staff) {
		staffDao.addStaff(staff);
		
	}
	@Override
	public void updateStaff(Staff staff) {
		staffDao.updateStaff(staff);
		
	}
	@Override
	public int getCounts() {
		// TODO Auto-generated method stub
		return staffDao.getCounts();
	}
	@Override
	public Staff getStaffById(int id) {
		// TODO Auto-generated method stub
		return staffDao.getStaffById(id);
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
	
}
