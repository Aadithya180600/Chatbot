package com.chatbot.chatbot;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Accountdetails")
public class Accdetails {
	@Id
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String accno,name,phn_no,occ,have_income,income;
	public Accdetails()
	{
		
	}
	public Accdetails(String accno,String name,String phn_no,String occ,String have_income,String income) {
		this.accno=accno;
		this.have_income=have_income;
		this.phn_no=phn_no;
		this.name=name;
		this.occ=occ;
		this.income=income;
	}
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhn_no() {
		return phn_no;
	}
	public void setPhn_no(String phn_no) {
		this.phn_no = phn_no;
	}
	public String getOcc() {
		return occ;
	}
	public void setOcc(String occ) {
		this.occ = occ;
	}
	public String getHave_income() {
		return have_income;
	}
	public void setHave_income(String have_income) {
		this.have_income = have_income;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
}