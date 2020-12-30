/**
 * 게시판 리스트
 */
	function date() {
		var date = new Date();
		var today = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()
	}
	function goBoardView(board_idx,board_state) {
		var today = date();
		if(localStorage.getItem(date+"_"+board_idx)==null){
			localStorage.setItem(date+"_"+board_idx,date+"_"+board_idx);
			location.href="/boardUpReadCntOk.bo?board_idx="+board_idx+"&board_state="+board_state;
		}else{
			location.href="/boardViewOk.bo?board_idx="+board_idx+"&board_state="+board_state;
		}
	}
	
	function goNoticeBoardView (board_idx) {
		var today = date();
		if(localStorage.getItem(date+"_"+board_idx)==null){
			localStorage.setItem(date+"_"+board_idx,date+"_"+board_idx);
			location.href="/boardUpReadCntOk.bo?board_idx="+board_idx+"&board_state=0";
		}else{
			location.href="/noticeboardViewOk.bo?board_idx="+board_idx;
		}
	}