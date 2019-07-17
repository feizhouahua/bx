package com.hxzy.bx.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.hxzy.bx.service.TrackService;

@Controller
public class TrackController {

	@Resource(name="trackServiceImpl")
	private TrackService trackService;
	public void setTrackService(TrackService trackService) {
		this.trackService = trackService;
	}
}
