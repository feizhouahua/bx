package com.hxzy.bx.security.exception;

import org.springframework.security.core.AuthenticationException;

public class ImageCodeException extends AuthenticationException{

	public ImageCodeException(String msg,Throwable throwable) {
		super(msg,throwable);
		// TODO Auto-generated constructor stub
	}
	
	public ImageCodeException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

}
