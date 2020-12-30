<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>COMYPET &mdash; 아이디 찾기</title>
</head>
<!-- <style>
html, body{
	overflow-x:hidden; 
}
 @media ( min-height :900px) and (max-height:2000px) {
	footer {
		position: absolute;
		bottom: 0;
		width: 100%;
		text-align: center;
	}
}
</style> -->
<body class="skin-blue">
	<c:if test="${not empty param.findId}">
		<c:if test="${not param.findId}">
			<script>alert("등록된 정보가 없습니다. 다시 입력해주세요.")</script>
		</c:if>
	</c:if>
	<jsp:include page="/app/menu/topMenu.jsp"></jsp:include>
	<section class="container">
		<div class="container">
			<div class="box-wrapper">
				<div class="box box-border">
					<div style="width:100%">
						<a href="#" class="btn btn-primary btn-lg" style="width:50%; background-color:white; color:black;">아이디 찾기</a>
						<a href="/FindPw.me" class="btn btn-primary btn-lg" style="width:50%; float:right;">비밀번호 찾기</a>
					</div>
				</div>
			</div><br>
			<div class="box-wrapper">
				<div class="box box-border">
					<div class="box-body">
						<h4>아이디 찾기</h4>
						<form name="findForm" action="/MemberFindIdOk.me" method="POST">
							<p>＊회원정보에 등록된 이름과 이메일을 입력해주세요.</p>
							<div class="title-line"></div>
							<div class="form-group">
								<label>이름</label>
								<div class="input-group" style="width:100%">
									<input type="text" name="member_name" class="form-control" onkeypress="if( event.keyCode==13 ){findId();}">
									<label id="name_check"></label>
								</div>
							</div>
							<div class="form-group">
								<label>이메일</label>
								<div class="input-group" style="width:100%">
									<input type="text" name="member_email" class="form-control" placeholder="abc@abc.com" onkeypress="if( event.keyCode==13 ){findId();}">
									<label id="email_check"></label>
								</div>
							</div>
							<div class="form-group"style="text-align: center">
								<input type="button" class="btn btn-primary " style="width:33%" value="확인" onclick="findId()">
								&nbsp;&nbsp;
								<a href="/MemberLogin.me" class="btn btn-primary " style="width: 33%">취소</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Start footer -->
	<jsp:include page="/app/menu/footer.jsp" />
	<!-- End Footer -->
	<!-- JS -->
<script src="/resource/scripts/bootstrap/bootstrap.min.js"></script>
<script src="/resource/js/join.js"></script>
</body>
</html>