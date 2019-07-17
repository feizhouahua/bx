package com.hxzy.bx.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.hxzy.bx.service.StationService;

@Controller
public class StationController {

	@Resource(name="stationServiceImpl")
	private StationService stationService;
	public void setStationService(StationService stationService) {
		this.stationService = stationService;
	}
	
}
