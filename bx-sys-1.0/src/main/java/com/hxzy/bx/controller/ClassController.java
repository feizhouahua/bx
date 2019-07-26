package com.hxzy.bx.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hxzy.bx.entity.Class;
import com.hxzy.bx.entity.Course_type;
import com.hxzy.bx.entity.Curriculum;
import com.hxzy.bx.service.ClassService;
import com.hxzy.bx.service.CurriculumService;

import net.sf.json.JSONArray;

@Controller
public class ClassController {

	@Resource(name="classServiceImpl")
	private ClassService classService;
	public void setClassService(ClassService classService) {
		this.classService = classService;
	}
	@Resource(name="curriculumServiceImpl")
	private CurriculumService curriculumService;
	public void setCurriculumService(CurriculumService curriculumService) {
		this.curriculumService = curriculumService;
	}
	
	@RequestMapping("education/class/list")
	public String list(@RequestParam(value="page") int page,Model model) {
		
		//每页显示5条记录
		int pagecount=5;
		//获得总页数
		int pages=classService.getPages(pagecount);
		List<com.hxzy.bx.entity.Class> classes=classService.getClasses((page-1)*pagecount, pagecount);
		
		model.addAttribute("page",page);
		model.addAttribute("pages",pages);
		model.addAttribute("classes",classes);
		return "list";
	}
	
	@RequestMapping("education/class/add")
	public String add(@ModelAttribute Class class1,Course_type course_type) throws ParseException {
		//根据类别名查询获得类别id
		int courseid=classService.getCourseIdByName(course_type.getCourse_name());
		
		course_type.setId(courseid);
		class1.setCourse_type(course_type);
		class1.setEntrance_number(0);
		class1.setTransfer_number(0);
		class1.setRefund_number(0);
		
		classService.setState(class1);
		classService.addClass(class1);
		
		return "redirect:list.html?page=1";
	}
	
	@RequestMapping("education/class/updatea")
	public String updatea(@RequestParam int id,Model model) {
		//根据id查询class
		Class class1=classService.getClassById(id);
		model.addAttribute("classx", class1);
		return "update";
	}
	
	@RequestMapping("education/class/updateb")
	public String updateb(@ModelAttribute Course_type course_type,Class class1) {
		//根据类别名查询获得类别id
		int courseid=classService.getCourseIdByName(course_type.getCourse_name());
		course_type.setId(courseid);
		class1.setCourse_type(course_type);
		//修改
		classService.updateClass(class1);
		return "redirect:list.html?page=1";
	}
	
	@ResponseBody
	@RequestMapping("education/class/ajax/course")
	public String ajaxcourse() {
		List<Course_type> course_types=classService.getCourse_Names();
		JSONArray array=JSONArray.fromObject(course_types);
		return array.toString();
	}
	
	//上传a页
	@RequestMapping("education/class/uploada")
	public String uploada(@RequestParam int id,Model model) {
		//根据id查询class
		Class class1=classService.getClassById(id);
		//根据class_id查询上传表（curriculum）
		List<Curriculum> curriculums=curriculumService.getCurriculumById(id);
		model.addAttribute("curriculums", curriculums);
		model.addAttribute("classupload", class1);
		return "upload";
	}
	
	//上传b页
	@RequestMapping("education/class/uploadb")
	public String uploadb(@RequestParam("filename") MultipartFile file,@RequestParam int id,Model model,HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
			//获取上下文信息
			String url=request.getRealPath("/");
			//(1)得到工程目录：
			//String a=request.getSession().getServletContext().getRealPath(""); //参数可具体到包名。
			//System.out.println(a);
			//System.out.println(url);
			//截取上一级路径
			File f=new File(url);
			File nurl=f.getParentFile();
			//创建上传文件夹
			String path=nurl+"\\upload";
			File f1=new File(path);
			if(!f1.exists()) {
				f1.mkdirs();
			}
			//System.out.println(f1+"------------------------------------------------------------");
			//获得上传文件名
			String filename=file.getOriginalFilename();
			
			String newfilename=null;
			if(filename==null || filename.equals("")) {
				return "redirect:list.html?page=1";
			}else{
				
				filename=new String(filename.getBytes("ISO-8859-1"),"UTF-8");
				//得到加了前缀的上传名
				Date date=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
				newfilename=sdf.format(date)+filename;
				
				File f2=new File(f1+"\\"+newfilename);
				file.transferTo(f2);
			}
			Curriculum curriculum=new Curriculum();
			curriculum.setUpload_path("\\upload");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date=new Date();
			curriculum.setUpload_time(sdf.format(date));
			curriculum.setOldname(filename);
			curriculum.setNewname(newfilename);
			//根据id查询class
			Class class1=classService.getClassById(id);
			//因为上传了课表 所有班级上传课表状态也应该变成有
			class1.setUpload_state("有");
			classService.updateUploadState(class1);
			curriculum.setClasses(class1);
			curriculumService.addCurriculum(curriculum);
			
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return "redirect:list.html?page=1";
	}
	
	@ResponseBody
	@RequestMapping("education/class/ajax/gettime")
	public String ajaxGetTime(@RequestParam int id) throws ParseException {
		//根据class_id查找课表
		List<Curriculum> curriculums=curriculumService.getCurriculumById(id);
		List<String> times=new ArrayList<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = null;
		if(curriculums.size()>1) {
			sdf=new SimpleDateFormat("yyyyMMddhhmmss");
			for (Curriculum curriculum : curriculums) {
				times.add(sdf.format(curriculum.getUpload_time()));
			}
			Date a=getBigtime(times);
			time=sdf.format(a);
		}else if(curriculums.size()==1){
			time=curriculums.get(0).getUpload_time();
		}else {
			time="无";
		}
		Curriculum curriculum=new Curriculum();
		curriculum.setUpload_time(time);
		JSONArray array=JSONArray.fromObject(curriculum);
		return array.toString();
	}
	
	public Date getBigtime(List<String> list) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		Date date1=sdf.parse(list.get(0));
		for(int i=0;i<list.size();i++){
			Date date2=sdf.parse(list.get(i));
			int com=date1.compareTo(date2);
			//compareTo()方法的返回值，date1小于date2返回-1，date1大于date2返回1，相等返回0
			if(com==-1) {
				date1=date2;
			}
		}	
		return date1;
	}
	
	
	
}
