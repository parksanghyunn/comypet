/**
 *  회원가입
 */
var idcheck = false;
var nickcheckB = false;
var emailCheck = false;
var pwCheck = false;
function idCheck(id){
   var hangleCheck =/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
   var sc = /^(?=.*?[#?!@$%^&*-])/;
   var num = /^(?=.*?[0-9])/;
   if(id == ""){
      $("#id_check").css("color", "red");
      $("#id_check").text("아이디를 입력해주세요.");
      return false;
   }
   
   if(id.length < 4){
      $("#id_check").css("color", "red");
      $("#id_check").text("아이디는 4글자 이상입니다.");
      return false;
   }
   if(id.length > 12){
      $("#id_check").css("color", "red");
      $("#id_check").text("아이디는 12글자 이하입니다.");
      return false;
   }
   //아이디에 한글과 특수문자를 포함할 수 없다.
   if(hangleCheck.test(id) || sc.test(id)){
      $("#id_check").css("color", "red");
      $("#id_check").text("아이디에 한글이나 특수문자를 사용할 수 없습니다.");
      return false;
   }
   //아이디에 공백을 포함할 수 없다.
   if(id.search(/\s/) != -1){
      $("#id_check").css("color", "red");
      $("#id_check").text("아이디는 공백없이 입력해주세요.");
      return false;
   }

   $.ajax({
      url:"/MemberCheckIdOk.me",
      type:"POST",
      data:{"id":id},
      dataType:"text",
      success:function(data){
         console.log(data);
         if(data.trim() == "ok"){
            $("#id_check").css("color", "green");
            $("#id_check").text("사용할 수 있는 아이디입니다.");
            idcheck = true;
         }else{
            $("#id_check").css("color", "red");
            $("#id_check").text("중복된 아이디입니다.");
            idcheck = false;
         }
      },
      error: function(){
         alert("잠시후 다시 시도해주세요");
      }
   });
}

function formSubmit(){
   var form = document.joinForm;


   if(form.member_id.value==''){
      $("#id_check").css("color", "red");
      $("#id_check").text("아이디를 입력해주세요.");
      form.member_id.focus();
      return false;
   }

   if(!idcheck){
      alert("아이디 중복 확인을 해주세요.");
      form.member_id.focus();
      return false;
   }

   if(form.member_pw.value == ''){
      $("#pw_check").css("color", "red");
      $("#pw_check").text("비밀번호를 입력해주세요.");
      form.member_pw.focus();
      return false;
   }

   if(form.member_pw.value != form.member_pw_re.value){
      $("#pw_re_check").css("color", "red");
      $("#pw_re_check").text("비밀번호가 같은지 확인해주세요.");
      form.member_pw_re.focus();
      return false;
   }
   
   if(!pwCheck){
      alert("비밀번호를 형식에 맞게 입력해주세요.");
      form.member_pw.focus();
      return false;
   }

   if(form.member_name.value==''){
      $("#name_check").css("color", "red");
      $("#name_check").text("이름을 입력해주세요.");
      form.member_name.focus();
      return false;
   }

   if(form.member_nick.value==''){
      $("#nick_check").css("color", "red");
      $("#nick_check").text("닉네임을 입력해주세요.");
      form.member_nick.focus();
      return false;
   }

   if(!nickcheckB){
      $("#nick_check").css("color", "red");
      $("#nick_check").text("닉네임을 확인해주세요.");
      form.member_nick.focus();
      return false;
   }
   if(form.member_birth.value==''){
      $("#bir_check").css("color","red")   ;
      $("#bir_check").text("생일을 선택해주세요.");
      form.member_birth.focus();
      return false;
   }

   if(form.member_tel.value==''){
      $("#tel_check").css("color", "red");
      $("#tel_check").text("전화번호를 입력해주세요.");
      form.member_tel.focus();
      return false;
   }

   if(form.member_email.value == ''){
      $("#email_check").css("color", "red");
      $("#email_check").text("이메일을 입력해주세요.");
      form.member_email.focus();
      return false;
   }
   if(!emailCheck){
      $("#email_check_num").css("color", "red");
      $("#email_check_num").text("이메일을 인증해주세요.");
      form.member_email.focus();
      return false;
   }

   if(form.member_zipcode.value == ''){
      $("#zipcode_check").css("color","red");
      $("#zipcode_check").text("우편번호를 선택해주세요.");
      return false;
   }

   if(form.member_address_detail.value == ''){
      $("#detail_check").css("color","red");
      $("#detail_check").text("우편번호를 선택해주세요.");
      return false;
   }
   if(confirm("회원가입을 하시겠습니까?")){
      form.submit();
   }else{
      alert("회원가입을 취소하셨습니다.");
   }
}

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
      pwCheck = false;
   }else{
      var reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
      var hangleCheck =/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
      console.log(pw);
      if(!reg.test(pw)){
         $("#pw_check").css("color", "red");
         $("#pw_check").text("비밀번호는 8자 이상 이어야 하며, 대문자/소문자/숫자/특수문자 모두 포함해야 합니다.");
         pwCheck = false;
         return false;
      } 
      //같은 문자를 4번 이상 사용할 수 없다.
      if(/(\w)\1\1\1/.test(pw)){
         $("#pw_check").css("color", "red");
         $("#pw_check").text("같은 문자를 4번 이상 사용하실 수 없습니다.");
         pwCheck = false;
         return false;
      }
      //비밀번호에 아이디가 포함되어 있을 수 없다.
      if(pw.search($("member_id").val()) < -1){
         $("#pw_check").text("비밀번호에 아이디를 포함할 수 없습니다.");
         pwCheck = false;
         return false;
      }
      //비밀번호에 공백을 포함할 수 없다.
      if(pw.search(/\s/) != -1){
         $("#pw_check").css("color", "red");
         $("#pw_check").text("비밀번호는 공백없이 입력해주세요.");
         pwCheck = false;
         return false;
      }
      //비밀번호에 한글을 포함할 수 없다.
      if(hangleCheck.test(pw)){
         $("#pw_check").css("color", "red");
         $("#pw_check").text("비밀번호에 한글을 사용할 수 없습니다.");
         pwCheck = false;
         return false;
      }
      /* 모든 조건이 충족하면 없애기 */
      $("#pw_check").css("color", "GREEN");
      $("#pw_check").text("사용가능한 비밀번호입니다.");
      pwCheck = true;
   }
}

