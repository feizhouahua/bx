package com.hxzy.bx.entity;

import java.io.Serializable;

public class Information implements Serializable{

	/**
	 * 就业信息表
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String student_name;
	private String class_name;
	private String employment_company;
	private double salary;
	private String post;
	private String entry_time;
	private String description;
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
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getEmployment_company() {
		return employment_company;
	}
	public void setEmployment_company(String employment_company) {
		this.employment_company = employment_company;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(String entry_time) {
		this.entry_time = entry_time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
