<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>COMYPET &mdash; 일상이 &amp; 즐거워지는 그 순간!</title>
		<link rel="stylesheet" href="/resource/css/kakao.css">
	</head>

	<body class="skin-blue">
		<jsp:include page="/app/menu/topMenu.jsp"></jsp:include>

		<section class="home">
			<div class="container">
				<div class="banner">
					<a href="#"><img src="/resource/images/ads.png" alt="Sample Article"></a>
				</div>
				<div style="text-align:center; font-size:30px;"><b>반려동물 이용시설 검색</b></div>
			<br/>
				<div class="map_wrap">
				    <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
				    <ul id="category" style="display:none;">
				        <li id="동물병원" data-order="0"> 
				            <span class="category_bg pharmacy"></span>
				     			병원
				        </li>       
				        <li id="반려동물용품" data-order="1"> 
				            <span class="category_bg mart"></span>
				            	용품
				        </li>  
				        <li id="반려동물카페" data-order="2"> 
				            <span class="category_bg cafe"></span>
				            	카페
				        </li>  
				    	<li id="반려동물미용" data-order="3"> 
				            <span class="category_bg cafe"></span>
				            	미용
				        </li>  
				      	<li id="반려동물호텔" data-order="4"> 
				            <span class="category_bg cafe"></span>
				            	호텔
				        </li>  
				    </ul>
				    <div id="menu_wrap">
					    <hr>
				        <ul id="placesList"></ul>
				        <div id="pagination"></div>
				    </div>
				</div>
			</div>
		</section>

		<!-- Start footer -->
		<jsp:include page="/app/menu/footer.jsp"></jsp:include>
		<!-- End Footer -->

		<!-- JS -->
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8e0e571f9a279b76917f1bff7c456e50&libraries=services"></script>
		<script src="/resource/js/kakaomap.js"></script>
		<script src="/resource/scripts/bootstrap/bootstrap.min.js"></script>
		<script>
			$("document").ready(function(){
				kakaoMapStart();
			});
		</script>
	</body>
</html>