package com.hxzy.bx.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hxzy.bx.entity.Refer;
import com.hxzy.bx.service.ReferService;

@Controller
public class ReferController {

	@Resource(name="referServiceImpl")
	private ReferService referService;

	public void setReferService(ReferService referService) {
		this.referService = referService;
	}
	
	@RequestMapping("refer/referStu/hei")
	public String in() {
		System.out.println(1);
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
		System.out.println(refers.get(0).getQQ());
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
		System.out.println("根直径");
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
		System.out.println(1);
		referService.uprefer(refer);
		return "redirect:into.html";
	}
}
