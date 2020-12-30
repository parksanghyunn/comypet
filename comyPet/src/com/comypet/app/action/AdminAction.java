package com.comypet.app.action;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.comypet.action.Action;
import com.comypet.action.ActionForward;
import com.comypet.app.dao.AdminDao;
import com.comypet.app.dao.BoardDao;
import com.comypet.app.dao.BoardFilesDao;
import com.comypet.app.vo.AdminVo;
import com.comypet.app.vo.BoardReportReceiveVo;
import com.comypet.app.vo.BoardViewVo;
import com.comypet.app.vo.BoardVo;
import com.comypet.app.vo.MemberReportReceiveVo;
import com.comypet.app.vo.MemberVo;
import com.comypet.app.vo.NoticeBoardVo;
import com.comypet.utils.Utils;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdminAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, String type) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		switch(type) {
		case "AdminAddOkAction":
			forward = AdminAddOkAction(request,response);
			return forward;
		case "AdminCheckIdOkAction":
			forward = AdminCheckIdOkAction(request, response);
			return forward;
		case "AdminListOk":
			forward = AdminListOk(request, response);
			return forward;
		case "AdminLoginOkAction":
			forward = AdminLoginOkAction(request, response);
			return forward;
		case "AdminUpdateMemberOkAction":
			forward = AdminUpdateMemberOkAction(request, response);
			return forward;
		case "MemberListOk":
			forward = MemberListOk(request, response);
			return forward;
		case "AdminBoardListF":
			forward = AdminBoardListF(request, response);
			return forward;
		case "AdminBoardListM":
			forward = AdminBoardListM(request,response);
			return forward;
		case "AdminBoardListN":
			forward = AdminBoardListN(request,response);
			return forward;
		case "AdminBoardListQ":
			forward = AdminBoardListQ(request,response);
			return forward;
		case "AdminSearchBoardF":
			forward= AdminSearchBoardF(request,response);
			return forward;
		case "AdminSearchBoardM":
			forward= AdminSearchBoardM(request,response);
			return forward;
		case "AdminSearchBoardN":
			forward= AdminSearchBoardN(request,response);
			return forward;
		case "AdminSearchBoardQ":
			forward= AdminSearchBoardQ(request,response);
			return forward;
		case "AdminSearchGalleryP":
			forward = AdminSearchGalleryP(request, response);
			return forward;
		case "AdminSearchGalleryC":
			forward = AdminSearchGalleryC(request, response);
			return forward;
		case "AdminSearchGalleryD":
			forward = AdminSearchGalleryD(request, response);
			return forward;
		case "AdminSearchGalleryE":
			forward = AdminSearchGalleryE(request, response);
			return forward;
		case "AdminGalleryListP":
			forward = AdminGalleryListP(request, response);
			return forward;
		case "AdminGalleryListC":
			forward = AdminGalleryListC(request, response);
			return forward;
		case "AdminGalleryListD":
			forward = AdminGalleryListD(request, response);
			return forward;
		case "AdminGalleryListE":
			forward = AdminGalleryListE(request, response);
			return forward;
		case "AdminSearchAdminOk":
			forward = AdminSearchAdminOk(request,response);
			return forward;
		case "AdminSearchMemberOk":
			forward = AdminSearchMemberOk(request, response);
			return forward;
			// 게시판 블라인드 처리
		case "AdminBlindFOk":
			forward = AdminBlindF(request, response);
			return forward;
		case "AdminBlindMOk":
			forward = AdminBlindM(request, response);
			return forward;
		case "AdminBlindNOk":
			forward = AdminBlindN(request, response);
			return forward;
		case "AdminBlindQOk":
			forward = AdminBlindQ(request, response);
			return forward;
			// 갤러리 블라인드처리
		case "AdminBlindPOk":
			forward = AdminBlindP(request, response);
			return forward;
		case "AdminBlindCOk":
			forward = AdminBlindC(request, response);
			return forward;
		case "AdminBlindDOk":
			forward = AdminBlindD(request, response);
			return forward;
		case "AdminBlindEOk":
			forward = AdminBlindE(request, response);
			return forward;
			// 반려동물 찾기 게시판 블라인드 처리
		case "AdminBlindLOk":
			forward = AdminBlindL(request, response);
			return forward;
			// 불편사항 게시판 블라인드 처리
		case "AdminBlindSugOk":
			forward = AdminBlindSug(request, response);
			return forward;
			//-------------------------------------------------------------------------------------------------------------------------------
		      //반려동물 찾기
		case "AdminBoardListL":
	         forward = AdminBoardListL(request, response);
	         return forward;
	      //불편사항
         case "AdminBoardListS":
	         forward = AdminBoardListS(request,response);
	         return forward;
	      //공지사항
         case "AdminBoardListNotice":
	         forward = AdminBoardListNotice(request,response);
	         return forward;
	      //광고문의
         case "AdminAdsBoardList":
	         forward = AdminAdsBoardList(request, response);
	         return forward;
		      //제휴문의
         case "AdminSupBoardList":
	         forward = AdminSupBoardList(request, response);
	         return forward;
         case "AdminMemberReportReceive":
	    	  forward = AdminMemberReportReceiveListOkAction(request, response);
	    	  return forward;
    	  case "AdminMemberReportReceiveSearch":
	    	  forward = AdminMemberReportReceiveSearchListOkAction(request, response);
	    	  return forward;
    	  case "MemberReportStateUpdate":
	    	  forward = MemberReportStateUpdateOkAction(request, response);
	    	  return forward;
	      case "AdminBoardReportReceive":
	    	  forward = AdminBoardReportReceiveListOkAction(request, response);
	    	  return forward;
    	  case "AdminSearchBoardL":
			forward = AdminSearchBoardL(request, response);
			return forward;
		case "AdminSearchBoardNotice":
			forward = AdminSearchBoardNotice(request, response);
			return forward;
		case "AdminSearchBoardS":
			forward = AdminSearchBoardS(request, response);
			return forward;
			//-------------------------------------------------------------------------------------------------------------------------------
		case "AdminLogoutOk":
			forward = AdminLogout(request, response);
			return forward;
		//신고 게시판 상태 변경
		case "BoardReportStateUpdate":
			forward = BoardReportStateUpdateOkAction(request, response);
			return forward;
		//신고 게시판 검색
		case "AdminBoardReportSearch":
			forward = AdminBoardReportReceiveSearchListOkAction(request, response);
			return forward;
		// admin 공지사항글쓰기
		case "adminBoardWriteOkAction":
			forward = adminBoardWriteOkAction(request,response);
			return forward;
		case "adminBoardFileUpload":
			adminBoardFileUpload(request,response);
			break;
		case "adminBoardFileForceDelete":
			adminBoardFileForceDelete(request, response);
			break;
			// 공지사항 게시글 수정
		case "AdminModifyNoticeOk":
			forward = AdminModifyNoticeOk(request,response);
			return forward;
		case "boardNoticeDeleteOkAction":
			forward = boardNoticeDeleteOkAction(request, response);
			return forward;
		}
		return null;
	}
	
	// 공지사항 게시글 이미지 업로드
	public ActionForward adminBoardFileUpload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String real = request.getSession().getServletContext().getRealPath("resource/images/board/notice/");
		int fileSize = 3 * 1024 * 1024;
		
		MultipartRequest multi = null;
		
		multi = new MultipartRequest(request, real, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		Enumeration<String> files = multi.getFileNames();
		String data = "";
		while(files.hasMoreElements()) {
			data = files.nextElement();
			if(multi.getFilesystemName(data) == null) {continue;}
		}
		
		out.print("/resource/images/board/notice/"+multi.getFilesystemName(data));
		return null;
	}
	
	
	// 비정상적으로 종료시 업로드 이미지 전체삭제
	public ActionForward adminBoardFileForceDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String[] upload = request.getParameterValues("uploadPath");
		String pathh = request.getSession().getServletContext().getRealPath("");
		
		if(upload != null) {
			for(int i=0;i<upload.length;i++) {
				File file = new File(pathh+upload[i]);
				file.delete();
			}
		}
		return null;
	}
	
	// 공지사항게시판 글쓰기
	public ActionForward adminBoardWriteOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setContentType("application/json");
		
		//ActionForward forward = new ActionForward();
		
		BoardDao boardDao = new BoardDao();
		BoardFilesDao boardFilesDao = new BoardFilesDao();
		
		PrintWriter out = response.getWriter();
		JSONObject obj = new JSONObject();
		
		String[] list = request.getParameterValues("insertPath");
		String[] upload = request.getParameterValues("uploadPath");
		String[] boardTitle = request.getParameterValues("title");
		String[] boardContents = request.getParameterValues("contents");
		
		String path = request.getSession().getServletContext().getRealPath("resource/images/board/notice/");
		String pathh = request.getSession().getServletContext().getRealPath("");
		
		String title = boardTitle[0];
		String contents = boardContents[0];
		int state = 0;
		
		String board_name = "notice";
		
		int idx = boardDao.incrementSeq();
		
		boolean check = boardFilesDao.insertFiles(idx, path, state);
		if(!check) {
			obj.put("code", "400");
			out.print(obj);
			out.close();
			return null;
		}
		
		//게시글 등록성공
		if(boardDao.insertBoardContents(board_name,idx,0,title,contents,state)) {
			System.out.println("게시글 등록");
			obj.put("code", "200");
			obj.put("url", "/AdminBoardListNoticeOk.ad");
			out.print(obj);
			out.close();
			return null;
		}
		return null;
	}
	
	// 공지사항 게시글 삭제
	public ActionForward boardNoticeDeleteOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		AdminDao a_dao = new AdminDao();
		BoardFilesDao boardFilesDao = new BoardFilesDao();
		int board_num = Integer.parseInt(request.getParameter("num"));
		
		//DB에 있는 경로 삭제
		boardFilesDao.deleteInsertFiles(board_num);
			
		//게시글 삭제
		a_dao.deleteBoardNotice(board_num);
		
		forward.setRedirect(false);
		forward.setPath("/AdminBoardListNoticeOk.ad");
		
		return forward;
	}
	
	// 어드민 추가
	public ActionForward AdminAddOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();

		AdminDao adminDao = new AdminDao();
		AdminVo adminVo = new AdminVo();

		adminVo.setAdmin_id(request.getParameter("admin_id"));
		adminVo.setAdmin_pw(request.getParameter("admin_pw"));
		adminVo.setAdmin_level(Integer.parseInt(request.getParameter("admin_level")));
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");

		if(adminDao.adminAdd(adminVo)) {
			out.println("ok");
		}else {
			out.println("not_ok");
		}
		out.close();
		System.out.println("adminaddok들어옴");
		return null;
	}

	public ActionForward AdminCheckIdOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		AdminDao a_dao = new AdminDao();
		String a_id = request.getParameter("admin_id");
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html;charset=utf-8");
		
		if(a_dao.adminCheckId(a_id)) {
			out.println("not-ok");
		}else {
			out.println("ok");
		}
		out.close();
		return null;
	}
	
	public ActionForward AdminListOk(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		AdminDao adminDao = new AdminDao();
		
		String temp = request.getParameter("page");
		
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);
		
		int totalCnt = adminDao.getAdminCnt();
		
		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;
		
		int totalPage = (totalCnt-1)/pageSize +1;
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminList", adminDao.getAdminList(startRow, endRow));

		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_admin.jsp");

		return forward;
	}
	
	public ActionForward AdminLoginOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
			
		AdminDao adminDao = new AdminDao();
			
		String adminId = request.getParameter("admin_id");
		String adminPw = request.getParameter("admin_pw");
		String adminSessionId = adminDao.adminLogin(adminId, adminPw);
			
		if(adminSessionId != null) {
			// 로그인 성공
			session.setAttribute("session_level", adminDao.adminGetLevel(adminId));
			session.setAttribute("session_id", adminSessionId);// 세션에 저장
			forward.setRedirect(true);
			forward.setPath("/AdminAdmin.ad");
				
		}else {
			// 로그인 실패
			forward.setRedirect(false);
			forward.setPath("/app/admin/admin_login.jsp?login=false");
		}
		return forward;
	}
	
	public ActionForward AdminUpdateMemberOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		
		AdminDao a_dao = new AdminDao();
		MemberVo m_vo = new MemberVo();
		
		String member_nick = request.getParameter("member_nick"+request.getParameter("num"));
		String member_tel = request.getParameter("member_tel"+request.getParameter("num"));
		String member_email = request.getParameter("member_email"+request.getParameter("num"));
		String member_address_detail = request.getParameter("member_address_detail"+request.getParameter("num"));
		String member_address_etc = request.getParameter("member_address_etc"+request.getParameter("num"));
		int num = Integer.parseInt(request.getParameter("num"));
		
		m_vo.setMember_uid(num);
		m_vo.setMember_nick(member_nick);
		m_vo.setMember_tel(member_tel);
		m_vo.setMember_email(member_email);
		m_vo.setMember_address_detail(member_address_detail);
		m_vo.setMember_address_etc(member_address_etc);
		
		a_dao.updateMember(m_vo);
		
		forward.setRedirect(true);
		forward.setPath("/AdminMember.ad");
		
		return forward;
	}
	
	public ActionForward MemberListOk(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		AdminDao a_dao = new AdminDao();
		
		String temp = request.getParameter("page");
		
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);
		
		int totalCnt = a_dao.getMemberCnt();
		
		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;
		
		int totalPage = (totalCnt-1)/pageSize +1;
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("memberList", a_dao.getMemberList(startRow, endRow));
		//System.out.println(a_dao.getMemberList(startRow, endRow));

		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_member.jsp");
		
		return forward;
		
	}
	
	public ActionForward AdminBoardListF(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		
		AdminDao a_dao = new AdminDao();
		
		String temp = request.getParameter("page");
		
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);
		
		int totalCnt = a_dao.getAdminBoardFCnt();
		
		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;
		
		int totalPage = (totalCnt-1)/pageSize +1;
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminBoardList", a_dao.getAdminBoardFList(startRow, endRow));
		
		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_boardF.jsp");
		
		return forward;
	}
	
	public ActionForward AdminBoardListM(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		
		AdminDao a_dao = new AdminDao();
		
		String temp = request.getParameter("page");
		
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);
		
		int totalCnt = a_dao.getAdminBoardMCnt();
		
		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;
		
		int totalPage = (totalCnt-1)/pageSize +1;
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminBoardList", a_dao.getAdminBoardMList(startRow, endRow));
		
		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_boardM.jsp");
		
		return forward;
	}
	
	public ActionForward AdminBoardListN(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		
		AdminDao a_dao = new AdminDao();
		
		String temp = request.getParameter("page");
		
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);
		
		int totalCnt = a_dao.getAdminBoardNCnt();
		
		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;
		
		int totalPage = (totalCnt-1)/pageSize +1;
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminBoardList", a_dao.getAdminBoardNList(startRow, endRow));
		
		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_boardN.jsp");
		
		return forward;
	}
	
	public ActionForward AdminBoardListQ(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		
		AdminDao a_dao = new AdminDao();
		
		String temp = request.getParameter("page");
		
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);
		
		int totalCnt = a_dao.getAdminBoardQCnt();
		
		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;
		
		int totalPage = (totalCnt-1)/pageSize +1;
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminBoardList", a_dao.getAdminBoardQList(startRow, endRow));
		
		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_boardQnA.jsp");
		
		return forward;
	}
	
	public ActionForward AdminSearchBoardF(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		
		AdminDao a_dao = new AdminDao();
		String searchCondition = request.getParameter("searchCondition");
		String search = request.getParameter("search");

		String temp = request.getParameter("page");

		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);
		
		int totalCnt = a_dao.getAdminBoardFCnt();
		
		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;
		
		int totalPage = (totalCnt-1)/pageSize +1;
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminBoardList", a_dao.getBoardListF(search, searchCondition));
		//System.out.println(a_dao.getBoardListF(search, searchCondition));
		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_boardF.jsp");
		
		return forward;
		
	}
	// 모임게시판 검색
	public ActionForward AdminSearchBoardM(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		
		AdminDao a_dao = new AdminDao();
		String searchCondition = request.getParameter("searchCondition");
		String search = request.getParameter("search");
		System.out.println("condition"+searchCondition);
		System.out.println("search"+search);
		
		String temp = request.getParameter("page");
		
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);
		
		int totalCnt = a_dao.getAdminBoardMCnt();
		
		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;
		
		int totalPage = (totalCnt-1)/pageSize +1;
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminBoardList", a_dao.getBoardListM(search, searchCondition));
		//System.out.println(a_dao.getBoardListF(search, searchCondition));
		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_boardM.jsp");
		
		return forward;
		
	}
	// 나눔게시판 검색
	public ActionForward AdminSearchBoardN(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		
		AdminDao a_dao = new AdminDao();
		String searchCondition = request.getParameter("searchCondition");
		String search = request.getParameter("search");
		System.out.println("condition"+searchCondition);
		System.out.println("search"+search);
		
		String temp = request.getParameter("page");
		
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);
		
		int totalCnt = a_dao.getAdminBoardNCnt();
		
		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;
		
		int totalPage = (totalCnt-1)/pageSize +1;
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminBoardList", a_dao.getBoardListN(search, searchCondition));
		//System.out.println(a_dao.getBoardListF(search, searchCondition));
		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_boardN.jsp");
		
		return forward;
		
	}
	// 질문게시판 검색
	public ActionForward AdminSearchBoardQ(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		
		AdminDao a_dao = new AdminDao();
		String searchCondition = request.getParameter("searchCondition");
		String search = request.getParameter("search");

		String temp = request.getParameter("page");
		
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);
		
		int totalCnt = a_dao.getAdminBoardQCnt();
		
		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;
		
		int totalPage = (totalCnt-1)/pageSize +1;
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminBoardList", a_dao.getBoardListQ(search, searchCondition));
		//System.out.println(a_dao.getBoardListF(search, searchCondition));
		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_boardQnA.jsp");
		
		return forward;
		
	}
	public ActionForward AdminSearchAdminOk(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		AdminDao a_dao = new AdminDao();
		
		String searchCondition = request.getParameter("searchCondition");
		String search = request.getParameter("search");
		
		String temp = request.getParameter("page");
		
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);
		
		int totalCnt = a_dao.getAdminBoardFCnt();
		
		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;
		
		int totalPage = (totalCnt-1)/pageSize +1;
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminList", a_dao.searchAdminList(search, searchCondition));
		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_admin.jsp");
		
		return forward;
		
	}
	public ActionForward AdminSearchMemberOk(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		AdminDao a_dao = new AdminDao();
		
		String searchCondition = request.getParameter("searchCondition");
		String search = request.getParameter("search");
		
		String temp = request.getParameter("page");
		
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);
		
		int totalCnt = a_dao.getMemberCnt();
		
		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;
		
		int totalPage = (totalCnt-1)/pageSize +1;
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("memberList", a_dao.searchMemberList(search, searchCondition));
		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_member.jsp");
		
		return forward;
	}
	
	
	public ActionForward AdminSearchGalleryP(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		
		AdminDao a_dao = new AdminDao();
		String searchCondition = request.getParameter("searchCondition");
		String search = request.getParameter("search");

		String temp = request.getParameter("page");
		
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);
		
		int totalCnt = a_dao.getAdminGalleryPCnt();
		
		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;
		
		int totalPage = (totalCnt-1)/pageSize +1;
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminGalleryList", a_dao.getGalleryListP(search, searchCondition));
		//System.out.println(a_dao.getBoardListF(search, searchCondition));
		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_galleryP.jsp");
		
		return forward;
	}
	
	public ActionForward AdminSearchGalleryC(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		
		AdminDao a_dao = new AdminDao();
		String searchCondition = request.getParameter("searchCondition");
		String search = request.getParameter("search");

		String temp = request.getParameter("page");
		
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);
		
		int totalCnt = a_dao.getAdminGalleryCCnt();
		
		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;
		
		int totalPage = (totalCnt-1)/pageSize +1;
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminGalleryList", a_dao.getGalleryListC(search, searchCondition));
		//System.out.println(a_dao.getBoardListF(search, searchCondition));
		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_galleryC.jsp");
		
		return forward;
	}
	
	public ActionForward AdminSearchGalleryD(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		
		AdminDao a_dao = new AdminDao();
		String searchCondition = request.getParameter("searchCondition");
		String search = request.getParameter("search");

		String temp = request.getParameter("page");
		
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);
		
		int totalCnt = a_dao.getAdminGalleryDCnt();
		
		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;
		
		int totalPage = (totalCnt-1)/pageSize +1;
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminGalleryList", a_dao.getGalleryListD(search, searchCondition));
		//System.out.println(a_dao.getBoardListF(search, searchCondition));
		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_galleryD.jsp");
		
		return forward;
	}
	
	public ActionForward AdminSearchGalleryE(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		
		AdminDao a_dao = new AdminDao();
		String searchCondition = request.getParameter("searchCondition");
		String search = request.getParameter("search");

		String temp = request.getParameter("page");
		
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);
		
		int totalCnt = a_dao.getAdminGalleryECnt();
		
		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;
		
		int totalPage = (totalCnt-1)/pageSize +1;
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminGalleryList", a_dao.getGalleryListE(search, searchCondition));
		//System.out.println(a_dao.getBoardListF(search, searchCondition));
		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_galleryE.jsp");
		
		return forward;
	}
	public ActionForward AdminGalleryListP(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		
		AdminDao a_dao = new AdminDao();
		
		String temp = request.getParameter("page");
		
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);
		
		int totalCnt = a_dao.getAdminGalleryPCnt();
		
		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;
		
		int totalPage = (totalCnt-1)/pageSize +1;
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminGalleryList", a_dao.getAdminGalleryPList(startRow, endRow));
		
		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_galleryP.jsp");
		
		return forward;
	}
	
	public ActionForward AdminGalleryListC(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		
		AdminDao a_dao = new AdminDao();
		
		String temp = request.getParameter("page");
		
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);
		
		int totalCnt = a_dao.getAdminGalleryCCnt();
		
		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;
		
		int totalPage = (totalCnt-1)/pageSize +1;
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminGalleryList", a_dao.getAdminGalleryCList(startRow, endRow));
		
		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_galleryC.jsp");
		
		return forward;
	}
	
	public ActionForward AdminGalleryListD(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		
		AdminDao a_dao = new AdminDao();
		
		String temp = request.getParameter("page");
		
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);
		
		int totalCnt = a_dao.getAdminGalleryDCnt();
		
		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;
		
		int totalPage = (totalCnt-1)/pageSize +1;
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminGalleryList", a_dao.getAdminGalleryDList(startRow, endRow));
		
		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_galleryD.jsp");
		
		return forward;
	}
	public ActionForward AdminGalleryListE(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		
		AdminDao a_dao = new AdminDao();
		
		String temp = request.getParameter("page");
		
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);
		
		int totalCnt = a_dao.getAdminGalleryECnt();
		
		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;
		
		int totalPage = (totalCnt-1)/pageSize +1;
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminGalleryList", a_dao.getAdminGalleryEList(startRow, endRow));
		
		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_galleryE.jsp");
		
		return forward;
	}
	// 게시판 블라인드
	public ActionForward AdminBlindF(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		AdminDao a_dao = new AdminDao();
		//System.out.println(request.getParameter("num"));
		int board_idx = Integer.parseInt(request.getParameter("num"));
		//System.out.println(board_idx);
		int board_blind = 2;
		
		a_dao.blindBoardF(board_idx, board_blind);
		
		forward.setRedirect(true);
		forward.setPath("/AdminBoardListFOk.ad");
		
		return forward;
	}
	public ActionForward AdminBlindM(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		AdminDao a_dao = new AdminDao();
		int board_idx = Integer.parseInt(request.getParameter("num"));
		int board_blind = 2;
		
		a_dao.blindBoardM(board_idx, board_blind);
		
		forward.setRedirect(true);
		forward.setPath("/AdminBoardListMOk.ad");
		
		return forward;
	}
	public ActionForward AdminBlindN(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		AdminDao a_dao = new AdminDao();
		int board_idx = Integer.parseInt(request.getParameter("num"));
		int board_blind = 2;
		
		a_dao.blindBoardN(board_idx, board_blind);
		
		forward.setRedirect(true);
		forward.setPath("/AdminBoardListNOk.ad");
		
		return forward;
	}
	public ActionForward AdminBlindQ(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		AdminDao a_dao = new AdminDao();
		int board_idx = Integer.parseInt(request.getParameter("num"));
		int board_blind = 2;
		
		a_dao.blindBoardQ(board_idx, board_blind);
		
		forward.setRedirect(true);
		forward.setPath("/AdminBoardListQOk.ad");
		
		return forward;
	}
	// 갤러리 블라인드
	public ActionForward AdminBlindP(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		AdminDao a_dao = new AdminDao();
		int board_idx = Integer.parseInt(request.getParameter("num"));
		int board_blind = 2;
		
		a_dao.blindGalleryP(board_idx, board_blind);
		
		forward.setRedirect(true);
		forward.setPath("/AdminListGalleryP.ad");
		
		return forward;
	}
	public ActionForward AdminBlindC(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		AdminDao a_dao = new AdminDao();
		int board_idx = Integer.parseInt(request.getParameter("num"));
		int board_blind = 2;
		
		a_dao.blindGalleryC(board_idx, board_blind);
		
		forward.setRedirect(true);
		forward.setPath("/AdminListGalleryC.ad");
		
		return forward;
	}
	public ActionForward AdminBlindD(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		AdminDao a_dao = new AdminDao();
		int board_idx = Integer.parseInt(request.getParameter("num"));
		int board_blind = 2;

		a_dao.blindGalleryD(board_idx, board_blind);

		forward.setRedirect(true);
		forward.setPath("/AdminListGalleryD.ad");

		return forward;
	}
	public ActionForward AdminBlindE(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		AdminDao a_dao = new AdminDao();
		int board_idx = Integer.parseInt(request.getParameter("num"));
		int board_blind = 2;

		a_dao.blindGalleryE(board_idx, board_blind);

		forward.setRedirect(true);
		forward.setPath("/AdminListGalleryE.ad");

		return forward;
	}
	public ActionForward AdminBlindL(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		AdminDao a_dao = new AdminDao();
		int board_idx = Integer.parseInt(request.getParameter("num"));
		int board_blind = 2;
		
		a_dao.blindBoardL(board_idx, board_blind);
		
		forward.setRedirect(true);
		forward.setPath("/AdminBoardListLOk.ad");
		
		return forward;
	}
	public ActionForward AdminBlindSug(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		AdminDao a_dao = new AdminDao();
		int board_idx = Integer.parseInt(request.getParameter("num"));
		int board_blind = 2;
		
		a_dao.blindBoardSug(board_idx, board_blind);
		
		forward.setRedirect(true);
		forward.setPath("/AdminSugBoardListOk.ad");
		
		return forward;
	}

	//-------------------------------------------------------------------------------------------------------------------------------
	//반려동물
	//반려동물 게시판 리스트 뽑기
	public ActionForward AdminBoardListL(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ActionForward forward = new ActionForward();


		AdminDao a_dao = new AdminDao();

		String temp = request.getParameter("page");

		int page = temp == null ? 1 : Integer.parseInt(temp);

		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);

		int totalCnt = a_dao.getAdminBoardFCnt();

		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;

		int totalPage = (totalCnt-1)/pageSize +1;

		endPage = endPage > totalPage ? totalPage : endPage;

		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminBoardList", a_dao.getAdminBoardLList(startRow, endRow));

		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_findAnimal.jsp");

		return forward;
	}

	//반려동물 검색해서 게시글 뽑아오기
	public ActionForward AdminSearchBoardL(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ActionForward forward = new ActionForward();


		AdminDao a_dao = new AdminDao();
		String searchCondition = request.getParameter("searchCondition");
		String search = request.getParameter("search");

		String temp = request.getParameter("page");

		int page = temp == null ? 1 : Integer.parseInt(temp);

		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);

		int totalCnt = a_dao.getAdminBoardFCnt();

		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;

		int totalPage = (totalCnt-1)/pageSize +1;

		endPage = endPage > totalPage ? totalPage : endPage;

		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminBoardList", a_dao.getBoardListL(search, searchCondition));
		//System.out.println(a_dao.getBoardListF(search, searchCondition));
		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_findAnimal.jsp");

		return forward;

	}

	//광고문의 게시글 뽑아오기
	public ActionForward AdminAdsBoardList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ActionForward forward = new ActionForward();


		AdminDao a_dao = new AdminDao();

		String temp = request.getParameter("page");

		int page = temp == null ? 1 : Integer.parseInt(temp);

		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);

		int totalCnt = a_dao.getAdminAdsBoardCnt();

		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;

		int totalPage = (totalCnt-1)/pageSize +1;

		endPage = endPage > totalPage ? totalPage : endPage;

		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminAdsList", a_dao.getAdminAdsBoardList(startRow, endRow));

		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_ads.jsp");

		return forward;
	}
	//제휴문의 게시글 뽑아오기
	public ActionForward AdminSupBoardList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ActionForward forward = new ActionForward();


		AdminDao a_dao = new AdminDao();

		String temp = request.getParameter("page");

		int page = temp == null ? 1 : Integer.parseInt(temp);

		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);

		int totalCnt = a_dao.getAdminSupBoardCnt();

		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;

		int totalPage = (totalCnt-1)/pageSize +1;

		endPage = endPage > totalPage ? totalPage : endPage;

		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminSupList", a_dao.getAdminSupBoardList(startRow, endRow));

		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_sup.jsp");

		return forward;
	}

	//불편사항 게시판
	public ActionForward AdminBoardListS(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ActionForward forward = new ActionForward();


		AdminDao a_dao = new AdminDao();

		String temp = request.getParameter("page");

		int page = temp == null ? 1 : Integer.parseInt(temp);

		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);

		int totalCnt = a_dao.getAdminBoardFCnt();

		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;

		int totalPage = (totalCnt-1)/pageSize +1;

		endPage = endPage > totalPage ? totalPage : endPage;

		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminBoardList", a_dao.getAdminBoardListS(startRow, endRow));

		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_sug.jsp");

		return forward;
	}

	//불편사항 검색해서 게시글 뽑아오기
	public ActionForward AdminSearchBoardS(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ActionForward forward = new ActionForward();


		AdminDao a_dao = new AdminDao();
		String searchCondition = request.getParameter("searchCondition");
		String search = request.getParameter("search");

		String temp = request.getParameter("page");

		int page = temp == null ? 1 : Integer.parseInt(temp);

		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);

		int totalCnt = a_dao.getAdminBoardFCnt();

		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;

		int totalPage = (totalCnt-1)/pageSize +1;

		endPage = endPage > totalPage ? totalPage : endPage;

		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminBoardList", a_dao.getBoardListS(search, searchCondition));
		//System.out.println(a_dao.getBoardListF(search, searchCondition));
		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_sug.jsp");

		return forward;

	}

	//공지사항
	//공지사항 게시판 리스트 뽑기
	public ActionForward AdminBoardListNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ActionForward forward = new ActionForward();

		AdminDao a_dao = new AdminDao();

		String temp = request.getParameter("page");

		int page = temp == null ? 1 : Integer.parseInt(temp);

		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);

		int totalCnt = a_dao.getAdminBoardFCnt();

		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;

		int totalPage = (totalCnt-1)/pageSize +1;

		endPage = endPage > totalPage ? totalPage : endPage;

		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("board_state", "notice");
		request.setAttribute("adminBoardList", a_dao.getAdminBoardNoticeList(startRow, endRow));

		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_notice.jsp");
		return forward;
	}

	//공지사항 검색해서 게시글 뽑아오기
	public ActionForward AdminSearchBoardNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ActionForward forward = new ActionForward();


		AdminDao a_dao = new AdminDao();
		String searchCondition = request.getParameter("searchCondition");
		String search = request.getParameter("search");

		String temp = request.getParameter("page");

		int page = temp == null ? 1 : Integer.parseInt(temp);

		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);

		int totalCnt = a_dao.getAdminBoardFCnt();

		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;

		int totalPage = (totalCnt-1)/pageSize +1;

		endPage = endPage > totalPage ? totalPage : endPage;

		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("adminBoardList", a_dao.getBoardListNotice(search, searchCondition));
		//System.out.println(a_dao.getBoardListF(search, searchCondition));
		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_notice.jsp");

		return forward;

	}
	// 공지사항 게시글 수정
	public ActionForward AdminModifyNoticeOk(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		AdminDao a_dao = new AdminDao();
		NoticeBoardVo nB_vo = new NoticeBoardVo();
		
		int board_idx = Integer.parseInt(request.getParameter("num"));
		System.out.println(board_idx);
		nB_vo = a_dao.noticeBoardGetDetail(board_idx);
		System.out.println(nB_vo);
		
		request.setAttribute("noticeBoardBean", nB_vo);
		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_modifyNotice.jsp");
		System.out.println(forward.getPath());
		
		return forward;
	}
	
	
	//-------------------------------------------------------------------------------------------------------------------------------
	   //신고된 유저 가져오기
	   public ActionForward AdminMemberReportReceiveListOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		      request.setCharacterEncoding("UTF-8");
		      response.setCharacterEncoding("UTF-8");
		      
		      ActionForward forward = new ActionForward();
		      
		      
		      AdminDao a_dao = new AdminDao();
		      
		      String temp = request.getParameter("page");
		      int report_state = Integer.parseInt(request.getParameter("report_state"));
		      System.out.println("신고 상태 : " + report_state);
		      int page = temp == null ? 1 : Integer.parseInt(temp);
		      
		      int pageSize = 10;
		      int endRow = page*pageSize;
		      int startRow = endRow-(pageSize-1);
		      
		      int totalCnt = a_dao.getMemberReportReceiveListCnt();
		      
		      int startPage = ((page-1)/pageSize)*pageSize +1;
		      int endPage = startPage + 9;
		      
		      int totalPage = (totalCnt-1)/pageSize +1;
		      
		      endPage = endPage > totalPage ? totalPage : endPage;
		      List<MemberReportReceiveVo> list =  a_dao.getAdminMemberReportReceiveList(report_state, startRow, endRow);
		      for (int i = 0; i < list.size(); i++) {
		    	  if(list.get(i).getReport_type().contains("기타")) {
		    		  list.get(i).setReport_type(list.get(i).getReport_type().substring(4,list.get(i).getReport_type().length()));
		    	  }
		      }
		      request.setAttribute("totalPage", totalPage);
		      request.setAttribute("totalCnt", totalCnt);
		      request.setAttribute("nowPage", page);
		      request.setAttribute("startPage", startPage);
		      request.setAttribute("endPage", endPage);
		      request.setAttribute("adminReportReceiveList",list);
		      if(report_state == 1) {
		    	  forward.setRedirect(false);
		    	  forward.setPath("/reportReceive.ad");
		      }else {
		    	  forward.setRedirect(false);
		    	  forward.setPath("/report.ad");
		      }
		      
		      return forward;
		   }
	   
	   //신고된 유저 검색해서 가져오기
	   public ActionForward AdminMemberReportReceiveSearchListOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		      request.setCharacterEncoding("UTF-8");
		      response.setCharacterEncoding("UTF-8");
		      
		      ActionForward forward = new ActionForward();
		      System.out.println("액션 들어옴");
		      
		      AdminDao a_dao = new AdminDao();
		      
		      int report_state = Integer.parseInt(request.getParameter("report_state"));
		      System.out.println("현재 페이지 넘버 : " +report_state);
		      String searchCondition = request.getParameter("searchCondition");
		      String search = request.getParameter("search");
		      System.out.println("condition"+searchCondition);
		      System.out.println("search"+search);
		      
		      String temp = request.getParameter("page");
		      
		      int page = temp == null ? 1 : Integer.parseInt(temp);
		      
		      int pageSize = 10;
		      int endRow = page*pageSize;
		      int startRow = endRow-(pageSize-1);
		      
		      int totalCnt = a_dao.getMemberReportReceiveListCnt();
		      
		      int startPage = ((page-1)/pageSize)*pageSize +1;
		      int endPage = startPage + 9;
		      
		      int totalPage = (totalCnt-1)/pageSize +1;
		      
		      endPage = endPage > totalPage ? totalPage : endPage;
		      
		      request.setAttribute("totalPage", totalPage);
		      request.setAttribute("totalCnt", totalCnt);
		      request.setAttribute("nowPage", page);
		      request.setAttribute("startPage", startPage);
		      request.setAttribute("endPage", endPage);
		      request.setAttribute("adminReportReceiveList", a_dao.getAdminMemberReportReceiveSearchList(report_state,search, searchCondition, startRow, endRow));
		      //System.out.println(a_dao.getBoardListF(search, searchCondition));
		      if(report_state == 1) {
		    	  forward.setRedirect(false);
		    	  forward.setPath("/reportReceive.ad");
		      }else {
		    	  forward.setRedirect(false);
		    	  forward.setPath("/report.ad");
		      }
		      
		      return forward;
		      
		   }
	   
	   //유저 블라인드 하기
		public ActionForward MemberReportStateUpdateOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			ActionForward forward = new ActionForward();
			AdminDao a_dao = new AdminDao();
			int report_state2 = Integer.parseInt(request.getParameter("pageState"));
			int report_uid = Integer.parseInt(request.getParameter("rUid"));
			int reporter = Integer.parseInt(request.getParameter("reporter"));
			int report_state = Integer.parseInt(request.getParameter("state"));
			
			if(report_state == 2) {
				int member_state = 1;
				a_dao.updateReportState(report_state, report_uid);
				System.out.println("report 테이블 상태 변경 완료");
				a_dao.updateReporterState(member_state, reporter);
				System.out.println("member 테이블 상태 변경 완료");
				
			}else if(report_state == 0 && report_state2 == 2) {
				int member_state = 0;
				a_dao.updateReportState(report_state, report_uid);
				System.out.println("report 테이블 상태 변경 완료");
				a_dao.updateReporterState(member_state, reporter);
				System.out.println("member 테이블 상태 변경 완료");
			}
			else {
				a_dao.updateReportState(report_state, report_uid);
				System.out.println("report 테이블 상태 변경 완료");
				
			}
			
			if(report_state2 == 1) {
				
				forward.setRedirect(true);
				forward.setPath("/AdminMemberReportReceiveOk.ad?report_state=1");
			}else {
				forward.setRedirect(true);
				forward.setPath("/AdminMemberReportReceiveOk.ad?report_state=2");
				
			}
			
			return forward;
		}
		
		//신고된 게시판 가져오기
		   public ActionForward AdminBoardReportReceiveListOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
			      request.setCharacterEncoding("UTF-8");
			      response.setCharacterEncoding("UTF-8");
			      
			      ActionForward forward = new ActionForward();
			      
			      
			      AdminDao a_dao = new AdminDao();
			      
			      String temp = request.getParameter("page");
			      int report_state = Integer.parseInt(request.getParameter("report_state"));
			      System.out.println("신고 상태 : " + report_state);
			      int page = temp == null ? 1 : Integer.parseInt(temp);
			      
			      int pageSize = 10;
			      int endRow = page*pageSize;
			      int startRow = endRow-(pageSize-1);
			      
			      int totalCnt = a_dao.getBoardReportReceiveListCnt();
			      
			      int startPage = ((page-1)/pageSize)*pageSize +1;
			      int endPage = startPage + 9;
			      
			      int totalPage = (totalCnt-1)/pageSize +1;
			      
			      endPage = endPage > totalPage ? totalPage : endPage;
			      
			      List<BoardReportReceiveVo> list =  a_dao.getAdminBoardReportReceiveList(report_state, startRow, endRow);
			      for (int i = 0; i < list.size(); i++) {
			    	  if(list.get(i).getReport_type().contains("기타")) {
			    		  list.get(i).setReport_type(list.get(i).getReport_type().substring(4,list.get(i).getReport_type().length()));
			    	  }
			      }
			      
			      request.setAttribute("totalPage", totalPage);
			      request.setAttribute("totalCnt", totalCnt);
			      request.setAttribute("nowPage", page);
			      request.setAttribute("startPage", startPage);
			      request.setAttribute("endPage", endPage);
			      request.setAttribute("adminReportReceiveList", list);
			      
			      
			      if(report_state == 1) {
			    	  forward.setRedirect(false);
			    	  forward.setPath("/BoardReportReceive.ad");
			      }else {
			    	  forward.setRedirect(false);
			    	  forward.setPath("/BoardReport.ad");
			      }
			      
			      return forward;
			   }
	   //-------------------------------------------------------------------------------------------------------------------------------
	
	
	public ActionForward AdminLogout(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();

		session.invalidate();

		forward.setRedirect(true);
		forward.setPath("/AdminLogin.ad");

		return forward;
	}
	
	//게시판 블라인드 처리
	public ActionForward BoardReportStateUpdateOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		AdminDao a_dao = new AdminDao();
		//페이지 상태 가져오기 report = 2, reportReceive = 1
		int report_state2 = Integer.parseInt(request.getParameter("pageState"));
		//신고된 게시판 테이블의 report_uid 받아오기
		int report_uid = Integer.parseInt(request.getParameter("rUid"));
		
		//board_idx 와 board_state값 가져오기
		int board_idx = Integer.parseInt(request.getParameter("board_idx"));
		int board_state = Integer.parseInt(request.getParameter("board_state"));
		//블라인드 처리를 위한 상태값 가져오기 0, 1, 2 (0 = 아무 처리 안된거 1 = 신고된 게시판, 2 = 블라인드)
		int report_state = Integer.parseInt(request.getParameter("state"));
		String board_name = "";
		//그리고 가져온 board_state의 이름 정해주고 board_name에 넣어주기
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
		
		//다 똑같음. 신고된 게시글 보여주는 곳에서도 각각의 테이블을 상태 처리 해줘야 하기 때문에 통일시켜도 된다.
		a_dao.updateBoardReportState(report_state, report_uid);
		System.out.println("report 테이블 상태 변경 완료");
		a_dao.updateBoardState(board_name, board_idx, report_state);
		System.out.println("board 테이블 상태 변경 완료");
		
		
		if(report_state2 == 1) {
			
			forward.setRedirect(true);
			forward.setPath("/AdminBoardReportReceiveOk.ad?report_state=1");
		}else {
			forward.setRedirect(true);
			forward.setPath("/AdminBoardReportReceiveOk.ad?report_state=2");
			
		}
		
		return forward;
	}
	
	//신고된 게시판 검색해서 가져오기
   public ActionForward AdminBoardReportReceiveSearchListOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      request.setCharacterEncoding("UTF-8");
	      response.setCharacterEncoding("UTF-8");
	      
	      ActionForward forward = new ActionForward();
	      System.out.println("액션 들어옴");
	      
	      AdminDao a_dao = new AdminDao();
	      
	      int report_state = Integer.parseInt(request.getParameter("report_state"));
	      System.out.println("현재 페이지 넘버 : " +report_state);
	      String searchCondition = request.getParameter("searchCondition");
	      String search = request.getParameter("search");
	      System.out.println("condition"+searchCondition);
	      System.out.println("search"+search);
	      
	      String temp = request.getParameter("page");
	      
	      int page = temp == null ? 1 : Integer.parseInt(temp);
	      
	      int pageSize = 10;
	      int endRow = page*pageSize;
	      int startRow = endRow-(pageSize-1);
	      
	      int totalCnt = a_dao.getMemberReportReceiveListCnt();
	      
	      int startPage = ((page-1)/pageSize)*pageSize +1;
	      int endPage = startPage + 9;
	      
	      int totalPage = (totalCnt-1)/pageSize +1;
	      
	      endPage = endPage > totalPage ? totalPage : endPage;
	      
	      request.setAttribute("totalPage", totalPage);
	      request.setAttribute("totalCnt", totalCnt);
	      request.setAttribute("nowPage", page);
	      request.setAttribute("startPage", startPage);
	      request.setAttribute("endPage", endPage);
	      request.setAttribute("adminReportReceiveList", a_dao.getAdminBoardReportReceiveSearchList(report_state,search, searchCondition, startRow, endRow));
	      //System.out.println(a_dao.getBoardListF(search, searchCondition));
	      if(report_state == 1) {
	    	  forward.setRedirect(false);
	    	  forward.setPath("/BoardReportReceive.ad");
	      }else {
	    	  forward.setRedirect(false);
	    	  forward.setPath("/BoardReport.ad");
	      }
	      
	      return forward;
	      
	   }
}
