<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${session_id eq null}">
         <script>
            alert("로그인 후 이용해주세요");
            location.replace("/AdminLogin.ad");
         </script>
      </c:if> 
      <div class="firstbar">
         <div class="container">
            <div class="row">
               <div class="col-md-3 col-sm-12">
                  <div class="brand">
                     <a href="/AdminAdmin.ad"> <img
                        src="/resource/images/cmpp.png" alt="comypet Logo">
                     </a>
                  </div>
               </div>
               <div style="float: right;font-size: 15px; margin-right: 20px;">
                  <i class="icon ion-person"></i>&nbsp;<c:out value="${sessionScope.session_id}"></c:out>
               </div>
            </div>
         </div>
      </div>

      <!-- Start nav -->
      <nav class="menu">
         <div class="container">
            <div class="brand">
               <a href="#"> <img src="/resource/images/cmpp.png"
                  alt="Magz Logo">
               </a>
            </div>
            <div class="mobile-toggle">
               <a href="#" data-toggle="menu" data-target="#menu-list"><i
                  class="ion-navicon-round"></i></a>
            </div>
            <div class="mobile-toggle">
               <a href="#" data-toggle="sidebar" data-target="#sidebar"><i
                  class="ion-ios-arrow-left"></i></a>
            </div>
            <div id="menu-list">
               <ul class="nav-list">
                  
					<li class="dropdown magz-dropdown"><a href="#" >컴마이펫 ADMIN</a></li>
					<li class="dropdown magz-dropdown"><a href="#" >회원관리
					<i class="ion-ios-arrow-right"></i></a>
						<ul class="dropdown-menu" >
							<li><a href="/AdminAdmin.ad">관리자관리
							</a></li>
							<li><a href="/AdminMember.ad" >회원관리</a></li>
						</ul>
					</li>
					<li class="dropdown magz-dropdown"><a href="#" >게시판관리
					<i class="ion-ios-arrow-right"></i></a>
						<ul class="dropdown-menu" >
							<li><a href="/AdminBoardListFOk.ad">자유게시판</a></li>
							<li><a href="/AdminBoardListMOk.ad">모임게시판</a></li>
							<li><a href="/AdminBoardListNOk.ad" >나눔게시판</a></li>
							<li><a href="/AdminBoardListQOk.ad" >질문/답변</a></li>
							<%--<li><a href="${pageContext.request.contextPath}/admin/AdminBoardListSOk.ad" >건의게시판</a></li> --%>
						</ul>
					</li>
					<li class="dropdown magz-dropdown"><a href="#" >갤러리관리
					<i class="ion-ios-arrow-right"></i></a>
						<ul class="dropdown-menu">
							<li><a href="/AdminListGalleryP.ad" >강아지 갤러리</a></li>
							<li><a href="/AdminListGalleryC.ad" >고양이 갤러리</a></li>
							<li><a href="/AdminListGalleryD.ad" >일상 공유</a></li>
							<li><a href="/AdminListGalleryE.ad" >기타 갤러리</a></li>
						</ul></li>
						
					<li class="dropdown magz-dropdown"><a href="/AdminBoardListLOk.ad">반려동물 찾기
                        <i class="ion-ios-arrow-right"></i>
                  </a>
                     <ul class="dropdown-menu">
                     <li><a href="/AdminBoardListLOk.ad">반려 동물 찾기</a></li>
                     </ul></li>
                     
                     
                     
					<li class="dropdown magz-dropdown"><a href="#"  >고객센터
					<i class="ion-ios-arrow-right"></i></a>
						<ul class="dropdown-menu" >
						  <li><a href="/AdminAdsBoardListOk.ad" >광고문의</a></li>
                    	  <li><a href="/AdminSupBoardListOk.ad" >제휴문의</a></li>
                   		  <li><a href="/AdminSugBoardListOk.ad" >불편사항</a></li>
						</ul></li>
						
					<li class="dropdown magz-dropdown"><a href="#"  >신고관리<i class="ion-ios-arrow-right"></i>
					</a>
						<ul class="dropdown-menu" >
							<li><a href="/AdminBoardReportReceiveOk.ad?report_state=1" >신고 접수 글</a></li>
                    		 <li><a href="/AdminMemberReportReceiveOk.ad?report_state=1" >신고 접수 유저</a></li>
                   			  <li><a href="/AdminBoardReportReceiveOk.ad?report_state=2" >블라인드 게시글</a></li>
                   			  <li><a href="/AdminMemberReportReceiveOk.ad?report_state=2" >정지 유저</a></li>
						</ul></li>
						
						<li class="dropdown magz-dropdown"><a href="#">공지사항
                        <i class="ion-ios-arrow-right"></i>
                  </a>
                     <ul class="dropdown-menu">
                     <li><a href="/AdminBoardListNoticeOk.ad">공지사항</a></li></ul></li>
                        
					<li class="dropdown magz-dropdown"><a href="#"  >팝업관리<i class="ion-ios-arrow-right"></i></a>
						<ul class="dropdown-menu">
							<li><a href="/popupListView.pop">팝업관리</a></li>
                       		<li><a href="/popup.ad">팝업등록</a></li>
                        </ul>
                    </li>
                  <li><a href="javascript:logOut()">로그아웃</a>
                  </li>
               </ul>
            </div>
         </div>
      </nav>
      <!-- End nav -->
</body>
<script>
	function logOut(){
		var checkConfirm = confirm("로그아웃 하시겠습니까?")
		if(checkConfirm == true){
			location.href="/AdminLogoutOk.ad";
		}
		else{
			return false;
		}
	}
</script>
</html>