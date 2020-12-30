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
<c:set var="admin_uid" value="${requestScope.admin_uid}"></c:set>
<c:set var="board_idx" value="${requestScope.board_idx}"></c:set>
<c:set var="admin_id" value="${requestScope.admin_id}"></c:set>
<c:set var="board_state" value="${requestScope.board_state}"></c:set>
<body class="skin-blue">
	<jsp:include page="/app/menu/topMenu.jsp"></jsp:include>

	<section class="home">
		<article>
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-sm-12 col-xs-12">
						<div id="view">
							<ol class="breadcrumb">
								<li><a href="/noticeBoardListOkM.bo">공지사항</a></li>
								<li class="active">${board_title}</li>
							</ol>
							<header>
								<span style="font-size: 30px;">${board_title}</span>
								<div>
									<div style="margin: 0; padding: 0; position: absolute;">
										<a href="#layer1" class="btn-example" style="color: black;">${admin_id}</a>
										<span>${board_regDate}</span>
									</div>
									<div style="margin: 0; padding: 0; text-align: right;">
										<span>조회수 ${board_readCnt}</span> <span>추천
											${board_upCnt}</span>
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
	<script src="/resource/scripts/bootstrap/bootstrap.min.js"></script>
	<script src="https://rawgit.com/jackmoore/autosize/master/dist/autosize.min.js"></script>
	<script src="/resource/js/board_view.js"></script>
	<script src="/resource/js/member_popup.js"></script>
	<script>
		
	</script>
</body>
</html>