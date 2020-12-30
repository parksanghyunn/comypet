package com.comypet.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.comypet.app.vo.BoardViewVo;
import com.comypet.app.vo.PopupVo;
import com.comypet.mybatis.config.SqlMapConfig;

public class PopupDao {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;

	public PopupDao() {
		sqlsession = sessionf.openSession(true);
	}
	
	public boolean PopupAdd(PopupVo popupVo) {
		if(sqlsession.insert("Popup.insertPopup", popupVo) == 1) {
			return true;
		}
		return false;
	}
	
	public List<Map<String,Object>> SelectPopupList() {
		List<Map<String,Object>> result = sqlsession.selectList("Popup.selectPopupList");
		return result;
	}
	
	public int getPopupAllCnt() {
		return sqlsession.selectOne("Popup.selectPopupAllCnt");
	}
	
	public int getPopupStateCnt() {
		return sqlsession.selectOne("Popup.selectPopupStateCnt");
	}
	
	public List<PopupVo> getPopupViewList(int startRow, int endRow){
		HashMap<String, Integer> pageMap = new HashMap<>();

		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		List<PopupVo> popupList = sqlsession.selectList("Popup.selectPopupViewList", pageMap);
		return popupList;
	}
	
	public boolean updatePostPopup(int idx, int state) {
		boolean check = false;
		
		HashMap<String, Integer> popup = new HashMap<>();
		popup.put("pop_idx", idx);
		popup.put("pop_state", state);
		
		if(sqlsession.update("Popup.updatePostPopup",popup) == 1) {
			check = true;
		}
		return check;
	}
	//-------------
	// 선택한 팝업의 모든 정보 가져오기
	public PopupVo getPopupDetail(int pop_idx) {
		return sqlsession.selectOne("Popup.selectPopupGetDetail", pop_idx);
	}
	
	// 선택한 팝업 정보 수정하기
	public boolean modifyPopup(PopupVo p_vo) {
		boolean check = false;
		
		if(sqlsession.update("Popup.updateModifyPopup", p_vo)==1) {
			check = true;
		}
		
		return check;
	}
	//-------------
}
