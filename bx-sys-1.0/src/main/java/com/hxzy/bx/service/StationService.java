package com.hxzy.bx.service;

import java.util.List;

import com.hxzy.bx.entity.Station;

public interface StationService {
	//添加station
	public void addSta(Station station);
	
	//queryStation
	public List<Station> queryStation(Integer start,Integer count);

	public int staNum();
}
