package com.hxzy.bx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.bx.dao.ReferDao;
import com.hxzy.bx.service.ReferService;

@Component("referServiceImpl")
public class ReferServiceImpl implements ReferService {

	@Resource
	private ReferDao referDao;
	public void setReferDao(ReferDao referDao) {
		this.referDao = referDao;
	}
	
}
