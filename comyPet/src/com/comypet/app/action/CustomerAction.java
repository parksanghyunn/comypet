package com.comypet.app.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comypet.action.Action;
import com.comypet.action.ActionForward;
import com.comypet.app.dao.CustomerDao;
import com.comypet.app.vo.CustomerVo;

public class CustomerAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, String type)throws Exception {
		ActionForward forward = new ActionForward();
		switch(type) {
		case "CustomerWriteOkAction":
			forward = CustomerWriteOkAction(request, response);
			return forward;
		}
		return null;
	}
	
	public ActionForward CustomerWriteOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		CustomerVo customerVo = new CustomerVo();
		CustomerDao customerDao = new CustomerDao();
		
		ActionForward forward = new ActionForward();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		System.out.println(request.getParameter("cs_name"));
		customerVo.setCustomer_name(request.getParameter("cs_name"));
		customerVo.setCustomer_email(request.getParameter("cs_email"));
		customerVo.setCustomer_tel(request.getParameter("cs_tel"));
		customerVo.setCustomer_contents(request.getParameter("cs_contents"));
		
		String title = request.getParameter("title");
		System.out.println(title);
		
		if(title.equals("광고")) {
			customerVo.setCustomer_state(1);
		}else {
			customerVo.setCustomer_state(0);
		}
		
		PrintWriter out = response.getWriter();
		
		if(customerDao.insertCustomerContents(customerVo)) {
			forward.setRedirect(true);
			if(title.equals("광고")) {
				forward.setPath("/ads.cs");
			}else {
				forward.setPath("/sup.cs");
			}
			return forward;
		}
		out.println("<script>");
		out.println("alert('"+title+"게시글 등록 실패. 다시 시도해주세요');");
		out.println("</script>");
		out.close();
		return null;
	}
}
