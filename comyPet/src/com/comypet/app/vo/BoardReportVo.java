package com.comypet.app.vo;

import java.util.Date;

public class BoardReportVo {
	private int report_uid;				//게시글 신고 고유번호
	private int board_state;				//게시글 분류(어떤 게시글에 있던 것인지 파악)
	private int board_idx;				//게시글 번호
	private String report_type;			//게시글 신고 타입
	private int writer;					//게시글 작성자
	private int reporter;				//게시글 신고자
	private Date report_reg_date;		//게시글 신고 날짜
	private int report_state;				//신고 게시글 분류(0 : 아무 처리가 없는 게시글, 1 : 처리 접수된 게시글, 2 : 블라인드 완료된 게시글)
	
	public BoardReportVo() {;}

	
	public int getReport_uid() {
		return report_uid;
	}


	public void setReport_uid(int report_uid) {
		this.report_uid = report_uid;
	}


	public int getBoard_state() {
		return board_state;
	}


	public void setBoard_state(int board_state) {
		this.board_state = board_state;
	}


	public int getBoard_idx() {
		return board_idx;
	}


	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}


	public String getReport_type() {
		return report_type;
	}


	public void setReport_type(String report_type) {
		this.report_type = report_type;
	}


	public int getWriter() {
		return writer;
	}


	public void setWriter(int writer) {
		this.writer = writer;
	}


	public int getReporter() {
		return reporter;
	}


	public void setReporter(int reporter) {
		this.reporter = reporter;
	}


	public Date getReport_reg_date() {
		return report_reg_date;
	}


	public void setReport_reg_date(Date report_reg_date) {
		this.report_reg_date = report_reg_date;
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
