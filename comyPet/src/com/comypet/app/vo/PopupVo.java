package com.comypet.app.vo;

import java.util.Date;

public class PopupVo {
	
	private int pop_idx;//팝업 번호
	private String pop_title;//팝업 제목
	private String pop_contents;//팝업 내용
	private int pop_writer;//팝업 작성자(어드민 UID)
	private Date pop_regDate;//팝업 등록날짜
	private int pop_state;//팝업 게시여부 0: 미개시 1:게시
	
	public int getPop_idx() {
		return pop_idx;
	}
	public void setPop_idx(int pop_idx) {
		this.pop_idx = pop_idx;
	}
	public String getPop_title() {
		return pop_title;
	}
	public void setPop_title(String pop_title) {
		this.pop_title = pop_title;
	}
	public String getPop_contents() {
		return pop_contents;
	}
	public void setPop_contents(String pop_contents) {
		this.pop_contents = pop_contents;
	}
	public int getPop_writer() {
		return pop_writer;
	}
	public void setPop_writer(int pop_writer) {
		this.pop_writer = pop_writer;
	}
	public Date getPop_regDate() {
		return pop_regDate;
	}
	public void setPop_regDate(Date pop_regDate) {
		this.pop_regDate = pop_regDate;
	}
	public int getPop_state() {
		return pop_state;
	}
	public void setPop_state(int pop_state) {
		this.pop_state = pop_state;
	}
	
	@Override
	public String toString() {
		return "PopupVO [pop_idx=" + pop_idx + ", pop_title=" + pop_title + ", pop_contents=" + pop_contents
				+ ", pop_writer=" + pop_writer + ", pop_regDate=" + pop_regDate + ", pop_state=" + pop_state + "]";
	}
}
