/**
 * 로그인
 */
function checkId(id) {
	if (id == "") {
		$("#id_check").css("color", "red");
		$("#id_check").text("아이디를 입력해주세요.");
	} else {
		$("#id_check").text("");
	}
}
function checkPw(pw) {
	if (pw == "") {
		$("#pw_check").css("color", "red");
		$("#pw_check").text("비밀번호를 입력해주세요.");
	} else {
		$("#pw_check").text("");
	}
}
$("input[name='member_id']").keyup(function(event) {
	var id = $("input[name='member_id']").val();
	checkId(id);
});
$("input[name='member_pw']").keyup(function(event) {
	var pw = $("input[name='member_pw']").val();
	checkPw(pw);
});
function login(){
	var form = document.loginForm;
	
	if(form.member_id.value == ""){
		$("#id_check").css("color","red");
		$("#id_check").text("아이디를 입력해주세요.");
		return false;
	}
	
	if(form.member_pw.value == ""){
		$("#pw_check").css("color","red");
		$("#pw_check").text("비밀번호를 입력해주세요.");
		return false;
	}
	
	form.submit();
}