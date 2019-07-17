package com.hxzy.bx.entity;

import java.io.Serializable;

public class RunOff implements Serializable{

	/**
	 * 流失表
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String student_name;
	private String tel;
	private String QQ;
	private String befor_classname;
	private String cause;
	private String business_time;
	private String manager;
	private String refund;
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
	public String getBefor_classname() {
		return befor_classname;
	}
	public void setBefor_classname(String befor_classname) {
		this.befor_classname = befor_classname;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getBusiness_time() {
		return business_time;
	}
	public void setBusiness_time(String business_time) {
		this.business_time = business_time;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getRefund() {
		return refund;
	}
	public void setRefund(String refund) {
		this.refund = refund;
	}
	
	
}
