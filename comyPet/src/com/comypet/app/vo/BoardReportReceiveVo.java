package com.comypet.app.vo;

public class BoardReportReceiveVo extends BoardReportVo{
	private String r_id;				//신고된 유저의 아이디
	private String r_nick;			//신고된 유저의 닉네임
	private String w_id;			//신고자 아이디
	private String w_nick;		//신고자 닉네임
	private String b_title;			//게시판 제목
	private String b_contents;	//게시판 내용
	
	public BoardReportReceiveVo() {;}

	public String getR_id() {
		return r_id;
	}

	public void setR_id(String r_id) {
		this.r_id = r_id;
	}

	public String getR_nick() {
		return r_nick;
	}

	public void setR_nick(String r_nick) {
		this.r_nick = r_nick;
	}

	public String getW_id() {
		return w_id;
	}

	public void setW_id(String w_id) {
		this.w_id = w_id;
	}

	public String getW_nick() {
		return w_nick;
	}

	public void setW_nick(String w_nick) {
		this.w_nick = w_nick;
	}
	
	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	
	
	public String getB_contents() {
		return b_contents;
	}

	public void setB_contents(String b_contents) {
		this.b_contents = b_contents;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
