<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="icon" href="images/favicon.png"/>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" as="style" crossorigin href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.6/dist/web/static/pretendard.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/main.css">
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>
<body>
<header>
<!-- 	<div>
		<input type="button" value="메인으로" onclick="location.href='main'">
	</div> -->
</header>

	<div style="margin-top: 73px; text-align: center;">
		<div>
			<img alt="logo" src="images/img_title.png" style="width: 258px; height: 226px;">
		</div>	
	</div>
	
	<div style="margin-top: 30px; margin-bottom: 29px;" align="center">	
		<form action="loginOK" id="frm">
			<table style="width: 300px;">
				<tr>
					<td align="center">
						<img src="images/img_loginBox.png" class="inputImg input_box">
						<input type="text" id="loginId" placeholder="아이디를 입력해주세요" name="id">
					</td>
				</tr>
				<tr>
					<td align="center">
						<img src="images/img_loginBox.png" class="inputImg input_box">
						<input type="password" id="loginPassword" placeholder="비밀번호를 입력해주세요" name="password">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<img src="images/btn_login.png" onclick="document.getElementById('frm').submit()" class="loginbtn" style="width: 278px; height: 69px;">
					</td>			
				</tr>
			</table>
		</form>
	</div>
	<div align="center" style="margin-bottom: 25px;">
		<img src="images/img_kakao.png" class="loginBtnImg" style="margin-right: 16px;">
		<img src="images/img_naver.png" class="loginBtnImg" style="margin-right: 16px;" onclick="location.href='${url}'">
		<img src="images/img_google.png" class="loginBtnImg">
	</div>
	<div align="center" style="padding-bottom: 42px;">
		<a href="joinmember" style="color: #c1c1d3;">회원가입</a>		
	</div>
<footer>

</footer>
</body>
</html>