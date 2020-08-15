package com.chatbot.chatbot;

public class Acc_mdetails {
	private String accno,name,phn_no,occ,have_income,income;
	private String loannumber,type_of_loan,no_of_months,reason;
	private Boolean processed;
	public String getAccno() {
		return accno;
	}
	
	public Acc_mdetails() {
		
	}
	
	public Acc_mdetails(String accno,String name,String phn_no,String occ,String have_income,String income,String loannumber,String type_of_loan,String no_of_months,String reason,Boolean processed) {
		this.accno=accno;
		this.have_income=have_income;
		this.phn_no=phn_no;
		this.name=name;
		this.occ=occ;
		this.income=income;
		this.loannumber=loannumber;
		this.no_of_months=no_of_months;
		this.type_of_loan=type_of_loan;
		this.reason=reason;
		this.processed=processed;
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
