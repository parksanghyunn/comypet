<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>COMYPET &mdash; 일상이 &amp; 즐거워지는 그 순간!</title>
<style>
.gallery{
  display: flex;
  width: 900px;
  margin: auto;
  justify-content: space-between;
  flex-wrap: wrap;
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
</style>
</head>
<body class="skin-blue">
	<c:set var="list" value="${requestScope.boardList}" />
	<c:set var="nowPage" value="${requestScope.nowPage}" />
	<c:set var="startPage" value="${requestScope.startPage}" />
	<c:set var="endPage" value="${requestScope.endPage}" />
	<c:set var="totalCnt" value="${requestScope.totalCnt}" />
	<c:set var="totalPage" value="${requestScope.totalPage}" />
	<c:set var="board_state" value="${requestScope.board_state}" />
	<c:set var="gallery_list" value="${requestScope.boardPathList}" />
	

	<jsp:include page="/app/menu/topMenu.jsp"></jsp:include>

	<section class="category first" style="padding-top: 20px;">
		<div class="container">
			<div class="row">
				<div class="col-md-8 text-left">
					<div class="banner">
						<a href="#"><img src="/resource/images/ads.png"
							alt="Sample Article"></a>
					</div>
					<div class="row">
						<div class="col-md-12">
							<ol class="breadcrumb">
							<c:choose>
							<c:when test="${board_state eq 10 }">
								<li><a href="#">고객센터</a></li>
								<li class="active">불편사항</li>
							</c:when>
							<c:when test="${board_state eq 5 or board_state eq 6 or board_state eq 7 or board_state eq 8}">
								<li><a href="#">갤러리</a></li>
								<c:choose>
									<c:when test="${board_state eq 5}">
										<li class="active">강아지 갤러리</li>
									</c:when>
									<c:when test="${board_state eq 6}">
										<li class="active">고양이 갤러리</li>
									</c:when>
									<c:when test="${board_state eq 7}">
										<li class="active">일상공유</li>
									</c:when>
									<c:when test="${board_state eq 8}">
										<li class="active">기타 갤러리</li>
									</c:when>
								</c:choose>
							</c:when>
							<c:when test="${board_state eq 9 }">
									<li><a>반려동물 찾기</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="#">커뮤니티</a></li>
								<c:choose>
									<c:when test="${board_state eq 1}">
										<li class="active">자유 게시판</li>
									</c:when>
									<c:when test="${board_state eq 2}">
										<li class="active">모임 게시판</li>
									</c:when>
									<c:when test="${board_state eq 3}">
										<li class="active">나눔 게시판</li>
									</c:when>
									<c:when test="${board_state eq 4}">
										<li class="active">질문 게시판</li>
									</c:when>
								</c:choose>
							</c:otherwise>
							</c:choose>
							</ol>
						</div>

						<div class="line" style="margin: 10px"></div>
					<c:choose>
						<c:when test="${board_state eq 1 || board_state eq 2 || board_state eq 3 || board_state eq 4 || board_state eq 10}">
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
												<td>${i}</td>
												<td><a
													href="javascript:goBoardView(${b_bean.getBoard_idx()},${board_state})">${b_bean.getBoard_title()}</a>
												</td>
												<td>${b_bean.getMember_nick()}</td>
												<td><fmt:formatDate
														value="${b_bean.getBoard_regDate()}" pattern="yyyy-MM-dd" />
												</td>
												<td>${b_bean.getBoard_readCnt()}</td>
												<td>${b_bean.getBoard_up_cnt()}</td>
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
						</c:when>
						<c:otherwise>
							<c:set var="i" value="${0}"></c:set>
							<c:choose>
									<c:when test="${gallery_list != null and fn:length(gallery_list) > 0}">
										<c:forEach var="b_bean" items="${gallery_list}">
											<c:set var="i" value="${i+1}"></c:set>
											<div class=".col-xs-6 .col-md-4">
											<div class="gallery">
										      <figure id=figure>
										      <c:choose>
										      	<c:when test="${b_bean.BOARD_PATH eq null}">
											        <img src="/resource/images/bg-01.jpg">
										      	</c:when>
										      	<c:otherwise>
										      		<img src="${b_bean.BOARD_PATH}">
										      	</c:otherwise>
										      </c:choose>
										        <figcaption><a href="javascript:goBoardView(${b_bean.BOARD_IDX},${b_bean.BOARD_STATE})">${b_bean.BOARD_TITLE}</a></figcaption>
										        <figcaption><fmt:formatDate value="${b_bean.BOARD_REGDATE}" pattern="yyyy-MM-dd"/></figcaption>
										      </figure>
										    </div>
										    </div>
										</c:forEach>
									</c:when>
									<c:otherwise>
											<div style="margin-top: 40%;margin-bottom: 40%;font-size: 20px; text-align:center;">
												<strong>등록된 게시물이 없습니다.</strong>
											</div>
									</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
					</div>
											<c:if test="${not empty session_uid}">
							<%-- 글 상세보기 할 때 나오는 태그 --%>
							<a href="/app/board/boardWrite.jsp?board=커뮤니티&&board_state=${board_state}"
								class="btn btn-primary btn-sm btn-rounded pull-right">글쓰기</a>
						</c:if>
						<c:if test="${not empty list }">
						<div class="col-md-12 text-center">
							<ul class="pagination" style="margin-left: 63px;">
								<c:choose>
									<c:when test="${nowPage > 1}">
										<li><a href="boardListOk.bo?page=${nowPage - 1}&board_state=${board_state}">&lt;
										</a></li>
									</c:when>
								</c:choose>
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
									<c:choose>
										<c:when test="${i eq nowPage}">
											<li><a href="#" style="background-color: #cccccc">${i}</a></li>
										</c:when>
										<c:otherwise>
											<li><a href="/boardListOk.bo?page=${i}&board_state=${board_state}">${i}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<c:choose>
									<c:when test="${nowPage != totalPage}">
										<li><a href="/boardListOk.bo?page=${nowPage + 1}&board_state=${board_state}">&gt;</a>
										</li>
									</c:when>
								</c:choose>
							</ul>
						</div>
						</c:if>
				</div>
				<jsp:include page="/app/menu/rightMenu.jsp"></jsp:include>
			</div>
		</div>
	</section>

	<!-- Start footer -->
	<jsp:include page="/app/menu/footer.jsp"></jsp:include>
	<!-- End Footer -->
</body>
<script src="/resource/scripts/bootstrap/bootstrap.min.js"></script>
<script>
	function date() {
		var date = new Date();
		var today = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()
	}
	function goBoardView(board_idx,board_state) {
		var today = date();
		if(localStorage.getItem(date+"_"+board_idx)==null){
			localStorage.setItem(date+"_"+board_idx,date+"_"+board_idx);
			location.href="/boardUpReadCntOk.bo?board_idx="+board_idx+"&board_state="+board_state;
		}else{
			location.href="/boardViewOk.bo?board_idx="+board_idx+"&board_state="+board_state;
		}
	}
	
	function muteCheck(){
		var mute = ${muteCheck};
		if(mute == 1){
			alert("글쓰기가 제한되었습니다.");
			return false;
		}else{
			location.href='/app/board/boardWrite.jsp?board=커뮤니티&&board_state=${board_state}';
		}
	}
</script>
</html>