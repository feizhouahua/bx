package com.hxzy.bx.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	

	@RequestMapping("resources/staff/list")
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
		System.out.println("xxxxxxxxxxxxxxxxxxx");
		List<Post> post_names=postService.getPost_names(depart_name);
		JSONArray array=JSONArray.fromObject(post_names);
		return new String(array.toString().getBytes("utf-8"),"iso-8859-1");
	}
	
	
}
