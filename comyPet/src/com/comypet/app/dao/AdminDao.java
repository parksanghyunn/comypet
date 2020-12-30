package com.comypet.app.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.comypet.app.vo.AdminVo;
import com.comypet.app.vo.BoardReportReceiveVo;
import com.comypet.app.vo.BoardViewVo;
import com.comypet.app.vo.BoardVo;
import com.comypet.app.vo.CustomerBoardVo;
import com.comypet.app.vo.CustomerVo;
import com.comypet.app.vo.MemberReportReceiveVo;
import com.comypet.app.vo.MemberReportVo;
import com.comypet.app.vo.MemberVo;
import com.comypet.app.vo.NoticeBoardVo;
import com.comypet.mybatis.config.SqlMapConfig;

public class AdminDao {

	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	public AdminDao() {
		sqlsession = sessionf.openSession(true);
	}
	// 로그인
	public String adminLogin(String admin_id, String admin_pw) {

		HashMap<String, String>map = new HashMap<>();
		map.put("admin_id", admin_id);
		map.put("admin_pw", admin_pw);

		return (String)sqlsession.selectOne("Admin.selectAdminLogin",map);
	}
	// admin_uid 가져오기
	public int adminGetUid(String admin_id) {
		return sqlsession.selectOne("Admin.selectAdminUid", admin_id);
	}
	
	
	// admin 등급 가져오기
	public int adminGetLevel(String admin_id) {
		return sqlsession.selectOne("Admin.selectAdminLevel", admin_id);
	}

	// 등록된 어드민의 총 개수를 가져온다.
	public int getAdminCnt() {
		return sqlsession.selectOne("Admin.selectListCnt");
	}
	// 어드민 리스트 가져오기
	public List<AdminVo> getAdminList(int startRow, int endRow){
		HashMap<String, Integer> pageMap = new HashMap<>();

		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		List<AdminVo> adminList = sqlsession.selectList("Admin.selectListAll", pageMap);
		return adminList;

	}
	// 공지사항 게시글쓰기
	public boolean boardNoticeWrite(BoardVo b_vo, String session_id) {
		int admin_uid = sqlsession.selectOne("Admin.selectAdminUid", session_id);
		System.out.println(admin_uid);
		HashMap<Object, Object> notice_b = new HashMap<>();
		notice_b.put("board_idx", b_vo.getBoard_idx());
		notice_b.put("admin_uid", admin_uid);
		notice_b.put("board_title", b_vo.getBoard_title());
		notice_b.put("board_contents", b_vo.getBoard_contents());
		
		
		if(sqlsession.insert("Admin.insertBoardContentsNotice", notice_b) == 1) {
			return true;
		}
		return false;
	}
	
