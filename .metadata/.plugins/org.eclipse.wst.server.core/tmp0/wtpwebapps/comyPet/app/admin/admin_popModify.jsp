<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
<link rel="stylesheet" type="text/css" href="/resource/css/util.css">
</head>
<body class="skin-purple" style="margin-top: 80px; overflow-x:hidden">
<c:set var="pop_bean" value="${requestScope.pop_bean}"></c:set>
	<jsp:include page="/app/menu/admin_topMenu.jsp"></jsp:include>
	<div class="wrap">
		<section class="home">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<ol class="breadcrumb">
							<li><a href="#">어드민</a></li>
							<li class="active">팝업등록</li>
						</ol>
					</div>
					<br>
					<br>
					<div class="contact_box">  
						<form id="contact" action="/PopModifyOkAction.pop" accept-charset="UTF-8" method="post" name="popModifyOk">
							<h3>팝업 등록</h3>
						    <fieldset>
						      <input value="${pop_bean.getPop_title() }" type="text" name="pop_title" tabindex="3" required>
						    </fieldset>
						    <fieldset>
						      <textarea name="pop_contents" tabindex="4" required>${pop_bean.getPop_contents() }</textarea>
						    </fieldset>
						    <fieldset>
						      <input type="hidden" name="title" value="제휴">
						      <div style="text-align:center;">
							      <input type="button" id="contact_button" value="수정완료" onclick="modifyOkAction()" >
							      <input type="button" value="취소" onclick="goBack()" id="contact_button">
							      <input type="hidden" name="num" value="${pop_bean.getPop_idx() }">
						      </div>
						    </fieldset>
						  </form>
					</div>
				</div>
			</div>
		</section>
	</div>
	<!-- Start footer -->
	<jsp:include page="/app/menu/footer.jsp"></jsp:include>
	<script src="/resource/scripts/bootstrap/bootstrap.min.js"></script>
	<!-- End Footer -->
	<script>
		function modifyOkAction(){
			var frm = document.popModifyOk;
			if(confirm("수정하시겠습니까?") == true){
				frm.submit();
			}else{
				return false;
			}
		}
		function goBack(){
			if(confirm("취소하시겠습니까?") == true){
				window.history.back();
			}else{
				return false;
			}
		}
	</script>

</body>
</html>