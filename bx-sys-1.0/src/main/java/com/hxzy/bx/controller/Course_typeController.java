package com.hxzy.bx.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		cla = course_typeService.queryClass(course);
		JSONArray array = JSONArray.fromObject(cla);
		return new String(array.toString().getBytes("utf-8"),"iso-8859-1");
	}
	
	@RequestMapping("education/course_type/list")
	public String list(@RequestParam(value="page") int page,
					   @ModelAttribute Course_type course_type,
					   @RequestParam(required=false,value="gtotal_hours")Integer gtotal_hours,
					   @RequestParam(required=false,value="gcourse_cost")Double gcourse_cost,HttpSession session) {
		
		
		Course_type c=null;
		
		if(course_type.getSynopsis()!=null || course_type.getCourse_name()!=null ||
		   course_type.getTotal_hours()!=null || course_type.getCourse_cost()!=null ||
		   gtotal_hours!=null || gcourse_cost!=null) {			
			session.setAttribute("course_type", course_type);
			session.setAttribute("gtotal_hours", gtotal_hours);
			session.setAttribute("gcourse_cost", gcourse_cost);
		}
		if(course_type.getSynopsis()==null || course_type.getCourse_name()==null ||
		   course_type.getTotal_hours()==null || course_type.getCourse_cost()==null ||
		   gtotal_hours==null || gcourse_cost==null) {
			c=(Course_type) session.getAttribute("course_type");
			gtotal_hours=(Integer)session.getAttribute("gtotal_hours");
			gcourse_cost=(Double) session.getAttribute("gcourse_cost");
			
		}else {//这个else的意思是因为系统会给这些字段一个默认值 会让他不满足上面两个if条件
			c=course_type;
			gtotal_hours=gtotal_hours;
			gcourse_cost=gcourse_cost;
		}

		
		//求出带条件的情况下数据库记录条数
		course_typeService.getCountByCourse_type(gcourse_cost,gtotal_hours,c);
		int pagecount=5;//每页显示5条记录
		//根据每页显示几条，记录条数 求出页数
		int pages=course_typeService.getPages(gcourse_cost,gtotal_hours,pagecount, c);
		if(pages==0) {
			pages=1;
		}
		List<Course_type> course_types=course_typeService.getListByCourse_type(gcourse_cost,gtotal_hours,c, (page-1)*pagecount, pagecount);
		session.setAttribute("course_types", course_types);
		session.setAttribute("page", page);
		session.setAttribute("pages", pages);
		return "list";
	}
	
	@RequestMapping("education/course_type/add")
	public String add(@ModelAttribute Course_type course_type) {
		course_typeService.addCourse_type(course_type);
		return "redirect:list.html?page=1";
	}
	
	@RequestMapping("education/course_type/updatea")
	public String updatea(@RequestParam int id,Model model) {
		//根据id查找course_type
		Course_type course_type=course_typeService.getCourse_typeById(id);
		model.addAttribute("course_type", course_type);
		return "update";
	}
	
	@RequestMapping("education/course_type/updateb")
	public String updateb(@ModelAttribute Course_type course_type) {
		course_typeService.updateCourse_type(course_type);
		return "redirect:list.html?page=1";
	}
}
