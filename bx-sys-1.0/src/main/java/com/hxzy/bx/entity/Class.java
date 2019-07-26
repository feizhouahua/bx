package com.hxzy.bx.entity;

import java.io.Serializable;

public class Class implements Serializable{

	/**
	 * 班级表
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String classname;
	private String opening_hours;
	private String graduation_time;
	private String state;
	private String other_notes;
	private Integer entrance_number;
	private Integer transfer_number;
	private Integer refund_number;
	private Integer student_number;
	private String upload_state;
	private Course_type course_type;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getOpening_hours() {
		return opening_hours;
	}
	public void setOpening_hours(String opening_hours) {
		this.opening_hours = opening_hours;
	}
	public String getGraduation_time() {
		return graduation_time;
	}
	public void setGraduation_time(String graduation_time) {
		this.graduation_time = graduation_time;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getOther_notes() {
		return other_notes;
	}
	public void setOther_notes(String other_notes) {
		this.other_notes = other_notes;
	}
	public Integer getEntrance_number() {
		return entrance_number;
	}
	public void setEntrance_number(Integer entrance_number) {
		this.entrance_number = entrance_number;
	}
	public Integer getTransfer_number() {
		return transfer_number;
	}
	public void setTransfer_number(Integer transfer_number) {
		this.transfer_number = transfer_number;
	}
	public Integer getRefund_number() {
		return refund_number;
	}
	public void setRefund_number(Integer refund_number) {
		this.refund_number = refund_number;
	}
	public Course_type getCourse_type() {
		return course_type;
	}
	public void setCourse_type(Course_type course_type) {
		this.course_type = course_type;
	}
	public Integer getStudent_number() {
		return student_number;
	}
	public void setStudent_number(Integer student_number) {
		this.student_number = student_number;
	}
	public String getUpload_state() {
		return upload_state;
	}
	public void setUpload_state(String upload_state) {
		this.upload_state = upload_state;
	}
	
	

}
