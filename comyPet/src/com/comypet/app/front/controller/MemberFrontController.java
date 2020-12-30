package com.comypet.app.front.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.comypet.action.ActionForward;
import com.comypet.app.action.MemberAction;

public class MemberFrontController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());

		ActionForward forward = null;

		switch(command) {
		case "/MemberJoin.me":
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/member/join.jsp");
			break;
		case "/MemberCheckIdOk.me":
			try {
				forward = new MemberAction().execute(req, resp,"MemberCheckIdOkAction");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "/MemberCheckNickOk.me":
			try {
				forward = new MemberAction().execute(req, resp, "MemberCheckNickOkAction");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "/MemeberSendEmail.me":
			try {
				forward = new MemberAction().execute(req, resp, "MemberSendEmailOkAction");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "/MemberCheckEmailNum.me":
			try {
				forward = new MemberAction().execute(req, resp, "MemberCheckEmailNumAction");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "/MemberJoinOk.me":
			try {
				forward = new MemberAction().execute(req, resp, "MemberJoinOkAction");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "/MemberLogin.me":
			try {
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/app/member/login.jsp");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "/ToS.me":
			try {
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/app/member/ToS.jsp");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "/FindId.me":
			try {
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/app/member/findId.jsp");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "/FindPw.me":
			try {
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/app/member/findPw.jsp");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "/Login.me":
			try {
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/app/member/login.jsp");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "/FindLocation.me":
			try {
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/app/func/find_utils.jsp");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "/MemberLoginOk.me":
			try {
				forward = new MemberAction().execute(req, resp, "MemberLoginOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/MemberMyPage.me":
			try {
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/app/member/myPage.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/MemberMyBoardOk.me":
			try {
				forward = new MemberAction().execute(req, resp,"MemberMyBoardOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/MemberDeleteMyBoardOk.me":
			try {
				forward = new MemberAction().execute(req, resp,"MemberDeleteMyBoardOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/MemberBoardReportReasonOk.me":
			try {
				forward = new MemberAction().execute(req, resp,"MemberBoardReportReasonOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/MemberBoardReportReason.me":
			try {
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/app/member/reportReason.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/MemberInfo.me":
			try {
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/app/member/myInfo.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/MemberSelectInfoOk.me":
			try {
				forward = new MemberAction().execute(req, resp,"MemberSelectInfoOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/MemberUpdateIfoOk.me":
			try {
				forward = new MemberAction().execute(req, resp,"MemberUpdateInfoOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/MemberChangePwOk.me":
			try {
				forward = new MemberAction().execute(req, resp, "MemberUpdatePwOkAction");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			break;
		case "/MemberDeleteProfileOk.me":
			try {
				forward = new MemberAction().execute(req, resp,"MemberDeleteProfileOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/MemberUpdateProfileOk.me":
			try {
				forward = new MemberAction().execute(req, resp,"MemberUpdateProfileOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		  case "/MemberFindIdOk.me":
		    	 try {
					forward = new MemberAction().execute(req, resp, "MemberFindIdOkAction");
				} catch (Exception e) {
					e.printStackTrace();
				}
		    	 break;
		     case "/MemberFindId.me":
		    	 forward = new ActionForward();
		    	 forward.setRedirect(false);
		    	 forward.setPath("/app/member/findId.jsp");
		    	 break;
		     case "/MemberSendIdOk.me":
		    	 try {
					forward = new MemberAction().execute(req, resp, "MemberSendIdOkAction");
				} catch (Exception e) {
					e.printStackTrace();
				}
		    	 break;
		     case "/MemberFindPw.me":
		    	 forward = new ActionForward();
		    	 forward.setRedirect(false);
		    	 forward.setPath("/app/member/findPw.jsp");
		    	 break;
		     case "/MemberFindPwOk.me":
		    	 try {
					forward = new MemberAction().execute(req, resp, "MemberFindPwOkAction");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		    	 break;
		     case "/MemberReportOk.me":
		    	 try {
		    		 forward = new MemberAction().execute(req, resp, "MemberReportOkAction");
		    	 } catch (Exception e1) {
		    		 e1.printStackTrace();
		    	 }
		    	 break;
		case "/MemberLogOut.me":
			try {
				forward = new MemberAction().execute(req, resp, "MemberLogOutAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/Index.me":
			try {
				forward = new MemberAction().execute(req, resp, "selectIndexList");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/returnNewsList.me":
			try {
				forward = new MemberAction().execute(req, resp, "returnNewsList");
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
