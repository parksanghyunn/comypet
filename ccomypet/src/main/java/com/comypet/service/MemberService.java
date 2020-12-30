package com.comypet.service;

import java.util.HashMap;
import java.util.List;

import com.comypet.domain.BoardVO;
import com.comypet.domain.Criteria;
import com.comypet.domain.MemberVO;

public interface MemberService {
	public boolean join(MemberVO member);
	public String login(MemberVO member);
	public int checkNick(String member_nick);
	public int checkid(String member_id);
	public int checkEmail(String member_email);
	public int getMemberUid(String member_id);
	public String getMemberNick(int member_uid);
	public List<BoardVO> myBoard(Criteria cri, String board_name, int member_uid);
	public int myBoardTotal(String board_name, int member_uid);
	public MemberVO myInfo(int member_uid);
	public String myProfil(int member_uid);
	public boolean updateInfo(MemberVO member);
	public boolean deleteMyBoard(String board_name, int board_idx);
	public boolean updateProfile(String file_name, int member_uid);
	public boolean deleteProfile(int member_uid);
}
