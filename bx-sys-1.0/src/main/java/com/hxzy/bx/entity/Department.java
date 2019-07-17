package com.hxzy.bx.entity;

import java.io.Serializable;

public class Department implements Serializable{

	/**
	 * 部门表
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String depart_name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepart_name() {
		return depart_name;
	}
	public void setDepart_name(String depart_name) {
		this.depart_name = depart_name;
	}
	
	

}
