package com.hxzy.bx.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxzy.bx.entity.Class;
import com.hxzy.bx.entity.Department;
import com.hxzy.bx.entity.Information;
import com.hxzy.bx.entity.Post;
import com.hxzy.bx.entity.Staff;
import com.hxzy.bx.entity.Student;
import com.hxzy.bx.service.ClassService;
import com.hxzy.bx.service.InformationService;
import com.hxzy.bx.service.StudentService;

import net.sf.json.JSONArray;

@Controller
public class InformationController {

	@Resource(name="informationServiceImpl")
	private InformationService informationService;
	public void setInformationService(InformationService informationService) {
		this.informationService = informationService;
	}
	
	@Resource(name="classServiceImpl")
	private ClassService classService;
	public void setClassService(ClassService classService) {
		this.classService = classService;
	}
	
	@Resource(name="studentServiceImpl")
	private StudentService studentService;
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping("employments/information/list")
	public String list(@RequestParam int page,Model model) {
		if(page==0) {
			page=1;
		}
		int pagecount=5;//每页显示5条记录
		int pages=informationService.getPages(pagecount);//获得页数
		List<Information> informations=informationService.getInformations((page-1)*pagecount, pagecount);
		model.addAttribute("informations", informations);
		model.addAttribute("page", page);
		model.addAttribute("pages", pages);
		return "list";
	}
	
	@RequestMapping("employments/information/add")
	public String add(@ModelAttribute Information information) {
		//因为学生登录了就业信息，所以学生表的状态也应该改为就业
		String studentname=information.getStudent_name();
		studentService.updateStudentStatesByName(studentname,"就业");
		
		informationService.addInformation(information);
		
		return "redirect:list.html?page=1";
	}
	
	@ResponseBody
	@RequestMapping("employments/information/ajax/classname")
	public String classname() throws UnsupportedEncodingException {
		List<Class> classes=classService.getClass_names();
		JSONArray array=JSONArray.fromObject(classes);
		return new String(array.toString().getBytes("utf-8"),"iso-8859-1");
	}
	
	@ResponseBody
	@RequestMapping("employments/information/ajax/studentname")
	public String studentname(@RequestParam String classname) throws UnsupportedEncodingException {
		List<Student> students=studentService.getStudentNames(classname);
		JSONArray array=JSONArray.fromObject(students);
		return new String(array.toString().getBytes("utf-8"),"iso-8859-1");
	}
	
	@RequestMapping("employments/information/updatea")
	public String updatea(@RequestParam int id,Model model) {
		Information information=informationService.getInformationById(id);
		model.addAttribute("information", information);
		return "update";
	}
	
	@RequestMapping("employments/information/updateb")
	public String updateb(@ModelAttribute Information information) {
		informationService.updateInformation(information);
		return "redirect:list.html?page=1";
	}
	
}
