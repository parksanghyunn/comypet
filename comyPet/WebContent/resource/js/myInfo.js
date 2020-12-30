/**
 * 회원 정보 및 정보 수정
 */
/* 정보 수정 클릭 이벤"트 */
function updateInfo() {
   $(".info").attr("readonly", false);
   $(".info").css("border", "1px solid black");
   $("#member_address_detail").attr("readonly", false);
   $("#member_address_detail").css("border", "1px solid black");
   $("input[name='member_gender']").attr("disabled", false);
   $("#postcodify_search_button").css("display", "block");
   $("#check_nick_btn").css("display", "inline");
   $("#myInfoBtn").css("display", "none");
   $("#updateInfoBtn").css("display", "block");
}

/* 사진 변경 팝업창 */
$('.btn-example').click(function() {
   var $href = $(this).attr('href');
   layer_popup($href);
});
function layer_popup(el) {

   var $el = $(el); //레이어의 id를 $el 변수에 저장
   var isDim = $el.prev().hasClass('dimBg'); //dimmed 레이어를 감지하기 위한 boolean 변수

   isDim ? $('.dim-layer').fadeIn() : $el.fadeIn();

   var $elWidth = ~~($el.outerWidth()), $elHeight = ~~($el
         .outerHeight()), docWidth = $(document).width(), docHeight = $(
               document).height();

   // 화면의 중앙에 레이어를 띄운다.
   if ($elHeight < docHeight || $elWidth < docWidth) {
      $el.css({
         marginTop : -$elHeight / 2,
         marginLeft : -$elWidth / 2
      })
   } else {
      $el.css({
         top : 0,
         left : 0
      });
   }

   $el.find('a.btn-layerClose').click(function() {
      isDim ? $('.dim-layer').fadeOut() : $el.fadeOut(); // 닫기 버튼을 클릭하면 레이어가 닫힌다.
      return false;
   });

   $('.layer .dimBg').click(function() {
      $('.dim-layer').fadeOut();
      return false;
   });

}

/*수정 완료 클릭 이벤트*/
function checkInfo() {
	var frm = document.infoForm;
	
   if($("#member_nick").val()==""){
	   $("#nick_check").css("color", "red");
	   $("#nick_check").text("닉네임을 입력해주세요.");
      return false;
   }else if($("#member_nick").val().length >4){
	   $("#nick_check").css("color", "red");
	   $("#nick_check").text("닉네임은 4자리까지만 가능합니다.");
	   return false;
   }
   if($("#member_tel").val()==""){
	   $("#tel_check").css("color", "red");
	   $("#tel_check").text("전화번호를 입력해주세요.");
	   return false;
   }/*else{
      //휴대전화 번호 검사 정규식
      var regExp = /^\d{3}-\d{3,4}-\d{4}$/;;

      if(!regExp.test($("#member_tel"))){
    	  $("#tel_check").css("color", "red");
    	  $("#tel_check").text("전화번호 형식이 올바르지 않습니다.");
    	  return false;
      }
   }*/
   
   if($("#member_address_detail").val()==""){
      a$("#address_detail_check").css("color", "red");
	   $("#address_detail_check").text("상세주소를 입력해주세요.");
      return false;
   }
   
   frm.submit();
}

function deleteProfile() {
	var check = confirm("사진 삭제 시 기본 이미지로 변경됩니다.\n사진을 삭제하시겠습니까?");
	if(check){
		location.href = "/MemberDeleteProfileOk.me";
	}else{
		alert("사진 삭제를 취소합니다.");
		location.href = "/MemberSelectInfoOk.me";
	}
}

$("#updateProfileBtn").click(function() {
	$("#file_name").click();
});
function updateProfile() {
	var frm = document.profileForm;
	var check = confirm("사진을 변경하시겠습니까?");
	if(check){
		console.log($("#file_name").val());
		var file_name =$("#file_name").val();
		frm.submit();
	}
}

