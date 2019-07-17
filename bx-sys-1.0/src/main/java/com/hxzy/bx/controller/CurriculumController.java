package com.hxzy.bx.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.hxzy.bx.service.CurriculumService;

@Controller
public class CurriculumController {

	@Resource(name="curriculumServiceImpl")
	private CurriculumService curriculumService;
	public void setCurriculumService(CurriculumService curriculumService) {
		this.curriculumService = curriculumService;
	}
	
}
