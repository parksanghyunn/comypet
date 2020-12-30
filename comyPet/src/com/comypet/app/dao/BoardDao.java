package com.comypet.app.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.comypet.app.vo.BoardCommentNickVo;
import com.comypet.app.vo.BoardCommentVo;
import com.comypet.app.vo.BoardReCommentNickVo;
import com.comypet.app.vo.BoardReportVo;
import com.comypet.app.vo.BoardViewVo;
import com.comypet.app.vo.BoardVo;
import com.comypet.app.vo.NoticeViewVo;
import com.comypet.mybatis.config.SqlMapConfig;

public class BoardDao {
	
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public BoardDao() {
		sqlsession = sessionf.openSession(true);
	}
	
	public boolean insertBoardContents(String board_name, int idx, int uid, String title,String contents, int state) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("board_name", board_name);
		map.put("board_idx", idx);
		map.put("member_uid", uid);
		map.put("board_title", title);
		map.put("board_contents", contents);
		map.put("board_state", state);
		if(sqlsession.insert("Board.insertBoardContents", map) == 1){
			return true;
		}
		return false;
	}
	
	public int incrementSeq() {
		return sqlsession.selectOne("Board.selectSeq");
	}
	
	public List<BoardViewVo> selectBoardList(int startRow, int endRow,String board_name){
		HashMap<String, Object> pageMap = new HashMap<>();

		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		pageMap.put("board_name", board_name);

		List<BoardViewVo> boardList = sqlsession.selectList("Board.selectBoardList", pageMap);
		return boardList;
	}
	
	public int selectBoardCnt(String board_name) {
		return sqlsession.selectOne("Board.selectBoardCnt",board_name);
	}
	public List<NoticeViewVo> selectNoticeBoardList(int startRow, int endRow){
		HashMap<String, Object> pageMap = new HashMap<>();
		
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		
		List<NoticeViewVo> boardList = sqlsession.selectList("Board.selectNoticeBoardListGet", pageMap);
		return boardList;
	}
	
	public int selectNoticeBoardCnt() {
		return sqlsession.selectOne("Board.selectNoticeBoardCntGet");
	}
	public BoardViewVo selectBoardView(int board_idx,String board_name) {
		HashMap<String, Object> datamap = new HashMap<>();
		datamap.put("board_idx", board_idx);
		datamap.put("board_name", board_name);
		return sqlsession.selectOne("Board.selectBoardDetail",datamap);
	}
	public NoticeViewVo selectNoticeBoardView(int board_idx) {
		return sqlsession.selectOne("Board.selectNoticeBoardDetail",board_idx);
	}
	
	public int selectBoardUpCnt(int board_idx, int member_uid) {
		HashMap<String, Object> datamap = new HashMap<>();
		datamap.put("board_idx", board_idx);
		datamap.put("member_uid", member_uid);
		return sqlsession.selectOne("Board.selectBoardUpCnt",datamap);
	}
	public void updateBoardUpCnt(int board_idx, String board_name) {
		HashMap<String, Object> datamap = new HashMap<>();
		datamap.put("board_idx", board_idx);
		datamap.put("board_name", board_name);
		sqlsession.update("Board.updateBoardUpCnt",datamap);
	}
	public void insertBoardUpCnt(int board_idx,int member_uid, int board_state) {
		HashMap<String, Integer> datamap = new HashMap<>();
		datamap.put("board_idx", board_idx);
		datamap.put("member_uid", member_uid);
		datamap.put("board_state", board_state);
		sqlsession.insert("Board.insertBoardUpCnt",datamap);
		
	}
	public int selectBoardDownCnt(int board_idx, int member_uid) {
		HashMap<String, Object> datamap = new HashMap<>();
		datamap.put("board_idx", board_idx);
		datamap.put("member_uid", member_uid);
		return sqlsession.selectOne("Board.selectBoardDownCnt",datamap);
	}
	public void updateBoardDownCnt(int board_idx, String board_name) {
		HashMap<String, Object> datamap = new HashMap<>();
		datamap.put("board_idx", board_idx);
		datamap.put("board_name", board_name);
		sqlsession.update("Board.updateBoardDownCnt",datamap);
	}
	public void insertBoardDownCnt(int board_idx,int member_uid, int board_state) {
		HashMap<String, Integer> datamap = new HashMap<>();
		datamap.put("board_idx", board_idx);
		datamap.put("member_uid", member_uid);
		datamap.put("board_state", board_state);
		sqlsession.insert("Board.insertBoardDownCnt",datamap);
		
	}
	
	public boolean insertBoardReport(BoardReportVo boardReportVo) {
		if(sqlsession.insert("Board.insertBoardReport",boardReportVo) == 1) {
			return true;
		}
		return false;
	}
	
	public boolean updateBoardBlind(String board_name,int board_idx) {
		HashMap<String, Object> datamap = new HashMap<>();
		datamap.put("board_idx", board_idx);
		datamap.put("board_name", board_name);
		if(sqlsession.update("Board.updateBoardBlind",datamap) ==1){
			return true;
		}
		return false;
	}
	public void insertBoardComment(BoardCommentVo boardCommentVo) {
		sqlsession.insert("Board.insertBoardComment",boardCommentVo);
	}
	public void insertBoardReComment(HashMap<String, Object> dataMap) {
		sqlsession.insert("Board.insertBoardReComment",dataMap);
	}
	
	public List<BoardCommentNickVo> selectBoardComment(int board_idx) {
		List<BoardCommentNickVo> boardCommentList = sqlsession.selectList("Board.selectBoardComment",board_idx);
		return boardCommentList;
	}
	public int selectBoardCommentCnt(int board_idx) {
		return sqlsession.selectOne("Board.selectBoardCommentCnt",board_idx);
	}
	
	public List<BoardReCommentNickVo> selectBoardReComment(int board_idx) {
		List<BoardReCommentNickVo> boardReCommentList = sqlsession.selectList("Board.selectBoardReComment",board_idx);
		return boardReCommentList;
	}
	public int selectBoardReCommentCnt(int board_idx) {
		return sqlsession.selectOne("Board.selectBoardReCommentCnt",board_idx);
	}
	public boolean deleteComment(int comment_idx) {
		if(sqlsession.delete("Board.deleteComment",comment_idx) !=-1) {
			return true;
		}
		return false;
	}
	
	public boolean deleteReComment(int re_comment_idx) {
		if(sqlsession.delete("Board.deleteReComment",re_comment_idx) !=-1) {
				return true;
		}
		return false;
	}
	
	public boolean updateComment(int comment_idx, String comment_content) {
		HashMap<String, Object> dataMap = new HashMap<>();
		dataMap.put("comment_idx", (int)comment_idx);
		dataMap.put("comment_content", comment_content.toString());
		
		if(sqlsession.update("Board.updateComment",dataMap)!=0) {
			return true;
		}
		return false;
	}
	public boolean updateReComment(int re_comment_idx, String re_comment_content) {
		HashMap<String, Object> dataMap = new HashMap<>();
		dataMap.put("re_comment_idx", (int)re_comment_idx);
		dataMap.put("re_comment_content", re_comment_content.toString());
		
		if(sqlsession.update("Board.updateReComment",dataMap)!=0) {
			return true;
		}
		return false;
	}
	public void updateReadCnt(int board_idx,String board_name) {
		HashMap<String, Object> dataMap = new HashMap<>();
		dataMap.put("board_idx", (int)board_idx);
		dataMap.put("board_name", board_name.toString());
		
		sqlsession.update("Board.updateReadCnt",dataMap);
	}
	
	public List<Map<String, Object>> selectNoticeBoardList() {
		List<Map<String, Object>> boardNoitceList =sqlsession.selectList("Board.selectNoticeBoardList");
		return boardNoitceList;
	}
	
	public List<HashMap<String, String>> selectHotBoardList() {
		List<Map<String, Object>> boardHotList = sqlsession.selectList("Board.selectHotBoardList");
		ArrayList<HashMap<String, String>> hotBoatTitleList = new ArrayList<>();
		for (int i = 0; i < boardHotList.size(); i++) {
			int board_state =  Integer.parseInt(String.valueOf(boardHotList.get(i).get("BOARD_STATE")));
			int board_idx = Integer.parseInt(String.valueOf(boardHotList.get(i).get("BOARD_IDX")));
			String board_name="";
			String title= "";
			HashMap<String, String> titleMap = new HashMap<String, String>();
			HashMap<String, Object> map = new HashMap<>();
			switch (board_state) {
			case 1:
				board_name = "free";
				map.put("board_name", board_name);
				map.put("board_idx", board_idx);
				title = sqlsession.selectOne("Board.selectHotBoardTitleList",map);
				titleMap.put("BOARD_TITLE", title);
				break;
			case 2:
				board_name = "meet";
				map.put("board_name", board_name);
				map.put("board_idx", board_idx);
				title = sqlsession.selectOne("Board.selectHotBoardTitleList",map);
				titleMap.put("BOARD_TITLE", title);
				break;
			case 3:
				board_name = "fra";
				map.put("board_name", board_name);
				map.put("board_idx", board_idx);
				title = sqlsession.selectOne("Board.selectHotBoardTitleList",map);
				titleMap.put("BOARD_TITLE", title);
				break;
			case 4:
				board_name = "qna";
				map.put("board_name", board_name);
				map.put("board_idx", board_idx);
				title =  sqlsession.selectOne("Board.selectHotBoardTitleList",map);
				titleMap.put("BOARD_TITLE", title);
				break;
			}
			hotBoatTitleList.add(titleMap);
		}
		return hotBoatTitleList;
	}
	
	public List<BoardVo> selectBoardContents(String board_name, int idx, int uid, int state) {
		HashMap<String, Object> datamap = new HashMap<>();
		datamap.put("board_name", board_name);
		datamap.put("board_idx", idx);
		datamap.put("member_uid", uid);
		datamap.put("board_state", state);
		List<BoardVo> boardContents = sqlsession.selectList("Board.selectBoardContents", datamap);
		return boardContents;
	}

	public boolean updataBoardContents(String board_name,int idx, int uid, String title, String contents, int state) {
		HashMap<String, Object> datamap = new HashMap<>();
		datamap.put("board_name", board_name);
		datamap.put("board_idx", idx);
		datamap.put("member_uid", uid);
		datamap.put("board_title", title);
		datamap.put("board_contents", contents);
		datamap.put("board_state", state);
		int num = sqlsession.update("Board.updateBoardContents", datamap);
		if(num == 1) {
			return true;
		}
		return false;
	}

	public List<Map<String,Object>> selectIndexxGalleryDogList() {
		List<Map<String,Object>> dogList = sqlsession.selectList("Board.selectIndexxGalleryDogList");
		return dogList;
	}

	public List<Map<String,Object>> selectIndexxGalleryCatList() {
		List<Map<String,Object>> catList = sqlsession.selectList("Board.selectIndexxGalleryCatList");
		return catList;
	}

	public List<Map<String,Object>> selectIndexxGalleryFindList() {
		List<Map<String,Object>> findList = sqlsession.selectList("Board.selectIndexxGalleryFindList");
		return findList;
	}
	
	public List<Map<String,Object>> selectIndexxGalleryEtcList() {
		List<Map<String,Object>> etcList = sqlsession.selectList("Board.selectIndexxGalleryEtcList");
		return etcList;
	}
	
	public List<BoardViewVo> selectIndexxFraBoardList() {
		List<BoardViewVo> fraList = sqlsession.selectList("Board.selectIndexxFraBoardList");
		return fraList;
	}

	public List<BoardViewVo> selectIndexxFreeBoardList() {
		List<BoardViewVo> freeList = sqlsession.selectList("Board.selectIndexxFreeBoardList");
		return freeList;
	}

	public List<BoardViewVo> selectIndexxMeetBoardList() {
		List<BoardViewVo> meetList = sqlsession.selectList("Board.selectIndexxMeetBoardList");
		return meetList;
	}

	public List<Map<String, Object>> selectIndexxGalleryList(int startRow, int endRow, String board_name) {
		HashMap<String, Object> pageMap = new HashMap<>();

		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		pageMap.put("board_name", board_name);
		
		List<Map<String,Object>> galleryList = sqlsession.selectList("Board.selectIndexxGalleryList", pageMap);
		return galleryList;
	}

}
