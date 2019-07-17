package com.hxzy.bx.entity;

import java.io.Serializable;

public class Post implements Serializable{

	/**
	 * 职务表
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String post_name;
	private Department department;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPost_name() {
		return post_name;
	}
	public void setPost_name(String post_name) {
		this.post_name = post_name;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	

}
