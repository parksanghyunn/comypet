package com.comypet.app.front.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.comypet.action.ActionForward;
import com.comypet.app.action.CustomerAction;

public class CustomerFrontController extends HttpServlet{

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
		case "/ads.cs" :
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/cs/cs_ads.jsp");
			break;
		case "/sup.cs" :
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/cs/cs_sup.jsp");
			break;
		case "/sug.cs" :
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/cs/cs_sug.jsp");
			break; 
		case "/policy.cs" :
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/cs/cs_policy.jsp");
			break; 
		case "/csWrite.cs" :
			try {
				forward = new CustomerAction().execute(req, resp, "CustomerWriteOkAction");
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