	// 자유게시판 게시글 검색
	public List<BoardViewVo> getBoardListF(String search, String searchCondition){

		if(searchCondition.equals("title")) {
			List<BoardViewVo> b_vo = sqlsession.selectList("Admin.selectAdminSearchBoardList_T", search);
			return b_vo;
		}else if(searchCondition.equals("context")) {
			List<BoardViewVo> b_vo = sqlsession.selectList("Admin.selectAdminSearchBoardList_C", search);
			return b_vo;
		}

		return null;
	}
	// 모임게시판 게시판검색
	public List<BoardViewVo> getBoardListM(String search, String searchCondition){

		if(searchCondition.equals("title")) {
			List<BoardViewVo> b_vo = sqlsession.selectList("Admin.selectAdminSearchBoardMList_T", search);
			return b_vo;
		}else if(searchCondition.equals("context")) {
			List<BoardViewVo> b_vo = sqlsession.selectList("Admin.selectAdminSearchBoardMList_C", search);
			return b_vo;
		}

		return null;
	}
	// 나눔게시판 게시판 검색
	public List<BoardViewVo> getBoardListN(String search, String searchCondition){

		if(searchCondition.equals("title")) {
			List<BoardViewVo> b_vo = sqlsession.selectList("Admin.selectAdminSearchBoardNList_T", search);
			return b_vo;
		}else if(searchCondition.equals("context")) {
			List<BoardViewVo> b_vo = sqlsession.selectList("Admin.selectAdminSearchBoardNList_C", search);
			return b_vo;
		}

		return null;
	}
	// 질문게시판 게시판 검색
	public List<BoardViewVo> getBoardListQ(String search, String searchCondition){

		if(searchCondition.equals("title")) {
			List<BoardViewVo> b_vo = sqlsession.selectList("Admin.selectAdminSearchBoardQList_T", search);
			return b_vo;
		}else if(searchCondition.equals("context")) {
			List<BoardViewVo> b_vo = sqlsession.selectList("Admin.selectAdminSearchBoardQList_C", search);
			return b_vo;
		}

		return null;
	}
	// 강아지갤러리 게시판 검색
	public List<BoardViewVo> getGalleryListP(String search, String searchCondition){

		if(searchCondition.equals("title")) {
			List<BoardViewVo> b_vo = sqlsession.selectList("Admin.selectAdminSearchGalleryPList_T", search);
			return b_vo;
		}else if(searchCondition.equals("context")) {
			List<BoardViewVo> b_vo = sqlsession.selectList("Admin.selectAdminSearchGalleryPList_C", search);
			return b_vo;
		}

		return null;
	}
	// 고양이갤러리 게시판 검색
	public List<BoardViewVo> getGalleryListC(String search, String searchCondition){

		if(searchCondition.equals("title")) {
			List<BoardViewVo> b_vo = sqlsession.selectList("Admin.selectAdminSearchGalleryCList_T", search);
			return b_vo;
		}else if(searchCondition.equals("context")) {
			List<BoardViewVo> b_vo = sqlsession.selectList("Admin.selectAdminSearchGalleryCList_C", search);
			return b_vo;
		}

		return null;
	}
	// 일상갤러리 게시판 검색
	public List<BoardViewVo> getGalleryListD(String search, String searchCondition){

		if(searchCondition.equals("title")) {
			List<BoardViewVo> b_vo = sqlsession.selectList("Admin.selectAdminSearchGalleryDList_T", search);
			return b_vo;
		}else if(searchCondition.equals("context")) {
			List<BoardViewVo> b_vo = sqlsession.selectList("Admin.selectAdminSearchGalleryDList_C", search);
			return b_vo;
		}

		return null;
	}
	// 기타갤러리 게시판 검색
	public List<BoardViewVo> getGalleryListE(String search, String searchCondition){

		if(searchCondition.equals("title")) {
			List<BoardViewVo> b_vo = sqlsession.selectList("Admin.selectAdminSearchGalleryEList_T", search);
			return b_vo;
		}else if(searchCondition.equals("context")) {
			List<BoardViewVo> b_vo = sqlsession.selectList("Admin.selectAdminSearchGalleryEList_C", search);
			return b_vo;
		}

		return null;
	}
	// admin검색
	public List<AdminVo> searchAdminList(String search, String searchCondition){
		if(searchCondition.equals("id")) {
			List<AdminVo> a_vo = sqlsession.selectList("Admin.selectAdminSearchId", search);
			return a_vo;
		}else if(searchCondition.equals("level")){
			List<AdminVo> a_vo = sqlsession.selectList("Admin.selectAdminSearchLevel", search);
			return a_vo;
		}

		return null;
	}
	// 회원검색
	public List<MemberVo> searchMemberList(String search,String searchCondition){
		if(searchCondition.equals("id")) {
			List<MemberVo> m_vo = sqlsession.selectList("Admin.selectAdminSearchMemberId", search);
			return m_vo;
		}else if(searchCondition.equals("name")) {
			List<MemberVo> m_vo = sqlsession.selectList("selectAdminSearchMemberName", search);
			return m_vo;
		}else if(searchCondition.equals("gender")) {
			List<MemberVo> m_vo = sqlsession.selectList("selectAdminSearchMemberGender", search);
			return m_vo;
		}

		return null;
	}


