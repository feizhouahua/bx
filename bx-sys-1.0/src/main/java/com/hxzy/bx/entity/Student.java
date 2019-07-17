package com.hxzy.bx.entity;

import java.io.Serializable;

public class Student implements Serializable{

	/**
	 * 学生表
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String student_name;
	private Integer sex;
	private String Id_card;
	private String Tel;
	private String QQ;
	private String Email;
	private String graduated_school;
	private String education;
	private String profession;
	private String card_address;
	private String current_address;
	private String student_description;
	private String family_tel;
	private String family_people;
	private double tuition_paid;
	private double unpaid_tuition;
	private String admission_time;
	private String state;
	private Class classes;
	
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
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getId_card() {
		return Id_card;
	}
	public void setId_card(String id_card) {
		Id_card = id_card;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getGraduated_school() {
		return graduated_school;
	}
	public void setGraduated_school(String graduated_school) {
		this.graduated_school = graduated_school;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getCard_address() {
		return card_address;
	}
	public void setCard_address(String card_address) {
		this.card_address = card_address;
	}
	public String getCurrent_address() {
		return current_address;
	}
	public void setCurrent_address(String current_address) {
		this.current_address = current_address;
	}
	public String getStudent_description() {
		return student_description;
	}
	public void setStudent_description(String student_description) {
		this.student_description = student_description;
	}
	public String getFamily_tel() {
		return family_tel;
	}
	public void setFamily_tel(String family_tel) {
		this.family_tel = family_tel;
	}
	public String getFamily_people() {
		return family_people;
	}
	public void setFamily_people(String family_people) {
		this.family_people = family_people;
	}
	public double getTuition_paid() {
		return tuition_paid;
	}
	public void setTuition_paid(double tuition_paid) {
		this.tuition_paid = tuition_paid;
	}
	public double getUnpaid_tuition() {
		return unpaid_tuition;
	}
	public void setUnpaid_tuition(double unpaid_tuition) {
		this.unpaid_tuition = unpaid_tuition;
	}
	public String getAdmission_time() {
		return admission_time;
	}
	public void setAdmission_time(String admission_time) {
		this.admission_time = admission_time;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Class getClasses() {
		return classes;
	}
	public void setClasses(Class classes) {
		this.classes = classes;
	}
	
	
}
