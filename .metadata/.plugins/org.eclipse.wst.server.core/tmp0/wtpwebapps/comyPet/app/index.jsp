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
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">	
<title>COMYPET &mdash; 일상이 &amp; 즐거워지는 그 순간!</title>
<link rel="stylesheet" href="/resource/css/indexList.css">
<style>
.gallery{
  display: flex;
  width: 100%;
  margin: auto;
  border: 2px dashed gray;
}
#figure{
  width: 200px;
  margin: 0;
  border: 1px solid #777;
  padding: 8px;
  box-sizing: border-box;
}
#figure img{
  width: 100%;
  height: 150px;
}
#figure figcaption{
  text-align: center;
  padding: 8px 4px;
}
.scale {overflow:hidden;}
/*overflow:hidden을 선언해줘야 확대 시 이미지가 밖으로 넘치지 않아요!*/
.scale img { transform:scale(1); transition:transform 0.5s linear;}
.scale:hover img { 
  transform:scale(1.1);             /*  default */
  -webkit-transform:scale(1.1);     /*  크롬 */
  -moz-transform:scale(1.1);       /* FireFox */
  -o-transform:scale(1.1);           /* Opera */
}

</style>
</head>
<c:if test="${checkCnt < 1}">
	<c:if test="${muteCheck eq 1 }">
		<script>alert("글쓰기, 댓글 기능이 제한된 유저입니다.");</script>
		<%
			session.setAttribute("checkCnt", (Integer)session.getAttribute("checkCnt") + 1);
		%>
	</c:if>
