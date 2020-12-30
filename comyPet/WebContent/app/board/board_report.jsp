<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>COMYPET &mdash; 신고하기</title>
<%@ include file="/app/script.html" %>
<!-- Bootstrap -->
<style>
	html, body{
		overflow: hidden;
	}
</style>
</head>
<c:set var="board_idx" value="${param.board_idx }"></c:set>
<c:set var="member_uid" value="${param.member_uid}"></c:set>
<c:set var="board_state" value="${param.board_state}"></c:set>
<body class="skin-blue">
	<section class="home">
		<div class="container">
			<div class="box-wrapper">
				<div class="box box-border">
					<div class="box-body">
						<h3>게시글 신고</h3>
						<form name="repotrForm" action="">
							<div>
								<input type="radio" class="checkbox-group" name="report" value="비방/욕설">&nbsp;비방/욕설<br>
								<input type="radio" class="checkbox-group" name="report" value="음란물">&nbsp;음란물<br>
								<input type="radio" class="checkbox-group" name="report" value="도배">&nbsp;도배<br>
								<input type="radio" class="checkbox-group" name="report" value="기타" >&nbsp;기타 : 
								<textarea name="reportEtc" id= "reportEtc" readonly style="background-color: #f6f6f6;width: 100%; height: 100%; resize: none;"></textarea>
							</div>
							<br> <br>
							<div style="text-align: center">
								<input type="hidden" value="${board_idx}" id ="board_idx">
								<input type="hidden" value="${member_uid}" id ="member_uid">
								<input type="hidden" value="${board_state}" id ="board_state">
								<a href="javascript:report()" class="btn btn-primary">신고</a>
								<a href="javascript:self.close()" class="btn btn-primary">취소</a>
							</div> 
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
<script src="/resource/scripts/bootstrap/bootstrap.min.js"></script>
<script>
var textCheck = true;
$("input:radio[name=report]").click(function() {
	if ($("input:radio[name=report]:checked").val() == "기타") {
		$("#reportEtc").attr("readonly", false);
		$("#reportEtc").css("background-color", "WHITE");
	} else {
		$("#reportEtc").attr("readonly", true);
		$("#reportEtc").css("background-color", "#f6f6f6");
		$("#reportEtc").val("");
	}
});

$("#reportEtc").keyup(function() {
	if ($("#reportEtc").val().length > 20) {
		alert("신고 내용은 20자까지 가능합니다.");
		textCheck = false;
	} else {
		textCheck = true;
	}
})
function report() {
	var board_state = $("#board_state").val();
	var board_idx = $("#board_idx").val();
	var member_uid = $("#member_uid").val();
	
	if (textCheck) {
		var frm = document.repotrForm;
		var check = $("input:radio[name=report]").is(":checked");
		var report_type = $("input:radio[name=report]:checked").val();
		
		if (check) {
			if (report_type == "기타") {
				report_type = "기타:"+$("#reportEtc").val();
			}
			var result = confirm("신고 하시겠습니까?");
			if (result) {
				$.ajax({
					url : "/boardReportOk.bo",
					type : "POST",
					data : {
						"report_type" : report_type,
						"member_uid" : member_uid,
						"board_idx" : board_idx,
						"board_state" : board_state
					},
					dataType : "text",
					success : function(data) {
						console.dir(data);
						if (data.trim() == "ok") {
							alert("신고가 접수되었습니다.");
						}else{
							alert("신고 접수가 되지 않았음");
						}
						window.open("about:blank", "_self").close();
					},
					error : function() {
						alert("신고 실패, 잠시 후 다시 시도해 주세요.");
						window.open("about:blank", "_self").close();
					}
				});

			} else {
				alert("신고가 취소되었습니다.");
				self.close();
			}
		} else {
			alert("신고 유형을 선택해주세요");
			return false;
		}
	}
}
</script>
</html>