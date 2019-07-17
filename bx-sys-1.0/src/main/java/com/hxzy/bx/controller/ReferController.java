package com.hxzy.bx.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.hxzy.bx.service.ReferService;

@Controller
public class ReferController {

	@Resource(name="referServiceImpl")
	private ReferService referService;
}
