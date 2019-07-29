package com.hxzy.bx.entity;

import java.io.Serializable;

public class Course_type implements Serializable{

	/**
	 * 课程类别表
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String course_name;
	private String synopsis;
	private Integer total_hours;
	private Double course_cost;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public Integer getTotal_hours() {
		return total_hours;
	}
	public void setTotal_hours(Integer total_hours) {
		this.total_hours = total_hours;
	}
	public Double getCourse_cost() {
		return course_cost;
	}
	public void setCourse_cost(Double course_cost) {
		this.course_cost = course_cost;
	}
	

}
