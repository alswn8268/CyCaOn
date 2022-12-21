<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방 만들기</title>
<link rel="icon" href="images/favicon.png"/>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" as="style" crossorigin href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.6/dist/web/static/pretendard.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/main.css">
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="js/main.js"></script>
</head>
<body>
<header>
	<div>
	</div>
</header>

	<div style="margin: 20px; padding: 20px;" align="center">
		<form action="makeRoomOK">
			<input type="hidden" name="id" value="${id}">
			<table>
				<tr>
					<th>방 제목</th>
					<td>
						<input type="text" placeholder="방 제목을 입력해주세요" name="roomName">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<select id="chkpwd" onchange="isPwd()">
							<option selected>없음</option>
							<option>있음</option>
						</select>
						<input type="password" id="roompwd" style="display: none;" placeholder="비밀번호를 입력해주세요" name="roomPassword">
					</td>
				</tr>
				<tr>
					<th>테마</th>
					<td>
						<select name="roomTheme">
							<option selected>기본</option>
							<option>잉어 테마</option>
							<option>떡볶이 테마</option>
							<option>두부 테마</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>최대 인원</th>
					<td>
						<select>
							<option selected>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							<option>6</option>
							<option>7</option>
							<option>8</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="만들기">
						<input type="button" value="메인으로" onclick="location.href='main'">
					</td>			
				</tr>
			</table>
		</form>
	</div>

<footer>

</footer>
</body>
</html>