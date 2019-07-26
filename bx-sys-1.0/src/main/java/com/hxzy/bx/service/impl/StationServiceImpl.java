package com.hxzy.bx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hxzy.bx.dao.StationDao;
import com.hxzy.bx.entity.Station;
import com.hxzy.bx.service.StationService;

@Component("stationServiceImpl")
public class StationServiceImpl implements StationService {

	@Resource
	private StationDao stationDao;
	public void setStationDao(StationDao stationDao) {
		this.stationDao = stationDao;
	}
	
	@Transactional
	@Override
	public void addSta(Station station) {
		System.out.println(8848);
		int i = 9/0;
		System.out.println(i);
		
		stationDao.addSta(station);
	}

	@Override
	public List<Station> queryStation(Integer start, Integer count) {
		// TODO Auto-generated method stub
		return stationDao.queryStation(start, count);
	}

	@Override
	public int staNum() {
		// TODO Auto-generated method stub
		return stationDao.staNum();
	}
	
}
