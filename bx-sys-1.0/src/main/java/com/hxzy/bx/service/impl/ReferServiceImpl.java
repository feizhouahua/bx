package com.hxzy.bx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.bx.dao.ReferDao;
import com.hxzy.bx.entity.Refer;
import com.hxzy.bx.service.ReferService;

@Component("referServiceImpl")
public class ReferServiceImpl implements ReferService {

	@Resource
	private ReferDao referDao;
	public void setReferDao(ReferDao referDao) {
		this.referDao = referDao;
	}
	@Override
	public List<Refer> getRefer(String text) {
		// TODO Auto-generated method stub
		return referDao.getRefer(text);
	}
	@Override
	public List<Refer> getRefers() {
		// TODO Auto-generated method stub
		return referDao.getRefers();
	}
	@Override
	public Refer chakan(Integer id) {
		// TODO Auto-generated method stub
		return referDao.chakan(id);
	}
	@Override
	public void uprefer(Refer refer) {
		// TODO Auto-generated method stub
		referDao.uprefer(refer);
	}
	
}
