package com.hxzy.bx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.bx.dao.InformationDao;
import com.hxzy.bx.service.InformationService;

@Component("informationServiceImpl")
public class InformationServiceImpl implements InformationService {
	
	@Resource
	private InformationDao informationDao;
	public void setInformationDao(InformationDao informationDao) {
		this.informationDao = informationDao;
	}
	
}
