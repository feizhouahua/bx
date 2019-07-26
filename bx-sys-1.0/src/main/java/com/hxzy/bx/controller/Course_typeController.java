package com.hxzy.bx.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxzy.bx.entity.Class;
import com.hxzy.bx.entity.Course_type;
import com.hxzy.bx.service.Course_typeService;

import net.sf.json.JSONArray;

@Controller
public class Course_typeController {

	@Resource(name="course_typeServiceImpl")
	private Course_typeService course_typeService;
	public void setCourse_typeService(Course_typeService course_typeService) {
		this.course_typeService = course_typeService;
	}
	
	@ResponseBody
	@RequestMapping("stu_depart/stu_manage/ajax/course")
	public String ajaxPost(@RequestParam String course) throws UnsupportedEncodingException{
		List<Class> cla = new ArrayList<Class>();
		System.out.println(course);
		cla = course_typeService.queryClass(course);
		JSONArray array = JSONArray.fromObject(cla);
		return new String(array.toString().getBytes("utf-8"),"iso-8859-1");
	}
	
	@ResponseBody
	@RequestMapping("stu_depart/stu_manage/ajax/coursename")
	public String quCourse() throws UnsupportedEncodingException {
		List<Course_type> cList = new ArrayList<Course_type>();
		cList = course_typeService.quCourse();
		for (Course_type string : cList) {
			System.out.println(string.getCourse_name());
		}
		JSONArray array = JSONArray.fromObject(cList);
		return  new String(array.toString().getBytes("utf-8"),"iso-8859-1");
	}
	
}
