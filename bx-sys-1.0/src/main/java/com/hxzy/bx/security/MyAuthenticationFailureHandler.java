package com.hxzy.bx.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hxzy.bx.security.exception.ImageCodeException;

public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// 让security知道成功之后返回什么
		// 返回json数据
		Map<String, Object> result = new HashMap<String, Object>();
		
		String error=null;
		if (exception instanceof BadCredentialsException) {
            error = "用户名或密码错误!";
            result.put("error", error);
        }
		
		result.put("success", false);
		result.put("errorMsg", exception.getMessage());
		String json = objectMapper.writeValueAsString(result);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(json);

	}

}
