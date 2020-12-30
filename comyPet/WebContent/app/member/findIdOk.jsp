<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
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
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>COMYPET &mdash; 아이디 찾기 완료</title>
<link href="https://fonts.googleapis.com/css2?family=Permanent+Marker&family=Righteous&display=swap" rel="stylesheet">
</head>
<body class="skin-blue">
<jsp:include page="/app/menu/topMenu.jsp"></jsp:include>
	<section class="join">
		<div class="container" style="margin-top: 120px; margin-bottom: 150px;">
					<div style="text-align: center;">
						<h2>아이디 확인 결과입니다.</h2>
						<span>- 아이디 조회 결과 일치하는 아이디는 아래와 같습니다.<br>
						- [아이디 확인] 버튼을 클릭하시면 가입 시 등록하신 메일로 아이디를 확인할 수 있습니다. </span><br><br>
						<h4><span>아이디 : </span>${display_id}</h4><br><br>
						<input type="button" class="btn btn-primary btn-rm" value="아이디 확인" onclick="sendId()">
						<a class="btn btn-primary" href="/app/member/findPw.jsp">비밀번호 찾기</a>
					</div>
		</div>
	</section>
		<!-- Start footer -->
	<jsp:include page="/app/menu/footer.jsp" />
	<!-- End Footer -->
</body>

<script src="/resource/scripts/bootstrap/bootstrap.min.js"></script>
<script src="/resource/js/join.js"></script>
<script>
function sendId() {
	var email = "${send_email}";
	console.log("이메일 : " + email);
	if(email == null){
		alert("이미 아이디를 전송했습니다.");
	}else{
		$.ajax({
			url:"/MemberSendIdOk.me",
			type:"POST",
			data:{"email":email},
			dataType:"text",
			success:function(){
				alert("아이디를 전송했습니다.");
				location.href = "/app/member/findPw.jsp";
			},
			error: function(){
			}
		});
	}
}
</script>
</html>