<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:set var="member_uid" value="${param.member_uid}"></c:set>
<body>
	<!-- layerPopup -->
		<div class="pop-container">
			<div class="pop-conts">
				<!--content //-->
				<div id="content" style="font-size: 11px; text-align: center;">
					<a href="javascript:window.open('/app/member/member_report.jsp?member_uid=${member_uid}', 'a', 'width=500, height=450, left=100, top=50')" style="color: black" id="report">신고하기</a><br>
					<a href="javascript:self.close()" class="btn-layerClose">닫기</a>
				</div>
				<!--// content-->
			</div>
		</div>
	<!-- End layerPopup -->
</body>
</html>