package com.hxzy.bx.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hxzy.bx.entity.RunOff;
import com.hxzy.bx.entity.Station;
import com.hxzy.bx.entity.Student;
import com.hxzy.bx.service.Course_typeService;
import com.hxzy.bx.service.RunOffService;
import com.hxzy.bx.service.StationService;
import com.hxzy.bx.service.StudentService;

@Controller
public class StudentController {

	@Resource(name="studentServiceImpl")
	private StudentService studentService;
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@Resource(name="course_typeServiceImpl")
	private Course_typeService course_typeService;
	public void setCourse_typeService(Course_typeService course_typeService) {
		this.course_typeService = course_typeService;
	}
	
	@Resource(name="stationServiceImpl")
	private StationService stationService;
	public void setStationService(StationService stationService) {
		this.stationService = stationService;
	}
	
	@Resource(name="runOffServiceImpl")
	private RunOffService runOffService;

	public void setRunOffService(RunOffService runOffService) {
		this.runOffService = runOffService;
	}
	
	@RequestMapping("stu_depart/stu_manage/stus")
	public String queryStus(@RequestParam(defaultValue="") String text,
			@RequestParam(defaultValue="")String course,@RequestParam(defaultValue="")String classname,
			@RequestParam(defaultValue="1")int page,HttpSession session) {
		int count = studentService.stuNum(text, course, classname);  //记录条数
		int pagecount = 4; // 一页几条
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
	
	//添加学生
	@RequestMapping("stu_depart/stu_manage/addstudent")
	public String addstudent(@ModelAttribute Student student,@RequestParam String classname) {
		int ss = studentService.queryid(classname);
		studentService.addStu(student,ss);
		return "queryStus";
	}
	
	//将学生信息传入修改信息界面
	@RequestMapping("stu_depart/stu_manage/upstu")
	public String upstudent(@RequestParam int page,String text,String name,int id,HttpSession session) {
		Student student = new Student();
		student = studentService.getStubyid(id);
		String course = studentService.queCourse(name);
		System.out.println(student.getClasses().getClassname());
		session.setAttribute("referstu", student);
		session.setAttribute("text", text);
		session.setAttribute("page", page);
		session.setAttribute("course", course);
		return "updatestu";
	}
	
	//修改完成，返回学生信息界面
	@RequestMapping("stu_depart/stu_manage/upstuok")
	public String upstuok(@ModelAttribute Student student,String classname) {
		int id = studentService.queryid(classname);
		studentService.upstudent(student, id);
		return "queryStus";
	}
	
	@RequestMapping("stu_depart/stu_manage/transfer")
	public String transfer(@RequestParam int id,HttpSession session) {
		Student student = studentService.getStubyid(id);
		
		session.setAttribute("upstudent", student);
		return "upgrade";
	}
	
	@RequestMapping("stu_depart/stu_manage/transferok")
	public String transferok(@RequestParam int id,String oldclass,
			String opertype,String classname,String username,String studentname) {
		Station station = new Station();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		station.setOperating_time(df.format(new Date()));	// new Date()为获取当前系统t间
		station.setAfter_classname(classname);
		station.setBefor_classname(oldclass);
		station.setManager(username);
		station.setOperation_type(opertype);
		station.setStudent_name(studentname);
		studentService.updatacla(station,classname, id);
		return "queryStus";
	}
	
	@RequestMapping("stu_depart/stu_manage/chakan")
	public String chakan(@RequestParam int id,HttpSession session) {
		Student student = studentService.getStubyid(id);
		session.setAttribute("destudent", student);
		return "details";
	}
	
	@RequestMapping("stu_depart/stu_manage/liushi")
	public String liushi(@RequestParam int id,HttpSession session) {
		Student student = studentService.getStubyid(id);
		session.setAttribute("sistudent", student);
		return "runoff";
	}
	
	@RequestMapping("stu_depart/stu_manage/delstudent")
	public String delstudent(@RequestParam int id,String username,String refund,String num,String cause) {
		System.out.println("hahahhahahahahhahahah");
		Student student = new Student();
		student = studentService.getStubyid(id);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		RunOff runOff = new RunOff();
		runOff.setBefor_classname(student.getClasses().getClassname());
		runOff.setBusiness_time(df.format(new Date()));	// new Date()为获取当前系统t间
		runOff.setCause(cause);
		runOff.setManager(username);
		runOff.setQQ(student.getQQ());
		runOff.setRefund(refund);
		runOff.setStudent_name(student.getStudent_name());
		runOff.setTel(student.getTel());
		studentService.delStuById(runOff,id);
		return "queryStus";
	}
	
	

}