</c:if>
<body class="skin-blue">
	<!-- 탑 메뉴  -->
	<jsp:include page="/app/menu/topMenu.jsp"></jsp:include>
	<c:set var="boardDogList" value="${requestScope.boardDogList}"></c:set>
	<c:set var="boardCatList" value="${requestScope.boardCatList}"></c:set>
	<c:set var="boardEtcList" value="${requestScope.boardEtcList}"></c:set>
	<c:set var="boardFindList" value="${requestScope.boardFindList}"></c:set>
	<c:set var="boardFreeList" value="${requestScope.boardFreeList}"></c:set>
	<c:set var="boardMeetList" value="${requestScope.boardMeetList}"></c:set>
	<c:set var="boardFraList" value="${requestScope.boardFraList}"></c:set>

	<div class="modal" id="modal_0" style="display: none;">
		<div class="modal-dialog modal-notify modal-info" role="document">
			<!--Content-->
			<div class="modal-content text-center">
				<!--Header-->
				<div class="modal-header d-flex justify-content-center">
					<p class="heading_0"></p>
				</div>

				<!--Body-->
				<div class="modal-body_0" style="width: 100%; height: 350px;">

				</div>
				<!--Footer-->
				<div class="modal-footer flex-center">
					<input type="hidden" id="modal_0_input" value="">
					<button type="button" id="modal_0_notToday" class="btn btn-info"
						style="text-align: cetner;">오늘하루 보지않기</button>
					<button type="button" id="modal_0_cancle" class="btn btn-info"
						style="text-align: cetner;">닫기</button>
				</div>
			</div>
			<!--/.Content-->
		</div>
	</div>

	<div class="modal" id="modal_1" style="display: none;">
		<div class="modal-dialog modal-notify modal-info" role="document">
			<!--Content-->
			<div class="modal-content text-center">
				<!--Header-->
				<div class="modal-header d-flex justify-content-center">
					<p class="heading_1"></p>
				</div>

				<!--Body-->
				<div class="modal-body_1" style="width: 100%; height: 350px;">

				</div>
				<!--Footer-->
				<div class="modal-footer flex-center">
					<input type="hidden" id="modal_1_input" value="">
					<button type="button" id="modal_1_notToday" class="btn btn-info"
						style="text-align: cetner;">오늘하루 보지않기</button>
					<button type="button" id="modal_1_cancle" class="btn btn-info"
						style="text-align: cetner;">닫기</button>
				</div>
			</div>
			<!--/.Content-->
		</div>
	</div>
	<section class="home">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-sm-12 col-xs-12">
					<div class="banner">
						<a href="#"><img src="/resource/images/ads.png"
							alt="Sample Article"></a>
					</div>
					<div class="badge" style="margin-bottom: 10px;">NEW</div><h5 style="display: inline;">최신글</h5>
					<ul class="nav nav-tabs nav-justified" role="tablist">
						<li class="active"><a href="#board_1" aria-controls="board_1"
							role="tab" data-toggle="tab">자유게시판 </a></li>
						<li id = "meetBoardBtn"><a href="#board_2" aria-controls="board_2" role="tab"
							data-toggle="tab">모임게시판 </a></li>
						<li id= "fraBoardBtn"><a href="#board_3" aria-controls="board_3" role="tab"
							data-toggle="tab">나눔게시판 </a></li>
					</ul>

					<div class="tab-content">
						<div class="tab-pane board_1 active" id="board_1">
							<table class="table table-striped"
								style="text-align: center; border: 1px solid #dddddd">
								<thead>
									<tr>
										<th style="background-color: #eeeeee; text-align: center;">번호</th>
										<th style="background-color: #eeeeee; text-align: center;">제목</th>
										<th style="background-color: #eeeeee; text-align: center;">작성자</th>
										<th style="background-color: #eeeeee; text-align: center;">조회수</th>
										<th style="background-color: #eeeeee; text-align: center;">추천수</th>
									</tr>
								</thead>
								<tbody class="BoardList1">
								<c:choose>
									<c:when test="${boardFreeList != null and fn:length(boardFreeList) > 0}">
										<c:forEach var="b_bean" items="${boardFreeList}">
											<tr>
												<td>${b_bean.getBoard_idx()}</td>
												<td><a href="javascript:goBoardView(${b_bean.getBoard_idx()},${b_bean.getBoard_state()})">${b_bean.getBoard_title()}</a></td>
												<td>${b_bean.getMember_nick()}</td>
												<td>${b_bean.getBoard_readCnt()}</td>
												<td>${b_bean.getBoard_up_cnt()}</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr style="border-bottom: 1px solid #DCEBFF;">
											<td colspan="6" style="text-align: center;">
												<div style="margin-top: 40%; margin-bottom: 40%; font-size: 20px">
													<strong>등록된 게시물이 없습니다.</strong>
												</div>
											</td>
										</tr>
									</c:otherwise>
									</c:choose>
								</tbody>
							</table>
						</div>
						<div class="tab-pane board_2" id="board_2">
							<table class="table table-striped"
								style="text-align: center; border: 1px solid #dddddd">
								<thead>
									<tr>
										<th style="background-color: #eeeeee; text-align: center;">번호</th>
										<th style="background-color: #eeeeee; text-align: center;">제목</th>
										<th style="background-color: #eeeeee; text-align: center;">작성자</th>
										<th style="background-color: #eeeeee; text-align: center;">조회수</th>
										<th style="background-color: #eeeeee; text-align: center;">추천수</th>
									</tr>
								</thead>
								<tbody class="BoardList2">
									<c:choose>
									<c:when test="${boardMeetList != null and fn:length(boardMeetList) > 0}">
										<c:forEach var="b_bean" items="${boardMeetList}">
											<tr>
												<td>${b_bean.getBoard_idx()}</td>
												<td><a href="javascript:goBoardView(${b_bean.getBoard_idx()},${b_bean.getBoard_state()})">${b_bean.getBoard_title()}</a></td>
												<td>${b_bean.getMember_nick()}</td>
												<td>${b_bean.getBoard_readCnt()}</td>
												<td>${b_bean.getBoard_up_cnt()}</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr style="border-bottom: 1px solid #DCEBFF;">
											<td colspan="6" style="text-align: center;">
												<div style="margin-top: 40%; margin-bottom: 40%; font-size: 20px">
													<strong>등록된 게시물이 없습니다.</strong>
												</div>
											</td>
										</tr>
									</c:otherwise>
									</c:choose>
								</tbody>
							</table>
						</div>
						<div class="tab-pane board_3" id="board_3">
							<table class="table table-striped"
								style="text-align: center; border: 1px solid #dddddd">
								<thead>
									<tr>
										<th style="background-color: #eeeeee; text-align: center;">번호</th>
										<th style="background-color: #eeeeee; text-align: center;">제목</th>
										<th style="background-color: #eeeeee; text-align: center;">작성자</th>
										<th style="background-color: #eeeeee; text-align: center;">조회수</th>
										<th style="background-color: #eeeeee; text-align: center;">추천수</th>
									</tr>
								</thead>
								<tbody class="BoardList3">
									<c:choose>
									<c:when test="${boardFraList != null and fn:length(boardFraList) > 0}">
										<c:forEach var="b_bean" items="${boardFraList}">
											<tr>
												<td>${b_bean.getBoard_idx()}</td>
												<td><a href="javascript:goBoardView(${b_bean.getBoard_idx()},${b_bean.getBoard_state()})">${b_bean.getBoard_title()}</a></td>
												<td>${b_bean.getMember_nick()}</td>
												<td>${b_bean.getBoard_readCnt()}</td>
												<td>${b_bean.getBoard_up_cnt()}</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr style="border-bottom: 1px solid #DCEBFF;">
											<td colspan="6" style="text-align: center;">
												<div style="margin-top: 40%; margin-bottom: 40%; font-size: 20px">
													<strong>등록된 게시물이 없습니다.</strong>
												</div>
											</td>
										</tr>
									</c:otherwise>
									</c:choose>
								</tbody>
							</table>
						</div>
					</div>
					<div class="banner">
						<a href="#"><img src="/resource/images/ads.png"
							alt="Sample Article"></a>
					</div>
					<div class="col-md-6 col-sm-6">
						<h1 class="title-col">반려동물 최신뉴스</h1>
						<div class="newsList">
							<br>
							<ol class="rectangle-list">
							</ol>
						</div>
					</div>
					<div class="col-md-6 col-sm-6 trending-tags">
						<h1 class="title-col">반려동물 찾기</h1>
						<div class="aside-body" style="margin-top: 5px; width:100%">
							<table class="table table-striped"
								style="text-align: center; border: 1px solid #dddddd; width:100%;">
								<tbody class="BoardList4">
								<c:choose>
					<c:when test="${boardFindList != null and fn:length(boardFindList) > 0}">
						<c:forEach var="b_bean" items="${boardFindList}">
							<tr>
							<c:choose>
								<c:when test="${b_bean.BOARD_PATH eq null}">
									<td class="scale"><img src="/resource/images/bg-01.jpg" width=100px; height=100px;></td>
								</c:when>
								<c:otherwise>
									<td class="scale"><img src="${b_bean.BOARD_PATH}" width=100px; height=100px;></td>
								</c:otherwise>
								</c:choose>
									<td><a href="javascript:goBoardView(${b_bean.BOARD_IDX},${b_bean.BOARD_STATE})">${b_bean.BOARD_TITLE}</a></td>
								</tr>
								</c:forEach>
								</c:when>
								<c:otherwise>
									<tr style="border-bottom: 1px solid #DCEBFF;">
										<td colspan="6" style="text-align: center;">
											<div style="margin-top: 40%; margin-bottom: 40%; font-size: 20px">
												<strong>등록된 게시물이 없습니다.</strong>
											</div>
										</td>
									</tr>
								</c:otherwise>
								</c:choose>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<jsp:include page="/app/menu/rightMenu.jsp" />
			</div>
		</div>
	</section>

		<div class="container" style="witdh:100%;">
			<ul class="nav nav-tabs nav-justified" role="tablist">
				<li class="active"><a href="#gallery_1"
					aria-controls="gallery_1" role="tab" data-toggle="tab">강아지 갤러리</a></li>
				<li><a href="#gallery_2" aria-controls="gallery_2" role="tab"
					data-toggle="tab">고양이 갤러리 </a></li>
				<li><a href="#gallery_3" aria-controls="gallery_3" role="tab"
					data-toggle="tab">기타 갤러리</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane gallery_1 active" id="gallery_1" style="width:100%;">
				<c:choose>
					<c:when test="${boardDogList != null and fn:length(boardDogList) > 0}">
						<c:forEach var="b_bean" items="${boardDogList}">
						<div class="gallery">
							<figure id="figure" class=scale>
							<c:choose>
								<c:when test="${b_bean.BOARD_PATH eq null}">
									<img src="/resource/images/bg-01.jpg">
								</c:when>
								<c:otherwise>
									<img src="${b_bean.BOARD_PATH}">
								</c:otherwise>
							</c:choose>
								<figcaption><a href="javascript:goBoardView(${b_bean.BOARD_IDX},${b_bean.BOARD_STATE})">${b_bean.BOARD_TITLE}</a></figcaption>
							</figure>
						</div>
					</c:forEach>
					</c:when>
					<c:otherwise>
						<div style='margin-top: 10%; margin-bottom: 10%; font-size: 20px; text-align:center;'>
							<strong>등록된 게시물이 없습니다.</strong>
						</div>
					</c:otherwise>
				</c:choose>
					</div>
				<div class="tab-pane gallery_2" id="gallery_2" style="width:100%;">
				<c:choose>
					<c:when test="${boardCatList != null and fn:length(boardCatList) > 0}">
						<c:forEach var="b_bean" items="${boardCatList}">
						<div class="inner">
							<figure id="figure">
							<c:choose>
								<c:when test="${b_bean.BOARD_PATH eq null}">
									<img src="/resource/images/bg-01.jpg">
								</c:when>
								<c:otherwise>
									<img src="${b_bean.BOARD_PATH}">
								</c:otherwise>
							</c:choose>
								<figcaption><a href="javascript:goBoardView(${b_bean.BOARD_IDX},${b_bean.BOARD_STATE})">${b_bean.BOARD_TITLE}</a></figcaption>
							</figure>
						</div>
					</c:forEach>
					</c:when>
					<c:otherwise>
						<div style='margin-top: 10%; margin-bottom: 10%; font-size: 20px; text-align:center;'>
							<strong>등록된 게시물이 없습니다.</strong>
						</div>
					</c:otherwise>
				</c:choose>
				</div>
				<div class="tab-pane gallery_3" id="gallery_3" style="width:100%;">
				<c:choose>
					<c:when test="${boardEtcList != null and fn:length(boardEtcList) > 0}">
						<c:forEach var="b_bean" items="${boardEtcList}">
						<div class="gallery">
							<figure id="figure">
							<c:choose>
								<c:when test="${b_bean.BOARD_PATH eq null}">
									<img src="/resource/images/bg-01.jpg">
								</c:when>
								<c:otherwise>
									<img src="${b_bean.BOARD_PATH}">
								</c:otherwise>
							</c:choose>
								<figcaption><a href="javascript:goBoardView(${b_bean.BOARD_IDX},${b_bean.BOARD_STATE})">${b_bean.BOARD_TITLE}</a></figcaption>
							</figure>
						</div>
					</c:forEach>
					</c:when>
					<c:otherwise>
						<div style='margin-top: 10%; margin-bottom: 10%; font-size: 20px; text-align:center;'>
							<strong>등록된 게시물이 없습니다.</strong>
						</div>
					</c:otherwise>
				</c:choose>
				</div>
			</div>
		</div>
		<div class="banner">
			<a href="#"><img src="/resource/images/ads.png"
				alt="Sample Article"></a>
		</div>
	<jsp:include page="/app/menu/footer.jsp" />

	<!-- JS -->
	<script src="/resource/scripts/bootstrap/bootstrap.min.js"></script>
	<script src="/resource/js/popup.js"></script>
	<script src="/resource/js/boardList.js"></script>
	<script>
		$("document").ready(function() {
			checkjson();
		});
		
		var list = [];
		$("document").ready(
				function() {
					$.ajax({
						url : "/returnNewsList.me",
						dataType : "json",
						contentType : 'application / json',
						success : function(data) {
							$.each(data, function(key, val) {
								$(".rectangle-list")
										.append(
												"<li><a href="+data[key].link+">"
														+ data[key].title
														+ "</a></li>");
								if (data == 11) {
									return false;
								}
							});
						},
						error : function(err) {
							console.dir()
						}
					});
				});
	</script>
</body>
</html>