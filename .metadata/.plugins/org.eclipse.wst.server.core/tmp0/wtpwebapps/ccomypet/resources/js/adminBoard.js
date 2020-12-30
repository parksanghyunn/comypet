/*
	게시글 작성 JS
*/
var insertPath = [];
var uploadPath = [];
		
$(document).ready(function() {
	//여기 아래 부분
	var $summernote =$('#summernote').summernote({
		height : 500, // 에디터 높이
		maximumImageFileSize : 3 * 1024 * 1024, //파일 최대용량 3MB
		minHeight : null, // 최소 높이
		maxHeight : null, // 최대 높이
		focus : true, // 에디터 로딩후 포커스를 맞출지 여부
		disableResizeEditor : true,
		lang : "ko-KR", // 한글 설정
		placeholder : '최대 2048자까지 쓸 수 있습니다', //placeholder 설정
		callbacks : {
			onImageUpload : function(files, editor) {       
				for (var i = files.length - 1; i >= 0; i--) {
					sendFile(files[i], this);
				}
			}
		}
	});
});

function sendFile(file,editor) {
	var form_data = new FormData();
	form_data.append('file', file);
	$.ajax({                                                              
		data : form_data,
		type : "POST",
		url : '/adminBoardFileUpload.ad',
		cache : false,
		contentType : false,
		enctype : 'multipart/form-data',                                  
		processData : false,
		success: function(data) {
			$('#myModal').show();
			var count = 4;
			var conuntdown = setInterval(function(){
				$("#count").html(count);
				if(count == 0){
					clearInterval(conuntdown);
					var image = $("<img>").attr("src", data).attr("style", "width:480px; height:auto;");
					$(editor).summernote('insertNode', image[0]);
					$('#myModal').hide();
					uploadPath.push(data);
				}
				count--;
			},1000);
		}
	});
}

function realPath(){
	$(".note-editor.note-frame img").each(function() {
		insertPath.push($(this).attr("src"));
	});
}

//게시글 작성 취소시 이전페이지로 이동
$("#cancle_btn").on("click", function(){
	history.go(-1);
});

$("#write_btn").on("click", function() {
	var title = $("#summernote_title");
	var contents = $("#summernote");
	
	if(title.val() == ""){
		alert("제목을 입력해주세요.");
		title.focus();
		return false;
	}
	
	if(contents.val() == ""){
		alert("게시글 내용을 입력해주세요.")
		contents.focus();
		return false;
	}
	
	$('#myModals').show();
	var count = 4;
	realPath();
	var sendTitle = $("#summernote_title").val();
	var sendContents = $("#summernote").val();
	var sendState = $("#summernote_state").val();
	var conuntdown = setInterval(function(){
		$("#counts").html(count);
		if(count == 0){
			clearInterval(conuntdown);
			$.ajaxSettings.traditional = true;
			$.ajax({
				url : "/adminInsertBoardContents.ad",
				type : "POST",
				traditional : true,
				data : { title : sendTitle, contents : sendContents, state : sendState, insertPath : insertPath, uploadPath : uploadPath},
				dataType : "json",
				success : function(data){
					if(data["code"] == "200"){
						alert("게시글 등록이 완료되었습니다.");
						location.href = data["url"];
					}else if(data["code"] == "250"){
						alert("로그인 후 이용해주세요.");
						location.href = "/Index.me";
					}
				}, error : function(err){
					alert(err.status);
				}
			});
			$('#myModals').hide();
		}
		count--;
	},1000);
});

