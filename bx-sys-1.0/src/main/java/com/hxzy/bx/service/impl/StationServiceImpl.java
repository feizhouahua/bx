package com.hxzy.bx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.bx.dao.StationDao;
import com.hxzy.bx.service.StationService;

@Component("stationServiceImpl")
public class StationServiceImpl implements StationService {

	@Resource
	private StationDao stationDao;
	public void setStationDao(StationDao stationDao) {
		this.stationDao = stationDao;
	}
	
}
