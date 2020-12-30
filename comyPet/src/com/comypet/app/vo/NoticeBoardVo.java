package com.comypet.app.vo;

import java.util.Date;

public class NoticeBoardVo {
	
	private int board_idx;				//게시글 번호
	private int admin_uid;				//게시글 작성자
	private String board_title;			//게시글 제목
	private String board_contents;		//게시글 내용
	private int board_readCnt;			//게시글 조회수
	private int board_up_cnt;			//게시글 추천 카운트
	private int board_down_cnt;		//게시글 다운 카운트
	private Date board_regDate;		//게시글 등록날짜
	private int board_state;				//게시판 분류번호 
	private int board_blind;				//게시판 블라인드 여부
										   /*
										   		0 : 공지사항
											 	1 : 자유 게시판
											 	2 : 모임 게시판
											 	3 : 나눔 게시판
											 	4 : 질문 게시판
											 	5 : 강아지 갤러리
											 	6 : 고양이 갤러리
											 	7 : 일상 공유 게시판
											 	8 : 기타 갤러리
											 	9 : 반려동물 찾기 게시판
											 	10 : 불편사항 게시판
										   */
	public NoticeBoardVo() {;}
	
	public int getBoard_idx() {
		return board_idx;
	}
	
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	
	public int getAdmin_uid() {
		return admin_uid;
	}
	
	public void setAdmin_uid(int Member_uid) {
		this.admin_uid = Member_uid;
	}
	
	public String getBoard_title() {
		return board_title;
	}
	
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	
	public String getBoard_contents() {
		return board_contents;
	}
	
	public void setBoard_contents(String board_contents) {
		this.board_contents = board_contents;
	}
	
	public int getBoard_readCnt() {
		return board_readCnt;
	}
	
	public void setBoard_readCnt(int board_readCnt) {
		this.board_readCnt = board_readCnt;
	}
	
	public int getBoard_up_cnt() {
		return board_up_cnt;
	}
	
	public void setBoard_up_cnt(int board_up_cnt) {
		this.board_up_cnt = board_up_cnt;
	}
	
	public int getBoard_down_cnt() {
		return board_down_cnt;
	}
	
	public void setBoard_down_cnt(int board_down_cnt) {
		this.board_down_cnt = board_down_cnt;
	}
	
	public Date getBoard_regDate() {
		return board_regDate;
	}
	
	public void setBoard_regDate(Date board_regDate) {
		this.board_regDate = board_regDate;
	}
	
	public int getBoard_state() {
		return board_state;
	}
	
	public void setBoard_state(int board_state) {
		this.board_state = board_state;
	}
	
	public int getBoard_blind() {
		return board_blind;
	}

	public void setBoard_blind(int board_blind) {
		this.board_blind = board_blind;
	}

	@Override
	public String toString() {
		return "NoticeBoardVO [board_idx=" + board_idx + ", board_uid=" + admin_uid + ", board_title=" + board_title
				+ ", board_contents=" + board_contents + ", board_readCnt=" + board_readCnt + ", board_up_cnt="
				+ board_up_cnt + ", board_down_cnt=" + board_down_cnt +", board_regDate=" 
				+ board_regDate + ", board_state=" + board_state + ", board_blind=" + board_blind
				+ "]";
	}
}
