<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>COMYPET &mdash; 일상이 &amp; 즐거워지는 그 순간!</title>
<link rel="stylesheet" href="/resource/css/member_popup.css">
<style>
.contents {
	border-top: 1px solid #cccc;
}

html, body {
	overflow-x: hidden;
}
</style>
</head>
<c:set var="board_title" value="${requestScope.board_title }"></c:set>
<c:set var="board_contents" value="${requestScope.board_contents }"></c:set>
<c:set var="board_readCnt" value="${requestScope.board_readCnt }"></c:set>
<c:set var="board_upCnt" value="${requestScope.board_up_cnt }"></c:set>
<c:set var="board_downCnt" value="${requestScope.board_down_cnt }"></c:set>
<c:set var="board_regDate" value="${requestScope.board_regDate }"></c:set>
<c:set var="member_uid" value="${requestScope.member_uid }"></c:set>
<c:set var="board_idx" value="${requestScope.board_idx}"></c:set>
<c:set var="member_nick" value="${requestScope.member_nick}"></c:set>
<c:set var="board_state" value="${requestScope.board_state}"></c:set>
<c:set var="boardCommentList" value="${requestScope.boardCommentList}"></c:set>
<c:set var="commentCnt" value="${requestScope.commentCnt}"></c:set>
<c:set var="boardReCommentList"
	value="${requestScope.boardReCommentList}"></c:set>
