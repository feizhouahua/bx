package com.hxzy.bx.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hxzy.bx.entity.User;
import com.hxzy.bx.service.UserService;

@Controller
public class UserController {

	@Resource(name="userServiceImpl")
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("index")
	public String index() {
		return "login";
	}
	//登录功能
	@RequestMapping("login")
	public String login(@ModelAttribute User user,HttpSession session) {
		System.out.println(user);
		User u=userService.getLogin(user);
		if(null !=u) {
			//model.addAttribute("loginUser", u);
			session.setAttribute("loginUser", u);
			return "home";
		}else {
			return "login";
		}
	}
	
	//退出登录
	@RequestMapping("loginout")
	public String loginout(HttpSession session) {
		session.removeAttribute("loginUser");
		return "login";
	}
	
	//更改密码
	@RequestMapping("change")
	public String change(@ModelAttribute User user,HttpSession session) {
		
		return "update";
	}
	
}
