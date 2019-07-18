package com.hxzy.bx.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxzy.bx.entity.Department;
import com.hxzy.bx.entity.Post;
import com.hxzy.bx.entity.Staff;
import com.hxzy.bx.service.DepartmentService;
import com.hxzy.bx.service.PostService;
import com.hxzy.bx.service.StaffService;
import net.sf.json.JSONArray;

@Controller
public class StaffController {

	@Resource(name="staffServiceImpl")
	private StaffService staffService;
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	
	@Resource(name="departmentServiceImpl")
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@Resource(name="postServiceImpl")
	private PostService postService;
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	

	//@RequestMapping("resources/staff/list")
	public String list(@RequestParam int page,Model model) {
		if(page==0) {
			page=1;
		}
		int pagecount=5;//每页显示5条记录
		int pages=staffService.getPages(pagecount);//获得页数
		List<Staff> staffs=staffService.getStaffs((page-1)*pagecount, pagecount);
		
		for (Staff staff : staffs) {
			System.out.println("-------->"+staff.getPost().getPost_name());
			System.out.println("-------->"+staff.getPost().getDepartment().getDepart_name());
		}
		
		model.addAttribute("staffs", staffs);
		model.addAttribute("page", page);
		model.addAttribute("pages", pages);
		return "list";
	}
	
	@ResponseBody
	@RequestMapping("resources/staff/ajax/depart")
	public String ajaxDepart() throws UnsupportedEncodingException {
		List<Department> depart_names=departmentService.getDepart_names();
		JSONArray array=JSONArray.fromObject(depart_names);
		return new String(array.toString().getBytes("utf-8"),"iso-8859-1");
	}
	
	@ResponseBody
	@RequestMapping("resources/staff/ajax/post")
	public String ajaxPost(@RequestParam String depart_name) throws UnsupportedEncodingException {
		List<Post> post_names=postService.getPost_names(depart_name);
		JSONArray array=JSONArray.fromObject(post_names);
		return new String(array.toString().getBytes("utf-8"),"iso-8859-1");
	}
	
	@RequestMapping("resources/staff/add")
	public String add(@ModelAttribute Staff staff,Post post) {
		Post p=postService.getPostByName(post.getPost_name());
		staff.setPost(p);
		staffService.addStaff(staff);
		return "redirect:list.html?page=1";
	}
	
	@RequestMapping("resources/staff/updatea")
	public String updatea(@RequestParam int id,Model model) {
		Staff staff=staffService.getStaffById(id);
		model.addAttribute("staff", staff);
		System.out.println(staff.getLoginname());
		return "update";
	}
	
	@RequestMapping("resources/staff/updateb")
	public String updateb(@ModelAttribute Staff staff,Post post) {
		Post p=postService.getPostByName(post.getPost_name());
		staff.setPost(p);
		staffService.updateStaff(staff);
		return "redirect:list.html?page=1";
	}
	
	@RequestMapping("resources/staff/list")
	public String advanced(@RequestParam(value="page") int page,@ModelAttribute Staff staff,Post post,Department department,Model model,HttpSession session) {
		System.out.println(staff);
		Post p=postService.getPostByName(post.getPost_name());
		Department d=departmentService.getDepartmentByName(department.getDepart_name());
		Staff s=null;
		if(d!=null) {
			model.addAttribute("depart", d);
			p.setDepartment(d);
		}
		if(p!=null) {			
			model.addAttribute("postname", p);
			staff.setPost(p);
		}
		if(staff.getStaff_name()!=null) {
			//model.addAttribute("staffname", staff);
			session.setAttribute("staffname", staff);
			//System.out.println("!=============null"+staff.getStaff_name());
		}
		if (staff.getStaff_name()==null) {
			s=(Staff) session.getAttribute("staffname");
			//System.out.println("=============null"+staff.getStaff_name());
		}else {
			s=staff;
		}
		
		if(page==0) {
			page=1;
		}
		int pagecount=5;//每页显示5条记录		
		//int pages=staffService.getPages(pagecount);//获得页数
		
		List<Staff> staffs=staffService.getStaffsByCondition(s,(page-1)*pagecount, pagecount);
		int pages=0;//获得页数
		int counts=staffService.getStaffsByConditionCounts(s);
		if(counts%pagecount==0) {
			pages=counts/pagecount;
		}else {
			pages=counts/pagecount+1;
		}
		System.out.println(pages+"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		model.addAttribute("staffs", staffs);
		model.addAttribute("page", page);
		model.addAttribute("pages", pages);
		return "list";
	}
	
}
