package com.comypet.app.front.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comypet.action.ActionForward;
import com.comypet.app.action.PopupAction;

public class PopupFrontController extends HttpServlet{

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
		case "/pop.pop":
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/admin/admin_popup.jsp");
			break;
		case "/addPopup.pop":
			try {
				forward = new PopupAction().execute(req, resp, "popupAddOkAction");
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case "/returnPopupList.pop":
			try {
				forward = new PopupAction().execute(req, resp, "returnPopupList");
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case "/popupListView.pop":
			try {
				forward = new PopupAction().execute(req, resp, "popupListView");
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case "/popupPostUpdate.pop":
			try {
				forward = new PopupAction().execute(req, resp, "popupPostUpdate");
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case "/AdminModifyPopOk.pop":
			try {
				forward = new PopupAction().execute(req, resp, "popupModifyOk");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/PopModifyOkAction.pop":
			try {
				forward = new PopupAction().execute(req, resp, "popModifyOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/error/404.jsp");
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
