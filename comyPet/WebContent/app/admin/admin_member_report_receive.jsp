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
<meta name="description"
	content="Magz is a HTML5 & CSS3 magazine template is based on Bootstrap 3.">
<meta name="author" content="Kodinger">
<meta name="keyword"
	content="magz, html5, css3, template, magazine template">
<!-- Shareable -->
<meta property="og:title"
	content="HTML5 & CSS3 magazine template is based on Bootstrap 3" />
<meta property="og:type" content="article" />
<meta property="og:url" content="http://github.com/nauvalazhar/Magz" />
<meta property="og:image"
	content="https://raw.githubusercontent.com/nauvalazhar/Magz/master/images/preview.png" />
<title>COMYPET &mdash; 일상이 &amp; 즐거워지는 그 순간!</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="/resource/scripts/bootstrap/bootstrap.min.css">
<!-- IonIcons -->
<link rel="stylesheet"
	href="/resource/scripts/ionicons/css/ionicons.min.css">
<!-- Toast -->
<link rel="stylesheet"
	href="/resource/scripts/toast/jquery.toast.min.css">
<!-- OwlCarousel -->
<link rel="stylesheet"
	href="/resource/scripts/owlcarousel/dist/assets/owl.carousel.min.css">
<link rel="stylesheet"
	href="/resource/scripts/owlcarousel/dist/assets/owl.theme.default.min.css">
<!-- Magnific Popup -->
<link rel="stylesheet"
	href="/resource/scripts/magnific-popup/dist/magnific-popup.css">
<link rel="stylesheet"
	href="/resource/scripts/sweetalert/dist/sweetalert.css">