	// 자유게시판에 등록된 게시글 총 개수를 가져옴
	public int getAdminBoardFCnt() {
		return sqlsession.selectOne("Admin.selectBoardFListCnt");
	}

	public List<BoardViewVo> getAdminBoardFList(int startRow, int endRow){
		HashMap<String, Integer> pageMap = new HashMap<>();

		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		List<BoardViewVo> boardFList = sqlsession.selectList("Admin.selectBoardFListAll", pageMap);
		return boardFList;

	}
	// 모임게시판 총 게시글 가져옴
	public int getAdminBoardMCnt() {
		return sqlsession.selectOne("Admin.selectBoardMListCnt");
	}

	public List<BoardViewVo> getAdminBoardMList(int startRow, int endRow){
		HashMap<String, Integer> pageMap = new HashMap<>();

		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		List<BoardViewVo> boardFList = sqlsession.selectList("Admin.selectBoardMListAll", pageMap);
		return boardFList;

	}

	// 나눔게시판 게시글 가져오기
	public int getAdminBoardNCnt() {
		return sqlsession.selectOne("Admin.selectBoardNListCnt");
	}

	public List<BoardViewVo> getAdminBoardNList(int startRow, int endRow){
		HashMap<String, Integer> pageMap = new HashMap<>();

		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		List<BoardViewVo> boardFList = sqlsession.selectList("Admin.selectBoardNListAll", pageMap);
		return boardFList;

	}
	// 질문게시판 총 게시글 가져오기
	public int getAdminBoardQCnt() {
		return sqlsession.selectOne("Admin.selectBoardQListCnt");
	}

	public List<BoardViewVo> getAdminBoardQList(int startRow, int endRow){
		HashMap<String, Integer> pageMap = new HashMap<>();

		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		List<BoardViewVo> boardFList = sqlsession.selectList("Admin.selectBoardQListAll", pageMap);
		return boardFList;

	}
	// 강아지갤러리 총 게시글 가져오기
	public int getAdminGalleryPCnt() {
		return sqlsession.selectOne("Admin.selectGalleryPListCnt");
	}

	public List<BoardViewVo> getAdminGalleryPList(int startRow, int endRow){
		HashMap<String, Integer> pageMap = new HashMap<>();

		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		List<BoardViewVo> boardFList = sqlsession.selectList("Admin.selectGalleryPListAll", pageMap);
		return boardFList;

	}

	// 고양이갤러리 총 게시글 가져오기
	public int getAdminGalleryCCnt() {
		return sqlsession.selectOne("Admin.selectGalleryCListCnt");
	}

	public List<BoardViewVo> getAdminGalleryCList(int startRow, int endRow){
		HashMap<String, Integer> pageMap = new HashMap<>();

		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		List<BoardViewVo> boardFList = sqlsession.selectList("Admin.selectGalleryCListAll", pageMap);
		return boardFList;

	}

	// 일상갤러리 총 게시글 가져오기
	public int getAdminGalleryDCnt() {
		return sqlsession.selectOne("Admin.selectGalleryDListCnt");
	}

	public List<BoardViewVo> getAdminGalleryDList(int startRow, int endRow){
		HashMap<String, Integer> pageMap = new HashMap<>();

		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		List<BoardViewVo> boardFList = sqlsession.selectList("Admin.selectGalleryDListAll", pageMap);
		return boardFList;

	}

	// 기타갤러리 총 게시글 가져오기
	public int getAdminGalleryECnt() {
		return sqlsession.selectOne("Admin.selectGalleryEListCnt");
	}

