package com.comypet.app.vo;

import java.util.Date;

public class CustomerBoardVo {
	private int cs_idx;					//문의 게시판 고유번호
	private String cs_manager;		//문의 게시판 담당자
	private String cs_email;			//문의 게시판 이메일
	private String cs_tel;				//문의 게시판 전화번호
	private String cs_content;		//문의 게시판 내용
	private Date cs_regdate;			//문의 게시판 날짜
//	private int cs_state;				//문의 게시판 종류 (0 = 제휴문의, 1 = 광고문의)
	
	public CustomerBoardVo() {;}

	public int getCs_idx() {
		return cs_idx;
	}

	public void setCs_idx(int cs_idx) {
		this.cs_idx = cs_idx;
	}

	public String getCs_manager() {
		return cs_manager;
	}

	public void setCs_manager(String cs_manager) {
		this.cs_manager = cs_manager;
	}

	public String getCs_email() {
		return cs_email;
	}

	public void setCs_email(String cs_email) {
		this.cs_email = cs_email;
	}

	public String getCs_tel() {
		return cs_tel;
	}

	public void setCs_tel(String cs_tel) {
		this.cs_tel = cs_tel;
	}

	public String getCs_content() {
		return cs_content;
	}

	public void setCs_content(String cs_content) {
		this.cs_content = cs_content;
	}

	public Date getCs_regdate() {
		return cs_regdate;
	}

	public void setCs_regdate(Date cs_regdate) {
		this.cs_regdate = cs_regdate;
	}

//	public int getCs_state() {
//		return cs_state;
//	}
//
//	public void setCs_state(int cs_state) {
//		this.cs_state = cs_state;
//	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
