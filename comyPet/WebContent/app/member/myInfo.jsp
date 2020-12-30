<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
response.setHeader("cache-control","no-store");
response.setHeader("expires","0");
response.setHeader("pragma","no-cache");
%>
<!DOCTYPE html>
<html>
<head>
<link
   href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap"
   rel="stylesheet">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
   content="width=device-width, initial-scale=1, maximum-scale=1">
<title>COMYPET &mdash; 내 정보</title>
<link rel="stylesheet" href="/resource/css/myInfo.css">
</head>
<body class="skin-blue">
<c:if test="${empty session_uid}">
	<script> alert('로그인 후 이용해주세요.');
		window.open("/Index.me", "_self")
	</script>
</c:if>
   <c:set var="member_id" value="${requestScope.member_id}"></c:set>
   <c:set var="member_nick" value="${requestScope.member_nick}"></c:set>
   <c:set var="member_name" value="${requestScope.member_name}"></c:set>
   <c:set var="member_gender" value="${requestScope.member_gender}"></c:set>
   <c:set var="member_birth" value="${requestScope.member_birth}"></c:set>
   <c:set var="member_tel" value="${requestScope.member_tel}"></c:set>
   <c:set var="member_email" value="${requestScope.member_email}"></c:set>
   <c:set var="member_zipcode" value="${requestScope.member_zipcode}"></c:set>
   <c:set var="member_address" value="${requestScope.member_address}"></c:set>
   <c:set var="member_address_detail" value="${requestScope.member_address_detail}"></c:set>
   <c:set var="member_address_etc" value="${requestScope.member_address_etc}"></c:set>
   <!-- 탑 메뉴 -->
   <jsp:include page="/app/menu/topMenu.jsp"></jsp:include>
  
   <section class="home">
      <div class="container">
         <div class="box-wrapper" style="width: 100%; height: 100%">
            <div class="box box-border" style="padding-left: 20%; border: none;">
               <div class="box-body">
                  <h3>내 정보</h3>
                  <hr>
                  <br>
                  <div style="float: left;">
                     <a href="#layer2" class="btn-example">
                     <c:choose>
                     	<c:when test="${session_profile eq 'defaultProfile.png'}">
		                    <img alt="profile" src="/app/upload/profile/${session_profile}"class="profile"><br>
                     	</c:when>
                     	<c:otherwise>
		                    <img alt="profile" src="/app/upload/profile/${session_uid}/${session_profile}"class="profile"><br>
                     	</c:otherwise>
                     </c:choose>
                        <br> </a>
                     <div class="dim-layer">
                        <div class="dimBg"></div>
                        <div id="layer2" class="pop-layer">
                           <div class="pop-container">
                              <div class="pop-conts">
                                 <!--content //-->
                                 <div id="content" style="font-size: 20px">
                                 <form action="/MemberUpdateProfileOk.me" method="post" name = "profileForm" enctype="multipart/form-data">
                                    <a href="#" class="btn btn-primary btn-block"  id = "updateProfileBtn"
                                       style="color: #626eef;" type="button">사진변경
                                       <input type="file" id="file_name" name = "file_name" style="display: none;" onchange="updateProfile()"></a>
                                        <a href="javascript:deleteProfile()"
                                       class="btn btn-primary btn-block" type="button"
                                       style="color: #e74c3c;">사진 삭제</a>
                                 </form>
                                 </div>
                                 <div class="btn-r">
                                    <a href="#" class="btn-layerClose"
                                       style="text-decoration: none;">취소</a>
                                 </div>
                                 <!--// content-->
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
                  <div style="float: left; width: 55%;">
                     <form style="font-size: 17px;" name="infoForm" action="/MemberUpdateIfoOk.me">
                        <table>
                           <tr>
                              <th>아이디</th>
                              <td><span id="id">${member_id}</span></td>
                           </tr>
                           <tr>
                              <th>이름</th>
                              <td><span id="name">${member_name}</span></td>
                           </tr>
                           <tr>
                              <th>닉네임</th>
                              <td><input type="text" value="${member_nick}" readonly class="info"
                                 id="member_nick" name="member_nick">
                                 <input
                                 type="button" id="check_nick_btn"
                                 class="btn btn-primary btn-sm" value="중복"
                                 style="display: none;" onclick="nickCheck(infoForm.member_nick.value)">
                                 <p id= "nick_check"></p>
                                 </td>
                           </tr>
                           <tr>
                              <th>성별</th>
                              <td><span id="gender">${member_gender}</span></td>
                           </tr>
                           <tr>
                              <th>생년월일</th>
                              <td><span id="birth">${member_birth}</span></td>
                           </tr>
                           <tr>
                              <th>전화번호</th>
                              <td><input type="text" value="${member_tel}" readonly
                                 class="info" id="member_tel" name="member_tel">
                                 <span id="tel_check"></span>
                                 </td>
                           </tr>
                           <tr>
                              <th>이메일</th>
                              <td><input type="text" value="${member_email}" readonly
                                 id="email" name="member_email" style="width: 100%"></td>
                           </tr>
                           <tr>
                              <th>우편번호</th>
                              <td><input type="text" value="${member_zipcode}" readonly
                                 class="postcodify_postcode5" name="member_zipcode"> <input
                                 type="button" id="postcodify_search_button"
                                 class="btn btn-primary btn-sm" value="검색"
                                 style="display: none;"></td>
                           </tr>
                           <tr>
                              <th>주소</th>
                              <td><input type="text" value="${member_address}" readonly
                                 class="postcodify_address" name="member_address"></td>
                           </tr>
                           <tr>
                              <th>상세주소</th>
                              <td><input type="text" value="${member_address_detail}" readonly
                                 class="postcodify_details" id="member_address_detail"
                                 name="member_address_detail" style="width:100%;">
                                 <p id="address_detail_check"></p>
                                 </td>
                           </tr>
                           <tr>
                              <th>참고사항</th>
                              <td><input type="text" value="${member_address_etc}" readonly
                                 class="postcodify_extra_info" name="member_address_etc"></td>
                           </tr>
                        </table>
                     </form>
                     <br>
                     <div style="text-align: right;" id="btn">
                        <div id="myInfoBtn">
                           <a href="/MemberMyPage.me" class="btn btn-primary">확인</a> <a
                              href="javascript:updateInfo()" class="btn btn-primary">수정</a>
                        </div>
                        <div id="updateInfoBtn" style="display: none">
                           <a href="javascript:checkInfo()" class="btn btn-primary">완료</a>
                           <a href="/MemberSelectInfoOk.me" class="btn btn-primary">취소</a>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </section>
   <!-- Start footer -->
   <jsp:include page="/app/menu/footer.jsp" />
   <!-- End Footer -->
   <!-- JS -->
   <script src="/resource/js/jquery.js"></script>
   <script src="/resource/js/jquery.migrate.js"></script>
   <script src="/resource/scripts/bootstrap/bootstrap.min.js"></script>
   <script src="/resource/scripts/jquery-number/jquery.number.min.js"></script>
   <script src="/resource/scripts/owlcarousel/dist/owl.carousel.min.js"></script>
   <script
      src="/resource/scripts/magnific-popup/dist/jquery.magnific-popup.min.js"></script>
   <script src="/resource/scripts/easescroll/jquery.easeScroll.js"></script>
   <script src="/resource/scripts/sweetalert/dist/sweetalert.min.js"></script>
   <script src="/resource/scripts/toast/jquery.toast.min.js"></script>
   <script src="/resource/js/e-magz.js"></script>
   <script src="/resource/js/myInfo.js"></script>
   <script src="/resource/js/join.js"></script>
   <script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
   <script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
   <script>
      $(function() {
         $("#postcodify_search_button").postcodifyPopUp();
      });
   </script>
</body>
</html>