package com.hxzy.bx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.bx.dao.InformationDao;
import com.hxzy.bx.entity.Information;
import com.hxzy.bx.service.InformationService;

@Component("informationServiceImpl")
public class InformationServiceImpl implements InformationService {
	
	@Resource
	private InformationDao informationDao;
	public void setInformationDao(InformationDao informationDao) {
		this.informationDao = informationDao;
	}
	@Override
	public List<Information> getInformations(int start, int count) {
		// TODO Auto-generated method stub
		return informationDao.getInformations(start, count);
	}
	@Override
	public void addInformation(Information information) {
		informationDao.addInformation(information);
		
	}
	@Override
	public int getCounts() {
		// TODO Auto-generated method stub
		return informationDao.getCounts();
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
	public Information getInformationById(int id) {
		// TODO Auto-generated method stub
		return informationDao.getInformationById(id);
	}
	@Override
	public void updateInformation(Information information) {
		// TODO Auto-generated method stub
		informationDao.updateInformation(information);
	}
	
}