function checkPwRe(pw_re) {
   if (pw_re == "") {
      $("#pw_re_check").css("color", "red");
      $("#pw_re_check").text("비밀번호를 입력해주세요.");
   } else {
      if($("#member_pw").val() == pw_re){
         $("#pw_re_check").css("color", "GREEN");
         $("#pw_re_check").text("비밀번호가 확인되었습니다.");
         console.log("비밀번호 체크 : " + pwCheck);
      }else{
         $("#pw_re_check").css("color", "red");
         $("#pw_re_check").text("비밀번호를 확인해주세요.");
      }
   }
}

function checkName(name) {
   if (name == "") {
      $("#name_check").css("color", "red");
      $("#name_check").text("이름을 입력해주세요.");
   } else {
      $("#name_check").text("");
   }
}

function checkNick(nick) {
   if (nick == "") {
      $("#nick_check").css("color", "red");
      $("#nick_check").text("닉네임을 입력해주세요.");
   }else if(nick.length > 4){
      $("#nick_check").css("color", "red");
      $("#nick_check").text("닉네임은 4자리까지만 가능합니다.");
      return false;
   }
}

function nickCheck(nick) {
   if(nick.length > 4){
      $("#nick_check").css("color", "red");
      $("#nick_check").text("닉네임은 4자리까지만 가능합니다.");
   }else{
      
   $.ajax({
      url:"/MemberCheckNickOk.me",
      type:"POST",
      data:{"nick":nick},
      dataType:"text",
      success:function(data){
         console.log(data);
         if(data.trim() == "ok"){
            $("#nick_check").css("color", "green");
            $("#nick_check").text("사용할 수 있는 닉네임입니다.");
            nickcheckB = true;
         }else{
            $("#nick_check").css("color", "red");
            $("#nick_check").text("사용중인 닉네임입니다.");
            nickcheckB = false;
         }
      },
      error: function(){
         alert("잠시후 다시 시도해주세요");
      }
   });
   }
}

