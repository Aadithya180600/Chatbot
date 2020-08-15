package com.chatbot.chatbot;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="moratoriumdetails")
public class mdetails {
	private String id;
	private String accno,loannumber,type_of_loan,no_of_months,reason;
	private Boolean processed;
	public mdetails() {
		
	}
	public mdetails(String accno,String loannumber,String type_of_loan,String no_of_months,String reason,Boolean processed) {
		this.accno=accno;
		this.loannumber=loannumber;
		this.no_of_months=no_of_months;
		this.type_of_loan=type_of_loan;
		this.reason=reason;
		this.processed=processed;
	}
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public String getLoannumber() {
		return loannumber;
	}
	public void setLoannumber(String loannumber) {
		this.loannumber = loannumber;
	}
	public String getType_of_loan() {
		return type_of_loan;
	}
	public void setType_of_loan(String type_of_loan) {
		this.type_of_loan = type_of_loan;
	}
	public String getNo_of_months() {
		return no_of_months;
	}
	public void setNo_of_months(String no_of_months) {
		this.no_of_months = no_of_months;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Boolean getProcessed() {
		return processed;
	}
	public void setProcessed(Boolean processed) {
		this.processed = processed;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}