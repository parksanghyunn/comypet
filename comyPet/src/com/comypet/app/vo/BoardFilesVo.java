package com.comypet.app.vo;

public class BoardFilesVo{
	private int file_idx;
	private String file_name;                 //파일 이름
	private String file_path;
	private int board_num;                    //게시글 번호
	private int board_state;				  //게시글 분류값
	
	public BoardFilesVo() {;}
	
	public int getFile_idx() {
		return file_idx;
	}

	public void setFile_idx(int file_idx) {
		this.file_idx = file_idx;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	
	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	
	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public int getBoard_state() {
		return board_state;
	}

	public void setBoard_state(int board_state) {
		this.board_state = board_state;
	}

	@Override
	public String toString() {
		return "BoardFilesVo [file_idx=" + file_idx + ", file_name=" + file_name + ", file_path=" + file_path
				+ ", board_num=" + board_num + ", board_state=" + board_state + "]";
	}
}