function checkBir(bir) {
   if (bir == "") {
      $("#bir_check").css("color", "red");
      $("#bir_check").text("생일을 입력해주세요.");
   } else {
      $("#bir_check").text("");
   }
}

function checkTel(tel) {
   $("#bir_check").text("");
   if (tel == "") {
      $("#tel_check").css("color", "red");
      $("#tel_check").text("전화번호를 입력해주세요.");
   } else {
      $("#tel_check").text("");
   }
}

function checkEmail(email) {
   if (email == "") {
      $("#email_check").css("color", "red");
      $("#email_check").text("이메일을 입력해주세요.");
   } else {
      var regEmail = /^[0-9a-zA-Z][0-9a-zA-Z\_\-\.\+]+[0-9a-zA-Z]@[0-9a-zA-Z][0-9a-zA-Z\_\-]*[0-9a-zA-Z](\.[a-zA-Z]{2,6}){1,2}$/;

      if(!regEmail.test(email)){
         $("#email_check").css("color", "red");
         $("#email_check").text("이메일형식이 올바르지 않습니다.");
      }else{
         $("#email_check").text("");
      }
   }
}

function checkBir(bir) {
   if (bir == "") {
      $("#bir_check").css("color", "red");
      $("#bir_check").text("생년월일을 입력해주세요.");
   } else {
      $("#bir_check").text("");
   }
}

function checkZip(zipcode) {
   if (zipcode == "") {
      $("#zip_check").css("color", "red");
      $("#zip_check").text("우편번호를 선택해주세요.");
   } else {
      $("#zip_check").text("");
   }
}

function checkDetail(detail) {
   if (detail == "") {
      $("#detail_check").css("color", "red");
      $("#detail_check").text("우편번호를 선택해주세요.");
   } else {
      $("#detail_check").text("");
   }
}

$("input[name='member_id']").click(function(event) {
   var id = $("input[name='member_id']").val();
   checkId(id);
});
$("input[name='member_id']").keyup(function(event) {
   var id = $("input[name='member_id']").val();
   checkId(id);
});

$("input[name='member_pw']").click(function(event) {
   var pw = $("input[name='member_pw']").val();
   checkPw(pw);
});
$("input[name='member_pw']").keyup(function(event) {
   var pw = $("input[name='member_pw']").val();
   checkPw(pw);
});

$("input[name='member_pw_re']").click(function(event) {
   var pw_re = $("input[name='member_pw_re']").val();
   checkPwRe(pw_re);
});
$("input[name='member_pw_re']").keyup(function(event) {
   var pw_re = $("input[name='member_pw_re']").val();
   checkPwRe(pw_re);
});

$("input[name='member_name']").click(function(event) {
   var name = $("input[name='member_name']").val();
   checkName(name);
});
$("input[name='member_name']").keyup(function(event) {
   var name = $("input[name='member_name']").val();
   checkName(name);
});

$("input[name='member_nick']").click(function(event) {
   var nick = $("input[name='member_nick']").val();
   checkNick(nick);
});
$("input[name='member_nick']").keyup(function(event) {
   var nick = $("input[name='member_nick']").val();
   checkNick(nick);
});

$("input[name='member_tel']").click(function(event) {
   var tel = $("input[name='member_tel']").val();
   checkTel(tel);
});
$("input[name='member_tel']").keyup(function(event) {
   var tel = $("input[name='member_tel']").val();
   checkTel(tel);
});

$("input[name='member_email']").click(function(event) {
   var email = $("input[name='member_email']").val();
   checkEmail(email);
});
$("input[name='member_email']").keyup(function(event) {
   var email = $("input[name='member_email']").val();
   checkEmail(email);
});

