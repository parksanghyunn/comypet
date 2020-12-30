<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>COMYPET &mdash; 일상이 &amp; 즐거워지는 그 순간!</title>
<%@ include file="/app/script.html"%>
</head>
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
<body class="skin-purple" style="margin-top: 80px; overflow-x:hidden">
	<jsp:include page="/app/menu/admin_topMenu.jsp"></jsp:include>
	<div class="wrap">
	<section class="home">
		<div class="container">
			<div class="row">
				<ul class="nav nav-tabs nav-justified" role="tablist">
					<li class="active"><a href="#board_1" aria-controls="board_1"
						role="tab" data-toggle="tab"> 건의게시판</a></li>
				</ul>

				<div class="tab-content">
					<div class="tab-pane board_1 active" id="board_1">
						<form class="search" autocomplete="off"
							style="background-color: #eeeeee;">
							<div class="input-group">
								<select class="form-control rounded" name="#"
									style="height: 30px; width: 100px;">
									<option value="#">성명</option>
									<option value="#">아이디</option>
								</select> <input type="text" name="q" class="form-control"
									style="height: 30px; width: 210px;"> <a href="#"
									class="btn btn-primary btn-sm btn-rounded" style="height: 30px">
									<i class="ion-search"></i>
								</a>
							</div>
						</form>

						<table class="table table-striped"
							style="text-align: center; border: 1px solid #dddddd">
							<thead>
								<tr>
									<th style="background-color: #eeeeee; text-align: center;">번호</th>
									<th style="background-color: #eeeeee; text-align: center;">제목</th>
									<th style="background-color: #eeeeee; text-align: center;">작성자</th>
									<th style="background-color: #eeeeee; text-align: center;">날짜</th>
									<th style="background-color: #eeeeee; text-align: center;">조회</th>
									<th style="background-color: #eeeeee; text-align: center;">추천</th>
									<th style="background-color: #eeeeee; text-align: center;">블라인드</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td><a href="javascript:showUpdate(1)">삼국지</a></td>
									<td>마속</td>
									<td>2020-10-19</td>
									<td>0</td>
									<td>0</td>
									<td><input type="button" value="블라인드 처리" onclick="cutBoard()" style="border:none; outline:none"></td>
								</tr>
								
								<%-- 제목 클릭시 게시글상세보기 --%>
								<tr id="hidden1" style="display:none;">
									<td colspan="7">
										<div id="content">
								<img src="/resource/images/ex2.jpeg" width="100%"><br> <br>
								<textarea id="contentsText" cols="70%"
									style="border: none; font-size: 20px; resize: none; outline: none; width: 100%"
									readonly>테스트 중입니다.</textarea>
									<div style="text-align: right;">
									<input type="button" value="닫기" onclick="cancleUpdate(1)">
								</div>
								</div>
									</td>
								</tr>

								<tr>
									<td>1</td>
									<td><a href="javascript:showUpdate(2)">삼국지</a></td>
									<td>마속</td>
									<td>2020-10-19</td>
									<td>0</td>
									<td>0</td>
									<td><input type="button" value="블라인드 처리" onclick="" style="border:none; outline:none"></td>
								</tr>
								
								<tr id="hidden2" style="display:none;">
									<td colspan="7">
										<div id="content">
								<img src="/resource/images/ex2.jpeg" width="100%"><br> <br>
								<textarea id="contentsText" cols="70%"
									style="border: none; font-size: 20px; resize: none; outline: none; width: 100%"
									readonly>테스트 중입니다.</textarea>
									<div style="text-align: right;">
									<input type="button" value="닫기" onclick="cancleUpdate(2)">
								</div>
								</div>
									</td>
								</tr>

								<tr>
									<td>1</td>
									<td><a href="#">삼국지</a></td>
									<td>마속</td>
									<td>2020-10-19</td>
									<td>1</td>
									<td>0</td>
									<td><input type="button" value="블라인드 처리" onclick="" style="border:none; outline:none"></td>
								</tr>
								
								<tr id="hidden1" style="display:none;">
									<td colspan="7">
										<div id="content">
								<img src="/resource/images/ex2.jpeg" width="100%"><br> <br>
								<textarea id="contentsText" cols="70%"
									style="border: none; font-size: 20px; resize: none; outline: none; width: 100%"
									readonly>테스트 중입니다.</textarea>
									<div style="text-align: right;">
									<input type="button" value="닫기" onclick="cancleUpdate(1)">
								</div>
								</div>
									</td>
								</tr>

							</tbody>
						</table>
					</div>

				</div>
			</div>
		</div>
	</section>
	</div>
	<!-- Start footer -->
	<jsp:include page="/app/menu/footer.jsp"></jsp:include>
	<!-- End Footer -->


	<!-- JS -->
	<script src="/resource/scripts/bootstrap/bootstrap.min.js"></script>
	<script>
		//$(document).ready(function(){
			//$("#showandhiden").click(function(){
				//status = $("#hidden").css("display"); if (status == "none") { $("#hidden").css("display", ""); } else { $("#hidden").css("display", "none"); }
			//});
		//});
		/* $(document).ready(function() {

		resizeContent();
		
		});
		
		$(window).resize(function() {

		resizeContent();
		
		});
		
		function resizeContent() {

		var windowHeight = $(window).height();


		$('#content').css({'height':(windowHeight-200)+'px'});

		} */
		
		function showUpdate(num){
			$("#hidden"+num).css("display","");
		}
		function cancleUpdate(num){
			$("#hidden"+num).css("display","none");
			return false;
		}
		
		function cutBoard(){
			//alert("이 게시글을 블라인드 처리하시겠습니까?");
			var checkConfirm = confirm("이 게시글을 블라인드 처리하시겠습니까?");
			if(checkConfirm == true){
				
			}
			else{
				return false;
			}
		}
		
		
		
	</script>
</body>
</html>