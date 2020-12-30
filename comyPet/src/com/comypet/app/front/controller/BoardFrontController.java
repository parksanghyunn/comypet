package com.comypet.app.front.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comypet.action.ActionForward;
import com.comypet.app.action.BoardAction;
import com.comypet.app.action.PopupAction;
import com.comypet.utils.Utils;

public class BoardFrontController extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		ActionForward forward = null;
		
		switch(command) {
		case "/boardListOk.bo": 
			try {
				forward = new BoardAction().execute(req, resp, "boardListOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			} 
			break;
		case "/boardList.bo": 
			try {
				forward = new ActionForward();
				forward.setPath("/app/board/boardList.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			} 
			break;
		case "/boardViewOk.bo": 
			try {
				forward = new BoardAction().execute(req, resp, "boardViewOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			} 
			break;
		case "/boardView.bo": 
			try {
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/app/board/boardView.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			} 
			break;
		case "/boardFileUpload.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "boardFileUpload");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/boardFileForceDelete.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "boardFileForceDelete");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/boardWriteOkAction.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "boardWriteOkAction");
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case "/boardReplyViewOk.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "boardReplyViewOk");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/boardReplyView.bo" :
			try {
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/app/board/boardReply.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			} 
			break;
		case "/boardReplyWriteOkAction.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "boardReplyWriteOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/boardReportOk.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "boardReportOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/selectBoardUpCntOk.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "selectBoardUpCntOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/selectBoardDownCntOk.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "selectBoardDownCntOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/boardUpCntOk.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "boardUpCntOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/boardDownCntOk.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "boardDownCntOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/boardCommentOk.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "boardCommentOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/deleteBoard.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "boardDeleteOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/boardReCommentOk.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "boardReCommentOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/boardDeleteCommentOk.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "boardDeleteCommentOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/boardDeleteReCommentOk.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "boardDeleteReCommentOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/boardUpdateCommentOk.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "boardUpdateCommentOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/boardUpdateReCommentOk.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "boardUpdateReCommentOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/boardUpReadCntOk.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "boardUpReadCntOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/indexBoardListOk.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "indexBoardListOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case "/hotBoardListOk.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "hotBoardListOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/noticeBoardListOkM.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "noticeBoardListOkMAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/noticeboardViewOk.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "noticeBoardViewOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/indexGalleryList.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "indexGalleryList");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/indexFindList.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "indexFindList");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/boardDeleteMyBoardOkAction.bo" :
			try {
				forward = new BoardAction().execute(req, resp, "boardDeleteMyBoardOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/error/404.html");
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
			}
		}
	}

}
