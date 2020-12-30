package com.comypet.app.vo;

import java.util.Date;

public class CustomerVo {
	
	private int customer_idx;
	private String customer_name;
	private String customer_email;
	private String customer_tel;
	private String customer_contents;
	private Date customer_regDate;
	private int customer_state;
	
	public CustomerVo() {;}

	public int getCustomer_idx() {
		return customer_idx;
	}

	public void setCustomer_idx(int customer_idx) {
		this.customer_idx = customer_idx;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_tel() {
		return customer_tel;
	}

	public void setCustomer_tel(String customer_tel) {
		this.customer_tel = customer_tel;
	}

	public String getCustomer_contents() {
		return customer_contents;
	}

	public void setCustomer_contents(String customer_contents) {
		this.customer_contents = customer_contents;
	}

	public Date getCustomer_regDate() {
		return customer_regDate;
	}

	public void setCustomer_regDate(Date customer_regDate) {
		this.customer_regDate = customer_regDate;
	}

	public int getCustomer_state() {
		return customer_state;
	}

	public void setCustomer_state(int customer_state) {
		this.customer_state = customer_state;
	}

	@Override
	public String toString() {
		return "CustomerVO [customer_idx=" + customer_idx + ", customer_name=" + customer_name + ", customer_email="
				+ customer_email + ", customer_tel=" + customer_tel + ", customer_contents=" + customer_contents
				+ ", customer_regDate=" + customer_regDate + ", customer_state=" + customer_state + "]";
	}
	
}
