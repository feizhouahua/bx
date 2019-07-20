package com.hxzy.bx.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hxzy.bx.service.Course_typeService;

import net.sf.json.JSONArray;

@Controller
public class Course_typeController {

	@Resource(name="course_typeServiceImpl")
	private Course_typeService course_typeService;
	public void setCourse_typeService(Course_typeService course_typeService) {
		this.course_typeService = course_typeService;
	}
	
	@RequestMapping("stu_depart/stu_manage/ajax/post")
	public String ajaxPost(@RequestParam String course) throws UnsupportedEncodingException{
		List<String> cla = new ArrayList<String>();
	
		cla = course_typeService.queryClass(course);
		String rcla=cla.get(0);
		JSONArray array = JSONArray.fromObject(cla);
		String data="['cla':'"+rcla+"']";
		
		//return new String(array.toString().getBytes("utf-8"),"iso-8859-1");
		return data;
	}
	
}
