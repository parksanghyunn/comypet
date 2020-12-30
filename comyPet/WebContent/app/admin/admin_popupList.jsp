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
<link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
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
</style>
<body class="skin-purple" style="margin-top: 80px; overflow-x:hidden">
	<c:set var="list" value="${requestScope.popupList}"/>
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
						role="tab" data-toggle="tab">팝업 리스트</a></li>
				</ul>

				<div class="tab-content">
					<div class="tab-pane board_1 active" id="board_1">
						<form name="boardFormPop" id="popForm" action="/AdminModifyPopOk.pop" method="get">
						<input type="hidden" name="num" />
						<table id="popupTable" class="table table-striped"
							style="text-align: center; border: 1px solid #dddddd">
							<thead>
								<tr>
									<th style="background-color: #eeeeee; text-align: center;">번호</th>
									<th style="background-color: #eeeeee; text-align: center;">제목</th>
									<th style="background-color: #eeeeee; text-align: center;">작성자</th>
									<th style="background-color: #eeeeee; text-align: center;">날짜</th>
									<th style="background-color: #eeeeee; text-align: center;">상태</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
							<c:when test="${list != null and fn:length(list) > 0 }">
								<c:forEach var="pop_bean" items="${list}">
									<tr>
										<td>${pop_bean.getPop_idx()}</td>
										<td><a href="javascript:showUpdate(${pop_bean.getPop_idx() })">${pop_bean.getPop_title()}</a></td>
										<td>${pop_bean.getPop_writer()}</td>
										<td><fmt:formatDate pattern="yyyy-MM-dd" value="${pop_bean.getPop_regDate()}"/></td>
										<td>
										<c:choose>
											<c:when test="${pop_bean.getPop_state() eq 1}">
												<label class="checkbox-inline">
							  						<input type="checkbox" name="popState" checked data-toggle="toggle">
							  						<input type="hidden" value="${pop_bean.getPop_state()}"/>
												</label>
											</c:when>
											<c:otherwise>
												<label class="checkbox-inline">
							  						<input type="checkbox" name="popState" data-toggle="toggle">
							  						<input type="hidden" value="${pop_bean.getPop_state()}"/>
												</label>
											</c:otherwise>
										</c:choose>
										</td>
									</tr>
									<tr id="hidden${pop_bean.getPop_idx() }" style="display:none;">
										<td colspan="7">
										<div id="content">
											${pop_bean.getPop_contents() }
										<div style="text-align: right;">
											<input type="button" value="수정" onclick="modifyPop(${pop_bean.getPop_idx() })">
											<input type="button" value="닫기" onclick="cancleUpdate(${pop_bean.getPop_idx()})">
										</div>
										</div>
										</td>
								</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="7">등록된 팝업이 없습니다.</td>
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
                   					  <a href="/popupListView.pop?page=${nowPage - 1}">[이전]</a>&nbsp;
                 					 </c:when>
            				   </c:choose>
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
                 					 <c:choose>
                    				 <c:when test="${i eq nowPage}">
                      				 	 [${i}]&nbsp;
                    				</c:when>
                    				 <c:otherwise>
                   			  			   <a href="/popupListView.pop?page=${i}">${i}&nbsp;</a>
                   					  </c:otherwise>
                  					</c:choose>
            			 	 	 </c:forEach>
								<c:choose>
                 				 <c:when test="${nowPage != totalPage}">
                  				   <a href="/popupListView.pop?page=${nowPage + 1}">[다음]</a>&nbsp;
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
	<script src="/resource/js/popupMgm.js"></script>
	<script>
	function showUpdate(num){
		$("#hidden"+num).css("display","");
	}
	function cancleUpdate(num){
		$("#hidden"+num).css("display","none");
		return false;
	}
	
	function modifyPop(num){
		var frm = document.boardFormPop;
		var checkConfirm = confirm("이 게시글을 수정하시겠습니까?");
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