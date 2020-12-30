package com.comypet.app.dao;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.comypet.app.vo.BoardCommentVo;
import com.comypet.app.vo.BoardReportVo;
import com.comypet.app.vo.BoardVo;
import com.comypet.app.vo.MemberReportVo;
import com.comypet.app.vo.MemberVo;
import com.comypet.app.vo.ProfileVo;
import com.comypet.mybatis.config.SqlMapConfig;
import com.oreilly.servlet.MultipartRequest;

public class MemberDao {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;

	public MemberDao() {
		sqlsession = sessionf.openSession(true);
	}

	public boolean join(MemberVo member) {
		if (sqlsession.insert("Member.insertMemberJoin", member) == 1) {
			return true;
		}
		return false;
	}

	public boolean idCheck(String id) {
		if ((Integer) sqlsession.selectOne("Member.selectMemberIdCheck", id) == 1) {
			return true;
		}
		return false;
	}

	public boolean nickCheck(String nick) {
		if ((Integer) sqlsession.selectOne("Member.selectMemberNickCheck", nick) == 1) {
			return true;
		}
		return false;
	}

	public String login(String id, String pw) {
		HashMap<String, String> dataMap = new HashMap<>();
		dataMap.put("member_id", id);
		dataMap.put("member_pw", pw);

		return (String) sqlsession.selectOne("Member.seletMemberLogin", dataMap);
	}
	//멤버 정지 여부 확인
	public boolean muteCheck(int member_uid) {
		if((Integer)sqlsession.selectOne("Member.selectMuteCheck", member_uid) == 1) {
			return true; 
		}else {
			return false;
		}
	}
	public int memberGetUid(String id) {
		return (Integer) sqlsession.selectOne("Member.selectMemberUid", id);
	}

	public String findId(String name, String email) {
		HashMap<String, String> dataMap = new HashMap<>();
		dataMap.put("member_name", name);
		dataMap.put("member_email", email);

		return (String) sqlsession.selectOne("Member.selectFindId", dataMap);
	}

	public String getNick(int member_uid) {
		return (String)sqlsession.selectOne("Member.getNick", member_uid);
	}
	public MemberVo selectInfo(int member_uid) {
		return sqlsession.selectOne("Member.selectInfo",member_uid);
	}
	public void updateInfo(HashMap<String, Object> member_map) {
		sqlsession.update("Member.updateInfo",member_map);
	}
	public void insertProfile() {
		System.out.println("프로필등록");
		sqlsession.insert("Profiles.insertProfile");
	}
	public String selectProfile(int member_uid) {
		return sqlsession.selectOne("Profiles.selectProfile",member_uid);
	}
	public void deleteProfile(int member_uid) {
		sqlsession.update("Profiles.deleteProfile",member_uid);
	}
	public String updateProfile(int member_uid,MultipartRequest multi) {
		Enumeration<String> files = multi.getFileNames();
		HashMap<String, Object> fileMap = new HashMap<>();
		fileMap.put("member_uid", (int)member_uid);
		while (files.hasMoreElements()) {
			String data = files.nextElement();
			//if(multi.getFilesystemName(data) == null) {continue;}
			fileMap.put("file_name", multi.getFilesystemName(data));
			if(sqlsession.update("Profiles.updateProfile",fileMap)==1) {
				String file_name = multi.getFilesystemName(data);
				return file_name;
			}
		}
		return null;
	}
	public boolean findPw(String id, String email) {
		HashMap<String, String> dataMap = new HashMap<>();
		dataMap.put("member_id", id);
		dataMap.put("member_email", email);
		
		if((Integer)sqlsession.selectOne("Member.selectFindPw", dataMap) == 1) {
			return true;
		}
		return false;
	}
	
	public void updatePw(String id, String pw) {
		HashMap<String, String> dataMap = new HashMap<>();
		dataMap.put("member_id", id);
		dataMap.put("member_pw", pw);
		
		sqlsession.update("Member.updatePw", dataMap);
	}
	
	public boolean selectEmailCheck(String member_email) {
		if((Integer)sqlsession.selectOne("Member.selectEmailCheck", member_email) == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean selectEqualsNowPw(String member_id, String member_pw) {
		HashMap<String, String> dataMap = new HashMap<>();
		dataMap.put("member_id", member_id);
		dataMap.put("member_pw", member_pw);
		if((Integer)sqlsession.selectOne("Member.selectNowPw", dataMap) == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<BoardVo> selectMyBoard(int startRow, int endRow, int member_uid, String board_name) {
		HashMap<String, Object> dataMap = new HashMap<>();
		dataMap.put("startRow", startRow);
		dataMap.put("endRow", endRow);
		dataMap.put("member_uid", member_uid);
		dataMap.put("board_name", board_name);
		List<BoardVo> boardList = sqlsession.selectList("Member.selectMyBoard",dataMap);
		return boardList;
	}
	
	public int selectMyBoardCnt(int member_uid, String board_name) {
		HashMap<String, Object> dataMap = new HashMap<>();
		dataMap.put("member_uid", member_uid);
		dataMap.put("board_name", board_name);
		return sqlsession.selectOne("Member.selectMyBoardCnt",dataMap);
	}
	
	public void deleteMyBoard(int board_idx,String board_name) {
		HashMap<String, Object> dataMap = new HashMap<>();
		dataMap.put("board_idx", board_idx);
		dataMap.put("board_name", board_name);
		sqlsession.delete("Member.deleteMyBoardReComment",board_idx);
		sqlsession.delete("Member.deleteMyBoardComment",board_idx);
		sqlsession.delete("Member.deleteMyBoardFile",board_idx);
		sqlsession.delete("Member.deleteMyBoard",dataMap);
	}
	
	public List<BoardReportVo> selectReportReason(int board_idx) {
		List<BoardReportVo> boardReportList = sqlsession.selectList("Member.selectReportReason",board_idx);
		return boardReportList;
		
	}
	
	public boolean insertMemberReport(MemberReportVo memberReportVo) {
		if(sqlsession.insert("Member.insertMemberReport",memberReportVo)==1){
			return true;
		}
		return false;
	}
}
