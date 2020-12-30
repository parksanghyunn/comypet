/**
 * 
 */
$("input, textarea").keyup(function(){

	var value = $(this).val();
	var arr_char = new Array();

	arr_char.push("'");
	arr_char.push("\"");
	arr_char.push("<");
	arr_char.push(">");

	for(var i=0 ; i<arr_char.length ; i++)
	{
		if(value.indexOf(arr_char[i]) != -1)
		{

			window.alert("<, >, ', \" 특수문자는 사용하실 수 없습니다.");
			value = value.substr(0, value.indexOf(arr_char[i]));
			$(this).val(value);				
		}
	}
});


function dcheck(){
	var name = document.getElementById('cs_name');
	var email = document.getElementById('cs_email');
	var tel = document.getElementById('cs_tel');
	var contents = document.getElementById('cs_contents');
		
	var reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
	
	if(name.value == ""){
		alert('담당자명을 입력해주세요.');
		name.focus();
		return false;
	}
	if(!reg_email.test(email.value)){
		alert('이메일이 제대로 입력되지 않았습니다.');
		email.focus();
		return false;
	}
	if(tel.value == ""){
		alert('연락처를 입력해주세요.');
		tel.focus();
		return false;
	}
	if(contents.value == ""){
		alert('내용을 입력해주세요.');
		contents.focus();
		return false;
	}else{
		var result = confirm("문의 등록을 하시겠습니까?");
		var form = document.getElementById('contact');
		if(result){
			alert('문의가 정상적으로 등록되었습니다.')
			form.submit();
		}else{
			alert('취소하셨습니다.');
			location.reload();
		}
	}
}