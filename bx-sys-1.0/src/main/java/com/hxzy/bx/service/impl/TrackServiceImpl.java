package com.hxzy.bx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.bx.dao.TrackDao;
import com.hxzy.bx.entity.Track;
import com.hxzy.bx.service.TrackService;

@Component("trackServiceImpl")
public class TrackServiceImpl implements TrackService {
	
	@Resource
	private TrackDao trackDao;
	public void setTrackDao(TrackDao trackDao) {
		this.trackDao = trackDao;
	}
	@Override
	public void inserttrack(Track track) {
		trackDao.inserttrack(track);
		
	}
	
}
