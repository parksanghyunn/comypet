package com.comypet.app.dao;



import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.io.File;
import java.util.HashMap;
import java.util.List;

import com.comypet.app.vo.BoardFilesVo;
import com.comypet.app.vo.BoardViewVo;
import com.comypet.mybatis.config.SqlMapConfig;

public class BoardFilesDao {
	
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public BoardFilesDao() {
		sqlsession = sessionf.openSession(true);
	}
	
	public boolean insertFiles(int board_num, String board_path, int state) {
		HashMap<String, Object> fileMap = new HashMap<>();
			
		boolean check = false;
		File checkFile = new File(board_path);
		
		if(checkFile.isDirectory()) {
			System.out.println("쿼리까지 접근");
			File[] realFile = checkFile.listFiles();
			for(int i =0;i<realFile.length;i++) {
				fileMap.put("board_num", board_num);
				fileMap.put("file_name", realFile[i].getName());
				fileMap.put("board_path", board_path.substring(board_path.lastIndexOf("/resource/"))+"/"+realFile[i].getName());
				fileMap.put("board_state", state);				
				sqlsession.insert("BoardFiles.insertFiles", fileMap);
				System.out.println("쿼리실행");
				fileMap = new HashMap<>();
			}
			check = true;
		}
		return check;
	}

	public String selectBoardPath(int idx) {
		return sqlsession.selectOne("BoardFiles.selectBoardPath",idx);
	}

	public void deleteInsertFiles(int idx) {
		sqlsession.delete("BoardFiles.deleteInsertFiles", idx);
	}

	public  List<BoardFilesVo> selectFilePath() {
		List<BoardFilesVo> boardPathList = sqlsession.selectList("BoardFiles.selectBoardPathList");
		return boardPathList;
	}
}
