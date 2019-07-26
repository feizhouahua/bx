package com.hxzy.bx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hxzy.bx.entity.Station;

public interface StationDao {
	//添加station
	public void addSta(Station station);
	
	//queryStation
	public List<Station> queryStation(@Param(value="start")Integer start,@Param(value="count")Integer count);

	
	public int staNum();
}
