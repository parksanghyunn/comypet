/**
 * 게시글 상세보기
 */
autosize($("textarea.replys"));
autosize($("textarea#contentsText"));

function rreply(num) {
	if ($("#rreplyForm" + num).css("display") == "none") {
		$("#rreplyForm" + num).css("display", "block");
	} else {
		$("#rreplyForm" + num).css("display", "none");
	}
}
function sendReComment(session_uid,i,muteCheck) {
	//var num = $("#num").val();
	var rreply = $("#re_comment_content"+i).val();
	
	if(session_uid == null){
		alert("로그인 후 작성 가능 합니다.");
	}else if(muteCheck == 1){
		alert("댓글이 제한된 유저입니다.")
	}else if(rreply == ""){
		alert("답글을 먼저 작성 해주세요");
	}else{
		$("#rreplyForm"+i).submit();
	}
}

function deleteComment(comment_idx) {
	var check = confirm("해당 댓글을 삭제 하시겠습니까?");
	if(check){
		$.ajax({
			url : "/boardDeleteCommentOk.bo",
			type:"post",
			data:{"comment_idx":comment_idx},
			dataType:"text",
			success:function(data){
				if(data.trim() == "ok"){
					alert("댓글이 삭제되었습니다.");
					location.reload();
				}
			},
			error:function(){
				alert("댓글 삭제 실패");
			}
		})
	}
}
function deleteReComment(re_comment_idx) {
	var check = confirm("해당 답글을 삭제 하시겠습니까?");
	if(check){
		$.ajax({
			url : "/boardDeleteReCommentOk.bo",
			type:"post",
			data:{"re_comment_idx":re_comment_idx},
			dataType:"text",
			success:function(data){
				if(data.trim() == "ok"){
					alert("답글이 삭제되었습니다.");
					location.reload();
				}
			},
			error:function(){
				alert("답글 삭제 실패");
			}
		})
	}
}
function updateComment(num) {
	var check = confirm("해당 댓글을 수정하시겠습니까?");
	if(check){
		$("#commentBtn"+num).css("display","none");
		$("#updateBtn"+num).css("display","block");
		$("#comment_content"+num).attr("readonly",false);
		$("#comment_content"+num).css("border","1px solid black");
	}
}
function updateReComment(num) {
	var check = confirm("해당 답글을 수정하시겠습니까?");
	if(check){
		$("#reCommentBtn"+num).css("display","none");
		$("#reUpdateBtn"+num).css("display","block");
		$("#re_comment_content"+num).attr("readonly",false);
		$("#re_comment_content"+num).css("border","1px solid black");
	}
}

function updateCommentOk(comment_idx,num) {
	var comment_content = $("#comment_content"+num).val();
	$.ajax({
		url : "/boardUpdateCommentOk.bo",
		type:"post",
		data:{
			"comment_idx":comment_idx,
			"comment_content":comment_content
			},
		dataType:"text",
		success:function(data){
			if(data.trim() == "ok"){
				alert("댓글이 수정되었습니다.");
				location.reload();
			}
		},
		error:function(){
			alert("댓글 수정 실패");
		}
	})
}
function updateReCommentOk(re_comment_idx,num) {
	var re_comment_content = $("#re_comment_content"+num).val();
	$.ajax({
		url : "/boardUpdateReCommentOk.bo",
		type:"post",
		data:{
			"re_comment_idx":re_comment_idx,
			"re_comment_content":re_comment_content
		},
		dataType:"text",
		success:function(data){
			if(data.trim() == "ok"){
				alert("답글이 수정되었습니다.");
				location.reload();
			}
		},
		error:function(){
			alert("답글 수정 실패");
		}
	})
}
function sendReport(session_uid) {
	var board_state = $("#board_state").val();
	var board_idx = $("#board_idx").val();
	var member_uid = $("#member_uid").val();
	if(session_uid !=null){
		window.open('/app/board/board_report.jsp?board_idx='+board_idx+'&member_uid='+member_uid+'&board_state='+board_state, 'a', 'width=500, height=450, left=100, top=50');
	}else{
		alert("로그인 후 작성 가능 합니다.");
	}
}
function sendReply(session_uid) {
	var frm = document.replyForm;
	var muteCheck = $("#muteCheck").val();
	var reply = $("textarea[name='comment_content']").val();
	if(session_uid == null){
		alert("로그인 후 작성 가능 합니다.");
	}else if(muteCheck == 1){
		alert("댓글을 작성 할 수 없는 아이디입니다.");
	}else if(reply == ""){
		alert("댓글을 먼저 작성 해주세요");
	}else{
		frm.submit();
	}
}

function boardUpCnt(session_uid) {
	if(session_uid != null){
		var check = confirm("해당 게시글을 추천하시겠습니까?");
		var board_idx = $("#board_idx").val();
		var board_state = $("#board_state").val();
		if(check){
			$.ajax({
				url : "/selectBoardDownCntOk.bo",
				type : "POST",
				data : {
					"board_idx":board_idx,
					"member_uid":session_uid
				},
				dataType:"text",
				success:function(data){
					if(data.trim() == "ok"){
						$.ajax({
							url : "/selectBoardUpCntOk.bo",
							type : "POST",
							data : {
								"board_idx" : board_idx,
								"member_uid" : session_uid
							},
							dataType:"text",
							success:function(data){
								if(data.trim() == "ok"){
									alert("게시글을 추천하셨습니다.");
									location.href = "/boardUpCntOk.bo?board_idx="+board_idx+"&board_state="+board_state+"&member_uid="+session_uid;
								}else{
									alert("이미 추천하신 게시글 입니다.");
								}
							},
							error:function(){
								alert("비추천 실패");
							}
						})
					}else{
						alert("비추천한 게시글은 추천 할 수 없습니다.");
					}
				},
				error:function(){
					alert("추천 실패");
				}
			})
		}
	}else{
		alert("로그인 후 추천이 가능합니다.");
	}
}

function boardDownCnt(session_uid) {
	if(session_uid != null){
		var check = confirm("해당 게시글을 비추천하시겠습니까?");
		var board_idx = $("#board_idx").val();
		var board_state = $("#board_state").val();
		if(check){
		$.ajax({
				url : "/selectBoardUpCntOk.bo",
				type : "POST",
				data : {
					"board_idx":board_idx,
					"member_uid":session_uid
				},
				dataType:"text",
				success:function(data){
					if(data.trim() == "ok"){
						$.ajax({
							url : "/selectBoardDownCntOk.bo",
							type : "POST",
							data : {
								"board_idx" : board_idx,
								"member_uid" : session_uid
							},
							dataType:"text",
							success:function(data){
								if(data.trim() == "ok"){
									alert("게시글을 비추천하였습니다.");
									location.href = "/boardDownCntOk.bo?board_idx="+board_idx+"&board_state="+board_state+"&member_uid="+session_uid;
								}else{
									alert("이미 비추천하신 게시글 입니다.");
								}
							},
							error:function(){
								alert("비추천 실패");
							}
						})
					}else{
						alert("추천한 게시글은 비추천 할 수 없습니다.");
					}
				},
				error:function(){
					alert("비추천 실패");
				}
			})
		
		}
	}else{
		alert("로그인 후 비추천이 가능합니다.");
	}
}