package com.comypet.app.vo;

public class ProfileVo {
	private int profile_idx;		//프로필 고유번호
	private String file_name;			//프로필에 올릴 파일 이름
	private int member_uid;			//사용자 고유 번호
	
	public ProfileVo() {;}

	protected int getProfile_idx() {
		return profile_idx;
	}

	protected void setProfile_idx(int profile_idx) {
		this.profile_idx = profile_idx;
	}

	protected String getFile_name() {
		return file_name;
	}

	protected void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	protected int getMember_uid() {
		return member_uid;
	}

	protected void setMember_uid(int member_uid) {
		this.member_uid = member_uid;
	}

	@Override
	public String toString() {
		return "ProfileVo [profile_idx=" + profile_idx + ", file_name=" + file_name + ", member_uid=" + member_uid
				+ "]";
	}

}
