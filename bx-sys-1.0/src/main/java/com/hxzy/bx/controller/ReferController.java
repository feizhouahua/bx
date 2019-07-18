package com.hxzy.bx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hxzy.bx.entity.Refer;
import com.hxzy.bx.entity.Student;
import com.hxzy.bx.service.ReferService;
import com.mysql.cj.Session;

@Controller
public class ReferController {

	@Resource(name="referServiceImpl")
	private ReferService referService;

	public void setReferService(ReferService referService) {
		this.referService = referService;
	}
	
	@RequestMapping("refer/referStu/hei")
	public String in() {
		return "redirect:into.html";
	}
	
	@RequestMapping("refer/referStu/into")
	public String getRefers(HttpSession session) {
		List<Refer> refers = referService.getRefers();
		session.setAttribute("refers", refers);
		return "table";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/select3")
	public String getRefer(@ModelAttribute String txt,HttpSession session) {
		List<Refer> refers = referService.getRefer(txt);
		session.setAttribute("refer", refers);
		return "table";
	}
	
	@RequestMapping("refer/referStu/chakan" )
	public String chakan(@RequestParam Integer id,HttpSession session) {
		Refer refer = referService.chakan(id);
		session.setAttribute("refer", refer);
		return "selrefer";
	}
	
	@RequestMapping("refer/referStu/genzong" )
	public String genzong(@RequestParam Integer id,HttpSession session) {
		Refer refer = referService.chakan(id);
		session.setAttribute("refer", refer);
		return "trackadd";
	}
	
	@RequestMapping("refer/referStu/xiugai" )
	public String xiugai(@RequestParam Integer id,HttpSession session) {
		Refer refer = referService.chakan(id);
		session.setAttribute("xgrefer", refer);
		return "edit";
	}
	
	@RequestMapping("refer/referStu/upup" )
	public String xiug(@ModelAttribute Refer refer) {
		referService.uprefer(refer);
		return "redirect:into.html";
	}
	
	@RequestMapping("refer/referStu/enter" )
	public String enter(@RequestParam Integer id,HttpSession session) {
		Refer refer = referService.chakan(id);
		session.setAttribute("refered", refer);
		return "enters";
	}
	
	@RequestMapping("refer/referStu/referadd")
	public String referadd(@ModelAttribute Student student,HttpSession session) {
		session.setAttribute("referstu", student);
		return "redirect:../../stu_depart/stu_manage/addstu.jsp";
	}
	
	@RequestMapping("queryStu")
	public String queryStu(HttpSession session) {
		System.out.println(123);
		List<Refer> refers = new ArrayList<Refer>();
		refers = referService.queryStu();
		session.setAttribute("queryStu", refers);
		return "redirect:refer/queryStu/query.jsp";
	}
	
	@RequestMapping("refer/queryStu/queryref" )
	public String check(@RequestParam Integer id,HttpSession session) {
		Refer refer = referService.chakan(id);
		session.setAttribute("qrefer", refer);
		return "check";
	}
}
