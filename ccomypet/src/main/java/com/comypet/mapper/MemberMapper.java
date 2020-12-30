package com.comypet.mapper;

import java.util.HashMap;
import java.util.List;

import com.comypet.domain.BoardVO;
import com.comypet.domain.MemberVO;

public interface MemberMapper {
	public int insertMemberJoin(MemberVO member);
	public String seletMemberLogin(MemberVO member);
	public int selectMemberIdCheck(String member_id);
	public int selectMemberNickCheck(String member_nick);
	public int selectEmailCheck(String member_email);
	public int selectMemberUid(String member_id);
	public String getNick(int member_uid);
	public List<BoardVO> selectMyBoard(HashMap<String, Object> map);
	public int selectMyBoardCnt(HashMap<String, Object> map);
	public MemberVO selectInfo(int member_uid);
	public int updateInfo(MemberVO member);
	public int deleteMyBoard(HashMap<String, Object> map);
}
