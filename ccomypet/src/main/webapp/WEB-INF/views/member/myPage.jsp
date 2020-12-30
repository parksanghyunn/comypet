<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
response.setHeader("cache-control","no-store");
response.setHeader("expires","0");
response.setHeader("pragma","no-cache");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">	
<title>COMYPET &mdash; 일상이 &amp; 즐거워지는 그 순간!</title>
<style>
th {
	text-align: center;
}

td {
	text-align: center;
}

#setting {
	text-align: right;
}

.profile {
	border-radius: 70%;
	overflow: hidden;
	width: 230px;
	height: 230px;
}
</style>
</head>

<body class="skin-blue">
<c:if test="${empty session_uid}">
	<script> 
		alert('로그인 후 이용해주세요.');
		window.open("/index", "_self");
	</script>
</c:if>
	<jsp:include page="../menu/topMenu.jsp"></jsp:include>
	<section class="home">
		<div class="container">
			<div class="row">
				<div id="view" style="text-align: center; margin: 0 auto;">
					<c:choose>
						<c:when test="${session_profile eq 'defaultProfile.png'}">
							<img alt="profile" src="/resources/images/member/profile/${session_profile}"
								class="profile">
							<br>
						</c:when>
						<c:otherwise>
							<img alt="profile"
								src="/resources/images/member/profile/${session_uid}/${session_profile}"
								class="profile">
							<br>
						</c:otherwise>
					</c:choose>
					<br> <br> <span style="font-size: 35px;"><strong>${session_nick}</strong></span>
					<div class="menu" style="border: none;">
						<div class="setting" style="float: left; margin-left:20px;">
							<ul class="nav-list">
								<li class="dropdown magz-dropdown"><a href="#"
									style="font-size: 20px" id="setting_icon"> <img
										src="/resources/images/setting.png">
								</a>
									<ul class="dropdown-menu">
										<li><a href="/member/myInfo/${session_uid}">내 정보</a></li>
										<li><a href="/app/member/updatePw.jsp">비밀번호 변경</a></li>
										<li><a href="/member/logOut">로그아웃</a></li>
									</ul></li>
							</ul>
						</div>
					</div>
				</div>
				<br>
				<h3>내가 쓴 게시글</h3>
				<hr>
				<div style="position: absolute;">
					<p style="margin-left: 10px; color: #626EEF; font-size: 18px"><strong>
					<c:choose>
					<c:when test="${not empty board_state}">
					<c:choose>
						<c:when test="${board_state eq 1}">자유 게시판</c:when>
						<c:when test="${board_state eq 2}">모임 게시판</c:when>
						<c:when test="${board_state eq 3}">나눔 게시판</c:when>
						<c:when test="${board_state eq 4}">질문 게시판</c:when>
						<c:when test="${board_state eq 10}">불편사항 게시판</c:when>
					</c:choose>
					</c:when>
					<c:otherwise>
						자유게시판
						<c:set var="board_state" value="1"></c:set>
					</c:otherwise>
					</c:choose>
					</strong></p>
					</div>
						<div style="display: inline; float: right;">
						<select class="form-control rounded" name="board_select" id="board_select"
							style="height: 35px; width: 150px" >
							<option value="0">게시판</option>
							<option value="1">자유 게시판</option>
							<option value="2">모임 게시판</option>
							<option value="3">나눔 게시판</option>
							<option value="4">질문 게시판</option>
							<option value="10">불편사항 게시판</option>
						</select>
						</div>
				<div class="tab-content">
					<div class="tab-pane myPost active" id="myPost">
						<table class="table table-hover">
							<thead>
								<tr>
									<th><strong>제목</strong></th>
									<th><strong>날짜</strong></th>
									<th><strong>조회</strong></th>
									<th><strong>추천</strong></th>
									<th><strong>상태</strong></th>
									<th></th>
								</tr>
							</thead>
								<c:set var="i" value="${0}"></c:set>
								<tbody style="border-bottom: 1px solid #DCEBFF;">
								<c:choose>
									<c:when test="${list != null and fn:length(list) > 0}">
										<c:forEach var="b_bean" items="${list}">
											<c:set var="i" value="${i+1}"></c:set>
											<tr style="border-bottom: 1px solid #DCEBFF;">
												<td>
													<a href="/boardViewOk.bo?board_idx=${b_bean.board_idx}&board_state=${board_state}">${b_bean.board_title}</a>
												</td>
												<td>
													<fmt:formatDate value="${b_bean.board_regDate}" pattern="yyyy-MM-dd"/>
												</td>
												<td>
												${b_bean.board_readCnt}
												</td>
												<td>
												${b_bean.board_up_cnt}
												</td>
												<c:choose>
													<c:when test="${b_bean.board_blind eq 0}">
														<td>게시중</td>
														<td><a href="javascript:deleteMyBoard(${b_bean.board_idx})"
                                						 class="btn btn-primary btn-sm"style="margin-left: 10px">삭제</a>
                                						</td>
													</c:when>
													<c:when test="${b_bean.board_blind eq 1}">
														<td>신고 처리중</td>
														<td><a href="javascript:board_report_reason(${b_bean.board_idx})"
                                						 class="btn btn-primary btn-sm"style="margin-left: 10px">사유</a></td>
													</c:when>
													<c:otherwise>
														<td>블라인드 처리</td>
														<td><a href="javascript:board_report_reason(${b_bean.board_idx})"
                                						 class="btn btn-primary btn-sm"style="margin-left: 10px">사유</a></td>
													</c:otherwise>
												</c:choose>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr style="border-bottom: 1px solid #DCEBFF;">
											<td colspan="6" style="text-align: center; margin-bottom: 100px;">등록된 게시물이
												없습니다.
											</td>
										</tr>
									</c:otherwise>
								</c:choose>
								</tbody>
						</table>
						<div class="col-md-12 text-center">
							<c:if test="${pageMaker.prev}">
								<a class="changePage" href="${pageMaker.startPage - 1}"><code>&lt;</code></a>
							</c:if>
							<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
								<c:choose>
									<c:when test="${num eq pageMaker.cri.pageNum}">
										<span>${num}</span>
									</c:when>
									<c:otherwise>
										<a class="changePage" href="${num}"><code>${num}</code></a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:if test="${pageMaker.next}">
								<a class="changePage" href="${pageMaker.endPage + 1}"><code>&gt;</code></a>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<form id="actionForm" action="/member/myPage" method="get">
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
		<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
		<input type="hidden" name="board_state" value="${board_state}">
	</form>
	<!-- Start footer -->
	<jsp:include page="../menu/footer.jsp" />
	<!-- End Footer -->
	<script src="/resources/scripts/bootstrap/bootstrap.min.js"></script>
	<script
		src="https://rawgit.com/jackmoore/autosize/master/dist/autosize.min.js"></script>
</body>
<script>
var actionForm = $("#actionForm");
   autosize($("textarea.replys"));
   autosize($("textarea#contentsText"));
   $("#board_select").change(function() {
	   console.log(this.value);
		location.href = "/member/myPage?board_state="+this.value;
})
function deleteMyBoard(board_idx) {
	var board_state = "${board_state}";
	var cri = "${pageMaker.cri.getListLink()}"
	var check = confirm("해당 게시글을 삭제하시겠습니까?");
	if(check){
		location.href = "/member/deleteMyBoard${pageMaker.cri.getListLink()}&board_idx="+board_idx+"&board_state="+board_state;
	}else{
		alert("게시글 삭제를 취소합니다.");
	}
}
function board_report_reason(board_idx) {
	window.open("/MemberBoardReportReasonOk.me?board_idx="+board_idx, "a", "width=500, height=350, left=100, top=50, resizable=no");
}
$(".changePage").on("click", function(e){
	e.preventDefault();
	actionForm.find("input[name='pageNum']").val($(this).attr("href"));
	actionForm.submit();
});
$(document).ready(function(){
	 var result = "${result}";
	 if(result == "success"){
		 alert("게시글을 삭제하였습니다.");
	 }
  });
</script>
</html>