<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/app/script.html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<!-- start top header -->
	<nav class="menu" style="height:50%; background-color: #333333; background-color: rgba( 232, 230, 230, 0.5 );">
		<div class="container">
			<a href="/Index.me" style="position: absolute;"><i class="icon ion-home"></i></a>
			<div style="text-align: right;">
			<c:choose>
				<c:when test="${empty session_uid}">
					<a href="/MemberLogin.me" style="color:black; font-size:12px;">로그인</a>&nbsp;
					<a href="/ToS.me" style="color:black; font-size:12px;"><b>회원가입</b></a>&nbsp;
				</c:when>
				<c:otherwise>
					<a href="/MemberMyBoardOk.me" style="color:black; font-size:12px;"><b>${session_nick}</b></a>&nbsp;
					<a href="/MemberLogOut.me" style="color:black; font-size:12px;">로그아웃</a>&nbsp;
				</c:otherwise>
			</c:choose> 
			<a href="/ads.cs" style="color:black; font-size:12px;">고객센터</a>
			</div>
		</div>
	</nav>
	<!-- end top header -->
	<div class="firstbar">
		<div class="container">
			<div style="text-align:center;">
				<a href="/Index.me"><img src="/resource/images/cmpp.png"/></a>
			</div>
			<div id="typewriteText" style="text-align:center; font-size:20px; height:50px; margin-top:20px;"></div>
		</div>
	</div>
	<br/>
	<!-- Start nav -->
	<nav class="menu" style="background:#626EEF; color:#FFF;">
		<div class="container" style="color:white;">
			<div class="mobile-toggle">
				<a href="#" data-toggle="menu" data-target="#menu-list"><i class="ion-navicon-round" style="color: white;"></i></a>
			</div>
			<div id="menu-list">
				<ul class="nav-list" style="background:#626EEF; float: left;">
					<li><a href="/Index.me" style="background:#626EEF; color:white;" ><i class="icon ion-home"></i></a></li>
					<li class="dropdown magz-dropdown"><a href="#" style="background:#626EEF; color:white;">컴마이펫</a>
						<ul class="dropdown-menu" style="background:#626EEF;">
							<li><a href="/noticeBoardListOkM.bo" style="background:#626EEF; color:white;">공지사항</a></li>
						</ul></li>
					<li class="dropdown magz-dropdown"><a href="#" style="background:#626EEF; color:white;">커뮤니티</a>
						<ul class="dropdown-menu" style="background:#626EEF;">
							<li><a href="/boardListOk.bo?board_state=1" style="background:#626EEF; color:white;">자유게시판</a></li>
							<li><a href="/boardListOk.bo?board_state=2" style="background:#626EEF; color:white;">모임게시판</a></li>
							<li><a href="/boardListOk.bo?board_state=3" style="background:#626EEF; color:white;">나눔게시판</a></li>
							<li><a href="/boardListOk.bo?board_state=4" style="background:#626EEF; color:white;">질문게시판</a></li>
						</ul>
					</li>
					<li class="dropdown magz-dropdown"><a href="#" style="background:#626EEF; color:white;">편의기능</a>
						<ul class="dropdown-menu" style="background:#626EEF;">
							<li><a href="/FindLocation.me" style="background:#626EEF; color:white;">이용시설 검색</a></li>
						</ul>
					</li>
					<li class="dropdown magz-dropdown"><a href="#" style="background:#626EEF; color:white;">갤러리</a>
						<ul class="dropdown-menu" style="background:#626EEF;">
							<li><a href="/boardListOk.bo?board_state=5" style="background:#626EEF; color:white;">강아지 갤러리</a></li>
							<li><a href="/boardListOk.bo?board_state=6" style="background:#626EEF; color:white;">고양이 갤러리</a></li>
							<li><a href="/boardListOk.bo?board_state=7" style="background:#626EEF; color:white;">일상 공유</a></li>
							<li><a href="/boardListOk.bo?board_state=8" style="background:#626EEF; color:white;">기타 갤러리</a></li>
						</ul>
					<li>
					<li><a href="/boardListOk.bo?board_state=9" style="background:#626EEF; color:white;">반려동물 찾기</a></li>
					<li class="dropdown magz-dropdown"><a href="#" style="background:#626EEF; color:white;" >고객센터</a>
						<ul class="dropdown-menu" style="background:#626EEF;">
							<li><a href="/ads.cs" style="background:#626EEF; color:white;">광고문의</a></li>
							<li><a href="/sup.cs" style="background:#626EEF; color:white;">제휴문의</a></li>
							<li><a href="/boardListOk.bo?board_state=10" style="background:#626EEF; color:white;">불편사항</a></li>
							<li><a href="/policy.cs" style="background:#626EEF; color:white;">이용약관 및 개인정보취급방침</a></li>
						</ul>
					<li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- End nav -->
</body>
<script src="/resource/js/typewrite.js"></script>
<script>
$('#typewriteText').typewrite({
  actions: [
    {type: '일상이 즐거워지는'},
    {type: '&nbsp'},
    {type: '그 순간!'},
    {type: '&nbsp'},
    {type: 'COMYPET'},
  ]
});
</script>
</html>