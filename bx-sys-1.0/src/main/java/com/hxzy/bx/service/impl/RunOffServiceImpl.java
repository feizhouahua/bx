package com.hxzy.bx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.bx.dao.RunOffDao;
import com.hxzy.bx.entity.RunOff;
import com.hxzy.bx.service.RunOffService;

@Component("runOffServiceImpl")
public class RunOffServiceImpl implements RunOffService {
	
	@Resource
	private RunOffDao runOffDao;
	public void setRunOffDao(RunOffDao runOffDao) {
		this.runOffDao = runOffDao;
	}
	@Override
	public void addrunOff(RunOff runOff) {
		runOffDao.addrunOff(runOff);
	}
	@Override
	public List<RunOff> queryRunOff(Integer start, Integer count) {
		// TODO Auto-generated method stub
		return runOffDao.queryRunOff(start, count);
	}
	@Override
	public int runNum() {
		// TODO Auto-generated method stub
		return runOffDao.runNum();
	}
}
