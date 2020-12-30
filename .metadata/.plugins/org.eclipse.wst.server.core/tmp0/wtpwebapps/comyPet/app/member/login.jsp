<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>COMYPET &mdash; 로그인</title>
<style>
/* @media(min-width :1440px) and (max-width:3000px) {
   footer{
      position: absolute;
      bottom: 0;
      width: 100%;
      text-align: center;
   }
} */
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
</style>
</head>
<body class="skin-blue">
	<c:if test="${not empty param.login}">
		<c:if test="${not param.login}">
			<script>alert("아이디 또는 비밀번호를 다시 확인해주세요.")</script>
		</c:if>
	</c:if>
	<jsp:include page="/app/menu/topMenu.jsp"></jsp:include>
	<section class="login">
		<div class="container">
			<div class="box-wrapper">
				<div class="box box-border">
					<div class="box-body">
						<h3>로그인</h3>
						<br>
						<form name="loginForm" action="/MemberLoginOk.me" method="post">
							<!-- 아이디 -->
							<div class="form-group">
								<label>아이디</label>
								<div class="input-group" style="width:100%">
									<input type="text" name="member_id" class="form-control" onkeypress="if( event.keyCode==13 ){login();}">
									<label id="id_check"></label>
								</div>
							</div>
							<!-- 비밀번호 -->
							<div class="form-group">
								<label>비밀번호</label>
								<input type="password" name="member_pw" class="form-control" onkeypress="if( event.keyCode==13 ){login();}">
								<label id="pw_check"></label>
							</div>
							<div style="text-align: center">
								<input type="button" class="btn btn-primary btn-block" value="로그인" onclick="login()" >
							</div>
							<br>
							<div class="form-group text-center">
								<a href="/ToS.me"
									style="text-decoration: none; color: black;">회원가입</a>&nbsp;&nbsp;&#124;&nbsp;&nbsp;
								<a href="/FindId.me"
									style="text-decoration: none; color: black;">아이디 찾기</a>&nbsp;&nbsp;&#124;&nbsp;&nbsp;
								<a href="/FindPw.me"
									style="text-decoration: none; color: black;">비밀번호 찾기</a>
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
	<script src="/resource/js/login.js"></script>
</body>
</html>