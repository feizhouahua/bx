package com.hxzy.bx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hxzy.bx.entity.Refer;
import com.hxzy.bx.entity.Student;
import com.hxzy.bx.service.ReferService;

@Controller
public class ReferController {

	@Resource(name = "referServiceImpl")
	private ReferService referService;

	public void setReferService(ReferService referService) {
		this.referService = referService;
	}


	
	//条件查询
	@RequestMapping("refer/referStu/into")
	public String getRefer(@RequestParam(defaultValue = "") String txt, 
			@RequestParam(defaultValue = "1") int page,HttpSession session) {
		int count = referService.getRefernum(txt); // 总条数
		int pagecount = 4; // 一页几条
		int lastPage = count / pagecount; // 共有几页
		if (lastPage * pagecount < count) { // 除不尽加一
			lastPage = lastPage + 1;
		}
		List<Refer> refers = referService.getRefer(txt, (page-1) * pagecount, pagecount);
		session.setAttribute("page", page);
		session.setAttribute("refers", refers);
		session.setAttribute("txt", txt);
		session.setAttribute("nums", lastPage);
		return "table";

	}
	
	
	//跳转查看功能
	@RequestMapping("refer/referStu/chakan" )
	public String chakan(@RequestParam Integer id,HttpSession session) {
		Refer refer = referService.chakan(id);
		session.setAttribute("refer", refer);
		return "selrefer";
	}

	//跳转跟踪功能
	@RequestMapping("refer/referStu/genzong")
	public String genzong(@RequestParam Integer id, HttpSession session) {
		Refer refer = referService.chakan(id);
		session.setAttribute("refer", refer);
		return "trackadd";
	}

	//跳转修改功能
	@RequestMapping("refer/referStu/xiugai")
	public String xiugai(@RequestParam Integer id, HttpSession session) {
		Refer refer = referService.chakan(id);
		session.setAttribute("xgrefer", refer);
		return "edit";
	}

	
	@RequestMapping("refer/referStu/upup")
	public String xiug(@ModelAttribute Refer refer) {
		referService.uprefer(refer);
		return "redirect:into.html";
	}

	@RequestMapping("refer/referStu/enter")
	public String enter(@RequestParam Integer id, HttpSession session) {
		Refer refer = referService.chakan(id);
		session.setAttribute("refered", refer);
		return "enters";
	}

	@RequestMapping("refer/referStu/referadd")
	public String referadd(@ModelAttribute Student student,int referid, HttpSession session) {
		session.setAttribute("referstu", student);
		referService.upstate(referid);
		return "redirect:../../stu_depart/stu_manage/addstu.jsp";
	}


	@RequestMapping("refer/queryStu/queryStu")
	public String queryStu(@RequestParam(defaultValue = "") String txts, @RequestParam(defaultValue = "1") int page,HttpSession session) {
		int counts = referService.queryStunum(txts);  //记录总条数
		int count = 4;		             //每页几条
		int pag = counts / count;                // 共有几页
		if (pag * count < counts) {               //如果没除尽，页数加一
			pag = pag + 1;
		}
		List<Refer> refers = new ArrayList<Refer>();  
		refers = referService.queryStu(txts,(page-1) * count, count);
		session.setAttribute("queryStu", refers);
		session.setAttribute("numq", pag);
		session.setAttribute("qupag", page);
		session.setAttribute("txts", txts);
		return "query";

	}
	

	@RequestMapping("refer/queryStu/queryref")
	public String check(@RequestParam Integer id, HttpSession session) {
		Refer refer = referService.chakan(id);
		session.setAttribute("qrefer", refer);
		return "check";
	}
}
