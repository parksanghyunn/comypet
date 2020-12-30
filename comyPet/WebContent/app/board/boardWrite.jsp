<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>COMYPET &mdash; 일상이 &amp; 즐거워지는 그 순간!</title>
<!-- CSS/JS 페이지 -->
<style>
/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 15% auto; /* 15% from the top and centered */
	padding: 20px;
	border: 1px solid #888;
	width: 30%; /* Could be more or less, depending on screen size */
}

.modals {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content/Box */
.modal-contents {
	background-color: #fefefe;
	margin: 15% auto; /* 15% from the top and centered */
	padding: 20px;
	border: 1px solid #888;
	width: 30%; /* Could be more or less, depending on screen size */
}
</style>
</head>
<c:set var="board_state" value="${param.board_state}"></c:set>
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
		<c:set var="board_name" value="강아지"></c:set>
	</c:when>
	<c:when test="${board_state eq 6}">
		<c:set var="board_name" value="고양이"></c:set>
	</c:when>
	<c:when test="${board_state eq 7}">
		<c:set var="board_name" value="일상공유"></c:set>
	</c:when>
	<c:when test="${board_state eq 8}">
		<c:set var="board_name" value="기타"></c:set>
	</c:when>
	<c:when test="${board_state eq 9}">
		<c:set var="board_name" value="반려동물찾기"></c:set>
	</c:when>
	<c:when test="${board_state eq 10}">
		<c:set var="board_name" value="불편사항"></c:set>
	</c:when>
</c:choose>
<body class="skin-blue">
<c:if test="${empty session_uid}">
	<script> alert('로그인 후 이용해주세요.');
		window.open("/Index.me", "_self")
	</script>
</c:if>
	<div class="lds-ring"></div>
	<jsp:include page="/app/menu/topMenu.jsp"></jsp:include>
	<section class="home">
		<div class="container">
			<div class="col-md-12">
				<ol class="breadcrumb">
					<%if(request.getParameter("board").equals("고객센터")){%>
					<li><a href="#">고객센터</a></li>
					<%}else if(request.getParameter("board").equals("갤러리")){%>
					<li><a href="#">갤러리</a></li>
					<%}else if(request.getParameter("board").equals("도움")){%>
					<li><a href="#">도움</a></li>
					<%}else{%>
					<li><a href="#">커뮤니티</a></li>
					<%}%>
					<li class="active">${board_name}</li>
				</ol>
			</div>
			<br> <br>
			<div class="col-md-8 col-sm-12 col-xs-12">
				<form method="post" id="board" enctype="multipart/form-data">
					<input type="text" id="summernote_title" name="board_title"
						class="form-control" placeholder="제목을 입력해주세요.">
					<textarea id="summernote" name="board_contents"
						style="resize: none;"></textarea>
					<div class="box box-border">
						<div class="box-body">
							<div style="text-align: center;">
								<button id="write_btn" type="button" class="btn btn-primary">등록</button>
								&nbsp;
								<button id="cancle_btn" class="btn btn-primary" type="button">취소</button>
							</div>
						</div>
					</div>
					<input type="hidden" id="summernote_state" name="board_state" value="${board_state}"/>
               </form>
					<div class="banner">
						<a href="#"><img src="/resource/images/ads.png"
							alt="Sample Article"></a>
					</div>
			</div>
			<jsp:include page="/app/menu/rightMenu.jsp"></jsp:include>
		</div>
	</section>

	<!-- 이미지 업로드 팝업 -->
	<div id="myModal" class="modal">
		<!-- Modal content -->
		<div class="modal-content">
			<p style="text-align: center;">
				<span style="font-size: 14pt;"><b><span
						style="font-size: 24pt;">이미지 업로드</span></b></span>
			</p>
			<p style="text-align: center; line-height: 1.5;">
				<br />
			</p>
			<p style="text-align: center; line-height: 1.5;">
				<span style="font-size: 14pt;">이미지 업로드중....</span>
			</p>
			<p style="text-align: center; line-height: 1.5;">
				<span style="font-size: 14pt;"><span id="count">5</span>초정도
					소요 됩니다.</span>
			</p>
			<p style="text-align: center; line-height: 1.5;">
				<br />
			</p>
			<p>
				<br />
			</p>
		</div>
	</div>

	<!-- 게시글 등록 -->
	<div id="myModals" class="modals">
		<!-- Modal content -->
		<div class="modal-contents">
			<p style="text-align: center;">
				<span style="font-size: 14pt;"><b><span
						style="font-size: 24pt;">게시글</span></b></span>
			</p>
			<p style="text-align: center; line-height: 1.5;">
				<br />
			</p>
			<p style="text-align: center; line-height: 1.5;">
				<span style="font-size: 14pt;">게시글 등록중....</span>
			</p>
			<p style="text-align: center; line-height: 1.5;">
				<span style="font-size: 14pt;"><span id="counts">5</span>초정도
					소요 됩니다.</span>
			</p>
			<p style="text-align: center; line-height: 1.5;">
				<br />
			</p>
			<p>
				<br />
			</p>
		</div>
	</div>

	<!-- Start footer -->
	<jsp:include page="/app/menu/footer.jsp"></jsp:include>
	<!-- End Footer -->
	<script src="/resource/scripts/bootstrap/bootstrap.min.js"></script>
	<script src="/resource/js/summernote/summernote-lite.js"></script>
	<script src="/resource/js/summernote/lang/summernote-ko-KR.js"></script>
	<script src="/resource/js/board.js"></script>
</body>
</html>