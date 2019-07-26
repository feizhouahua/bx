package com.hxzy.bx.service;

import java.text.ParseException;
import java.util.List;
import com.hxzy.bx.entity.Class;
import com.hxzy.bx.entity.Course_type;

public interface ClassService {
	
	//查询所有班级
	public List<Class> getClass_names(); 
	
	//分页查询所有数据
	public List<Class> getClasses(int start,int count);
	
	//查询数据库记录条数
	public int getCounts();
	
	//根据每页显示条数 和 总记录数 求出 页数
	public int getPages(int pagecount);
	
	//查询所有的类别名
	public List<Course_type> getCourse_Names();
	
	//添加一个班级
	public void addClass(Class class1);
	
////根据类别名查询获得类别id
	public int getCourseIdByName(String course_name);
	
	//通过开班时间 毕业时间 判断当前班的状态
	public void setState(Class class1) throws ParseException;
	
	//根据id查询class
	public Class getClassById(int id);
	
	//修改class
	public void updateClass(Class class1);
	
	//根据id修改上传课表状态
	public void updateUploadState(Class class1);
}
