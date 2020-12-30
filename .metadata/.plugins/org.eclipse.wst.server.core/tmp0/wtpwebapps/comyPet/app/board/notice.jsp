<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>COMYPET &mdash; 일상이 &amp; 즐거워지는 그 순간!</title>

</head>
<body class="skin-blue">
	<c:set var="list" value="${requestScope.boardList}" />
	<c:set var="nowPage" value="${requestScope.nowPage}" />
	<c:set var="startPage" value="${requestScope.startPage}" />
	<c:set var="endPage" value="${requestScope.endPage}" />
	<c:set var="totalCnt" value="${requestScope.totalCnt}" />
	<c:set var="totalPage" value="${requestScope.totalPage}" />
	<c:set var="board_state" value="${requestScope.board_state}" />

	<jsp:include page="/app/menu/topMenu.jsp"></jsp:include>

	<section class="category first" style="padding-top: 20px;">
		<div class="container">
			<div class="row">
				<div class="col-md-8 text-left">
					<div class="banner">
						<a href="http://naver.com"><img src="/resource/images/ads.png"
							alt="Sample Article"></a>
					</div>
					<div class="row">
						<div class="col-md-12">
							<ol class="breadcrumb">
								<li><a href="#">공지사항</a></li>
							</ol>
						</div>

						<div class="line" style="margin: 10px"></div>
						<table class="table table-hover">
							<thead>
								<tr>
									<th><strong>번호</strong></th>
									<th><strong>제목</strong></th>
									<th><strong>작성자</strong></th>
									<th><strong>날짜</strong></th>
									<th><strong>조회</strong></th>
									<th><strong>추천</strong></th>
								</tr>
							</thead>
							<c:set var="i" value="${0}"></c:set>
								<tbody style="border-bottom: 1px solid #DCEBFF;">
							<c:choose>
									<c:when test="${list != null and fn:length(list) > 0}">
										<c:forEach var="b_bean" items="${list}">
											<c:set var="i" value="${i+1}"></c:set>
											<tr style="border-bottom: 1px solid #DCEBFF;">
												<td>
													${i}
												</td>
											<td>
												<a href="javascript:goNoticeBoardView(${b_bean.getBoard_idx()})">${b_bean.getBoard_title()}</a>
												</td>
											<td>${b_bean.getAdmin_id()}</td>
												<td>
												<fmt:formatDate value="${b_bean.getBoard_regDate()}" pattern="yyyy-MM-dd"/>
												</td>
												<td>
												${b_bean.getBoard_readCnt()}
												</td>
											<td>
												${b_bean.getBoard_up_cnt()}
												</td>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr style="border-bottom: 1px solid #DCEBFF;">
											<td colspan="6" style="text-align: center;">
												<div style="margin-top: 40%;margin-bottom: 40%;font-size: 20px">
													<strong>등록된 공지사항이 없습니다.</strong>
												</div>
											</td>
										</tr>
									</c:otherwise>
							</c:choose>
								</tbody>
						</table>
						<c:if test="${not empty list }">
						<div class="text-center">
							<ul class="pagination" style="margin-left: 63px;">
								<c:choose>
									<c:when test="${nowPage > 1}">
										<li><a href="boardListOk.bo?page=${nowPage - 1}">&lt;
										</a></li>
									</c:when>
								</c:choose>
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
									<c:choose>
										<c:when test="${i eq nowPage}">
											<li><a href="#" style="background-color: #cccccc">${i}</a></li>
										</c:when>
										<c:otherwise>
											<li><a href="/boardListOk.bo?page=${i}">${i}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<c:choose>
									<c:when test="${nowPage != totalPage}">
										<li><a href="/boardListOk.bo?page=${nowPage + 1}">&gt;</a>
										</li>
									</c:when>
								</c:choose>
							</ul>
						</div>
						</c:if>

					</div>
				</div>
				<jsp:include page="/app/menu/rightMenu.jsp" />
			</div>
		</div>
	</section>

	<!-- Start footer -->
	<jsp:include page="/app/menu/footer.jsp"></jsp:include>
	<!-- End Footer -->
</body>
<script src="/resource/scripts/bootstrap/bootstrap.min.js"></script>
<script src="/resource/js/boardList.js"></script>
</html>