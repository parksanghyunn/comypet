<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>COMYPET &mdash; 일상이 &amp; 즐거워지는 그 순간!</title>
</head>
<body class="skin-blue">
	<jsp:include page="/app/menu/topMenu.jsp"></jsp:include>
	<section class="category first" style="padding-top: 20px;">
		<div class="container">
			<div class="row">
				<div class="col-md-8 text-left">
					<div class="banner">
						<a href="#"><img src="/resource/images/ads.png"
							alt="Sample Article"></a>
					</div>
					<div class="row">
						<div class="col-md-12">
							<ol class="breadcrumb">
								<li><a href="#">고객센터</a></li>
								<li class="active">불편사항</li>
							</ol>
						</div>

						<div class="line" style="margin: 10px"></div>
						<table class="table table-hover">
							<thead>
								<tr>
									<th><strong>번호</strong></th>
									<th><strong>제목</strong></th>
									<th><strong>작성자</strong></th>
									<th><strong>날짜</strong></th>
									<th><strong>조회</strong></th>
									<th><strong>추천</strong></th>
								</tr>
							</thead>
							<tbody style="border-bottom: 1px solid #DCEBFF;">
								<tr style="border-bottom: 1px solid #DCEBFF;">
									<td>1</td>
									<td><a href="#">삼국지</a></td>
									<td>마속</td>
									<td>2020-10-19</td>
									<td>0</td>
									<td>0</td>
								</tr>
								<tr style="border-bottom: 1px solid #DCEBFF;">
									<td>2</td>
									<td><a href="#">삼국지</a></td>
									<td>조조</td>
									<td>2020-10-19</td>
									<td>0</td>
									<td>10</td>
								</tr>
								<tr>
									<td>3</td>
									<td><a href="#">삼국지</a></td>
									<td>유비</td>
									<td>2020-10-19</td>
									<td>10</td>
									<td>20</td>
								</tr>
							</tbody>
						</table>

						<%-- 글 상세보기 할 때 나오는 태그 --%>
						<a href="/app/board/boardWrite.jsp?board=고객센터&&board_name=불편사항" class="btn btn-primary btn-sm btn-rounded pull-right">글쓰기</a>

						<div class="text-center">
							<ul class="pagination">
								<li><a href="#">&lt;</a></li>
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">6</a></li>
								<li><a href="#">7</a></li>
								<li><a href="#">8</a></li>
								<li><a href="#">9</a></li>
								<li><a href="#">10</a></li>
								<li><a href="#">&gt;</a></li>
							</ul>
						</div>

						<form class="search" autocomplete="off" style="margin-top: 12px;">
							<div class="form-group" style="margin-left: 15px;">

								<div class="input-group" style="width: 210px; margin: auto">
									<select class="form-control rounded" name="#"
										style="margin-left: -80px; height: 30px; width: 80px">
										<option value="#">제목</option>
										<option value="#">작성자</option>
										<option value="#">내용</option>
									</select> <input type="text" name="q" class="form-control"
										style="height: 30px">
									<div class="input-group-btn">
										<button class="btn btn-primary btn-sm btn-rounded"
											style="height: 30px">
											<i class="ion-search"></i>
										</button>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
				<jsp:include page="/app/menu/rightMenu.jsp"></jsp:include>
			</div>
		</div>
	</section>

	<!-- Start footer -->
	<jsp:include page="/app/menu/footer.jsp"></jsp:include>
	<!-- End Footer -->
	<script src="/resource/scripts/bootstrap/bootstrap.min.js"></script>
</body>
</html>