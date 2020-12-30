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
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>COMYPET &mdash; 일상이 &amp; 즐거워지는 그 순간!</title>
<%@ include file="/app/script.html"%>
</head>
<body class="skin-purple" style="margin-top: 80px; overflow-x:hidden">

	<jsp:include page="/app/menu/admin_topMenu.jsp"></jsp:include>
	
	<div class="wrap">
	<section class="home">
		<div class="container">
			<div class="row">
				<ul class="nav nav-tabs nav-justified" role="tablist">
					<li class="active"><a href="#board_1" aria-controls="board_1"
						role="tab" data-toggle="tab" >신고접수된 게시글</a></li>
					<li><a href="#board_2" aria-controls="board_2"
						role="tab" data-toggle="tab" >신고접수된 유저</a></li>
					<li><a href="#board_3" aria-controls="board_3"
						role="tab" data-toggle="tab" >블라인드 게시글 </a></li>
					<li><a href="#board_4" aria-controls="board_4"
						role="tab" data-toggle="tab" >정지 유저</a></li>
				</ul>

				<div class="tab-content">

					<div class="tab-pane board_1 active" id="board_1">
						<form class="search" autocomplete="off"
							style="background-color: #eeeeee;">
							<div class="input-group">
								<select class="form-control rounded" name="#"
									style="height: 30px; width: 100px;">
									<option value="#">작성자</option>
									<option value="#">신고 타입</option>
									<option value="#">신고자</option>
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
									<th style="background-color: #eeeeee; text-align: center;">신고
										번호</th>
									<th style="background-color: #eeeeee; text-align: center;">신고
										타입</th>
									<th style="background-color: #eeeeee; text-align: center;">신고된
										게시글</th>
									<th style="background-color: #eeeeee; text-align: center;">작성자</th>
									<th style="background-color: #eeeeee; text-align: center;">날짜</th>
									<th style="background-color: #eeeeee; text-align: center;">신고자</th>
									<th style="background-color: #eeeeee; text-align: center;">블라인드 처리</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>비방/욕설</td>
									<td><a href="#">비속어를 남발합니다.</a></td>
									<td>마속</td>
									<td>2020-10-19</td>
									<td>조조</td>
									<td><input type="button" value="블라인드 처리" onclick="cutBoard()" style="border:none; outline:none">
									<input type="button" value="취소" onclick="#" style="border:none; outline:none"></td>
								</tr>
								<tr>
									<td>1</td>
									<td>비방/욕설</td>
									<td><a href="#">비속어를 남발합니다.</a></td>
									<td>마속</td>
									<td>2020-10-19</td>
									<td>조조</td>
									<td><input type="button" value="블라인드 처리" onclick="cutBoard()" style="border:none; outline:none">
									<input type="button" value="취소" onclick="#" style="border:none; outline:none"></td>
								</tr>
								<tr>
									<td>1</td>
									<td>비방/욕설</td>
									<td><a href="#">비속어를 남발합니다.</a></td>
									<td>마속</td>
									<td>2020-10-19</td>
									<td>조조</td>
									<td><input type="button" value="블라인드 처리" onclick="cutBoard()" style="border:none; outline:none">
									<input type="button" value="취소" onclick="#" style="border:none; outline:none"></td>
								</tr>
							</tbody>
						</table>
					</div>
					
					
					<div class="tab-pane board_2 " id="board_2">
						<form class="search" autocomplete="off"
							style="background-color: #eeeeee;">
							<div class="input-group">
								<select class="form-control rounded" name="#"
									style="height: 30px; width: 100px;">
									<option value="#">작성자</option>
									<option value="#">신고 타입</option>
									<option value="#">신고자</option>
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
									<th style="background-color: #eeeeee; text-align: center;">신고
										번호</th>
									<th style="background-color: #eeeeee; text-align: center;">신고
										타입</th>
									<th style="background-color: #eeeeee; text-align: center;">신고된
										유저</th>
									<th style="background-color: #eeeeee; text-align: center;">날짜</th>
									<th style="background-color: #eeeeee; text-align: center;">신고자</th>
									<th style="background-color: #eeeeee; text-align: center;">정지 처리</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>비방/욕설</td>
									<td>마속</td>
									<td>2020-10-19</td>
									<td>조조</td>
									<td><input type="button" value="정지" onclick="cutBoard()" style="border:none; outline:none">
									<input type="button" value="취소" onclick="#" style="border:none; outline:none"></td>
								</tr>
								<tr>
									<td>1</td>
									<td>비방/욕설</td>
									<td>마속</td>
									<td>2020-10-19</td>
									<td>조조</td>
									<td><input type="button" value="정지" onclick="cutBoard()" style="border:none; outline:none">
									<input type="button" value="취소" onclick="#" style="border:none; outline:none"></td>
								</tr>
								<tr>
									<td>1</td>
									<td>비방/욕설</td>
									<td>마속</td>
									<td>2020-10-19</td>
									<td>조조</td>
									<td><input type="button" value="정지" onclick="cutBoard()" style="border:none; outline:none">
									<input type="button" value="취소" onclick="#" style="border:none; outline:none"></td>
								</tr>
							</tbody>
						</table>
					</div>
					
					<div class="tab-pane board_3" id="board_3">
						<form class="search" autocomplete="off"
							style="background-color: #eeeeee;">
							<div class="input-group">
								<select class="form-control rounded" name="#"
									style="height: 30px; width: 100px;">
									<option value="#">작성자</option>
									<option value="#">신고 타입</option>
									<option value="#">신고자</option>
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
									<th style="background-color: #eeeeee; text-align: center;">신고
										번호</th>
									<th style="background-color: #eeeeee; text-align: center;">신고
										타입</th>
									<th style="background-color: #eeeeee; text-align: center;">신고된
										게시글</th>
									<th style="background-color: #eeeeee; text-align: center;">작성자</th>
									<th style="background-color: #eeeeee; text-align: center;">날짜</th>
									<th style="background-color: #eeeeee; text-align: center;">신고자</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>비방/욕설</td>
									<td><a href="javascript:showUpdate(2)" id="showandhiden" >환단고기</a></td>
									<td>마속</td>
									<td>2020-10-19</td>
									<td>조조</td>
								</tr>
								<tr>
									<td>1</td>
									<td>비방/욕설</td>
									<td><a href="javascript:showUpdate(2)" id="showandhiden" >환단고기</a></td>
									<td>마속</td>
									<td>2020-10-19</td>
									<td>조조</td>
								</tr>
								<tr>
									<td>1</td>
									<td>비방/욕설</td>
									<td><a href="javascript:showUpdate(2)" id="showandhiden" >환단고기</a></td>
									<td>마속</td>
									<td>2020-10-19</td>
									<td>조조</td>
								</tr>
							</tbody>
						</table>
					</div>
					
					<div class="tab-pane board_4" id="board_4">
						<form class="search" autocomplete="off"
							style="background-color: #eeeeee;">
							<div class="input-group">
								<select class="form-control rounded" name="#"
									style="height: 30px; width: 100px;">
									<option value="#">작성자</option>
									<option value="#">신고 타입</option>
									<option value="#">신고자</option>
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
									<th style="background-color: #eeeeee; text-align: center;">신고
										번호</th>
									<th style="background-color: #eeeeee; text-align: center;">신고
										타입</th>
									<th style="background-color: #eeeeee; text-align: center;">작성자</th>
									<th style="background-color: #eeeeee; text-align: center;">날짜</th>
									<th style="background-color: #eeeeee; text-align: center;">신고자</th>
									<th style="background-color: #eeeeee; text-align: center;">정지 처리</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>비방/욕설</td>
									<td>마속</td>
									<td>2020-10-19</td>
									<td>조조</td>
									<td><input type="button" value="취소" onclick="#" style="border:none; outline:none"></td>
								</tr>
								<tr>
									<td>1</td>
									<td>비방/욕설</td>
									<td>마속</td>
									<td>2020-10-19</td>
									<td>조조</td>
									<td><input type="button" value="취소" onclick="#" style="border:none; outline:none"></td>
								</tr>
								<tr>
									<td>1</td>
									<td>비방/욕설</td>
									<td>마속</td>
									<td>2020-10-19</td>
									<td>조조</td>
									<td><input type="button" value="취소" onclick="#" style="border:none; outline:none"></td>
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
</body>
<script>
	function showUpdate(num){
			$("#hidden"+num).css("display","");
		}
		function cancleUpdate(num){
			alert("취소하시겠습니까?");
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
</html>