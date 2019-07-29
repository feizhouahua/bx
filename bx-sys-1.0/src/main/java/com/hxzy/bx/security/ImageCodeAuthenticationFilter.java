package com.hxzy.bx.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.web.filter.OncePerRequestFilter;

import com.hxzy.bx.security.exception.ImageCodeException;

public class ImageCodeAuthenticationFilter extends OncePerRequestFilter{
	
	private MyAuthenticationFailureHandler myAuthenticationFailureHandler;
	public void setMyAuthenticationFailureHandler(MyAuthenticationFailureHandler myAuthenticationFailureHandler) {
		this.myAuthenticationFailureHandler = myAuthenticationFailureHandler;
	}


	//当所有请求经过时都会经过这个过滤器
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//判断当前请求是否为登陆请求
		if(request.getRequestURI().contains("/login")) {
			//校验验证码
			try {
				//获取用户输入的验证码
				String imageCode=request.getParameter("imageCode");
				//获取系统生成的验证码
				String key=(String) request.getSession().getAttribute("key");
				if(imageCode==null || imageCode=="") {//如果输入的验证码为空
					throw new ImageCodeException("验证码必须输入！");
				}
				if(!imageCode.trim().equals(key.trim())) {
					throw new ImageCodeException("验证码不正确！");
				}
			} catch (AuthenticationException e) {
				//交给自定义的AuthentFailureHandler处理
				myAuthenticationFailureHandler.onAuthenticationFailure(request, response, e);
				return;
			}
			
		}
		
		filterChain.doFilter(request, response);
	}

}
