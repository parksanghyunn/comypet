<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>COMYPET &mdash; 일상이 &amp; 즐거워지는 그 순간!</title>
<%@ include file="/app/script.html" %>
<!-- 에디터 -->
<link rel="stylesheet"
	href="/resource/css/summernote/summernote-lite.css">
</head>
<body class="skin-purple">
	<c:set var="board_state" value="0"></c:set>
	<c:set var="board_name" value="공지사항"></c:set>
	<c:set var="noticeBoardBean" value="${requestScope.noticeBoardBean}"/>
	<jsp:include page="/app/menu/admin_topMenu.jsp"></jsp:include>

	<section class="home">
		<div class="container">
			<form method="post" id="board" enctype="multipart/form-data">
				<input type="text" id="summernote_title" name="board_title" class="form-control" value="${noticeBoardBean.getBoard_title()}">
				<textarea id="summernote" name="board_contents" style="resize: none;">${noticeBoardBean.getBoard_contents()}</textarea>
				<div class="box box-border">
					<div class="box-body">
						<div style="text-align: center;">
							<button id="write_btn" type="button" class="btn btn-primary">수정완료</button>
							&nbsp;
							<button id="cancle_btn" class="btn btn-primary" type="button">취소</button>
						</div>
					</div>
				</div>
			</form>
			<input type="hidden" name="typeTitle" value="${board_name}">
		</div>
	</section>
	<!-- 이미지 업로드 팝업 -->
    <div id="myModal" class="modal" style="display:none;">
      <!-- Modal content -->
      <div class="modal-content">
      	<p style="text-align: center;"><span style="font-size: 14pt;"><b><span style="font-size: 24pt;">이미지 업로드</span></b></span></p>
      	<p style="text-align: center; line-height: 1.5;"><br /></p>
      	<p style="text-align: center; line-height: 1.5;"><span style="font-size: 14pt;">이미지 업로드중....</span></p>
      	<p style="text-align: center; line-height: 1.5;"><span style="font-size: 14pt;"><span id="count">5</span>초정도 소요 됩니다.</span></p>
      	<p style="text-align: center; line-height: 1.5;"><br /></p>
      	<p><br /></p>
      </div>
    </div>
    
    <!-- 게시글 등록 -->
    <div id="myModals" class="modals" style="display:none;">
      <!-- Modal content -->
      <div class="modal-contents">
      	<p style="text-align: center;"><span style="font-size: 14pt;"><b><span style="font-size: 24pt;">게시글</span></b></span></p>
      	<p style="text-align: center; line-height: 1.5;"><br /></p>
      	<p style="text-align: center; line-height: 1.5;"><span style="font-size: 14pt;">게시글 등록중....</span></p>
      	<p style="text-align: center; line-height: 1.5;"><span style="font-size: 14pt;"><span id="counts">5</span>초정도 소요 됩니다.</span></p>
      	<p style="text-align: center; line-height: 1.5;"><br /></p>
      	<p><br /></p>
      </div>
    </div>

	<!-- Start footer -->
	<jsp:include page="/app/menu/footer.jsp"></jsp:include>
	<!-- End Footer -->
	<script src="/resource/scripts/bootstrap/bootstrap.min.js"></script>
	<script src="/resource/js/summernote/summernote-lite.js"></script>
	<script src="/resource/js/summernote/lang/summernote-ko-KR.js"></script>
	<script src="/resource/js/adminBoard.js"></script>
</body>
</html>