package com.comypet.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	private int member_uid;							//멤버 고유번호
	private String member_name;					//멤버 이름
	private String member_id;						//멤버 아이디
	private String member_pw;						//멤버 비밀번호
	private String member_nick;					//멤버 닉네임
	private String member_gender;				//멤버 성별
	private Date member_birth;					//멤버 생년월일
	private String member_tel;						//멤버 전화번호
	private String member_email;					//멤버 이메일
	private String member_zipcode;				//멤버 우편번호
	private String member_address;				//멤버 주소
	private String member_address_detail;		//멤버 상세주소
	private String member_address_etc;			//멤버 주소(동,호수)
	private int member_mute_comment;		//멤버 댓글 금지 0 : 허용 / 1 : 금지
	private int member_mute_contents;			//멤버 게시글 금지 0 : 허용 / 1 : 금지
}