	public List<BoardViewVo> getAdminGalleryEList(int startRow, int endRow){
		HashMap<String, Integer> pageMap = new HashMap<>();

		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		List<BoardViewVo> boardFList = sqlsession.selectList("Admin.selectGalleryEListAll", pageMap);
		return boardFList;

	}
	// 자유게시판 블라인드처리
	public void blindBoardF(int board_idx, int board_blind) {
		HashMap<String, Integer> board = new HashMap<>();
		board.put("board_idx", board_idx);
		board.put("board_blind", board_blind);
		sqlsession.update("Admin.updateBlindBoardF", board);
	}
	// 모임게시판 블라인드처리
	public void blindBoardM(int board_idx, int board_blind) {
		HashMap<String, Integer> board = new HashMap<>();
		board.put("board_idx", board_idx);
		board.put("board_blind", board_blind);
		sqlsession.update("Admin.updateBlindBoardM", board);
	}
	// 나눔게시판 블라인드처리
	public void blindBoardN(int board_idx, int board_blind) {
		HashMap<String, Integer> board = new HashMap<>();
		board.put("board_idx", board_idx);
		board.put("board_blind", board_blind);
		sqlsession.update("Admin.updateBlindBoardN", board);
	}
	// 질문게시판 블라인드처리
	public void blindBoardQ(int board_idx, int board_blind) {
		HashMap<String, Integer> board = new HashMap<>();
		board.put("board_idx", board_idx);
		board.put("board_blind", board_blind);
		sqlsession.update("Admin.updateBlindBoardQ", board);
	}
	// 강아지갤러리 블라인드처리
	public void blindGalleryP(int board_idx, int board_blind) {
		HashMap<String, Integer> board = new HashMap<>();
		board.put("board_idx", board_idx);
		board.put("board_blind", board_blind);
		sqlsession.update("Admin.updateBlindGalleryP", board);
	}
	// 고양이갤러리 블라인드처리
	public void blindGalleryC(int board_idx, int board_blind) {
		HashMap<String, Integer> board = new HashMap<>();
		board.put("board_idx", board_idx);
		board.put("board_blind", board_blind);
		sqlsession.update("Admin.updateBlindGalleryC", board);
	}
	// 일상갤러리 블라인드처리
	public void blindGalleryD(int board_idx, int board_blind) {
		HashMap<String, Integer> board = new HashMap<>();
		board.put("board_idx", board_idx);
		board.put("board_blind", board_blind);
		sqlsession.update("Admin.updateBlindGalleryD", board);
	}
	// 기타갤러리 블라인드처리
	public void blindGalleryE(int board_idx, int board_blind) {
		HashMap<String, Integer> board = new HashMap<>();
		board.put("board_idx", board_idx);
		board.put("board_blind", board_blind);
		sqlsession.update("Admin.updateBlindGalleryE", board);
	}
	// 반려동물 찾기 게시판 블라인드 처리
	public void blindBoardL(int board_idx, int board_blind) {
		HashMap<String, Integer> board = new HashMap<>();
		board.put("board_idx", board_idx);
		board.put("board_blind", board_blind);
		sqlsession.update("Admin.updateBlindBoardL", board);
	}
	// 불편사항 게시판 블라인드 처리
	public void blindBoardSug(int board_idx, int board_blind) {
		HashMap<String, Integer> board = new HashMap<>();
		board.put("board_idx", board_idx);
		board.put("board_blind", board_blind);
		sqlsession.update("Admin.updateBlindBoardSug", board);
	}

	// admin 아이디 중복체크
	public boolean adminCheckId(String admin_id) {

		if((Integer)sqlsession.selectOne("Admin.selectAdminCheckId",admin_id) == 1) {
			return true;
		}
		return false;
	}

	// admin 추가
	public boolean adminAdd(AdminVo admin) {
		if(sqlsession.insert("Admin.selectAdminAdd", admin)==1) {
			return true;
		}
		return false;
	}

	// 등록된 회원 총 개수를 가져온다.
	public int getMemberCnt() {
		return sqlsession.selectOne("Admin.selectMemberListCnt");
	}

	public List<MemberVo> getMemberList(int startRow, int endRow){
		HashMap<String, Integer> pageMap = new HashMap<>();

		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		List<MemberVo> memberList = sqlsession.selectList("Admin.selectMemberListAll", pageMap);
		return memberList;
	}

