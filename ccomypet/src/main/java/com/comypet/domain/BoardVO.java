package com.comypet.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	private int board_idx;				//게시글 번호
	private int member_uid;				//게시글 작성자
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
}
