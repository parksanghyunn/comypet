package com.comypet.app.vo;

import java.util.Date;

public class MemberVo {
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

	public MemberVo(){;}

	public int getMember_uid() {
		return member_uid;
	}

	public void setMember_uid(int member_uid) {
		this.member_uid = member_uid;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_nick() {
		return member_nick;
	}

	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}

	public String getMember_gender() {
		return member_gender;
	}

	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}

	public Date getMember_birth() {
		return member_birth;
	}

	public void setMember_birth(Date birthh) {
		this.member_birth = birthh;
	}

	public String getMember_tel() {
		return member_tel;
	}

	public void setMember_tel(String member_tel) {
		this.member_tel = member_tel;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_zipcode() {
		return member_zipcode;
	}

	public void setMember_zipcode(String member_zipcode) {
		this.member_zipcode = member_zipcode;
	}

	public String getMember_address() {
		return member_address;
	}

	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}

	public String getMember_address_detail() {
		return member_address_detail;
	}

	public void setMember_address_detail(String member_address_detail) {
		this.member_address_detail = member_address_detail;
	}

	public String getMember_address_etc() {
		return member_address_etc;
	}

	public void setMember_address_etc(String member_address_etc) {
		this.member_address_etc = member_address_etc;
	}


	public int getMember_mute_comment() {
		return member_mute_comment;
	}

	public void setMember_mute_comment(int member_mute_comment) {
		this.member_mute_comment = member_mute_comment;
	}

	public int getMember_mute_contents() {
		return member_mute_contents;
	}

	public void setMember_mute_contents(int member_mute_contents) {
		this.member_mute_contents = member_mute_contents;
	}

	@Override
	public String toString() {
		return "MemberVO [member_uid=" + member_uid + ", member_name=" + member_name + ", member_id=" + member_id
				+ ", member_pw=" + member_pw + ", member_nick=" + member_nick + ", member_gender=" + member_gender
				+ ", member_birth=" + member_birth + ", member_tel=" + member_tel + ", member_email=" + member_email
				+ ", member_zipcode=" + member_zipcode + ", member_address=" + member_address + ", member_address_detail=" + member_address_detail
				+ ", member_address_etc=" + member_address_etc + ", member_mute_comment=" + member_mute_comment + ", member_mute_contents=" 
				+ member_mute_contents + "]";
	}
	
}
