package com.hxzy.bx.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	private ObjectMapper objectMapper=new ObjectMapper();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		//让security知道成功之后返回什么
		//返回json数据
		Map<String, Boolean> result=new HashMap<String, Boolean>();
		result.put("success",true);
		response.setContentType("text/json;charset=utf-8");
		String json=objectMapper.writeValueAsString(result);
		response.getWriter().write(json);
	}

}
