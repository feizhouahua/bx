package com.hxzy.bx.entity;

import java.io.Serializable;

public class Track implements Serializable{

	/**
	 * 跟踪表
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String content;
	private String time;
	private String consultants;
	private Refer refer;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getConsultants() {
		return consultants;
	}
	public void setConsultants(String consultants) {
		this.consultants = consultants;
	}
	public Refer getRefer() {
		return refer;
	}
	public void setRefer(Refer refer) {
		this.refer = refer;
	}
	
}
