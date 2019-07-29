package com.hxzy.bx.entity;

import java.io.Serializable;

public class Curriculum implements Serializable{

	/**
	 * （上传、下载）课表
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String upload_time;
	private String upload_path;
	private String oldname;
	private String newname;
	private Class classes;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUpload_time() {
		return upload_time;
	}
	public void setUpload_time(String upload_time) {
		this.upload_time = upload_time;
	}
	public String getUpload_path() {
		return upload_path;
	}
	public void setUpload_path(String upload_path) {
		this.upload_path = upload_path;
	}
	public Class getClasses() {
		return classes;
	}
	public void setClasses(Class classes) {
		this.classes = classes;
	}
	public String getOldname() {
		return oldname;
	}
	public void setOldname(String oldname) {
		this.oldname = oldname;
	}
	public String getNewname() {
		return newname;
	}
	public void setNewname(String newname) {
		this.newname = newname;
	}
	
	

}
