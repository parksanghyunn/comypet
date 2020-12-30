package com.comypet.app.action;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.comypet.action.Action;
import com.comypet.action.ActionForward;
import com.comypet.app.dao.BoardDao;
import com.comypet.app.dao.BoardFilesDao;
import com.comypet.app.dao.MemberDao;
import com.comypet.app.vo.BoardCommentNickVo;
import com.comypet.app.vo.BoardCommentVo;
import com.comypet.app.vo.BoardReCommentNickVo;
import com.comypet.app.vo.BoardReportVo;
import com.comypet.app.vo.BoardViewVo;
import com.comypet.app.vo.BoardVo;
import com.comypet.app.vo.NoticeViewVo;
import com.comypet.utils.Utils;

import org.json.simple.JSONObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, String type) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		switch(type) {
		case "boardWriteOkAction":
			forward = boardWriteOkAction(request,response);
			return forward;
		case "boardFileUpload":
			boardFileUpload(request,response);
			break;
		case "boardFileForceDelete":
			boardFileForceDelete(request,response);
			break;
		case "boardReplyViewOk":
			forward = boardReplyView(request, response);
			return forward;
		case "boardReplyWriteOkAction":
			boardReplyWriteOkAction(request,response);
			break;
		case "boardListOkAction":
			forward = boardListOkAction(request, response);
			return forward;
		case "boardViewOkAction":
			forward = boardViewOkAction(request, response);
			return forward;
		case "boardReportOkAction":
			forward = boardReportOkAction(request, response);
			return forward;
		case "selectBoardUpCntOkAction":
			forward = selectBoardUpCntOkAction(request, response);
			return forward;
		case "boardUpCntOkAction":
			forward = boardUpCntOkAction(request, response);
			return forward;
		case "selectBoardDownCntOkAction":
			forward = selectBoardDownCntOkAction(request, response);
			return forward;
		case "boardDownCntOkAction":
			forward = boardDownCntOkAction(request, response);
			return forward;
		case "boardCommentOkAction":
			forward = boardCommentOkAction(request, response);
			return forward;
		case "boardReCommentOkAction":
			forward = boardReCommentOkAction(request, response);
			return forward;
		case "boardDeleteCommentOkAction":
			forward = boardDeleteCommentOkAction(request, response);
			return forward;
		case "boardDeleteReCommentOkAction":
			forward = boardDeleteReCommentOkAction(request, response);
			return forward;
		case "boardUpdateCommentOkAction":
			forward = boardUpdateCommentOkAction(request, response);
			return forward;
		case "boardUpdateReCommentOkAction":
			forward = boardUpdateReCommentOkAction(request, response);
			return forward;
		case "boardUpReadCntOkAction":
			forward = boardUpReadCntOkAction(request, response);
			return forward;
		case "hotBoardListOkAction":
			forward = hotBoardListOkAction(request, response);
			return forward;
		case "noticeBoardListOkAction":
			forward = noticeBoardListOkAction(request, response);
			return forward;
		case "noticeBoardListOkMAction":
			forward = noticeBoardListOkMAction(request, response);
			return forward;
		case "noticeBoardViewOkAction":
			forward = noticeBoardViewOkAction(request, response);
			return forward;
		case "boardDeleteMyBoardOkAction":
			forward = boardDeleteMyBoardOkAction(request, response);
			return forward;
		}
		return null;
	}
	
	public ActionForward boardWriteOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		String[] boardState = request.getParameterValues("state");
		
		String path = request.getSession().getServletContext().getRealPath("resource/images/board/folder/");
		String pathh = request.getSession().getServletContext().getRealPath("");
