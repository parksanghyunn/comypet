<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<title>COMYPET &mdash; 비밀번호 변경</title>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body class="skin-blue">
<c:if test="${empty session_uid}">
	<script> alert('로그인 후 이용해주세요.');
		window.open("/Index.me", "_self")
	</script>
</c:if>
	<jsp:include page="/app/menu/topMenu.jsp"></jsp:include>
	<c:if test="${not empty param.reason}">
	   <c:if test="${param.reason eq 'now'}">
	      <script>alert("현재 비밀번호가 틀립니다.")</script>
	   </c:if>
	   <c:if test="${param.reason eq 'change'}">
	      <script>alert("변경할 비밀번호를 확인해주세요.")</script>
	   </c:if>
	</c:if>
	<section class="join">
		<div class="container">
			<div class="box-wrapper">
				<div class="box box-border">
					<div class="box-body">
						<h3>비밀번호 변경</h3>
						<br>
						<form name="changeForm" action="/MemberChangePwOk.me?member_id=${session_id}" method="post">
							<div class="form-group">
								<label>현재 비밀번호</label> 
								<input type="password" name="member_pw" class="form-control" value=""> <br> 
								<label>변경 비밀번호</label> 
								<input type="password" name="member_change_pw" class="form-control" value=""> <br> 
								<label>변경 비밀번호 확인</label> 
								<input type="password" name="member_change_pw_re" class="form-control" value=""> <br>
								<div style="text-align: right;">
									<input type="button" onclick="changePw()" class="btn btn-primary" value="변경"> 
									<a href="/MemberMyPage.me" class="btn btn-primary">취소</a>
								</div>
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
	<script>
	function changePw(){
		var form = document.changeForm;
		
		if(form.member_pw.value == ""){
			alert("현재 비밀번호를 입력해주세요.");
			return false;
		}
		
		if(form.member_change_pw.value == ""){
			alert("변경할 비밀번호를 입력해주세요.");
			return false;
		}
		
		if(form.member_change_pw_re.value==""){
			alert("변경할 비밀번호 확인을 입력해주세요.");
			return false;
		}
		
		form.submit();
	}
	</script>
</body>
</html>