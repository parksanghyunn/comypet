<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>COMYPET &mdash; 로그인</title>	

<%@ include file="/app/script.html" %>

</head>
<body>
	<c:if test="${not empty param.login }">
   		<c:if test="${not param.login }">
   			<script>
   				alert("아이디 또는 비밀번호를 다시 확인해 주세요!");
   			</script>
   		</c:if>
   </c:if>
	<section>
		<div class="container" style="text-align: center; margin: 0 auto;">
			<a href="#"> <img src="/resource/images/cmpp.png"
				alt="Magz Logo" style="width: 40%; height: 30%;">
			</a><br>
			<br>
		</div>
		<div class="container">
			<div class="box-wrapper">
				<div class="box box-border">
					<div class="box-body">
						<h3>관리자 로그인</h3>
						<br>
						<form name="adminJoinForm" action="/AdminLoginOk.ad" method="post">
							<!-- 아이디 -->
							<div class="form-group">
								<label>아이디</label> <input type="text" name="admin_id"
									class="form-control">
							</div>
							<!-- 비밀번호 -->
							<div class="form-group">
								<label class="fw">비밀번호</label> <input type="password"
									name="admin_pw" class="form-control">
							</div>
							<div style="text-align: center">
								<button class="btn btn-info btn-lg btn-block">로그인</button>
							</div>
							<br>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- JS -->
	<script src="/resource/scripts/bootstrap/bootstrap.min.js"></script>
	<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
	<script>
      $(function() {
         $("#postcodify_search_button").postcodifyPopUp();
      });
   </script>
</body>
</html>