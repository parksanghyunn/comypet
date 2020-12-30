/**
 * index 페이지 팝업
 */
		var popData = [];
		var type;
		
			function checkjson(){
				$.ajax({
					url : "/returnPopupList.pop",
					dataType : "json",
					success : function(data){
						if(data == null){
							return false;
						}
						var exist = false;
						$.each(data, function(key,val){
							popData.push(val);
							type = getKeyName(popData[key]);
							exist = true;
							
							if(exist){
								setLocalStorage(type);
								makePopup(type,popData[key]);
							}
						});
					}, error : function(err1){
						console.dir(err1.status);
					}
				});
				
				function getKeyName( popData ){
					var data = popData.POP_IDX;
					var getDate = (new Date()).toISOString().slice(2,10).split("-").join("");
					var makeKey = "notice_" + data + "_" + getDate;
					return makeKey;
				}
				
				function setLocalStorage(type){
					var data = type;
					if( data == localStorage.getItem(data) ){
						return false;
					}else{
						localStorage.setItem(data,data);
					}
				}
				
				var idx = 0;
				var num = 0;
				
				function makePopup(type,popData){
					var data = type;
					var contents = popData.POP_CONTENTS;
					if(localStorage.getItem(data) == data){
						if(localStorage.getItem(data+"_NOT") == localStorage.getItem(data)){
							return false;
						}else{
							var text = $('<p>'+contents+'</p>');
							var contentsText = $(".modal-body_"+num).prepend(text);
							var contentsTitle = $(".heading_"+num).append(popData.POP_TITLE);
							$("#modal_"+num+"_input").attr("value",data);
							$("#modal_"+num).show();
							num++;
						}
					}
				}
				
				$("#modal_0_cancle, #modal_1_cancle").on("click", function(){
					if($(this).attr("id") == "modal_0_cancle"){
						$("#modal_0").hide();
					}else if($(this).attr("id") == "modal_1_cancle"){
						$("#modal_1").hide();
					}
				});
				
				$("#modal_0_notToday, #modal_1_notToday").on("click", function(){
					if($(this).attr("id") == "modal_0_notToday"){
						var data = $("#modal_0_input").attr("value");
						localStorage.setItem(data+"_NOT", data);
						$("#modal_0").hide();
					}else if($(this).attr("id") == "modal_1_notToday"){
						var data = $("#modal_1_input").attr("value");
						localStorage.setItem(data+"_NOT", data);
						$("#modal_1").hide();
					}
				});
			}
