package com.comypet.app.vo;

import java.util.Date;

public class BoardReCommentVo {
	private int re_comment_idx;
	private int comment_idx;
	private int board_idx;
	private int member_uid;
	private String re_comment_content;
	private Date re_comment_reg_date;
	
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public int getRe_comment_idx() {
		return re_comment_idx;
	}
	public void setRe_comment_idx(int re_comment_idx) {
		this.re_comment_idx = re_comment_idx;
	}
	public int getComment_idx() {
		return comment_idx;
	}
	public void setComment_idx(int comment_idx) {
		this.comment_idx = comment_idx;
	}
	public int getMember_uid() {
		return member_uid;
	}
	public void setMember_uid(int member_uid) {
		this.member_uid = member_uid;
	}
	public String getRe_comment_content() {
		return re_comment_content;
	}
	public void setRe_comment_content(String re_comment_content) {
		this.re_comment_content = re_comment_content;
	}
	public Date getRe_comment_reg_date() {
		return re_comment_reg_date;
	}
	public void setRe_comment_reg_date(Date re_comment_reg_date) {
		this.re_comment_reg_date = re_comment_reg_date;
	}
	
	@Override
	public String toString() {
		return "BoardReCommentVO [re_comment_idx+ " +re_comment_idx +", comment_idx=" + comment_idx
				+ ", member_uid=" + member_uid+ ", re_comment_content=" + re_comment_content + ", re_comment_reg_date=" + re_comment_reg_date +"]";
	}
	
}
