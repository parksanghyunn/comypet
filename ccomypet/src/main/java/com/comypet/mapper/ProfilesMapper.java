package com.comypet.mapper;

import java.util.HashMap;

public interface ProfilesMapper {
	public int insertProfile();
	public String selectProfile(int member_uid);
	public int updateProfile(HashMap<String, Object> map);
	public int deleteProfile(int member_uid);
}
