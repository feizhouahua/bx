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

@Controller
public class ReferController {

	@Resource(name="referServiceImpl")
	private ReferService referService;

	public void setReferService(ReferService referService) {
		this.referService = referService;
	}
	
	/*
	 * @RequestMapping("refer/referStu/into") public String
	 * getRefers(@RequestParam(value="pag") int pag,HttpSession session) { int i =
	 * referService.getRefersnum(); int c=1;//一页几条 int b=i/c;//共有几页
	 * System.out.println(i); System.out.println(pag); if (b*c<i) { b=b+1; }
	 * System.out.println(b); List<Refer> refers =
	 * referService.getRefers((pag-1)*c,c); session.setAttribute("pags", pag);
	 * session.setAttribute("nums", b); session.setAttribute("refers", refers);
	 * return "table"; }
	 */
	
	@RequestMapping("refer/referStu/into")
	public String getRefer(@RequestParam(defaultValue="") String txt,@RequestParam(defaultValue="0") int pag,HttpSession session) {
		int i = referService.getRefernum("1");
		int c=1; //一页几条
		int b=i/c;//共有几页
		if (b*c<i) {
			b=b+1;
		}
		List<Refer> refers = referService.getRefer("1",pag*c,c);
		session.setAttribute("nums", i);
		session.setAttribute("refers", refers);
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
	public String queryStu(@RequestParam(defaultValue="0") Integer pag ,HttpSession session) {
		List<Refer> refers = new ArrayList<Refer>();
		int i = referService.queryStunum();
		int c=2;
		int b=i/c;//共有几页
		if (b*c<i) {
			b=b+1;
		}
		refers = referService.queryStu(pag*c,1);
		session.setAttribute("queryStu", refers);
		session.setAttribute("numq", i);
		return "redirect:refer/queryStu/query.jsp";
	}
	
	@RequestMapping("refer/queryStu/queryref" )
	public String check(@RequestParam Integer id,HttpSession session) {
		Refer refer = referService.chakan(id);
		session.setAttribute("qrefer", refer);
		return "check";
	}
}
