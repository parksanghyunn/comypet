package com.comypet.app.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.comypet.action.Action;
import com.comypet.action.ActionForward;
import com.comypet.app.dao.PopupDao;
import com.comypet.app.vo.PopupVo;

public class PopupAction implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, String type)throws Exception {
		ActionForward forward = new ActionForward();
		switch(type) {
		case "popupAddOkAction":
			forward = PopupAddOkAction(request, response);
			return forward;
		case "returnPopupList":
			forward = ReturnPopupList(request, response);
			return forward;
		case "popupListView":
			forward = PopupListView(request, response);
			return forward;
		case "popupPostUpdate":
			forward = popupPostUpdate(request, response);
			return null;
		case "popupModifyOk":
			forward = popupModifyOk(request, response);
			return forward;
		case "popModifyOkAction":
			forward = popModifyOkAction(request, response);
			return forward;
		}
		return null;
	}

	private ActionForward PopupAddOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
			
		response.setContentType("application/json");
		
		ActionForward forward = new ActionForward();
		
		PopupVo popupVo = new PopupVo();
		PopupDao popupDao  = new PopupDao();
		
		popupVo.setPop_title(request.getParameter("pop_title"));
		popupVo.setPop_contents(request.getParameter("pop_contents"));
		popupVo.setPop_writer(1);
		popupVo.setPop_state(0);
		
		PrintWriter out = response.getWriter();
		
		if(popupDao.PopupAdd(popupVo)) {
			forward.setRedirect(false);
			forward.setPath("/popupListView.pop");
			return forward;
		}
		return null;
	}
	
	//게시한 팝업에 대한 정보를 JSON으로 넘겨준다.
	private ActionForward ReturnPopupList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		response.setContentType("application/json");
		//팝업 정보를 담을 Json obj 생성
		JSONObject obj = new JSONObject();
		
		PopupDao popupDao = new PopupDao();
		
		//개시상태가 1인것만 list형식으로 받아온다
		List<Map<String,Object>> data = popupDao.SelectPopupList();
		
		//list형식으로 받아온 data를 data size만큼
		//json에 담아준다.
		PrintWriter out = response.getWriter();
		
		if(data.size() != 0) {
			for(int i=0;i<data.size();i++) {
				obj.put(i, data.get(i));
			}
			out.print(obj);
			out.close();
		}else {
			out.print("null");
			out.close();
		}
		
		return null;
	}
	
	public ActionForward PopupListView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ActionForward forward = new ActionForward();


		PopupDao popupDao = new PopupDao();

		String temp = request.getParameter("page");

		int page = temp == null ? 1 : Integer.parseInt(temp);

		int pageSize = 10;
		int endRow = page*pageSize;
		int startRow = endRow-(pageSize-1);

		int totalCnt = popupDao.getPopupAllCnt();

		int startPage = ((page-1)/pageSize)*pageSize +1;
		int endPage = startPage + 9;

		int totalPage = (totalCnt-1)/pageSize +1;

		endPage = endPage > totalPage ? totalPage : endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("popupList", popupDao.getPopupViewList(startRow, endRow));

		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_popupList.jsp");

		return forward;
	}
	
	//팝업 게시여부 상태값 변경
	public ActionForward popupPostUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		
		PopupDao popupDao = new PopupDao();
		PrintWriter out = response.getWriter();
				
		int totalPostPopup = popupDao.getPopupStateCnt();

		String[] data_idx = request.getParameterValues("idx");
		String[] data_state = request.getParameterValues("state");
		
		System.out.println(":::"+data_idx[0]);
		System.out.println(":::"+data_state[0]);
		
		int idx = Integer.parseInt(data_idx[0]);
		int state = Integer.parseInt(data_state[0]);
		
		//넘어온 상태값이 1이면 게시된 글이기 때문에 0으로 바꿔주고
		//그게 아니면 1로 반환
		int realState = (state == 1) ? (realState = 0) : (realState = 1); 
		
		if(realState != 0 && totalPostPopup >= 2) {
			out.print("300");
			out.close();
			return null;
		}else {
			//팝업 상태값 변경 성공
			if(popupDao.updatePostPopup(idx,realState)) {
				if(realState == 1) {
					out.print("200");
					out.close();
					return null;
				}else {
					out.print("210");
					out.close();
					return null;
				}
			//팝업 게시 실패(값이 제대로 넘어오지 않았을때
			}else {
				out.print("400");
				out.close();
				System.out.println("팝업 등록이 실패 되었습니다.");
				return null;
			}
		}
	}
	public ActionForward popupModifyOk(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		PopupVo p_vo = new PopupVo();
		PopupDao p_dao = new PopupDao();
		int pop_idx = Integer.parseInt(request.getParameter("num"));
		
		p_vo = p_dao.getPopupDetail(pop_idx);
		request.setAttribute("pop_bean", p_vo);
		forward.setRedirect(false);
		forward.setPath("/app/admin/admin_popModify.jsp");
		
		return forward;
	}
	public ActionForward popModifyOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UtF-8");
		ActionForward forward = new ActionForward();
		PopupVo p_vo = new PopupVo();
		PopupDao p_dao = new PopupDao();
		
		String pop_title = request.getParameter("pop_title");
		String pop_contents = request.getParameter("pop_contents");
		int pop_idx = Integer.parseInt(request.getParameter("num"));
		p_vo.setPop_title(pop_title);
		p_vo.setPop_contents(pop_contents);
		p_vo.setPop_idx(pop_idx);
		
		//response.setContentType("text/html;charset=utf-8");
		//PrintWriter out = response.getWriter();
		
		p_dao.modifyPopup(p_vo);
		//out.println("<script>alert('수정완료!');</script>");
		//out.flush();
		//out.close();
		forward.setRedirect(true);
		forward.setPath("/popupListView.pop");
		
		return forward;
		
	}
}
