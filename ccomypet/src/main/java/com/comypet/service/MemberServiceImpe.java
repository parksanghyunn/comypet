package com.comypet.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.comypet.domain.BoardVO;
import com.comypet.domain.Criteria;
import com.comypet.domain.MemberVO;
import com.comypet.mapper.MemberMapper;
import com.comypet.mapper.ProfilesMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MemberServiceImpe implements MemberService {
	@Setter(onMethod_= {@Autowired})
	private MemberMapper mapper;
	@Setter(onMethod_= {@Autowired})
	private ProfilesMapper proMapper;
	
	@Override
	public boolean join(MemberVO member) {
		if(mapper.insertMemberJoin(member) == 1) {
			return proMapper.insertProfile( ) == 1;
		}
		return false;
	}

	@Override
	public String login(MemberVO member) {
		return mapper.seletMemberLogin(member);
	}
	@Override
	public String myProfil(int member_uid) {
		return proMapper.selectProfile(member_uid);
	}
	@Override
	public int checkid(String member_id) {
		return mapper.selectMemberIdCheck(member_id);
	}
	
	@Override
	public int checkNick(String member_nick) {
		return mapper.selectMemberNickCheck(member_nick);
	}
	
	@Override
	public int checkEmail(String member_email) {
		log.info("check_email : " + member_email);
		return mapper.selectEmailCheck(member_email);
	}
	
	@Override
	public int getMemberUid(String member_id) {
		return mapper.selectMemberUid(member_id);
	}
	
	@Override
	public String getMemberNick(int member_uid) {
		return mapper.getNick(member_uid);
	}
	
	@Override
	public List<BoardVO> myBoard(Criteria cri, String board_name, int member_uid) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("pageNum", cri.getPageNum());
		map.put("amount", cri.getAmount());
		map.put("board_name", board_name);
		map.put("member_uid", member_uid);
		List<BoardVO> board = mapper.selectMyBoard(map);
		return board;
	}
	
	@Override
	public int myBoardTotal(String board_name, int member_uid) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("board_name", board_name);
		map.put("member_uid", member_uid);
		return mapper.selectMyBoardCnt(map);
	}
	
	@Override
	public MemberVO myInfo(int member_uid) {
		return mapper.selectInfo(member_uid);
	}
	
	@Override
	public boolean updateInfo(MemberVO member) {
		return mapper.updateInfo(member)==1;
	}
	
	@Override
	public boolean deleteMyBoard(String board_name, int board_idx) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("board_name", board_name);
		map.put("board_idx", board_idx);
		return mapper.deleteMyBoard(map) != 0;
	}
	
	@Override
	public boolean updateProfile(String file_name, int member_uid) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("file_name", file_name);
		map.put("member_uid", member_uid);
		return proMapper.updateProfile(map)!=0;
	}
	
	@Override
	public boolean deleteProfile(int member_uid) {
		return proMapper.deleteProfile(member_uid)!=0;
	}
}