	// 회원정보 수정
	public void updateMember(MemberVo m_vo){
		sqlsession.update("Admin.updateMember", m_vo);
	}
	//-------------------------------------------------------------------------------------------------------------------------------
	//반려동물 찾기 게시판
	//모든 게시글 가져오기
	public List<BoardViewVo> getAdminBoardLList(int startRow, int endRow){
		HashMap<String, Integer> pageMap = new HashMap<>();

		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		List<BoardViewVo> boardLList = sqlsession.selectList("Admin.selectBoardLListAll", pageMap);
		return boardLList;

	}

	//게시글 갯수 가져오기
	public int getAdminBoardLCnt() {
		return sqlsession.selectOne("Admin.selectBoardLListCnt");
	}

	//검색한 게시글 가져오기
	public List<BoardViewVo> getBoardListL(String search, String searchCondition){

		//제목으로 검색
		if(searchCondition.equals("title")) {
			List<BoardViewVo> b_vo = sqlsession.selectList("Admin.selectAdminSearchBoardLList_T", search);
			return b_vo;
			//내용으로 검색
		}else if(searchCondition.equals("context")) {
			List<BoardViewVo> b_vo = sqlsession.selectList("Admin.selectAdminSearchBoardLList_C", search);
			return b_vo;
		}

		return null;
	}

	//광고문의
	public List<CustomerVo> getAdminAdsBoardList(int startRow, int endRow){
		HashMap<String, Integer> pageMap = new HashMap<>();

		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		List<CustomerVo> AdsList = sqlsession.selectList("Admin.selectAdsBoardAllList", pageMap);
		return AdsList;

	}
	
	//광고문의 게시글 갯수 가져오기
	public int getAdminAdsBoardCnt() {
		return sqlsession.selectOne("Admin.selectAdsBoardListCnt");
	}
	
	
	//제휴문의
	public List<CustomerVo> getAdminSupBoardList(int startRow, int endRow){
		HashMap<String, Integer> pageMap = new HashMap<>();

		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		List<CustomerVo> SupList = sqlsession.selectList("Admin.selectSupBoardAllList", pageMap);
		return SupList;

	}
	
	//제휴문의 게시글 갯수 가져오기
	public int getAdminSupBoardCnt() {
		return sqlsession.selectOne("Admin.selectSupBoardListCnt");
	}

	//불편사항
	public List<BoardViewVo> getAdminBoardListS(int startRow, int endRow){
		HashMap<String, Integer> pageMap = new HashMap<>();

		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		List<BoardViewVo> sugList = sqlsession.selectList("Admin.selectSugBoardAllList", pageMap);
		return sugList;

	}

	//게시글 갯수 가져오기
	public int getAdminBoardSCnt() {
		return sqlsession.selectOne("Admin.selectBoardSListCnt");
	}

	//검색한 게시글 가져오기
	public List<BoardViewVo> getBoardListS(String search, String searchCondition){

		//제목으로 검색
		if(searchCondition.equals("title")) {
			List<BoardViewVo> b_vo = sqlsession.selectList("Admin.selectAdminSearchBoardSList_T", search);
			return b_vo;
			//내용으로 검색
		}else if(searchCondition.equals("context")) {
			List<BoardViewVo> b_vo = sqlsession.selectList("Admin.selectAdminSearchBoardSList_C", search);
			return b_vo;
		}

		return null;
	}

	//공지사항
	//모든 게시글 가져오기
	public List<BoardViewVo> getAdminBoardNoticeList(int startRow, int endRow){
		HashMap<String, Integer> pageMap = new HashMap<>();

		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		List<BoardViewVo> boardLList = sqlsession.selectList("Admin.selectBoardNoticeListAll", pageMap);
		return boardLList;

	}

	//게시글 갯수 가져오기
	public int getAdminBoardNoticeCnt() {
		return sqlsession.selectOne("Admin.selectBoardNoticeListCnt");
	}

