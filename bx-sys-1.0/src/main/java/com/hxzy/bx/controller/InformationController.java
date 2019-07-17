package com.hxzy.bx.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.hxzy.bx.service.InformationService;

@Controller
public class InformationController {

	@Resource(name="informationServiceImpl")
	private InformationService informationService;
	public void setInformationService(InformationService informationService) {
		this.informationService = informationService;
	}
	
}
