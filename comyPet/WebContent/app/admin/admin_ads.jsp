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
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>COMYPET &mdash; 일상이 &amp; 즐거워지는 그 순간!</title>
<%@ include file="/app/script.html" %>

</head>
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
<body class="skin-purple" style="margin-top: 80px; overflow-x:hidden">
	<c:set var="list" value="${requestScope.adminAdsList}"/>
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
						role="tab" data-toggle="tab"> 광고문의</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane board_1 active" id="board_1">
						<table class="table table-striped"
							style="text-align: center; border: 1px solid #dddddd">
							<thead>
								<tr>
									<th style="background-color: #eeeeee; text-align: center;">번호</th>
									<th style="background-color: #eeeeee; text-align: center;">담당자</th>
									<th style="background-color: #eeeeee; text-align: center;">이메일</th>
									<th style="background-color: #eeeeee; text-align: center;">연락처</th>
									<th style="background-color: #eeeeee; text-align: center;">날짜</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
							<c:when test="${list != null and fn:length(list) > 0 }">
								<c:forEach var="ad_bean1" items="${list}">
									<tr>
										<td>${ad_bean1.getCustomer_idx()}</td>
										<td><a href="javascript:showUpdate(${ad_bean1.getCustomer_idx()})">${ad_bean1.getCustomer_name()}</a></td>
										<td>${ad_bean1.getCustomer_email()}</td>
										<td>${ad_bean1.getCustomer_tel()}</td>
										<td><fmt:formatDate pattern="yyyy-MM-dd" value="${ad_bean1.getCustomer_regDate()}"/></td>
									</tr>
									<tr id="hidden${ad_bean1.getCustomer_idx() }" style="display:none;">
										<td colspan="7">
										<div id="content">
											${ad_bean1.getCustomer_contents() }
										<div style="text-align: right;">
											<input type="button" value="닫기" onclick="cancleUpdate(${ad_bean1.getCustomer_idx()})">
										</div>
										</div>
										</td>
								</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr style="text-align:center">
									<td colspan="5">등록된 게시글이 없습니다.</td>
								</tr>
							</c:otherwise>
							</c:choose>
								
							</tbody>
						</table>
						<div class="text-center">
							<ul class="pagination" style="margin-left:63px;">
								<c:choose>
                  					<c:when test="${nowPage > 1}">
                   					  <a href="/AdminAdsBoardListOk.ad?page=${nowPage - 1}">[이전]</a>&nbsp;
                 					 </c:when>
            				   </c:choose>
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
                 					 <c:choose>
                    				 <c:when test="${i eq nowPage}">
                      				 	 [${i}]&nbsp;
                    				</c:when>
                    				 <c:otherwise>
                   			  			   <a href="/AdminAdsBoardListOk.ad?page=${i}">${i}&nbsp;</a>
                   					  </c:otherwise>
                  					</c:choose>
            			 	 	 </c:forEach>
								<c:choose>
                 				 <c:when test="${nowPage != totalPage}">
                  				   <a href="/AdminAdsBoardListOk.ad?page=${nowPage + 1}">[다음]</a>&nbsp;
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
		/* $(document).ready(function() {

		resizeContent();
		
		});
		
		$(window).resize(function() {

		resizeContent();
		
		});
		
		function resizeContent() {

		var windowHeight = $(window).height();


		$('#content').css({'height':(windowHeight-200)+'px'});

		} */
		function showUpdate(num){
			$("#hidden"+num).css("display","");
		}
		function cancleUpdate(num){
			$("#hidden"+num).css("display","none");
			return false;
		}
		
		
		
		
	</script>
</body>
</html>