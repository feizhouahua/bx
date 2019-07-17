package com.hxzy.bx.entity;

import java.io.Serializable;

public class Refer implements Serializable{

	/**
	 * 咨询表
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String refername;
	private String tel;
	private String QQ;
	private String Intention_level;
	private String source;
	private String remarks;
	private String state;
	private String marketer;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRefername() {
		return refername;
	}
	public void setRefername(String refername) {
		this.refername = refername;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getIntention_level() {
		return Intention_level;
	}
	public void setIntention_level(String intention_level) {
		Intention_level = intention_level;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMarketer() {
		return marketer;
	}
	public void setMarketer(String marketer) {
		this.marketer = marketer;
	}
	
	
}
