package com.hxzy.bx.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hxzy.bx.entity.Department;
import com.hxzy.bx.service.DepartmentService;

@Controller
public class DepartmentController {

	@Resource(name="departmentServiceImpl")
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@RequestMapping("resources/department/list")
	public String list(@RequestParam int page,Model model) {
		if(page==0) {
			page=1;
		}
		int pagecount=5;//每页显示5条记录
		int pages=departmentService.getPages(pagecount);//获得页数
		List<Department> departments=departmentService.getDepartments((page-1)*pagecount, pagecount);
		model.addAttribute("departments", departments);
		model.addAttribute("page", page);
		model.addAttribute("pages", pages);
		return "list";
	}
	
	@RequestMapping("resources/department/add")
	public String add(@ModelAttribute Department department) throws UnsupportedEncodingException {
		System.out.println(department.getDepart_name());
		//department.setDepart_name(new String(department.getDepart_name().getBytes("iso-8859-1"),"utf-8"));
		departmentService.addDepartment(department);
		return "redirect:list.html?page=1";
	}
	
	@RequestMapping("resources/department/updatea")
	public String updatea(@RequestParam int id,Model model) {
		Department department=departmentService.getDepartmentById(id);
		model.addAttribute("department", department);
		return "update";
	}
	
	@RequestMapping("resources/department/updateb")
	public String updateb(@ModelAttribute Department department) throws UnsupportedEncodingException {
		//department.setDepart_name(new String(department.getDepart_name().getBytes("iso-8859-1"),"utf-8"));
		departmentService.updateDepartment(department);
		return "redirect:list.html?page=1";
	}
	
	
}
