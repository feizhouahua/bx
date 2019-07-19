package com.hxzy.bx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hxzy.bx.entity.Information;

public interface InformationService {
	
	//查询就业信息列表集合(start 表示从第几条记录开始 count表示每页显示几条记录)
	public List<Information> getInformations(@Param(value = "start") int start,@Param(value = "count")int count);
			
	//添加就业信息
	public void addInformation(Information information);
		
	//查询有多少条记录
	public int getCounts();
	
	//根据记录数求出页数
	public int getPages(int pagecount);
	
	//根据id查找Information对象
	public Information getInformationById(int id);
		
	//根据id修改就业信息Information
	public void updateInformation(Information information);

}
