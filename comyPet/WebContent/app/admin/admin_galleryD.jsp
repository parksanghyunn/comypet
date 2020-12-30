<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<style>
	@media ( min-height :900px) and (max-height:2000px) {
   footer {
      position: bottom;
      bottom: 0;
      width: 100%;
      text-align: center;
   }
   
}
</style>
<style>
	html{
		height:100%;
	}
	body{
		height:100%;
	}
	.wrap{
		min-height:100%;
		position:relative;
		padding-bottom:250px;
	}
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
}
</style>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>COMYPET &mdash; 일상이 &amp; 즐거워지는 그 순간!</title>
<%@ include file="/app/script.html" %>
</head>
<body class="skin-purple" style="margin-top: 80px; overflow-x:hidden">
	<c:set var="list" value="${requestScope.adminGalleryList}"/>
    <c:set var="nowPage" value="${requestScope.nowPage}"/>
    <c:set var="startPage" value="${requestScope.startPage}"/>
    <c:set var="endPage" value="${requestScope.endPage}"/>
    <c:set var="totalCnt" value="${requestScope.totalCnt}"/>
    <c:set var="totalPage" value="${requestScope.totalPage}"/>
	<jsp:include page="/app/menu/admin_topMenu.jsp"></jsp:include>
	
	<div class="wrap">
	<section class="home">
		<div class="container">
			<div class="row">
				<ul class="nav nav-tabs nav-justified" role="tablist">
					<li class="active"><a href="#board_1" aria-controls="board_1"
						role="tab" data-toggle="tab"> 일상 공유</a></li>
				</ul>

				<div class="tab-content">
					<div class="tab-pane board_1 active" id="board_1">
						<form class="search" autocomplete="off"
							style="background-color: #eeeeee;" method="get" action="/admin/AdminSearchGalleryD.ad">
							<div class="input-group">
								<select class="form-control rounded" name="searchCondition"
									style="height: 30px; width: 100px;">
									<option value="title">제목</option>
									<option value="context">내용</option>
								</select> <input type="text" class="form-control" name="search"
									style="height: 30px; width: 210px;"> <a href="/AdminSearchGalleryD.ad"
									class="btn btn-primary btn-sm btn-rounded" style="height: 30px">
									<i class="ion-search"></i>
								</a>
							</div>
						</form>
						<form name="galleryFormD" id="blindForm" action="/AdminBlindDOk.ad" method="get">
						<input type="hidden" name="num" />
						<table class="table table-striped"
							style="text-align: center; border: 1px solid #dddddd">
							<thead>
								<tr>
									<th style="background-color: #eeeeee; text-align: center;">번호</th>
									<th style="background-color: #eeeeee; text-align: center;">제목</th>
									<th style="background-color: #eeeeee; text-align: center;">작성자</th>
									<th style="background-color: #eeeeee; text-align: center;">날짜</th>
									<th style="background-color: #eeeeee; text-align: center;">조회</th>
									<th style="background-color: #eeeeee; text-align: center;">추천</th>
									<th style="background-color: #eeeeee; text-align: center;">블라인드</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
							<c:when test="${list != null and fn:length(list) > 0 }">
								<c:forEach var="ad_bean1" items="${list}">
									<tr>
										<td>${ad_bean1.getBoard_idx()}</td>
										<td><a href="javascript:showUpdate(${ad_bean1.getBoard_idx() })">${ad_bean1.getBoard_title()}</a></td>
										<td>${ad_bean1.getMember_nick()}</td>
										<td><fmt:formatDate pattern="yyyy-MM-dd" value="${ad_bean1.getBoard_regDate()}"/></td>
										<td>${ad_bean1.getBoard_readCnt()}</td>
										<td>${ad_bean1.getBoard_up_cnt()}</td>
										<c:choose>
											<c:when test="${ad_bean1.getBoard_blind() eq 2 }">
												<td>블라인드됨</td>
											</c:when>
											<c:otherwise>
												<td><input name="${ad_bean1.getBoard_idx()}" type="button" value="블라인드 처리" onclick="cutBoard(${ad_bean1.getBoard_idx()})" id="blindBtn${ad_bean.getBoard_idx()}" style="border:none; outline:none"></td>
											</c:otherwise>
										</c:choose>
									</tr>
									<tr id="hidden${ad_bean1.getBoard_idx() }" style="display:none;">
										<td colspan="7">
										<div id="content">
											${ad_bean1.getBoard_contents() }
										<div style="text-align: right;">
											<input type="button" value="닫기" onclick="cancleUpdate(${ad_bean1.getBoard_idx()})">
										</div>
										</div>
										</td>
								</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="7">등록된 게시글이 없습니다.</td>
								</tr>
							</c:otherwise>
							</c:choose>
								
							</tbody>
						</table>
						</form>
						<div class="text-center">
							<ul class="pagination" style="margin-left:63px;">
								<c:choose>
                  					<c:when test="${nowPage > 1}">
                   					  <a href="/AdminListGalleryD.ad?page=${nowPage - 1}">[이전]</a>&nbsp;
                 					 </c:when>
            				   </c:choose>
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
                 					 <c:choose>
                    				 <c:when test="${i eq nowPage}">
                      				 	 [${i}]&nbsp;
                    				</c:when>
                    				 <c:otherwise>
                   			  			   <a href="/AdminListGalleryD.ad?page=${i}">${i}&nbsp;</a>
                   					  </c:otherwise>
                  					</c:choose>
            			 	 	 </c:forEach>
								<c:choose>
                 				 <c:when test="${nowPage != totalPage}">
                  				   <a href="/AdminListGalleryD.ad?page=${nowPage + 1}">[다음]</a>&nbsp;
                				  </c:when>
              					 </c:choose>
							</ul>
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>
	</div>

	<!-- Start footer -->
	<jsp:include page="/app/menu/footer.jsp"></jsp:include>
	<!-- End Footer -->

	<script src="/resource/scripts/bootstrap/bootstrap.min.js"></script>
	<script>
		//$(document).ready(function(){
			//$("#showandhiden").click(function(){
				//status = $("#hidden").css("display"); if (status == "none") { $("#hidden").css("display", ""); } else { $("#hidden").css("display", "none"); }
			//});
		//});
		
		
		function showUpdate(num){
			$("#hidden"+num).css("display","");
		}
		function cancleUpdate(num){
			$("#hidden"+num).css("display","none");
			return false;
		}
		
		function cutBoard(num){
			var frm = document.galleryFormD;

			var checkConfirm = confirm("이 게시글을 블라인드 처리하시겠습니까?");
			if(checkConfirm == true){
				frm.num.value = num;
				frm.submit();
			}
			else{
				return false;
			}
		}
		
	</script>
</body>
</html>