package com.comypet.app.vo;

public class AdminVo {

	private int admin_uid;                 //어드민 고유번호
	private String admin_id;               //어드민 아이디
	private String admin_pw;               //어드민 패스워드
	private int admin_level;               //어드민 레벨(권한)
	
	public AdminVo(){;}

	public int getAdmin_uid() {
		return admin_uid;
	}

	public void setAdmin_uid(int admin_uid) {
		this.admin_uid = admin_uid;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_pw() {
		return admin_pw;
	}

	public void setAdmin_pw(String admin_pw) {
		this.admin_pw = admin_pw;
	}

	public int getAdmin_level() {
		return admin_level;
	}

	public void setAdmin_level(int admin_level) {
		this.admin_level = admin_level;
	}
	
	@Override
	public String toString() {
		return "adminVO [admin_uid=" + admin_uid + ", admin_id=" + admin_id + ", admin_pw=" + admin_pw
				+ ", admin_level=" + admin_level + "]";
	}
}
