<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>COMYPET &mdash; 일상이 &amp; 즐거워지는 그 순간!</title>
<link rel="stylesheet" type="text/css" href="/resource/css/util.css">
</head>
<body class="skin-blue">
	<jsp:include page="/app/menu/topMenu.jsp"></jsp:include>
	<section class="category first" style="padding-top: 20px;">
		<div class="container">
			<div class="row">
				<div class="col-md-8 text-left">
					<div class="banner">
						<a href="#"><img src="/resource/images/ads.png" alt="Sample Article"></a>
					</div>
					<div class="row">
						<div class="col-md-12">
							<ol class="breadcrumb">
								<li><a href="#">고객센터</a></li>
								<li class="active">광고문의</li>
							</ol>
						</div>
						<br>
						<br>
						<div class="contact_box">  
						  <form id="contact" action="/csWrite.cs" accept-charset="UTF-8" method="post">
						    <h3>광고 문의</h3>
						    <h4>내용을 모두 기입 해주세요.</h4>
						    <fieldset>
						      <input id="cs_name" placeholder="담당자" type="text" name="cs_name" tabindex="1" required autofocus>
						    </fieldset>
						    <fieldset>
						      <input id="cs_email" placeholder="이메일" type="email" name="cs_email" tabindex="2" required>
						    </fieldset>
						    <fieldset>
						      <input id="cs_tel" placeholder="연락처" type="tel" name="cs_tel" tabindex="3" required>
						    </fieldset>
						    <fieldset>
						      <textarea id="cs_contents" placeholder="내용을 입력 해주세요." name="cs_contents" tabindex="4" required></textarea>
						    </fieldset>
						    <fieldset>
						      <input type="hidden" name="title" value="광고">
						      <div style="text-align:center;">
							      <input type="button" onclick="dcheck();" id="contact_button" value="보내기" >
						      </div>
						    </fieldset>
						  </form>
						</div>
					</div>
				</div>
				<jsp:include page="/app/menu/rightMenu.jsp"></jsp:include>
			</div>
		</div>
	</section>

	<!-- Start footer -->
	<jsp:include page="/app/menu/footer.jsp"></jsp:include>
	<!-- End Footer -->
	<script src="/resource/scripts/bootstrap/bootstrap.min.js"></script>
</body>
</html>