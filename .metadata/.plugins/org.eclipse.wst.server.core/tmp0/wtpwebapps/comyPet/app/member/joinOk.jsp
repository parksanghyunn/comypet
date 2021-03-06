<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>COMYPET &mdash; 회원가입완료</title>
<link href="https://fonts.googleapis.com/css2?family=Permanent+Marker&family=Righteous&display=swap" rel="stylesheet">
</head>
<body class="skin-blue">
<jsp:include page="/app/menu/topMenu.jsp"></jsp:include>
	<section class="join">
		<div class="container" style="margin-top: 120px; margin-bottom: 150px;">
					<div style="text-align: center;">
						<h2>회원가입 완료</h2>
						<span>COMYPET의 회원이 되신 걸 환영합니다.</span><br><br>
						<span>5초후 로그인 페이지로 이동하니</span><br>
						<span>메인페이지로 이동을 원하시는 분은 아래 버튼은 클릭해 주세요</span><br>
						<span id="time" style="font-size: 30px; font-family: 'Righteous', cursive;">5</span>
						<br>
						<a class="btn btn-primary" href="/Index.me">메인 페이지로 이동</a>
					</div>
		</div>
	</section>
		<!-- Start footer -->
	<jsp:include page="/app/menu/footer.jsp" />
	<!-- End Footer -->
</body>
<script src="/resource/scripts/bootstrap/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		setTimeout('go_url()', 5000) // 5초후 go_url() 함수를 호출한다.
	});

	var cnt = 6;
	var counter = setInterval(timer, 1000);

	function timer() {
		cnt--;
		if (cnt < 0) {
			creanInterval(counter);
			$("#time").text("");
		}
		$("#time").text(cnt);
	}
	function go_url() {
		location.href = "/MemberLogin.me";
	}
</script>
</html>