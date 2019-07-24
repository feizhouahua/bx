package com.hxzy.bx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hxzy.bx.entity.Course_type;
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
			@RequestParam(defaultValue="1")int page,HttpSession session) {
		int count = studentService.stuNum(text, course, classname);  //记录条数
		int pagecount = 2; // 一页几条
		int lastPage = count / pagecount; // 共有几页
		if (lastPage * pagecount < count) { // 除不尽加一
			lastPage = lastPage + 1;
		}
		List<Student> students = new ArrayList<Student>();
		session.setAttribute("count", count);
		students = studentService.queryStus(text, course, classname, (page-1)*pagecount, pagecount);
 		session.setAttribute("students", students);
 		session.setAttribute("pagnums", lastPage);
 		session.setAttribute("page", page);
 		session.setAttribute("text", text);
		return "queryStus";
	}
	
	@RequestMapping("stu_depart/stu_manage/add")
	public String add(HttpSession session) {
		Student list = new Student();
		session.setAttribute("referstu", list);
		return "addstu";
	}
	
	@RequestMapping("stu_depart/stu_manage/addstudent")
	public String addstudent(@ModelAttribute Student student,@RequestParam String classname) {
		int ss = studentService.queryid(classname);
		studentService.addStu(student,ss);
		return "queryStus";
	}
	
	@RequestMapping("stu_depart/stu_manage/upstu")
	public String upstudent(@RequestParam int page,String text,String classname,int id,HttpSession session) {
		Student student = new Student();
		student = studentService.getStubyid(id);
		//int ss = studentService.queryid(classname);
		session.setAttribute("referstu", student);
		session.setAttribute("text", text);
		session.setAttribute("page", page);
		return "updatestu";
	}

}
