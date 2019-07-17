package com.hxzy.bx.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.hxzy.bx.service.RunOffService;

@Controller
public class RunOffController {

	@Resource(name="runOffServiceImpl")
	private RunOffService runOffService;
}
