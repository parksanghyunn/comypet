<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>COMYPET &mdash; 일상이 &amp; 즐거워지는 그 순간!</title>
<%@ include file="/app/script.html" %>

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
<style>
tr {
	height: 15px;
	border-bottom: 1px solid #cccccc;
}

th {
	font-size: 15px;
	height:25px;
	background-color: #eeeeee;
	text-align: center;
	border-right: 1px solid #cccccc;
	width: 150px;
}

table {
	width: 300%;
	border-top: 3px solid #626eef;
	border-bottom: 3px solid #626eef;
}

td {
	padding-left: 10px;
	font-size: 12px;
	background-color: #f6f6f6;
	width: 20px;
	text-align: center;
}

input {
	border: none;
	outline: none;
	background-color: #f6f6f6;
	width: 45px;
	text-align: center;
	
}

html, body{
	overflow: auto;
}
	@media ( min-height :900px) and (max-height:2000px) {
   footer {
      position: bottom;
      bottom: 0;
      width: 100%;
      text-align: center;
   }
   
}
</style>
</head>
<body class="skin-purple" style="margin-top:100px; overflow-x:hidden">
	<jsp:include page="/app/menu/admin_topMenu.jsp"></jsp:include>
	
	  <c:set var="list" value="${requestScope.adminList}"/>
      <c:set var="nowPage" value="${requestScope.nowPage}"/>
      <c:set var="startPage" value="${requestScope.startPage}"/>
      <c:set var="endPage" value="${requestScope.endPage}"/>
      <c:set var="totalCnt" value="${requestScope.totalCnt}"/>
      <c:set var="totalPage" value="${requestScope.totalPage}"/>

	<div class="wrap">
	<section class="home">
		<div class="container">
			<div class="row" style="width: 105%;">
				<ul class="nav nav-tabs nav-justified" role="tablist">
						<li class="active"><a href="#board_1" aria-controls="board_1" role="tab" data-toggle="tab">관리자 리스트</a></li>
					</ul>


				<div class="tab-content">
					
					<div class="tab-pane board_1 active" id="board_1">
						<form class="search" autocomplete="off"
							style="background-color: #eeeeee;" action="/AdminSearchAdminOk.ad" method="get">
							<div class="input-group" style="width:1199px;">
								<select class="form-control rounded" name="searchCondition"
									style="height: 30px; width: 100px;">
									<option value="id">아이디</option>
									<option value="level">등급</option>
								</select> <input type="text" name="search" class="form-control"
									style="height: 30px; width: 210px;"> <a href="/AdminSearchAdminOk.ad"
									class="btn btn-primary btn-sm btn-rounded" style="height: 30px">
									<i class="ion-search"></i>
								</a>
								<c:if test="${session_level eq 3 }">
								<a href="javascript:admin_add()" class="btn btn-primary btn-sm btn-rounded" style="height:30px; margin-left: 760px;" >관리자추가</a>							
								</c:if>
								</div>
						</form>
							<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
							<thead>
								<tr>
									<th style="background-color: #eeeeee; text-align: center;">고유번호</th>
									<th style="background-color: #eeeeee; text-align: center;">ID</th>
									<th style="background-color: #eeeeee; text-align: center;">관리자 등급</th>
								</tr>
							</thead>
							<tbody>
							<c:choose>
							<c:when test="${list != null and fn:length(list) > 0 }">
								<c:forEach var="ad_bean" items="${list}">
									<tr>
										<td>${ad_bean.getAdmin_uid()}</td>
										<td>${ad_bean.getAdmin_id()}</td>
										<td>${ad_bean.getAdmin_level()}</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="3">등록된 관리자가 없습니다.</td>
								</tr>
							</c:otherwise>
							</c:choose>
							</tbody>
						</table>
						
         
         				<div class="text-center">
							<ul class="pagination" style="margin-left:63px;">
								<c:choose>
                  					<c:when test="${nowPage > 1}">
                   					  <a href="/AdminAdmin.ad?page=${nowPage - 1}">[이전]</a>&nbsp;
                 					 </c:when>
            				   </c:choose>
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
                 					 <c:choose>
                    				 <c:when test="${i eq nowPage}">
                      				 	 [${i}]&nbsp;
                    				</c:when>
                    				 <c:otherwise>
                   			  			   <a href="/AdminAdmin.ad?page=${i}">${i}&nbsp;</a>
                   					  </c:otherwise>
                  					</c:choose>
            			 	 	 </c:forEach>
								<c:choose>
                 				 <c:when test="${nowPage != totalPage}">
                  				   <a href="/AdminAdmin.ad?page=${nowPage + 1}">[다음]</a>&nbsp;
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

</body>
<script src="/resource/scripts/bootstrap/bootstrap.min.js"></script>
<script>
/* function cancleUpdate(num){
	alert("취소하시겠습니까?");
	$("#hidden"+num).css("display","none");
	$(document).ready(function(){
		$("#cancleBtn").click(function(){
			$("#updateForm")[0].reset();
		});
	});
	
	$(".info").attr("readonly", true);
	$(".info").css("border", "none");
	$("#birth").attr("readonly", true);
	$("#birth").prop("type", "text");
	$("input[name='member_gender']").attr("disabled", true);
	$(".address").css("border", "none");
	$("#address_detail").attr("readonly", true);
	$("#address_etc").attr("readonly", true);
	$("#postcodify_search_button").css("display", "none");
	$("#myInfoBtn").css("display", "");
	$("#updateInfoBtn").css("display", "none");
	$(".updateImage").css("display", "none");
	
	$("#updateOk").css("display","none");
	$("#updBtn").css("display","");
	
	return false;
} */
function admin_add() {
	window.open("/app/admin/admin_add.jsp", "a", "width=500, height=350, left=400, top=200");
}
</script>

</html>