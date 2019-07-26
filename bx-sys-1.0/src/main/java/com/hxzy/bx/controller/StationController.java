package com.hxzy.bx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hxzy.bx.entity.Station;
import com.hxzy.bx.service.StationService;

@Controller
public class StationController {

	@Resource(name="stationServiceImpl")
	private StationService stationService;
	public void setStationService(StationService stationService) {
		this.stationService = stationService;
	}
	
	@RequestMapping("stu_depart/checkStation/xiaoyang")
	public String station(@RequestParam (defaultValue="1")int page,HttpSession session) {
		int count = stationService.staNum();
		int pagecount = 4; // 一页几条
		int lastPage = count / pagecount; // 共有几页
		if (lastPage * pagecount < count) { // 除不尽加一
			lastPage = lastPage + 1;
		}
		List<Station> stations = new ArrayList<Station>();
		stations = stationService.queryStation(pagecount*(page-1), 1);
		session.setAttribute("station", stations);
		session.setAttribute("pagnums", lastPage);
 		session.setAttribute("page", page);
		return "queryStation";
	}
}
