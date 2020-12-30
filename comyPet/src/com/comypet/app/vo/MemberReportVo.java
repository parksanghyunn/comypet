package com.comypet.app.vo;

import java.util.Date;

public class MemberReportVo {
	private int report_uid;				//유저 신고 고유번호
	private int reporter;					//신고 받은 사람
	private String report_type;			//유저 신고 타입
	private Date report_reg_date;		//유저 신고 날짜
	private int writer;						//신고자
	private int report_state;				//신고 상태(0 = 신고 취소, 1 = 신고 접수 2= 정지 완료)
	
	public MemberReportVo() {;}

	
	public int getReport_uid() {
		return report_uid;
	}


	public void setReport_uid(int report_uid) {
		this.report_uid = report_uid;
	}


	public int getReporter() {
		return reporter;
	}


	public void setReporter(int reporter) {
		this.reporter = reporter;
	}


	public String getReport_type() {
		return report_type;
	}


	public void setReport_type(String report_type) {
		this.report_type = report_type;
	}


	public Date getReport_reg_date() {
		return report_reg_date;
	}


	public void setReport_reg_date(Date report_reg_date) {
		this.report_reg_date = report_reg_date;
	}


	public int getWriter() {
		return writer;
	}


	public void setWriter(int writer) {
		this.writer = writer;
	}


	public int getReport_state() {
		return report_state;
	}


	public void setReport_state(int report_state) {
		this.report_state = report_state;
	}


	@Override
	public String toString() {
		return super.toString();
	}
}