/*		String path = "D:\\jsp\\workspace\\comyPet\\WebContent\\resource\\images\\board\\folder\\";
		String pathh = "D:\\jsp\\workspace\\comyPet\\WebContent";*/
		
		String title = boardTitle[0];
		String contents = boardContents[0];
		int state = Integer.parseInt(boardState[0]);
		
		String board_name = "";
		switch (state) {
			case 0:board_name = "notice";break;
			case 1:board_name = "free";break;
			case 2:board_name = "meet";break;
			case 3:board_name = "fra";break;
			case 4:board_name = "qna";break;
			case 5:board_name = "puppy";break;
			case 6:board_name = "cat";break;
			case 7:board_name = "detail";break;
			case 8:board_name = "etc";break;
			case 9:board_name = "lost";break;
			case 10:board_name = "sug";break;
		}
		
		//이름이 같은 파일을 진짜 업로드할 경로에 넣는다.
		int uid = Utils.getUid(request);
		int idx = boardDao.incrementSeq();
		
		//폴더생성
		if(list != null) {
			File folder = new File(path+"board_"+idx+"_"+uid);
			if(!folder.isDirectory()) {
				folder.mkdir();
				//폴더를 생성 후 임시폴더에 있는
				//파일들을 생성된 폴더로 옴겨준다.
				if(folder.isDirectory()) {
					for(int i=0;i<list.length;i++) {
						String fileName = list[i].substring(list[i].lastIndexOf("/"));
						System.out.println(fileName+"파일이름");
						File file1 = new File(pathh+list[i]);
						File file2 = new File(path+"board_"+idx+"_"+uid+fileName);
						Utils.copys(file1, file2);
					}
				}
				
				boolean check = boardFilesDao.insertFiles(idx, path+"board_"+idx+"_"+uid, state);
					if(!check) {
						obj.put("code", "400");
						out.print(obj);
						out.close();
						return null;
					}
			}
		}
		
		//나머지 파일들을 제거
		if(upload != null){
			for(int i=0;i<upload.length;i++) {
				System.out.println(upload[i]);
				System.out.println(pathh+upload[i]);
				File file = new File(pathh+upload[i]);
				file.delete();
			}
		}
		
		contents = contents.replace("/resource/images/board/temp/", "/resource/images/board/folder/board_"+idx+"_"+uid+"/");
		
		//게시글 등록성공
		if(boardDao.insertBoardContents(board_name,idx,uid,title,contents,state)) {
			System.out.println("게시글 등록");
			obj.put("code", "200");
			out.print(obj);
			out.close();
			return null;
		}
		return null;
	}
	
	public ActionForward boardFileForceDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

	public ActionForward boardFileUpload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String real = request.getSession().getServletContext().getRealPath("resource/images/board/temp/");
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
		
		out.print("/resource/images/board/temp/"+multi.getFilesystemName(data));
		return null;
	}
	
	public ActionForward boardReplyView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		int state = Integer.parseInt(request.getParameter("board_state"));
		int idx = Integer.parseInt(request.getParameter("board_idx"));
		int uid = Utils.getUid(request);
		String board_name = "";
		
		switch(state) {
		case 0:
			board_name = "notice";
			break;
		case 1:
			board_name = "free";
			break;
		case 2:
			board_name = "meet";
			break;
		case 3:
			board_name = "fra";
			break;
		case 4:
			board_name = "qna";
			break;
		case 5:
			board_name = "puppy";
			break;
		case 6:
			board_name = "cat";
			break;
		case 7:
			board_name = "detail";
			break;
		case 8:
			board_name = "etc";
			break;
		case 9:
			board_name = "lost";
			break;
		case 10:
			board_name = "sug";
			break;
		}
		
		BoardDao boardDao = new BoardDao();
		
		List<BoardVo> boardContents = boardDao.selectBoardContents(board_name, idx, uid, state);
		
		request.setAttribute("replyBoardData", boardContents);
		forward.setRedirect(false);
		forward.setPath("/boardReplyView.bo");
		return forward;
	}
	
	public ActionForward boardReplyWriteOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setContentType("application/json");

		//게시글 수정에 필요한 데이터
		String[] boardTitle = request.getParameterValues("title");
		String[] boardContents = request.getParameterValues("contents");
		String[] boardIdx = request.getParameterValues("idx");
		String[] boardState = request.getParameterValues("state");
		
		//실제로 DB에 들어가는 데이터
		String title = boardTitle[0];
		String contents = boardContents[0];
		int idx = Integer.parseInt(boardIdx[0]);
		int state = Integer.parseInt(boardState[0]);
		int uid = Utils.getUid(request);

		//파일업로드될때의 img데이터
		String[] upload = request.getParameterValues("uploadPath");
		//실제 남아잇는 img데이터
		String[] insert = request.getParameterValues("insertPath");

		BoardFilesDao boardFilesDao = new BoardFilesDao();
		BoardDao boardDao = new BoardDao();
		
		PrintWriter out = response.getWriter();
		JSONObject obj = new JSONObject();
		
		String board_name = "";
		switch (state) {
			case 0:board_name = "notice";break;
			case 1:board_name = "free";break;
			case 2:board_name = "meet";break;
			case 3:board_name = "fra";break;
			case 4:board_name = "qna";break;
			case 5:board_name = "puppy";break;
			case 6:board_name = "cat";break;
			case 7:board_name = "detail";break;
			case 8:board_name = "etc";break;
			case 9:board_name = "lost";break;
			case 10:board_name = "sug";break;
		}

		//업로드에 필요한 경로
		String path = request.getSession().getServletContext().getRealPath("resource/images/board/folder/");
		String pathh = request.getSession().getServletContext().getRealPath("");

		if(insert != null) {
			String folderPath =path+"board_"+idx+"_"+uid;
			File folderCheck = new File(folderPath);
			if(folderCheck.isDirectory()) {
				//String folderPath = boardFilesDao.selectBoardPath(idx).substring(0,boardFilesDao.selectBoardPath(idx).lastIndexOf("/"));
				//기존 경로에 파일을 옮겨주고
				File folder = new File(folderPath);
				if(folder.isDirectory()) {
					if(upload != null) {
						for(int i=0;i<upload.length;i++) {
							String fileName = upload[i].substring(insert[i].lastIndexOf("/"));
							File file1 = new File(pathh+upload[i]);
							File file2 = new File(path+"board_"+idx+"_"+uid+"/"+fileName);
							Utils.copys(file1, file2);
						}
					}
				}
			}else {
				//기존 경로가 없을 경우 새로 폴더를 생성한다.
				File folder = new File(path+"board_"+idx+"_"+uid);
				if(!folder.isDirectory()) {
					folder.mkdir();
					if(folder.isDirectory()) {
						for(int i=0;i<insert.length;i++) {
							String fileName = insert[i].substring(insert[i].lastIndexOf("/"));
							System.out.println(fileName+"파일이름");
							File file1 = new File(pathh+insert[i]);
							File file2 = new File(path+"board_"+idx+"_"+uid+fileName);
							Utils.copys(file1, file2);
						}
					}
				}
			}
			contents = contents.replace("/resource/images/board/temp/", "/resource/images/board/folder/board_"+idx+"_"+uid+"/");
			
			boardFilesDao.deleteInsertFiles(idx);
			
			boolean check = boardFilesDao.insertFiles(idx, path+"board_"+idx+"_"+uid, state);
			if(!check) {
				obj.put("code", "400");
				out.print(obj);
				out.close();
				return null;
			}
		}else {
			//파일 이미지를 지웟을때
			System.out.println("파일 경로 및 파일 삭제");
			File folder = new File(path+"board_"+idx+"_"+uid);
			File[] fileList = folder.listFiles();
			if(fileList != null) {
				for(int i=0;i<fileList.length;i++) {
					fileList[i].delete();
				}
				boardFilesDao.deleteInsertFiles(idx);
				System.out.println("파일 및 경로 삭제 완료");
			}
		}
		
		if(insert == null) {
			File file = new File(path+"board_"+idx+"_"+uid);
			if(file.isDirectory()) {
				File[] list = file.listFiles();
				if(file.exists()) {
					for(int i=0;i<list.length;i++) {
						list[i].delete();
					}
				}
			}
		}
		
		//게시글 등록성공
		if(boardDao.updataBoardContents(board_name,idx,uid,title,contents,state)) {
			obj.put("code", "200");
			out.print(obj);
			out.close();
			return null;
		}
		return null;
	}

	public ActionForward boardListOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ActionForward forward = new ActionForward();
		BoardDao boardDao = new BoardDao();
		BoardFilesDao boardFilesDao = new BoardFilesDao();

		String temp = request.getParameter("page");
		int board_state = Integer.parseInt(request.getParameter("board_state"));
		int page = temp == null ? 1 : Integer.parseInt(temp);
		String board_name = "";
		switch (board_state) {
		case 0:
			board_name = "notice";
			break;
		case 1:
			board_name = "free";
			break;
		case 2:
			board_name = "meet";
			break;
		case 3:
			board_name = "fra";
			break;
		case 4:
			board_name = "qna";
			break;
		case 5:
			board_name = "puppy";
			break;
		case 6:
			board_name = "cat";
			break;
		case 7:
			board_name = "detail";
			break;
		case 8:
			board_name = "etc";
			break;
		case 9:
			board_name = "lost";
			break;
		case 10:
			board_name = "sug";
			break;
		}
		int pageSize = 0;
		if(board_state >= 5 && board_state <= 9) {
			pageSize = 16;
		}else {
			pageSize = 10;
		}

		int endRow = page * pageSize;

		int startRow = endRow - (pageSize - 1);
		int totalCnt = boardDao.selectBoardCnt(board_name);

		int startPage = ((page - 1) / pageSize) * pageSize + 1;
		int endPage = startPage + 9;

		int totalPage = (totalCnt - 1) / pageSize + 1;

		List<Map<String,Object>> boardPathList = boardDao.selectIndexxGalleryList(startRow, endRow,board_name);
		request.setAttribute("boardPathList", boardPathList);
		endPage = endPage > totalPage ? totalPage : endPage;
		List<BoardViewVo> boardList = boardDao.selectBoardList(startRow, endRow,board_name);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("boardList", boardList);
		request.setAttribute("board_state", board_state);
		forward.setRedirect(false);
		forward.setPath("/boardList.bo");

		return forward;
	}
	public ActionForward boardViewOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		BoardDao boardDao = new BoardDao();
		int board_idx = Integer.parseInt(request.getParameter("board_idx"));
		int board_state = Integer.parseInt(request.getParameter("board_state"));
		String board_name = "";
		switch (board_state) {
		case 0:
			board_name = "notice";
			break;
		case 1:
			board_name = "free";
			break;
		case 2:
			board_name = "meet";
			break;
		case 3:
			board_name = "fra";
			break;
		case 4:
			board_name = "qna";
			break;
		case 5:
			board_name = "puppy";
			break;
		case 6:
			board_name = "cat";
			break;
		case 7:
			board_name = "detail";
			break;
		case 8:
			board_name = "etc";
			break;
		case 9:
			board_name = "lost";
			break;
		case 10:
			board_name = "sug";
			break;
		}
		
		BoardViewVo boardViewVo = boardDao.selectBoardView(board_idx,board_name);
		List<BoardCommentNickVo> boardCommentList = boardDao.selectBoardComment(board_idx);
		List<BoardReCommentNickVo> boardReCommentList = boardDao.selectBoardReComment(board_idx);

		if(boardViewVo !=null) {
			request.setAttribute("board_title", boardViewVo.getBoard_title());
			request.setAttribute("board_contents", boardViewVo.getBoard_contents());
			request.setAttribute("board_readCnt", boardViewVo.getBoard_readCnt());
			request.setAttribute("board_up_cnt", boardViewVo.getBoard_up_cnt());
			request.setAttribute("board_down_cnt", boardViewVo.getBoard_down_cnt());
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			String regDate = date.format(boardViewVo.getBoard_regDate());
			request.setAttribute("board_regDate", regDate);
			request.setAttribute("member_uid", boardViewVo.getMember_uid());
			request.setAttribute("board_idx", boardViewVo.getBoard_idx());
			request.setAttribute("member_nick", boardViewVo.getMember_nick());
			request.setAttribute("board_state", boardViewVo.getBoard_state());
			request.setAttribute("boardCommentList", boardCommentList);
			request.setAttribute("boardReCommentList", boardReCommentList);
			request.setAttribute("commentCnt", boardDao.selectBoardCommentCnt(board_idx));
			request.setAttribute("reCommentCnt", boardDao.selectBoardReCommentCnt(board_idx));

			forward.setRedirect(false);
			forward.setPath("/boardView.bo");
			return forward;
		}

		return null;
	}
	public ActionForward boardReportOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		BoardDao boardDao = new BoardDao();
		BoardReportVo boardReportVo = new BoardReportVo();

		int board_idx = Integer.parseInt(request.getParameter("board_idx"));
		int writer = Integer.parseInt(request.getParameter("member_uid"));
		int reporter = Utils.getUid(request);
		String repoert_type = request.getParameter("report_type");
		int board_state = Integer.parseInt(request.getParameter("board_state"));
		String board_name = "";
		switch (board_state) {
		case 0:
			board_name = "notice";
			break;
		case 1:
			board_name = "free";
			break;
		case 2:
			board_name = "meet";
			break;
		case 3:
			board_name = "fra";
			break;
		case 4:
			board_name = "qna";
			break;
		case 5:
			board_name = "puppy";
			break;
		case 6:
			board_name = "cat";
			break;
		case 7:
			board_name = "detail";
			break;
		case 8:
			board_name = "etc";
			break;
		case 9:
			board_name = "lost";
			break;
		case 10:
			board_name = "sug";
			break;
		}
		
		boardReportVo.setBoard_idx(board_idx);
		boardReportVo.setReport_type(repoert_type);
		boardReportVo.setReporter(reporter);
		boardReportVo.setWriter(writer);
		boardReportVo.setBoard_state(board_state);

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		if(boardDao.insertBoardReport(boardReportVo)) {
			if(boardDao.updateBoardBlind(board_name,board_idx)){
				out.println("ok");
			}else {
				out.println("no");
			}
		}else {
			out.println("no");
		}
		out.close();

		return null;
	}

	public ActionForward selectBoardUpCntOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		BoardDao boardDao = new BoardDao();
		int board_idx = Integer.parseInt(request.getParameter("board_idx"));
		int member_uid = Integer.parseInt(request.getParameter("member_uid"));

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		if(boardDao.selectBoardUpCnt(board_idx, member_uid) == 0) {
			out.println("ok");
		}else {
			out.println("no");
		}
		out.close();
		return null;
	}

	public ActionForward boardUpCntOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		BoardDao boardDao = new BoardDao();
		int board_idx = Integer.parseInt(request.getParameter("board_idx"));
		int member_uid = Integer.parseInt(request.getParameter("member_uid"));
		int board_state = Integer.parseInt(request.getParameter("board_state"));
		String board_name = "";
		switch (board_state) {
		case 0:
			board_name = "notice";
			break;
		case 1:
			board_name = "free";
			break;
		case 2:
			board_name = "meet";
			break;
		case 3:
			board_name = "fra";
			break;
		case 4:
			board_name = "qna";
			break;
		case 5:
			board_name = "puppy";
			break;
		case 6:
			board_name = "cat";
			break;
		case 7:
			board_name = "detail";
			break;
		case 8:
			board_name = "etc";
			break;
		case 9:
			board_name = "lost";
			break;
		case 10:
			board_name = "sug";
			break;
		}
		
		boardDao.updateBoardUpCnt(board_idx, board_name);
		boardDao.insertBoardUpCnt(board_idx, member_uid, board_state);

		forward.setRedirect(false);
		forward.setPath("/boardViewOk.bo?board_state="+board_state+"&board_idx="+board_idx);
		return forward;
	}

	public ActionForward selectBoardDownCntOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		BoardDao boardDao = new BoardDao();
		int board_idx = Integer.parseInt(request.getParameter("board_idx"));
		int member_uid = Integer.parseInt(request.getParameter("member_uid"));

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		if(boardDao.selectBoardDownCnt(board_idx, member_uid) == 0) {
			out.println("ok");
		}else {
			out.println("no");
		}
		out.close();
		return null;
	}

	public ActionForward boardDownCntOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		BoardDao boardDao = new BoardDao();
		int board_idx = Integer.parseInt(request.getParameter("board_idx"));
		int member_uid = Integer.parseInt(request.getParameter("member_uid"));
		int board_state = Integer.parseInt(request.getParameter("board_state"));
		String board_name = "";
		switch (board_state) {
		case 0:
			board_name = "notice";
			break;
		case 1:
			board_name = "free";
			break;
		case 2:
			board_name = "meet";
			break;
		case 3:
			board_name = "fra";
			break;
		case 4:
			board_name = "qna";
			break;
		case 5:
			board_name = "puppy";
			break;
		case 6:
			board_name = "cat";
			break;
		case 7:
			board_name = "detail";
			break;
		case 8:
			board_name = "etc";
			break;
		case 9:
			board_name = "lost";
			break;
		case 10:
			board_name = "sug";
			break;
		}
		boardDao.updateBoardDownCnt(board_idx, board_name);
		boardDao.insertBoardDownCnt(board_idx, member_uid, board_state);

		forward.setRedirect(false);
		forward.setPath("/boardViewOk.bo?board_state="+board_state+"&board_idx="+board_idx);
		return forward;
	}

	public ActionForward boardCommentOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		BoardDao boardDao = new BoardDao();
		BoardCommentVo boardCommentVo = new BoardCommentVo();
		int board_idx= Integer.parseInt(request.getParameter("board_idx"));
		int member_uid= Utils.getUid(request);
		String comment_content = request.getParameter("comment_content");
		int board_state = Integer.parseInt(request.getParameter("board_state"));
		String board_name = "";
		switch (board_state) {
		case 0:
			board_name = "notice";
			break;
		case 1:
			board_name = "free";
			break;
		case 2:
			board_name = "meet";
			break;
		case 3:
			board_name = "fra";
			break;
		case 4:
			board_name = "qna";
			break;
		case 5:
			board_name = "puppy";
			break;
		case 6:
			board_name = "cat";
			break;
		case 7:
			board_name = "detail";
			break;
		case 8:
			board_name = "etc";
			break;
		case 9:
			board_name = "lost";
			break;
		case 10:
			board_name = "sug";
			break;
		}
		boardCommentVo.setBoard_idx(board_idx);
		boardCommentVo.setComment_content(comment_content);
		boardCommentVo.setMember_uid(member_uid);
		boardCommentVo.setBoard_state(board_state);

		boardDao.insertBoardComment(boardCommentVo);
		forward.setRedirect(false);
		forward.setPath("/boardViewOk.bo?board_state="+board_state+"&board_idx="+board_idx);
		return forward;
	}

	public ActionForward boardReCommentOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		BoardDao boardDao = new BoardDao();
		int board_idx= Integer.parseInt(request.getParameter("board_idx"));
		int comment_idx= Integer.parseInt(request.getParameter("comment_idx"));
		int num= Integer.parseInt(request.getParameter("num"));
		int member_uid= Utils.getUid(request);
		String re_comment_content = request.getParameter("re_comment_content"+num);
		int board_state = Integer.parseInt(request.getParameter("board_state"));
		String board_name = "";
		switch (board_state) {
		case 0:
			board_name = "notice";
			break;
		case 1:
			board_name = "free";
			break;
		case 2:
			board_name = "meet";
			break;
		case 3:
			board_name = "fra";
			break;
		case 4:
			board_name = "qna";
			break;
		case 5:
			board_name = "puppy";
			break;
		case 6:
			board_name = "cat";
			break;
		case 7:
			board_name = "detail";
			break;
		case 8:
			board_name = "etc";
			break;
		case 9:
			board_name = "lost";
			break;
		case 10:
			board_name = "sug";
			break;
		}
		HashMap<String, Object> dataMap = new HashMap<>();
		dataMap.put("comment_idx", (int)comment_idx);
		dataMap.put("member_uid", (int)member_uid);
		dataMap.put("re_comment_content", re_comment_content.toString());
		dataMap.put("board_idx", (int)board_idx);
		boardDao.insertBoardReComment(dataMap);

		forward.setRedirect(false);
		forward.setPath("/boardViewOk.bo?board_state="+board_state+"&board_idx="+board_idx);
		return forward;
	}

	public ActionForward boardDeleteCommentOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		BoardDao boardDao = new BoardDao();
		int comment_idx = Integer.parseInt(request.getParameter("comment_idx"));
		int board_idx= Integer.parseInt(request.getParameter("board_idx"));
		int board_state = Integer.parseInt(request.getParameter("board_state"));
		ActionForward forward = new ActionForward();
		
		if(boardDao.deleteComment(comment_idx)) {
			forward.setRedirect(false);
			forward.setPath("/boardViewOk.bo?board_state="+board_state+"&board_idx="+board_idx);
			return forward;
		}
		return null;
	}
	public ActionForward boardDeleteReCommentOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		BoardDao boardDao = new BoardDao();
		int re_comment_idx = Integer.parseInt(request.getParameter("re_comment_idx"));
		int board_idx= Integer.parseInt(request.getParameter("board_idx"));
		int board_state = Integer.parseInt(request.getParameter("board_state"));
		ActionForward forward = new ActionForward();
		
		if(boardDao.deleteReComment(re_comment_idx)) {
			forward.setRedirect(false);
			forward.setPath("/boardViewOk.bo?board_state="+board_state+"&board_idx="+board_idx);
			return forward;
		}
		return null;
	}
	public ActionForward boardUpdateCommentOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		BoardDao boardDao = new BoardDao();
		int comment_idx = Integer.parseInt(request.getParameter("comment_idx"));
		String comment_content = request.getParameter("comment_content");
		int board_idx= Integer.parseInt(request.getParameter("board_idx"));
		int board_state = Integer.parseInt(request.getParameter("board_state"));
		ActionForward forward = new ActionForward();
		
		if(boardDao.updateComment(comment_idx,comment_content)) {
			forward.setRedirect(false);
			forward.setPath("/boardViewOk.bo?board_state="+board_state+"&board_idx="+board_idx);
			return forward;
		}
		return null;
	}
	public ActionForward boardUpdateReCommentOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		BoardDao boardDao = new BoardDao();
		int re_comment_idx = Integer.parseInt(request.getParameter("re_comment_idx"));
		String re_comment_content = request.getParameter("re_comment_content");
		int board_idx= Integer.parseInt(request.getParameter("board_idx"));
		int board_state = Integer.parseInt(request.getParameter("board_state"));
		ActionForward forward = new ActionForward();
		
		if(boardDao.updateReComment(re_comment_idx,re_comment_content)) {
			forward.setRedirect(false);
			forward.setPath("/boardViewOk.bo?board_state="+board_state+"&board_idx="+board_idx);
			return forward;
		}
		return null;
	}
	
	public ActionForward boardUpReadCntOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		BoardDao boardDao = new BoardDao();
		int board_idx = Integer.parseInt(request.getParameter("board_idx"));
		int board_state = Integer.parseInt(request.getParameter("board_state"));
		ActionForward forward = new ActionForward();
		String board_name = "";
		switch (board_state) {
		case 0:
			board_name = "notice";
			break;
		case 1:
			board_name = "free";
			break;
		case 2:
			board_name = "meet";
			break;
		case 3:
			board_name = "fra";
			break;
		case 4:
			board_name = "qna";
			break;
		case 5:
			board_name = "puppy";
			break;
		case 6:
			board_name = "cat";
			break;
		case 7:
			board_name = "detail";
			break;
		case 8:
			board_name = "etc";
			break;
		case 9:
			board_name = "lost";
			break;
		case 10:
			board_name = "sug";
			break;
		}
		
		boardDao.updateReadCnt(board_idx,board_name);

		forward.setRedirect(false);
		if(board_state==0) {
			forward.setPath("/noticeboardViewOk.bo?board_idx="+board_idx);
			
		}else {
			forward.setPath("/boardViewOk.bo?board_state="+board_state+"&board_idx="+board_idx);
		}
		return forward;
	}
	
	public ActionForward hotBoardListOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");

		BoardDao boardDao = new BoardDao();
		List<HashMap<String, String>> boardHotList = boardDao.selectHotBoardList();
		JSONObject data = new JSONObject();
		for(int i =0;i<boardHotList.size();i++) {
			data.put(i, boardHotList.get(i));
		}	
		PrintWriter out = response.getWriter();
		out.print(data);
		return null;
	}
	
	public ActionForward noticeBoardListOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		BoardDao boardDao = new BoardDao();
		List<Map<String, Object>> boardNoticeList = boardDao.selectNoticeBoardList();
		JSONObject data = new JSONObject();
		for(int i =0;i<boardNoticeList.size();i++) {
			data.put(i, boardNoticeList.get(i));
		}	
		
		PrintWriter out = response.getWriter();
		out.print(data);
		return null;
	}
	public ActionForward noticeBoardListOkMAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ActionForward forward = new ActionForward();
		BoardDao boardDao = new BoardDao();

		String temp = request.getParameter("page");
		int board_state = 0;
		int page = temp == null ? 1 : Integer.parseInt(temp);
		int pageSize = 10;

		int endRow = page * pageSize;

		int startRow = endRow - (pageSize - 1);
		int totalCnt = boardDao.selectNoticeBoardCnt();

		int startPage = ((page - 1) / pageSize) * pageSize + 1;
		int endPage = startPage + 9;

		int totalPage = (totalCnt - 1) / pageSize + 1;

		endPage = endPage > totalPage ? totalPage : endPage;

		List<NoticeViewVo> boardList = boardDao.selectNoticeBoardList(startRow, endRow);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("boardList", boardList);
		request.setAttribute("board_state", board_state);
		forward.setRedirect(false);
		forward.setPath("/app/board/notice.jsp");

		return forward;
	}
	public ActionForward noticeBoardViewOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		BoardDao boardDao = new BoardDao();
		int board_idx =Integer.parseInt(request.getParameter("board_idx"));
		int board_state = 0;
		
		NoticeViewVo noticeViewVo = boardDao.selectNoticeBoardView(board_idx);

		if(noticeViewVo !=null) {
			request.setAttribute("board_title", noticeViewVo.getBoard_title());
			request.setAttribute("board_contents", noticeViewVo.getBoard_contents());
			request.setAttribute("board_readCnt", noticeViewVo.getBoard_readCnt());
			request.setAttribute("board_up_cnt", noticeViewVo.getBoard_up_cnt());
			request.setAttribute("board_down_cnt", noticeViewVo.getBoard_down_cnt());
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			String regDate = date.format(noticeViewVo.getBoard_regDate());
			request.setAttribute("board_regDate", regDate);
			request.setAttribute("admin_uid", noticeViewVo.getAdmin_uid());
			request.setAttribute("board_idx", noticeViewVo.getBoard_idx());
			request.setAttribute("admin_id", noticeViewVo.getAdmin_id());
			request.setAttribute("board_state", board_state);

			forward.setRedirect(false);
			forward.setPath("/app/board/noticeView.jsp");
			return forward;
		}

		return null;
	}
	
	public ActionForward boardDeleteMyBoardOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		int board_state = Integer.parseInt(request.getParameter("board_state"));
		int board_idx = Integer.parseInt(request.getParameter("board_idx"));
		ActionForward forward = new ActionForward();
		MemberDao memberDao = new MemberDao();
		BoardFilesDao boardFilesDao = new BoardFilesDao();
		String board_name = "";
		
		switch (board_state) {
		case 0:board_name = "notice";break;
		case 1:board_name = "free";break;
		case 2:board_name = "meet";break;
		case 3:board_name = "fra";break;
		case 4:board_name = "qna";break;
		case 5:board_name = "puppy";break;
		case 6:board_name = "cat";break;
		case 7:board_name = "detail";break;
		case 8:board_name = "etc";break;
		case 9:board_name = "lost";break;
		case 10:board_name = "sug";break;
		}
		
		String pathh = request.getSession().getServletContext().getRealPath("");
		String path = boardFilesDao.selectBoardPath(board_idx);
		
		if(path != null) {
			path = path.substring(0,path.lastIndexOf("/"));
			File file = new File(pathh+path);
			File[] list = file.listFiles();
			if(file.isDirectory()) {
				for(int i=0;i<list.length;i++) {
					list[i].delete();
				}
			}
		}
		
		boardFilesDao.deleteInsertFiles(board_idx);
		memberDao.deleteMyBoard(board_idx, board_name);
		//String folder = "C:\\psh_java\\workspace\\comyPet\\WebContent\\resource\\images\\board\\"+boardTitle;
		//Utils.delete(folder);
		forward.setRedirect(true);
		forward.setPath("/boardListOk.bo?board_state="+board_state);
		return forward;
	}
}
