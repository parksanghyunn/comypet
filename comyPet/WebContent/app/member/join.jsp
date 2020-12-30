<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>COMYPET &mdash; 회원가입</title>
<!-- Bootstrap -->
<script src="/resource/scripts/bootstrap/bootstrap.min.js"></script>
</head>
<body class="skin-blue">
	<jsp:include page="/app/menu/topMenu.jsp"></jsp:include>
	<c:if test="${not empty param.join }">
		<c:if test="${not param.join}">
			<script>alert("회원가입 실패!");</script>
		</c:if>
	</c:if>
	<c:if test="${not empty param.email_check }">
		<c:if test="${param.email_check eq 1}">
			<script>
				alert("이미 가입된 이메일입니다.");
			</script>
		</c:if>
	</c:if>
	<section class="join">
		<div class="container">
			<div class="box-wrapper">
				<div class="box box-border">
					<div class="box-body">
						<h3>회원가입</h3>
						<br>
						<form name="joinForm" action="/MemberJoinOk.me" method="post">
							<!-- 아이디 -->
							<div class="form-group">
								<label>아이디</label>
								<div class="input-group" style="width:100%">
									<input type="text" name="member_id" id="member_id"class="form-control" style="width:80%">
									<!-- 
											아이디가 중복되지 않았으면 label에 사용 가능한 아이디라고 적어주고
											아니면 중복된 아이디라고 적어주기
									 -->
									<input type="button" class="btn btn-primary btn-rm" style="width:20%" value="중복" onclick="idCheck(joinForm.member_id.value)">
									<label id="id_check"></label>
								</div>
							</div>
							<!-- 패스워드 -->
							<div class="form-group">
								<label>비밀번호</label>
								<input type="password" name="member_pw" id="member_pw"class="form-control">
								<label id="pw_check"></label>
							</div>
							<div class="form-group">
								<label>비밀번호 확인</label>
								<input type="password" name="member_pw_re" class="form-control">
								<!-- 비밀번호와 일치하지 않았을 때 -->
								<label id="pw_re_check"></label>
							</div>
							<!-- 이름 -->
							<div class="form-group">
								<label>이름</label>
								<div class="input-group" style="width:100%">
									<input type="text" name="member_name" class="form-control">
									<label id="name_check"></label>
								</div>
							</div>
							<!-- 닉네임 -->
							<div class="form-group">
								<label>닉네임</label>
								<div class="input-group" style="width:100%">
									<input type="text" name="member_nick" class="form-control" style="width:80%">
									<input type="button" class="btn btn-primary btn-rm" style="width:20%" value="중복" onclick="nickCheck(joinForm.member_nick.value)">
									<label id="nick_check"></label>
								</div>
							</div>
							<!-- 성별 -->
							<div class="form-group">
								<label>성별</label><br>
								<input type="radio" class="checkbox-group" name="member_gender" value="남" checked />&nbsp;남&nbsp;
								<input type="radio" class="checkbox-group" name="member_gender" value="여" />&nbsp;여
							</div>
							<!-- 생년월일 -->
							<div class="form-group">
								<label>생년월일</label>
								<div class="input-group" style="width:100%">
									<input type="date" name="member_birth" class="form-control" min="1950-01-01" max="">
									<label id="bir_check"></label>
								</div>
							</div>
							<!-- 전화번호 -->
							<div class="form-group">
								<label>전화번호</label>
								<div class="input-group" style="width:100%">
									<input type="text" name="member_tel" class="form-control" placeholder="010-0000-0000">
									<label id="tel_check"></label>
								</div>
								
							</div>
							<!-- 이메일 -->
							<div class="form-group">
								<label>이메일</label>
									<div class="input-group" style="width:100%">
									<input type="text" name="member_email" id="member_email" class="form-control" placeholder="abc@abc.com" style="width:70%">
									<input type="button" class="btn btn-primary btn-rm" id="sendBtn"style="width:30%" value="발송" onclick="sendEmail()">
									<label id="email_check"></label>
								</div><br>
								<div class="input-group"style="width:100%">
									<input type="text" class="form-control" name="email_auth" id="email_auth" style="width:70%;"placeholder="인증번호를 입력해주세요." readonly>
									<input type="button" class="btn btn-primary btn-rm" id="checkEmailBtn"style="width:30%" value="확인" onclick="checkNum()" disabled>
									<label id="email_check_num" ></label>
								</div>
							</div>
							<!-- 우편번호 -->
							<div class="form-group">
								<label>우편번호</label><br>
								<div class="input-group" style="width:100%">
									<input type="text" name="member_zipcode" class="postcodify_postcode5 form-control" style="width:80%" value="" readonly />
									<input type="button" id="postcodify_search_button" class="btn btn-primary btn-sm" style="width:20%" value="검색" >
									<label id="zipcode_check"></label>
								</div>
							</div>
							<!-- 주소 -->
							<div class="form-group">
								<label>주소</label><br>
								<input type="text" name="member_address" class="postcodify_address form-control" value="" readonly />
							</div>
							<!-- 상세주소 -->
							<div class="form-group">
								<label>상세주소</label><br>
								<div class="input-group" style="width:100%">
									<input type="text" name="member_address_detail" class="postcodify_details form-control" value="" />
									<label id="detail_check"></label>
								</div>
							</div>
							<!-- 참고항목 -->
							<div class="form-group">
								<label>참고항목</label><br>
								<input type="text" name="member_address_etc" class="postcodify_extra_info form-control" value="" />
							</div>
							<div style="text-align: right;">
								<!-- 회원가입 버튼 눌렀을 때 공백이 하나라도 있으면 그 밑에 입력하라고 경고해주고, 포커스 맞춰주기 -->
								<input type="button" class="btn btn-primary" style="width: 33%" onclick="formSubmit()" value="회원가입">
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
	<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
	<script src="/resource/js/join.js"></script>
	<script>var $target_end = $(".best-of-the-week");</script>
	<script>$(function() { $("#postcodify_search_button").postcodifyPopUp(); });</script>
</body>
</html>