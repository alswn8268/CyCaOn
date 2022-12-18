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
	<div style="margin: 20px; padding: 20px;" align="center">
		<h2>${memberVO.nickname} (${memberVO.id}) 님의 프로필</h2>
			<table>
				<tr>
					<th>자기소개</th>
					<td>한마디</td>
				</tr>
				<tr>
					<th>친구 상태</th>
					<td>${rel}</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<c:if test="${rel == null}">
							<input type="button" value="친구 신청" onclick="location.href='makeFriend?fid=${memberVO.id}&mid=${id}'">
						</c:if>
						<c:if test="${rel != null}">
							<input type="button" value="친구 삭제" onclick="location.href='deleteFriend?fid=${memberVO.id}&mid=${id}'">
						</c:if>
						<input type="button" value="창 닫기" onclick="self.close()">
					</td>			
				</tr>
			</table>
	</div>

<footer>

</footer>
</body>
</html>