$("input[name='member_birth']").click(function(event) {
   var bir = $("input[name='member_birth']").val();
   checkBir(bir);
});
$("input[name='member_birth']").keyup(function(event) {
   var bir = $("input[name='member_birth']").val();
   checkBir(bir);
});


$("input[name='member_address_detail']").click(function(event) {
   var detail = $("input[name='member_address_detail']").val();
   checkDetail(detail);
});
$("input[name='member_address_detail']").keyup(function(event) {
   var detail = $("input[name='member_address_detail']").val();
   checkDetail(detail);
});
$("input[name='member_id'").change(function(){
   idcheck=false;
});
/*$("input[name='member_pw'").change(function(){
   pwCheck=false;
});*/
$("input[name='member_nick'").change(function(){
   nickcheckB=false;
});
$("input[name='member_email'").change(function(){
   emailCheck=false;
});
$(document).ready(function(){
   $("input[name='agree_all'").change(function(){
      if($("input[name='agree_all'").is(":checked")){
         $('input:checkbox[name="agree_1"]').attr("checked", true);
         $('input:checkbox[name="agree_2"]').attr("checked", true);
      }else{
         $('input:checkbox[name="agree_1"]').attr("checked", false);
         $('input:checkbox[name="agree_2"]').attr("checked", false);
      }
   });
});
$(document).ready(function(){
   if($("input[name='agree_1'").is(":checked") && $("input[name='agree_2'").is(":checked")){
      $('input:checkbox[name="agree_all"]').attr("checked", true);
   }
});
function agree_ok(){
   if($("input[name='agree_1'").is(":checked") && $("input[name='agree_2'").is(":checked")){
      location.href="/MemberJoin.me";
   }else{
      alert("약관에 동의해 주세요.");
   }
}

function sendEmail() {
	   var email = $("#member_email").val();
	   console.log(email);
	   if($("#email_check").val()==""){
	      $("#email_auth").attr("readonly",false);
	      $("#checkEmailBtn").attr("disabled",false);
	      $("#sendBtn").val("재발송");
	      $.ajax({
	         url:"/MemeberSendEmail.me",
	         type:"POST",
	         data:{"email":email},
	         dataType:"text",
	         success:function(data){
	            console.log(data);
	            if(data.trim() == "no"){
	               alert("이미 가입한 이메일 입니다.\n다른 이메일을 입력하시거나 아이디 또는 비밀번호 찾기를 해주세요!");
	            }else{
	               alert("인증번호를 전송하였습니다.");
	            }
	         },
	         error: function(){
	            alert("잠시후 다시 시도해주세요");
	         }
	      });
	   }
	}

function checkNum() {
   var num = $("#email_auth").val();
   console.log(num);
   if(num != null){
      $.ajax({
         url:"/MemberCheckEmailNum.me",
         type:"POST",
         data:{"num":num},
         dataType:"text",
         success:function(data){
            console.log("data : "+data)
            if(data.trim() == "ok"){
               $("#email_check_num").css("color","GREEN");
               $("#email_check_num").text("인증되었습니다.");
               emailCheck = true;

            }else{
               $("#email_check_num").css("color","RED");
               $("#email_check_num").text("인증번호가 올바르지 않습니다.");

            }
         },
         error:function(){
            alert("이메일 인증 오류발생");
         }
      });
   }
}
//아이디 찾기
function findId(){
   var form = document.findForm;
   
   if(form.member_name.value ==""){
      alert("이름을 입력해주세요.");
      return false;
   }
   if(form.member_email.value==""){
      alert("이메일을 입력해주세요.");
      return false;
   }
   
   form.submit();
}
//비밀번호 찾기
function findPw(){
   var form = document.findForm;
   
   if(form.member_id.value == ""){
      alert("아이디를 입력해주세요.");
      return false;
   }
   if(form.member_email.value == ""){
      alert("이메일을 입력해주세요.");
      return false;
   }
   
   form.submit();
}