<c:set var="reCommentCnt" value="${requestScope.reCommentCnt}"></c:set>
<body class="skin-blue">
	<c:choose>
		<c:when test="${board_state eq 1}">
			<c:set var="board_name" value="자유게시판"></c:set>
		</c:when>
		<c:when test="${board_state eq 2}">
			<c:set var="board_name" value="모임게시판"></c:set>
		</c:when>
		<c:when test="${board_state eq 3}">
			<c:set var="board_name" value="나눔게시판"></c:set>
		</c:when>
		<c:when test="${board_state eq 4}">
			<c:set var="board_name" value="질문게시판"></c:set>
		</c:when>
		<c:when test="${board_state eq 5}">
			<c:set var="board_name" value="강아지 갤러리"></c:set>
		</c:when>
		<c:when test="${board_state eq 6}">
			<c:set var="board_name" value="고양이 갤러리"></c:set>
		</c:when>
		<c:when test="${board_state eq 7}">
			<c:set var="board_name" value="일상공유"></c:set>
		</c:when>
		<c:when test="${board_state eq 8}">
			<c:set var="board_name" value="기타 갤러리"></c:set>
		</c:when>
		<c:when test="${board_state eq 9}">
			<c:set var="board_name" value="반려동물 찾기"></c:set>
			<c:set var="board" value="qna"></c:set>
		</c:when>
		<c:when test="${board_state eq 10}">
			<c:set var="board_name" value="불편사항"></c:set>
		</c:when>
	</c:choose>
	<jsp:include page="/app/menu/topMenu.jsp"></jsp:include>

	<section class="home">
		<article>
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-sm-12 col-xs-12">
						<div id="view">
							<ol class="breadcrumb">
							<c:choose>
								<c:when test="${board_state eq 10}">
									<li><a href="#">고객센터</a></li>
								</c:when>
								<c:when test="${board_state eq 5 or board_state eq 6 or board_state eq 7 or board_state eq 8}">
									<li><a href="#">갤러리</a></li>
								</c:when>
								<c:when test="${board_state eq 1 or board_state eq 2 or board_state eq 3 or board_state eq 4}">
									<li><a href="#">커뮤니티</a></li>
								</c:when>
							</c:choose>
							<li class="active"><a
									href="/boardListOk.bo?board_state=${board_state}">${board_name}</a></li>							
								<li class="active">${board_title}</li>
							</ol>
							<header>
								<span style="font-size: 30px;">${board_title}</span>
								<div>
									<div style="margin: 0; padding: 0; position: absolute;">
										<a href="#layer1" class="btn-example" style="color: black;">${member_nick}</a>
										<span>${board_regDate}</span>
										<div id="layer1" class="pop-layer">
											<jsp:include page="nameLayerPopup.jsp?member_uid=${member_uid}" flush="false">
												<jsp:param value="${member_uid}" name="member_uid"/>
											</jsp:include>
										</div>
									</div>
									<div style="margin: 0; padding: 0; text-align: right;">
										<span>조회수 ${board_readCnt}</span> <span>추천
											${board_upCnt}</span> <span>댓글 ${commentCnt+reCommentCnt}</span>
									</div>
								</div>
							</header>
							<hr>
							<div id="content">
								${board_contents}
								<div style="text-align: right;">

									<input type="hidden" value="${board_idx}" id="board_idx">
									<input type="hidden" value="${member_uid}" id="member_uid">
									<input type="hidden" value="${board_state}" id="board_state">
									<a href="javascript:boardUpCnt(${session_uid})"
										class="btn btn-primary btn-sm btn-rounded">추천<span
										style="display: inline;">&nbsp;${board_upCnt}</span>
									</a> <a href="javascript:boardDownCnt(${session_uid})"
										class="btn btn-primary btn-sm btn-rounded">비추천<span
										style="display: inline;">&nbsp;${board_downCnt}</span></a>
										<c:if test="${session_uid ne member_uid}">
										<a href="javascript:sendReport(${session_uid })" class="btn btn-magz btn-sm btn-rounded">신고</a>
										</c:if>
								</div>
							</div>
							<hr>
							<div id="writeReply">
								<form name="replyForm"
									action="/boardCommentOk.bo?board_idx=${board_idx}&board_state=${board_state}"
									method="post">
									<div class="col-md-3" style="width: 70%; position: relative;">
										<textarea cols="auto" rows="4%"
											style="resize: none; width: 120%" placeholder="댓글을 작성해주세요"
											name="comment_content"></textarea>
									</div>
									<div style="text-align: right; position: relative;">
										<input type="hidden" value="${muteCheck}" id="muteCheck">									
										<a href="javascript:sendReply(${session_uid})"
											class="btn btn-primary btn-lg btn-rounded"
											style="margin-left: 7em;">작성</a>
									</div>
								</form>
							</div>
							<br> <br>
							<h5>댓글 목록</h5>
							<div id="replys">
								<hr>
								<c:set var="i" value="${0}"></c:set>
								<c:forEach var="b_bean" items="${boardCommentList}">
									<c:set var="i" value="${i+1}"></c:set>
									<div>
										<a>${b_bean.getMember_nick()}</a>&nbsp;&nbsp; <span><fmt:formatDate
												value="${b_bean.getComment_reg_date()}"
												pattern="yyyy-MM-dd HH:mm" /></span><br>
										<textarea class="replys"
											style="resize: none; border: none; outline: none; width: 100%"
											readonly id="comment_content${i}">${b_bean.getComment_content()}</textarea>
										<div style="text-align: right; height: 20%">
											<div id="commentBtn${i}">
												<c:if test="${b_bean.getMember_uid() eq session_uid}">
													<a
														href="javascript:deleteComment(${b_bean.getComment_idx()})"
														class="btn btn-default btn-sm btn-rounded">삭제</a>
													<a href="javascript:updateComment(${i})"
														class="btn btn-default btn-sm btn-rounded">수정</a>
												</c:if>
												<a href="javascript:rreply(${i})"
													class="btn btn-default btn-sm btn-rounded">답글</a>
											</div>
											<div id="updateBtn${i}" style="display: none;">
												<a
													href="javascript:updateCommentOk(${b_bean.getComment_idx()},${i})"
													class="btn btn-default btn-sm btn-rounded">수정 완료</a> <a
													href="javascript:location.reload()"
													class="btn btn-default btn-sm btn-rounded">취소</a>
											</div>
											<br>
											<form id="rreplyForm${i}" name="rreplyForm${i}"
												style="display: none;"
												action="/boardReCommentOk.bo?comment_idx=${b_bean.getComment_idx()}&board_idx=${board_idx}&board_state=${board_state}&num=${i}"
												method="post">
												<br>
												<div class="col-md-3"
													style="width: 70%; position: relative;">
													<textarea cols="auto" rows="3%"
														style="resize: none; width: 120%" placeholder="답글을 작성해주세요"
														name="re_comment_content${i}"></textarea>
												</div>
												<div style="text-align: right; position: relative;">
													<a href="javascript:sendReComment(${session_uid},${i},${muteCheck})"
														class="btn btn-primary btn-lg btn-rounded"
														style="margin-left: 7em; background-color: #cccccc; border-color: #cccccc">작성</a>
												</div>
											</form>
											<br>
											<c:set var="j" value="${0}"></c:set>
											<c:forEach var="reComment_bean" items="${boardReCommentList}">
												<c:set var="j" value="${j+1}"></c:set>
												<div style="margin-left: 15px; background-color: #f6f6f6">
													<c:if
														test="${reComment_bean.getComment_idx() eq b_bean.getComment_idx()}">
														<div style="padding: 5px;">
															<a href="#" style="float: left;" class="btn-example">${reComment_bean.getMember_nick() }</a>
															<span style="float: right; color: #cccccc;"><fmt:formatDate
																	value="${reComment_bean.getRe_comment_reg_date()}"
																	pattern="yyyy-MM-dd HH:mm" /></span>
															<textarea class="replys"
																style="resize: none; border: none; outline: none; width: 100%; background-color: #f6f6f6"
																id="re_comment_content${j}" readonly>${reComment_bean.getRe_comment_content()}</textarea>
															<c:if test="${b_bean.getMember_uid() eq session_uid}">
																<div id="reCommentBtn${j}">
																	<a
																		href="javascript:deleteReComment(${reComment_bean.getRe_comment_idx()})"
																		class="btn btn-default btn-sm btn-rounded">삭제</a> <a
																		href="javascript:updateReComment(${j})"
																		class="btn btn-default btn-sm btn-rounded">수정</a>
																</div>
															</c:if>
															<div id="reUpdateBtn${j}" style="display: none;">
																<a
																	href="javascript:updateReCommentOk(${reComment_bean.getRe_comment_idx()},${j})"
																	class="btn btn-default btn-sm btn-rounded">수정 완료</a> <a
																	href="javascript:location.reload()"
																	class="btn btn-default btn-sm btn-rounded">취소</a>
															</div>
														</div>
													</c:if>
												</div>
											</c:forEach>
										</div>
									</div>
								</c:forEach>
								<form id="replay_view_data" action="/boardReplyViewOk.bo" method="POST">
									<input type="hidden" name="board_state" value="${board_state}">
									<input type="hidden" name="board_idx" value="${board_idx}">
								</form>
								<hr>
								<div style="text-align: right;">
									<c:if test="${not empty session_uid}">
										<button type="button" id="write_board" onclick="writeBoard(${board_state})"
											class="btn btn-primary btn-sm btn-rounded">글쓰기</button>
									</c:if>
									<c:if test="${member_uid eq session_uid}">
										<button type="button" id="replys_board"
											class="btn btn-primary btn-sm btn-rounded">수정</button>
										<button type="button" id="delete_board" onclick="deleteMyBoard(${board_idx},${board_state})"
											class="btn btn-primary btn-sm btn-rounded">삭제</button>
									</c:if>
								</div>
							</div>
						</div>
					</div>
					<jsp:include page="/app/menu/rightMenu.jsp"></jsp:include>
				</div>
			</div>
		</article>
	</section>
	<!-- Start footer -->
	<jsp:include page="/app/menu/footer.jsp" />
	<!-- End Footer -->

	<!-- JS -->
	<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
	<script
		src="https://rawgit.com/jackmoore/autosize/master/dist/autosize.min.js"></script>
	<script src="/resource/js/board_view.js"></script>
	<script src="/resource/js/member_popup.js"></script>
	<script>
	 	$("#replys_board").on("click", function(){
			$("#replay_view_data").submit();		
	 	});
	 	
	 	function writeBoard(board_state){
	 		location.href = "/app/board/boardWrite.jsp?board=커뮤니티&&board_state="+board_state;
	 	}
	 	
	 	function deleteMyBoard(board_idx,board_state) {
	 		var check = confirm("해당 게시글을 삭제하시겠습니까?");
	 		if(check){
	 			location.href = "/boardDeleteMyBoardOkAction.bo?board_idx="+board_idx+"&board_state="+board_state;
	 		}else{
	 			alert("게시글 삭제를 취소합니다.");
	 		}
	 	}
	</script>
	<script src="/resource/scripts/bootstrap/bootstrap.min.js"></script>
</body>
</html>