	//검색한 게시글 가져오기
	public List<BoardViewVo> getBoardListNotice(String search, String searchCondition){

		//제목으로 검색
		if(searchCondition.equals("title")) {
			List<BoardViewVo> b_vo = sqlsession.selectList("Admin.selectAdminSearchBoardNoticeList_T", search);
			return b_vo;
			//내용으로 검색
		}else if(searchCondition.equals("context")) {
			List<BoardViewVo> b_vo = sqlsession.selectList("Admin.selectAdminSearchBoardNoticeList_C", search);
			return b_vo;
		}

		return null;
	}
	// 공지사항 게시글 정보 가져오기
	public NoticeBoardVo noticeBoardGetDetail(int board_idx) {
		return sqlsession.selectOne("Admin.selectBoardNoticeGetDetail", board_idx);
	}
	// 공지사항 게시글 이미지 삭제
	public void deleteBoardFiles(int board_num) {
		sqlsession.delete("Admin.deleteBoardFile", board_num);
	}
	// 공지사항 게시글 삭제
	public void deleteBoardNotice(int board_idx) {
		sqlsession.delete("Admin.deleteBoardNotice", board_idx);
	}
	// 이미지 삭제를 위한 경로 가져오기
	public String boardGetPath(int board_num) {
		String path = sqlsession.selectOne("Admin.selectBoardFileGetDetail", board_num);
		return path;
	}
	
	
	//-------------------------------------------------------------------------------------------------------------------------------
	//신고된 유저 가져오기
	public List<MemberReportReceiveVo> getAdminMemberReportReceiveList(int report_state, int startRow, int endRow){
		HashMap<String, Integer> pageMap = new HashMap<>();
		
		pageMap.put("report_state", report_state);
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		List<MemberReportReceiveVo> reportReceiveList = sqlsession.selectList("Admin.selectMemberReportReceiveList", pageMap);
		return reportReceiveList;

	}
	//검색한 신고된 유저 가져오기
	public List<MemberReportReceiveVo> getAdminMemberReportReceiveSearchList(int report_state,String search, String searchCondition,int startRow, int endRow){
		HashMap<String, Object>searchMap = new HashMap<>();
		System.out.println("다오 들어옴");
		searchMap.put("report_state", report_state);
		searchMap.put("startRow", startRow);
		searchMap.put("endRow", endRow);
		//제목으로 검색
		if(searchCondition.equals("nick")) {
			searchMap.put("search", search);
			
			List<MemberReportReceiveVo> mr_vo = sqlsession.selectList("Admin.selectMemberReportReceiveSearchNickList", searchMap);
			
			return mr_vo;
			//내용으로 검색
		}else if(searchCondition.equals("type")) {
			searchMap.put("search", search);
			List<MemberReportReceiveVo> mr_vo = sqlsession.selectList("Admin.selectMemberReportReceiveSearchTypeList", searchMap);
			return mr_vo;
		}

		return null;
	}
	
	//게시글 갯수 가져오기
	public int getMemberReportReceiveListCnt() {
		return sqlsession.selectOne("Admin.selectMemberReportReceiveListCnt");
	}
	
	//신고된 사람 상태 처리하기
	public void updateReportState(int report_state, int report_uid) {
		HashMap<String, Integer> report = new HashMap<>();
		report.put("report_state", report_state);
		report.put("report_uid", report_uid);
		sqlsession.update("Admin.updateReportState", report);
		
	}
	
