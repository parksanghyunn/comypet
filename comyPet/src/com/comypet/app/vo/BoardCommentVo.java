package com.comypet.app.vo;

import java.util.Date;

public class BoardCommentVo {
	
	private int comment_idx;				//게시글 댓글 번호
	private int board_idx;					//게시글 번호
	private int member_uid;					//댓글 작성자
	private String comment_content;		//댓글 내용
	private Date comment_reg_date;		//댓글 작성 시간
	private int board_state;
	
	public BoardCommentVo() {;}
	
	public int getComment_idx() {
		return comment_idx;
	}

	public void setComment_idx(int comment_idx) {
		this.comment_idx = comment_idx;
	}

	public int getBoard_state() {
		return board_state;
	}

	public void setBoard_state(int board_state) {
		this.board_state = board_state;
	}

	public int getBoard_comment_idx() {
		return comment_idx;
	}

	public void setBoard_comment_idx(int board_comment_idx) {
		this.comment_idx = board_comment_idx;
	}

	public int getBoard_idx() {
		return board_idx;
	}

	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}

	public int getMember_uid() {
		return member_uid;
	}

	public void setMember_uid(int member_uid) {
		this.member_uid = member_uid;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public Date getComment_reg_date() {
		return comment_reg_date;
	}

	public void setComment_reg_date(Date comment_reg_date) {
		this.comment_reg_date = comment_reg_date;
	}
	
	@Override
	public String toString() {
		return "BoardCommentVO [comment_idx=" + comment_idx + ", board_idx=" + board_idx+ ", member_uid=" + member_uid
				+ ", comment_content=" + comment_content +", comment_reg_date=" + comment_reg_date + "]";
	}
}
