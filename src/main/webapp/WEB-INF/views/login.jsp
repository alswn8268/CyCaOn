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
	<div>
		<input type="button" value="메인으로" onclick="location.href='main'">
	</div>
</header>

	<div style="margin: 20px; padding: 20px;" align="center">
		<form action="loginOK">
			<table>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" placeholder="아이디를 입력해주세요" name="id">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" placeholder="비밀번호를 입력해주세요" name="password">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="회원가입" onclick="location.href='joinmember'">
						<input type="submit" value="로그인">
					</td>			
				</tr>
			</table>
		</form>
	</div>

<footer>

</footer>
</body>
</html>