	public void updateReporterState(int member_state, int reporter) {
		HashMap<String, Integer> memberState = new HashMap<>();
		memberState.put("member_mute_comment", member_state);
		memberState.put("member_mute_contents", member_state);
		memberState.put("reporter", reporter);
		sqlsession.update("Admin.updateMemberState", memberState);
	}
	//------------------------------------------
	//신고된 게시판 가져오기
	public List<BoardReportReceiveVo> getAdminBoardReportReceiveList(int report_state, int startRow, int endRow){
		HashMap<String, Integer> pageMap = new HashMap<>();
		HashMap<String, Object> titleMap = new HashMap<>();
		
		pageMap.put("report_state", report_state);
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		List<BoardReportReceiveVo> reportReceiveList = sqlsession.selectList("Admin.selectBoardReportReceiveList", pageMap);
		if(reportReceiveList.size() > 0) {
			
			for (int i =0;i < reportReceiveList.size(); i++) {
				int board_state = reportReceiveList.get(i).getBoard_state();
				String board_name = "";
				
				switch(board_state) {
				case 0 : 
					board_name = "CMPP_NOTICE_BOARD";
					break;
				case 1:
					board_name = "CMPP_FREE_BOARD";
					break;
				case 2:
					board_name = "CMPP_MEET_BOARD";
					break;
				case 3:
					board_name = "CMPP_FRA_BOARD";
					break;
				case 4:
					board_name = "CMPP_QNA_BOARD";
					break;
				case 5:
					board_name = "CMPP_PUPPY_GALLERY";
					break;
				case 6:
					board_name = "CMPP_CAT_GALLERY";
					break;
				case 7:
					board_name = "CMPP_DETAIL_GALLERY";
					break;
				case 8:
					board_name = "CMPP_ETC_GALLERY";
					break;
				case 9:
					board_name = "CMPP_LOST_BOARD";
					break;
				case 10:
					board_name = "CMPP_SUG_BOARD";
					break;
				default:
					break;
				}
				titleMap.put("board_name", board_name);
				titleMap.put("board_idx", reportReceiveList.get(i).getBoard_idx());
				
				reportReceiveList.get(i).setB_title(sqlsession.selectOne("Admin.selectBoardTitleList", titleMap));
				reportReceiveList.get(i).setB_contents(sqlsession.selectOne("Admin.selectBoardContents", titleMap));
				titleMap.clear();
			}
		}
		
		 /*
   		0 : 공지사항
	 	1 : 자유 게시판
	 	2 : 모임 게시판
	 	3 : 나눔 게시판
	 	4 : 질문 게시판
	 	5 : 강아지 갤러리
	 	6 : 고양이 갤러리
	 	7 : 일상 공유 게시판
	 	8 : 기타 갤러리
	 	9 : 반려동물 찾기 게시판
	 	10 : 불편사항 게시판
   */
		
		

		 
		return reportReceiveList;

	}
	
	//신고된 게시글 갯수 가져오기
	public int getBoardReportReceiveListCnt() {
		return sqlsession.selectOne("Admin.selectBoardReportReceiveListCnt");
	}

	//-------------------------------------------------------------------------------------------------------------------------------
	
	//신고된 게시판 상태 처리하기
	public void updateBoardReportState(int report_state, int report_uid) {
		HashMap<String, Integer> report = new HashMap<>();
		report.put("report_state", report_state);
		report.put("report_uid", report_uid);
		sqlsession.update("Admin.updateBoardReportState", report);
		
	}
	
	public void updateBoardState(String board_name, int board_blind, int board_idx) {
		HashMap<String, Object> boardState = new HashMap<>();
		boardState.put("board_name",board_name);
		boardState.put("board_blind", board_blind);
		boardState.put("board_idx", board_idx);
		sqlsession.update("Admin.updateBoardState", boardState);
	}
	
	//검색한 신고된 게시판 가져오기
	public List<BoardReportReceiveVo> getAdminBoardReportReceiveSearchList(int report_state,String search, String searchCondition,int startRow, int endRow){
		HashMap<String, Object>searchMap = new HashMap<>();
		System.out.println("다오 들어옴");
		searchMap.put("report_state", report_state);
		searchMap.put("startRow", startRow);
		searchMap.put("endRow", endRow);
		//제목으로 검색
		if(searchCondition.equals("nick")) {
			searchMap.put("search", search);
			
			List<BoardReportReceiveVo> mr_vo = sqlsession.selectList("Admin.selectBoardReportReceiveSearchNickList", searchMap);
			
			return mr_vo;
			//내용으로 검색
		}else if(searchCondition.equals("type")) {
			searchMap.put("search", search);
			List<BoardReportReceiveVo> mr_vo = sqlsession.selectList("Admin.selectBoardReportReceiveSearchTypeList", searchMap);
			return mr_vo;
		}

		return null;
	}
}
