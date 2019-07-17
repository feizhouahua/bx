package com.hxzy.bx.entity;

import java.io.Serializable;

public class Station implements Serializable{

	/**
	 * 升级/转班表
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String student_name;
	private String operating_time;
	private String operation_type;
	private String manager;
	private String befor_classname;
	private String after_classname;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getOperating_time() {
		return operating_time;
	}
	public void setOperating_time(String operating_time) {
		this.operating_time = operating_time;
	}
	public String getOperation_type() {
		return operation_type;
	}
	public void setOperation_type(String operation_type) {
		this.operation_type = operation_type;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getBefor_classname() {
		return befor_classname;
	}
	public void setBefor_classname(String befor_classname) {
		this.befor_classname = befor_classname;
	}
	public String getAfter_classname() {
		return after_classname;
	}
	public void setAfter_classname(String after_classname) {
		this.after_classname = after_classname;
	}
	
	
	
}
