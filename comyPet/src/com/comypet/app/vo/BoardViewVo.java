package com.comypet.app.vo;

public class BoardViewVo extends BoardVo{
	private String member_nick;
	private String admin_id;
	
	public BoardViewVo() {;}
	
	public String getMember_nick() {
		return member_nick;
	}

	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	
	
	
}
