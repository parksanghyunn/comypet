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
	
	  <c:set var="list" value="${requestScope.memberList}"/>
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
						<li class="active"><a href="#board_1" aria-controls="board_1" role="tab" data-toggle="tab">회원 리스트 </a></li>
					</ul>


				<div class="tab-content">
					<div class="tab-pane board_1 active" id="board_1">
						<form class="search" autocomplete="off"
							style="background-color: #eeeeee;" action="/AdminSearchMemberOk.ad" method="get">
							<div class="input-group">
								<select class="form-control rounded" name="searchCondition"
									style="height: 30px; width: 100px;">
									<option value="id">아이디</option>
									<option value="name">이름</option>
									<option value="gender">성별(남/여)</option>
								</select> <input type="text" name="search" class="form-control"
									style="height: 30px; width: 210px;"> <a href="/AdminSearchMemberOk.ad"
									class="btn btn-primary btn-sm btn-rounded" style="height: 30px">
									<i class="ion-search"></i>
								</a>
							</div>
						</form>

					<form style="font-size: 17px;" name="infoForm" id="updateForm" action="/AdminUpdateOk.ad" method="post">
						<table class="table table-striped"
							style="text-align: center; border: 1px solid #dddddd">
							<thead>
								<tr>
									<th>번호</th>
									<th>이름</th>
									<th>아이디</th>
									<th>닉네임</th>
									<th>성별</th>
									<th>생년월일</th>
									<th>전화번호</th>
									<th>이메일</th>
									<th>우편번호</th>
									<th>주소</th>
									<th>상세주소</th>
									<th>참고사항</th>
									<!-- <th>회원등급</th> -->
									<th>
									</th>
								</tr>
							</thead>
							<tbody>
							<c:choose>
							<c:when test="${list != null and fn:length(list) > 0 }">
								<c:forEach var="ad_bean" items="${list}">
									<tr>
										<td><input name="member_uid${ad_bean.getMember_uid()}" id="member_uid${ad_bean.getMember_uid()}" type="text" value="${ad_bean.getMember_uid()}" readonly></td>
										<td><input name="member_name${ad_bean.getMember_uid()}" id="member_name${ad_bean.getMember_uid()}" type="text" value="${ad_bean.getMember_name()}" readonly></td>
										<td><input name="member_id${ad_bean.getMember_uid()}" id="member_id${ad_bean.getMember_uid()}" type="text" value="${ad_bean.getMember_id()}" readonly></td>
										<td><input name="member_nick${ad_bean.getMember_uid()}" id="member_nick${ad_bean.getMember_uid()}" type="text" value="${ad_bean.getMember_nick()}" readonly></td>
										<td><input name="member_gender${ad_bean.getMember_uid()}" id="member_gender${ad_bean.getMember_uid()}" type="text" value="${ad_bean.getMember_gender()}" readonly></td>
										<td><input name="member_birth${ad_bean.getMember_uid()}" id="member_birth${ad_bean.getMember_uid()}" type="text" value="${ad_bean.getMember_birth()}" readonly></td>
										<td><input name="member_tel${ad_bean.getMember_uid()}" id="member_tel${ad_bean.getMember_uid()}" type="text" value="${ad_bean.getMember_tel()}" readonly></td>
										<td><input name="member_email${ad_bean.getMember_uid()}" id="member_email${ad_bean.getMember_uid()}" type="text" value="${ad_bean.getMember_email()}" readonly></td>
										<td><input name="member_zipcode${ad_bean.getMember_uid()}" id="member_zipcode${ad_bean.getMember_uid()}" type="text" value="${ad_bean.getMember_zipcode()}" readonly></td>
										<td><input name="member_address${ad_bean.getMember_uid()}" id="member_address${ad_bean.getMember_uid()}" type="text" value="${ad_bean.getMember_address()}" readonly></td>
										<td><input name="member_address_detail${ad_bean.getMember_uid()}" id="member_address_detail${ad_bean.getMember_uid()}" type="text" value="${ad_bean.getMember_address_detail()}" readonly></td>
										<td><input name="member_address_etc${ad_bean.getMember_uid()}" id="member_address_etc${ad_bean.getMember_uid()}" type="text" value="${ad_bean.getMember_address_etc()}" readonly></td>
										
										<td>
										<!-- 시퀀스 값을 updateInfo에 넘겨준다 -->
										<input type="button" value="수정" onclick="updateInfo(${ad_bean.getMember_uid()})" id="updBtn${ad_bean.getMember_uid()}">
										<input type="button" value="완료" onclick="updateOk(${ad_bean.getMember_uid()})" id="insBtn${ad_bean.getMember_uid()}" style="display:none; text-align: center; margin-left: 21px;">
										<a href="/AdminMember.ad" style="display: none; text-align: center" id="cancleBtn${ad_bean.getMember_uid()}">취소</a>
									</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="13">등록된 회원이 없습니다.</td>
								</tr>
							</c:otherwise>
							</c:choose>
							</tbody>
						</table>
					</form>
					</div>
					
					<div class="text-center">
							<ul class="pagination" style="margin-left:63px;">
								<c:choose>
                  					<c:when test="${nowPage > 1}">
                   					  <a href="/AdminMember.ad?page=${nowPage - 1}">[이전]</a>&nbsp;
                 					 </c:when>
            				   </c:choose>
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
                 					 <c:choose>
                    				 <c:when test="${i eq nowPage}">
                      				 	 [${i}]&nbsp;
                    				</c:when>
                    				 <c:otherwise>
                   			  			   <a href="/AdminMember.ad?page=${i}">${i}&nbsp;</a>
                   					  </c:otherwise>
                  					</c:choose>
            			 	 	 </c:forEach>
								<c:choose>
                 				 <c:when test="${nowPage != totalPage}">
                  				   <a href="/AdminMember.ad?page=${nowPage + 1}">[다음]</a>&nbsp;
                				  </c:when>
              					 </c:choose>
							</ul>
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
function updateInfo(num) {
	/* var num = $(".member_num").val(); */
	console.log(num);
	$("#member_nick"+num).attr("readonly", false);
	$("#member_nick"+num).css("border", "solid");
	//$("#member_"+num).css("border", "1px solid black");
	//$("#member_birth"+num).attr("readonly", false);
	//$("#member_birth"+num).css("border", "solid");
	//$("#member_birth"+num).prop("type", "date");
	$("#member_tel"+num).attr("readonly", false);
	$("#member_tel"+num).css("border", "solid");
	$("#member_email"+num).attr("readonly", false);
	$("#member_email"+num).css("border", "solid");
	$("#member_address_detail"+num).css("border", "solid");
	$("#member_address_detail"+num).attr("readonly", false);
	$("#member_address_etc"+num).attr("readonly", false);
	$("#member_address_etc"+num).css("border", "solid");
 	//$("#postcodify_search_button").css("display", "block");
	$("#updBtn"+num).css("display","none");
	$("#insBtn"+num).css("display","block");
	$("#cancleBtn"+num).css("display","block");
}
	function updateOk(num){
		var frm = document.infoForm;
		var nick = $("#member_nick"+num).val();
		var tel = $("#member_tel"+num).val();
		var email = $("#member_email"+num).val();
		var address_d = $("#member_address_detail"+num).val();
		var address_e = $("#member_address_etc"+num).val();
		
		// 공백 검사
		if(nick.replace(/\s| /gi,"").length==0){
			alert("내용을 입력해주세요.");
			$("#nick"+num).focus();
			return false;
		}
		
		if(tel.replace(/\s| /gi,"").length==0){
			alert("내용을 입력해주세요.");
			$("#nick"+num).focus();
			return false;
		}
		if(email.replace(/\s| /gi,"").length==0){
			alert("내용을 입력해주세요.");
			$("#nick"+num).focus();
			return false;
		}
		if(address_d.replace(/\s| /gi,"").length==0){
			alert("내용을 입력해주세요.");
			$("#nick"+num).focus();
			return false;
		}
		if(address_e.replace(/\s| /gi,"").length==0){
			alert("내용을 입력해주세요.");
			$("#nick"+num).focus();
			return false;
		}
		$("form[name='infoForm']").attr("action", "/AdminUpdateOk.ad?num="+num);

			frm.submit();
	}

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
</script>

</html>