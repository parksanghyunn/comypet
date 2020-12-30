<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/app/script.html"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.profile {
	border-radius: 70%;
	overflow: hidden;
	width: 100px;
	height: 100px;
}
</style>

<link rel="stylesheet" href="/resource/css/indexList.css">
</head>
<body>
	<div class="col-xs-6 col-md-4 sidebar" id="sidebar">
		<div class="sidebar-title for-tablet">Sidebar</div>
		<aside>
		<div class="aside-body">
			<div class="featured-author">
				<div class="box box-border">
					<div class="box-body" style="font-size: 12px; text-align: center;">
						<!-- 로그인 전 index -->
						<c:choose>
							<c:when test="${session_uid eq null}">
								<button class="btn btn-primary btn-block"
									onclick="location.href='/MemberLogin.me'">로그인</button>
								<br>
								<a href="/ToS.me"
									style="text-decoration: none; color: black; margin-right: 75px; font-family: 'Noto Sans KR', sans-serif;"><b>회원가입</b></a>
								<a href="/FindId.me"
									style="text-decoration: none; color: black; font-family: 'Noto Sans KR', sans-serif;"><b>아이디찾기</b></a>
								<b>|</b>
								<a href="/FindPw.me"
									style="text-decoration: none; color: black; font-family: 'Noto Sans KR', sans-serif;"><b>비밀번호찾기</b></a>
							</c:when>
							<c:when test="${session_uid != null}">
								<div class="row">
									<div class="col-md-6 col-sm-6">
										<c:choose>
											<c:when test="${session_profile eq 'defaultProfile.png'}">
												<img alt="profile"
													src="/app/upload/profile/${session_profile}"
													class="profile">
												<br>
											</c:when>
											<c:otherwise>
												<img alt="profile"
													src="/app/upload/profile/${session_uid}/${session_profile}"
													class="profile">
												<br>
											</c:otherwise>
										</c:choose>
									</div>
									<div class="col-md-6 col-sm-6">
										<h3>${session_nick}</h3>
										<a href="/MemberMyBoardOk.me?board_state=0"
											style="text-decoration: none; color: black;"><i
											class="icon ion-settings"></i> 마이페이지</a><br> <a
											href="/MemberLogOut.me"
											style="text-decoration: none; color: black;"><i
											class="icon ion-log-out"></i> 로그아웃</a>
									</div>
								</div>
							</c:when>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
		</aside>
		<aside>
		<ul class="nav nav-tabs nav-justified" role="tablist">
			<li class="active"><a href="#imContents"
				aria-controls="imContents" role="tab" data-toggle="tab">
					<div class="badge">!</div>공지사항
			</a></li>
			<li><a href="#popContents" aria-controls="popContents"
				role="tab" data-toggle="tab">
					<div class="badge">HOT</div> 인기글
			</a></li>
		</ul>
		<div class="tab-content">
			<div class="tab-pane imContents active" id="imContents">
				<ol id="noticeBoard">
				<li id ="noNotice">공지사항이 없습니다!</li>
				</ol>
			</div>
			<div class="tab-pane popContents" id="popContents">
				<ol id="hotBoard">
				<li id ="noHot">인기글이 없습니다!</li>
				</ol>
			</div>
		</div>
		</aside>
		<aside>
		<div class="aside-body">
			<figure class="ads"> <img src="/resource/images/ad.png">
			<figcaption>Advertisement</figcaption> </figure>
		</div>
		</aside>
	</div>
</body>
<script src="/resource/js/boardList.js"></script>
<script src="/resource/js/typewrite.js"></script>
<script>
$("document").ready(
		function() {
			$.ajax({
				url : "/hotBoardListOk.bo",
				dataType : "json",
				success : function(data) {
					var num = 1;
					$.each(data, function(key, val) {
						$("#noHot").remove();
						$("#hotBoard").append("<li>"+num+"위. "+"<a href=javascript:goBoardView("+data[key].BOARD_IDX+","+data[key].BOARD_STATE+")>"+data[key].BOARD_TITLE+"</a></li>");
						num++;
						if (num > 10) {
							return false;
						}
					});
				},
				error : function(err) {
				}
			})
		});
$("document").ready(
		function() {
			$.ajax({
				url : "/noticeBoardListOk.bo",
				dataType : "json",
				success : function(data) {
					var num = 1;
					$.each(data, function(key, val) {
						$("#noNotice").remove();
						$("#noticeBoard").append("<li><a href=javascript:goNoticeBoardView("+data[key].BOARD_IDX+")>"+data[key].BOARD_TITLE+"</a></li><hr>");
						num++;
						if (num > 10) {
							return false;
						}
					});
				},
				error : function(err) {
				}
			})
		});
</script>
</html>