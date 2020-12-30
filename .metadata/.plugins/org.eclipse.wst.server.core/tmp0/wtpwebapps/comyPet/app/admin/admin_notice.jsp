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
	<c:set var="list" value="${requestScope.adminBoardList}"/>
    <c:set var="nowPage" value="${requestScope.nowPage}"/>
    <c:set var="startPage" value="${requestScope.startPage}"/>
    <c:set var="endPage" value="${requestScope.endPage}"/>
    <c:set var="totalCnt" value="${requestScope.totalCnt}"/>
    <c:set var="totalPage" value="${requestScope.totalPage}"/>
    <c:set var="board_state" value="${requestScope.board_state}" />
	<jsp:include page="/app/menu/admin_topMenu.jsp"></jsp:include>
	<div class="wrap">
	<section class="home">
		<div class="container">
			<div class="row">
				<ul class="nav nav-tabs nav-justified" role="tablist">
					<li class="active"><a href="#board_1" aria-controls="board_1"
						role="tab" data-toggle="tab"> 공지사항</a></li>
				</ul>

				<div class="tab-content">
					<div class="tab-pane board_1 active" id="board_1">
						<form class="search" autocomplete="off"
							style="background-color: #eeeeee;" method="get" action="/AdminSearchBoardNotice.ad">
							<div class="input-group">
								<select class="form-control rounded" name="searchCondition"
									style="height: 30px; width: 100px;">
									<option value="title">제목</option>
									<option value="context">내용</option>
								</select> <input type="text" class="form-control" name="search"
									style="height: 30px; width: 210px;"> <a href="/AdminSearchBoardNotice.ad"
									class="btn btn-primary btn-sm btn-rounded" style="height: 30px">
									<i class="ion-search"></i>
								</a>
							</div>
						</form>
						<form name="boardFormNotice" id="NoticeForm" action="/AdminModifyNoticeOk.ad" method="get">
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
									<th style="background-color: #eeeeee; text-align: center;">								
										<a class="btn btn-primary btn-sm btn-rounded" type="button" href="/app/admin/admin_writeNotice.jsp?board=공지사항&&board_state=${board_state}" style="text-align: right;">글쓰기</a>
									</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
							<c:when test="${list != null and fn:length(list) > 0 }">
								<c:forEach var="ad_bean1" items="${list}">
									<tr>
										<td>${ad_bean1.getBoard_idx()}</td>
										<td><a href="javascript:showUpdate(${ad_bean1.getBoard_idx() })">${ad_bean1.getBoard_title()}</a></td>
										<td>${ad_bean1.getAdmin_id()}</td>
										<td><fmt:formatDate pattern="yyyy-MM-dd" value="${ad_bean1.getBoard_regDate()}"/></td>
										<td>${ad_bean1.getBoard_readCnt()}</td>
										<td>${ad_bean1.getBoard_up_cnt()}</td>
										<td><input type="hidden" value="수정" onclick="modifyBoard(${ad_bean1.getBoard_idx()})" style="border:none; outline:none">
										<input type="button" value="삭제" onclick="deleteBoard(${ad_bean1.getBoard_idx()})" style="border:none; outline:none"></td>
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
                   					  <a href="/AdminBoardListNoticeOk.ad?page=${nowPage - 1}">[이전]</a>&nbsp;
                 					 </c:when>
            				   </c:choose>
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
                 					 <c:choose>
                    				 <c:when test="${i eq nowPage}">
                      				 	 [${i}]&nbsp;
                    				</c:when>
                    				 <c:otherwise>
                   			  			   <a href="/AdminBoardListNoticeOk.ad?page=${i}">${i}&nbsp;</a>
                   					  </c:otherwise>
                  					</c:choose>
            			 	 	 </c:forEach>
								<c:choose>
                 				 <c:when test="${nowPage != totalPage}">
                  				   <a href="/AdminBoardListNoticeOk.ad?page=${nowPage + 1}">[다음]</a>&nbsp;
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
		
		function modifyBoard(num){
			var frm = document.boardFormNotice;
			var checkConfirm = confirm("이 게시글을 수정하시겠습니까?");
			if(checkConfirm == true){
				frm.num.value = num;
				frm.submit();
			}
			else{
				return false;
			}
		}
		function deleteBoard(num){
			var frm = document.boardFormNotice;
			var deleteCheck = confirm("이 게시글을 삭제하시겠습니까?");
			if(deleteCheck == true){
				frm.num.value = num;
				$("form[name='boardFormNotice']").attr("action", "/AdminDeleteOk.ad?num="+num);
				frm.submit();
			}else{
				return false;
			}
		}
		
		
		
	</script>
</body>
</html>