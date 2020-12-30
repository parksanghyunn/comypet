<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>COMYPET &mdash; 신고하기</title>
<%@ include file="/app/script.html" %>

<style>
	html, body{
		overflow: hidden;
	}
</style>
</head>
<body class="skin-blue">
	<section class="home">
		<div class="container">
			<div class="box-wrapper">
				<div class="box box-border">
					<div class="box-body">
						<h3>관리자 추가</h3>
						<form name="adminAddForm" action="/AdminAddOk.ad">
							<div>
								<label>아이디 <input type="text" id="admin_id" name="admin_id"></label>
								<p id="idCheck_text"></p>
							</div>
							<div>
								<label>비밀번호<input type="text" id="admin_pw" name="admin_pw"></label>
							</div>
							<div>
								<label>관리자 등급</label>
							</div>
							<div>
								<select name="admin_level" id="admin_level">
									<option value="1">1(일반권한)</option>
									<option value="2">2(중간권한)</option>
									<option value="3">3(최고권한)</option>
								</select>
							</div>
							<br> <br>
							<div style="text-align: center">
								<a href="javascript:formSubmit()" class="btn btn-primary">등록</a>
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
<script>var contextPath = "${pageContext.request.contextPath}";</script>
<script>
	var check = false;
	
	function formSubmit() {
		var frm = document.adminAddForm;
		if(frm.admin_id.value == '' || !check){
			alert("아이디를 확인해주세요.");
			frm.admin_id.focus();
			return false;
		}
		if(frm.admin_pw.value == ''){
			alert("비밀번호를 입력해주세요.");
			frm.admin_pw.focus();
			return false;
		}
		//frm.submit();
		if(confirm("관리자를 등록하시겠습니까?")){
			var admin_id = frm.admin_id.value;
			var admin_pw = frm.admin_pw.value;
			var admin_level = frm.admin_level.value;
			$.ajax({
				url: "/AdminAddOk.ad",
				type: 'post',
				data:{
					"admin_id":admin_id,
					"admin_pw":admin_pw,
					"admin_level":admin_level
				},
				dataType: 'text',
				success: function(data){
					if(data.trim() == "ok"){
						alert("등록되었습니다.");
						window.open("about:blank", "_self").close();
						opener.parent.location="/AdminAdmin.ad";
					}else{
						alert("등록 실패! 잠시 후 다시 시도해주세요.")
						window.open("about:blank", "_self").close();
					}
				},
				error: function(){
					console.log("오류");
				}
			})
		}else{
			alert("등록 취소!");
			return false;
			self.close();
		}
		
	}
	function checkId(id){
		//check = false;
		if(id == ""){
			$("#idCheck_text").text("아이디를 작성해주세요.");
		}else{
			$.ajax({
				url: "/AdminCheckIdOk.ad?admin_id="+id,
				type: 'get',
				dataType: 'text',
				success: function(data){
					if(data.trim() == "ok"){
						check = true;
						$("#idCheck_text").text("사용할 수 있는 아이디입니다.");
					}else{
						$("#idCheck_text").text("중복된 아이디입니다.");
						check = false;
					}
				},
				error: function(){
					console.log("오류");
				}
			})
		}
	}
	$("input[name='admin_id']").keyup(function(event){
		var id = $("input[name='admin_id']").val();
		checkId(id);
	});
</script>
</html>