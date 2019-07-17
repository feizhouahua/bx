package com.hxzy.bx.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hxzy.bx.entity.Refer;
import com.hxzy.bx.entity.Track;
import com.hxzy.bx.service.ReferService;
import com.hxzy.bx.service.TrackService;
import com.hxzy.bx.service.impl.ReferServiceImpl;

@Controller
public class TrackController {

	@Resource(name="trackServiceImpl")
	private TrackService trackService;
	public void setTrackService(TrackService trackService) {
		this.trackService = trackService;
	}
	
	@RequestMapping("refer/referStu/addtrack")
	private String inserttrack(@RequestParam String txt,Integer id,String name) {
		Track track = new Track();
		track.setId(id);
		track.setContent(txt);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统t间
		track.setTime(df.format(new Date()));
		track.setConsultants(name);
		trackService.inserttrack(track);
		return "redirect:into.html";
	}
}
