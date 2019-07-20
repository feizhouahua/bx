package com.hxzy.bx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hxzy.bx.entity.Student;
import com.hxzy.bx.service.StudentService;

@Controller
public class StudentController {

	@Resource(name="studentServiceImpl")
	private StudentService studentService;
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@RequestMapping("stu_depart/stu_manage/stus")
	public String queryStus(@RequestParam(defaultValue="") String text,
			@RequestParam(defaultValue="")String course,@RequestParam(defaultValue="")String classname,
			@RequestParam(defaultValue="0")int page,HttpSession session) {
		int count = studentService.stuNum(text, course, classname);  //记录条数
		
		
		List<Student> students = new ArrayList<Student>();
		session.setAttribute("count", count);
		students = studentService.queryStus(text, course, classname, 0, 3);
 		session.setAttribute("students", students);
		return "queryStus";
	}
	
}