<!-- Custom style -->
<link rel="stylesheet" href="/resource/css/style.css">
<link rel="stylesheet" href="/resource/css/skins/all.css">
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
	<c:set var="list" value="${requestScope.adminReportReceiveList}"/>
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
						role="tab" data-toggle="tab">유저 신고 접수</a></li>
				</ul>

				<div class="tab-content">
					<div class="tab-pane board_1 active" id="board_1">
						<form class="search" autocomplete="off" style="background-color: #eeeeee;" method="get" action="/AdminMemberReportReceiveSearch.ad">
							<input type="hidden" name="report_state" value="1"/>
							<div class="input-group">
								<select class="form-control rounded" name="searchCondition" style="height: 30px; width: 100px;">
									<option value="nick">닉네임</option>
									<option value="type">타입</option>
								</select> 
								<input type="text" class="form-control" name="search" style="height: 30px; width: 210px;"> <a href="/AdminMemberReportReceiveSearch.ad" class="btn btn-primary btn-sm btn-rounded" style="height: 30px">
									<i class="ion-search"></i>
								</a>
							</div>
						</form>
						<form name="boardForm" id="blindForm" action = "/AdminReportStateChangeOk.ad" method="get">
						<input type="hidden" name="rUid"/>
						<input type="hidden" name="reporter"/>
						<input type="hidden" name="state"/>
						<input type="hidden" name="pageState"/>
						<table class="table table-striped"
							style="text-align: center; border: 1px solid #dddddd">
							<thead>
								<tr>
									<th style="background-color: #eeeeee; text-align: center;">신고번호</th>
									<th style="background-color: #eeeeee; text-align: center;">분류</th>
									<th style="background-color: #eeeeee; text-align: center;">신고된 유저</th>
									<th style="background-color: #eeeeee; text-align: center;">날짜</th>
									<th style="background-color: #eeeeee; text-align: center;">신고자</th>
									<th style="background-color: #eeeeee; text-align: center;">정지 처리</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
							<c:when test="${list != null and fn:length(list) > 0 }">
								<c:forEach var="ad_bean1" items="${list}">
									<c:set var="type" value="${ad_bean1.getReport_type()}"/>
									<tr>
										<td>${ad_bean1.getReport_uid()}</td>
										<c:choose>
											<c:when test="${type eq '비방/욕설' or type eq '음란물' or type eq '도배'}">
												<td>${ad_bean1.getReport_type()}</td>
											</c:when>
											<c:otherwise>
												<td><a href="javascript:showUpdate(${ad_bean1.getReport_uid()})">기타</a>
											</c:otherwise>
										</c:choose>
										<td>${ad_bean1.getR_nick()}(${ad_bean1.getR_id()})</td>
										<td><fmt:formatDate pattern="yyyy-MM-dd" value="${ad_bean1.getReport_reg_date()}"/></td>
										<td>${ad_bean1.getW_nick()}(${ad_bean1.getW_id()})</td>
										<td>
											<input name="blind" type="button" value="블라인드" onclick="cutBoard(${ad_bean1.getReport_uid()},${ad_bean1.getReporter()},2,1)" id="blindBtn${ad_bean.getReport_uid()}" style="border:none; outline:none">
											<input name="cancle" type="button" value="취소" onclick="cutBoard(${ad_bean1.getReport_uid()},${ad_bean1.getReporter()},0,1)" id="blindBtn${ad_bean.getReport_uid()}" style="border:none; outline:none">
										</td>
									</tr>
									<tr id="hidden${ad_bean1.getReport_uid() }" style="display:none;">
										<td colspan="6">
										<div id="content">
											${ad_bean1.getReport_type()}
										<div style="text-align: right;">
											<input type="button" value="닫기" onclick="cancleUpdate(${ad_bean1.getReport_uid()})">
										</div>
										</div>
										</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="6">등록된 게시글이 없습니다.</td>
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
                   					  <a href="/AdminMemberReportReceiveOk.ad?page=${nowPage - 1}&report_state=1">[이전]</a>&nbsp;
                 					 </c:when>
            				   </c:choose>
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
                 					 <c:choose>
                    				 <c:when test="${i eq nowPage}">
                      				 	 [${i}]&nbsp;
                    				</c:when>
                    				 <c:otherwise>
                   			  			   <a href="/AdminMemberReportReceiveOk.ad?page=${i}&report_state=1">${i}&nbsp;</a>
                   					  </c:otherwise>
                  					</c:choose>
            			 	 	 </c:forEach>
								<c:choose>
                 				 <c:when test="${nowPage != totalPage}">
                  				   <a href="/AdminMemberReportReceiveOk.ad?page=${nowPage + 1}&report_state=1">[다음]</a>&nbsp;
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


	<!-- JS -->
	<script src="/resource/js/jquery.js"></script>
	<script src="/resource/js/jquery.migrate.js"></script>
	<script src="/resource/scripts/bootstrap/bootstrap.min.js"></script>
	<script src="/resource/scripts/jquery-number/jquery.number.min.js"></script>
	<script src="/resource/scripts/owlcarousel/dist/owl.carousel.min.js"></script>
	<script
		src="/resource/scripts/magnific-popup/dist/jquery.magnific-popup.min.js"></script>
	<script src="/resource/scripts/easescroll/jquery.easeScroll.js"></script>
	<script src="/resource/scripts/sweetalert/dist/sweetalert.min.js"></script>
	<script src="/resource/scripts/toast/jquery.toast.min.js"></script>
	<script src="/resource/js/e-magz.js"></script>

	<script>
		
		function showUpdate(num){
			$("#hidden"+num).css("display","");
		}
		function cancleUpdate(num){
			$("#hidden"+num).css("display","none");
			return false;
		}
		
		function cutBoard(rUid, reporter, state,pageState){
			var frm = document.boardForm;
			console.log("state 값 : " + state);
			console.log("rUid 값 : " + rUid)
			console.log("reporter 값 : " + reporter)
			if(state == 2){
				var checkConfirm = confirm("유저를 블라인드 처리하시겠습니까?");
			}else{
				checkConfir = confirm("취소하시겠습니까?")
			}
			if(checkConfirm == true){
				frm.rUid.value = rUid;
				frm.reporter.value = reporter;
				frm.state.value = state;
				frm.pageState.value = pageState;
				frm.submit();
			}
			else{
				return false;
			} 
		}
		
		
		
	</script>
</body>
</html>