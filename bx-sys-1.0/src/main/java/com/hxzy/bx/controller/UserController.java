package com.hxzy.bx.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping("home")
	public String home(HttpSession session) {
		//获取登录用户(UserDetails对象)
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()  
				.getAuthentication()  
				.getPrincipal();
		session.setAttribute("loginUser", userDetails);
//		Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		if(principal!=null) {
//			if(principal instanceof UserDetails) {
//				UserDetails userDetails = (UserDetails) principal;
//			}
//		}
		return "home";
	}
	
	//权限登录
	@RequestMapping("userLogin")
	public String login() {
		return "login";
	}
	
	//权限不足
	@RequestMapping("error")
	public String error() {
		return "error";
	}
	
	//登录功能
	//@RequestMapping("login")
//	public String login(@ModelAttribute User user,HttpSession session) {
//		System.out.println(user);
//		User u=userService.getLogin(user);
//		if(null !=u) {
//			//model.addAttribute("loginUser", u);
//			session.setAttribute("loginUser", u);
//			return "home";
//		}else {
//			return "login";
//		}
//	}
	
	//更改密码
	@RequestMapping("change")
	public String change(@ModelAttribute User user,HttpSession session) {
		return "update";
	}
	
	//更改密码
	@RequestMapping("update")
	public String update(@ModelAttribute User user,@RequestParam String newpassword,HttpSession session) {
		User u=(User) session.getAttribute("loginUser");
		System.out.println(user.getId());
		User user1=new User();
		
		//加密操作
		PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		user1.setUsername(u.getUsername());
		user1.setPassword(user.getPassword());
		User u2=userService.getLogin(user1);
		if(u2==null) {
			return "update"; 
		}else {	
			//加密操作
			newpassword=passwordEncoder.encode(newpassword);
			
		    User u3=new User();
			u3.setId(user.getId());
		    u3.setPassword(newpassword);
			userService.updateUserById(u3);
			System.out.println(user.getPassword());
			System.out.println(newpassword);
			//userService.updateUserById(user);
			return "hello";
		}
	}
	
	//生成验证码
	@RequestMapping("imageCode")
	public String image() {
		return "imageCode";
	}
	
}
