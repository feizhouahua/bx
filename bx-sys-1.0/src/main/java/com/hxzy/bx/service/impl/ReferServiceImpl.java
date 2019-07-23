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
	
	//模糊查询并分页
	@Override
	public List<Refer> getRefer(String text,int start,int count) {
		// TODO Auto-generated method stub
		return referDao.getRefer(text, start, count);
	}
	
	//查询总数
	@Override
	public int getRefernum(String text) {
		// TODO Auto-generated method stub
		return referDao.getRefernum(text);
	}
	
	//通过id查询数据
	@Override
	public Refer chakan(Integer id) {
		// TODO Auto-generated method stub
		return referDao.chakan(id);
	}
	
	//更新对象
	@Override
	public void uprefer(Refer refer) {
		// TODO Auto-generated method stub
		referDao.uprefer(refer);
	}
	
	//实现分页
	@Override
	public List<Refer> queryStu(String text,int start,int count) {
		return referDao.queryStu(text, start, count);
	}
	
	//查询总数
	@Override
	public int queryStunum(String text) {
		// TODO Auto-generated method stub
		return referDao.queryStunum(text);
	}
}
