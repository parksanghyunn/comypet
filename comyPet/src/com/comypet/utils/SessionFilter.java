package com.comypet.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.comypet.action.ActionForward;
import com.comypet.app.front.controller.MemberFrontController;

public class SessionFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		 String url = request.getServletPath();
		 
	    
	    PrintWriter out = response.getWriter();
	    JSONObject obj = new JSONObject();
	    
    	if(request.getSession().getAttribute("session_uid") == null || request.getSession() == null) {
    		if(url.equals("/boardWriteOkAction.bo") || url.equals("/boardReplyWriteOkAction.bo")) {
    			obj.put("code", "250");
    			out.print(obj);
    			out.close();
    		}else {
    			
    		}
    	}else {
    		chain.doFilter(req, res);
    	}
    }
	    
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
}
