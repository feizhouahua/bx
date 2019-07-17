package com.hxzy.bx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.bx.dao.RunOffDao;
import com.hxzy.bx.service.RunOffService;

@Component("runOffServiceImpl")
public class RunOffServiceImpl implements RunOffService {
	
	@Resource
	private RunOffDao runOffDao;
	public void setRunOffDao(RunOffDao runOffDao) {
		this.runOffDao = runOffDao;
	}
	
}
