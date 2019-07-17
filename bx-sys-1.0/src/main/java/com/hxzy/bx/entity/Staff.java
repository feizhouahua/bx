package com.hxzy.bx.entity;

import java.io.Serializable;

public class Staff implements Serializable{

	/**
	 * 员工表
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String Loginname;
	private String password;
	private String entry_time;
	private String staff_name;
	private String sex;//1--->男  2--->女
	private Post post;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginname() {
		return Loginname;
	}
	public void setLoginname(String loginname) {
		Loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(String entry_time) {
		this.entry_time = entry_time;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	
	
	

	
}
