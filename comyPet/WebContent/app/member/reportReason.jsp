<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>COMYPET &mdash; 게시글 신고 사유</title>
<%@ include file="/app/script.html" %>
<style>
	html, body{
		overflow: auto;
	}
</style>
</head>
<c:set var = "boardReportList" value="${requestScope.boardReportList }"></c:set>
<body class="skin-blue">
	<section class="home">
		<div class="container">
			<div class="box-wrapper">
				<div class="box box-border">
					<div class="box-body">
						<h3>신고 사유</h3>
						<form name="repotrForm" action="">
							<div>
								<c:forEach var="b_bean" items="${boardReportList}">
								<span><strong>게시글 신고 사유</strong></span><br>
								<span>${b_bean.getReport_type()}</span><br>
								<span><strong>신고 날짜</strong></span><br>
								<span><fmt:formatDate value = "${b_bean.getReport_reg_date()}" pattern="yyyy-MM-dd"/></span><br><br>
								</c:forEach>
							</div>
							<br> <br>
							<div style="text-align: center">
								<a href="javascript:self.close()" class="btn btn-primary">확인</a>
							</div> 
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="/resource/scripts/bootstrap/bootstrap.min.js"></script>
</html>