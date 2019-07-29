package com.hxzy.bx.service;

import java.util.List;

import com.hxzy.bx.entity.Curriculum;

public interface CurriculumService {
	
	//根据class_id查询上传表（curriculum）
	public List<Curriculum> getCurriculumById(int class_id);

	//添加一条上传记录
	public void addCurriculum(Curriculum curriculum);
}
