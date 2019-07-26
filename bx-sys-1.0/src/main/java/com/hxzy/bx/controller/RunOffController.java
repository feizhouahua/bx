package com.hxzy.bx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hxzy.bx.entity.RunOff;
import com.hxzy.bx.service.RunOffService;
import com.mysql.cj.Session;

@Controller
public class RunOffController {

	@Resource(name="runOffServiceImpl")
	private RunOffService runOffService;

	public void setRunOffService(RunOffService runOffService) {
		this.runOffService = runOffService;
	}
	
	//进入
	@RequestMapping("stu_depart/runoff/intorunoff")
	public String runOff(@RequestParam (defaultValue="1")int page,HttpSession session) {
		int count = runOffService.runNum();
		int pagecount = 4; // 一页几条
		int lastPage = count / pagecount; // 共有几页
		if (lastPage * pagecount < count) { // 除不尽加一
			lastPage = lastPage + 1;
		}
		List<RunOff> lists = new ArrayList<RunOff>();
		lists = runOffService.queryRunOff(pagecount*(page-1), pagecount);
		session.setAttribute("runoff", lists);
		session.setAttribute("pagnums", lastPage);
 		session.setAttribute("page", page);
		return "qurunoff";
	}
}
