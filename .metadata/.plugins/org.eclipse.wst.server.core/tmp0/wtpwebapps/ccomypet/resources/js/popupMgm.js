/**
 * 
 */
		
		//버튼 클릭시 해당 로우의 데이터를 가져온다.
		$(".checkbox-inline").click(function(){
	        var checkBtn = $(this);
	        var exist = false;
	        var tag = checkBtn.children().find("input[name='popState']").is(":checked");
	        if(tag == true){
	        	var downPopup = confirm("게시된 팝업을 내리시겠습니까?");
	        	if(downPopup){
		        	exist = true;
	        	}else{
	        		alert("취소하셨습니다.");
	        		return false;
	        	}
	        }else{
	        	var upPopup = confirm("새로운 팝업을 올리시겠습니까?");
	        	if(upPopup){
	        		exist = true;
	        	}else{
	        		return false;
	        	}
	        }
	       	if(exist){
		        //버튼의 부모는 td이다 
		        //td의 부모는 tr이다 그래서 부모의 부모를 찾았다.
		        var tr = checkBtn.parent().parent();
		        var td = tr.children();
		        
		        var idx = td.eq(0).text();
		        var state = td.children().find("input[type='hidden']").val();
		        
		        var data = {"idx" : idx, "state" : state};
		        
		        $.ajax({
		        	url 		: "/popupPostUpdate.pop",
		        	type 		: "POST",
		        	data 		: data,
		        	success 	: function(msg){
		        		if(msg == 200){
		        			alert("팝업이 정상적으로 게시 되었습니다.");
		        		}else if(msg == 210){
		        			alert("게시된 팝업이 정상적으로 내려갔습니다.");
		        		}else if(msg == 300){
		        			alert("팝업은 2개이상 게시할 수 없습니다.");
		        			location.reload();
		        		}else if(msg == 400){
		        			alert("알수없는 에러가 발생했습니다.");
		        		}
		        		location.reload();
		        	}, error 	: function(err){
		        		alert("ajax 호출 에러 : "+err.status);
		        		return false;
		        	}
		        });
	       	}
		});