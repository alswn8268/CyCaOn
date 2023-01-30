<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<link rel="icon" href="images/favicon.png"/>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" as="style" crossorigin href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.6/dist/web/static/pretendard.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/main.css">
<script type="text/javascript">
	function fn_sendFB(sns) {
	    var thisUrl = document.URL;
	    var snsTitle = "Study With Meow";
	    if( sns == 'facebook' ) {
	        var url = "http://www.facebook.com/sharer/sharer.php?u="+encodeURIComponent(thisUrl);
	        window.open(url, "", "width=486, height=286");
	    }
	    else if( sns == 'twitter' ) {
	        var url = "http://twitter.com/share?url="+encodeURIComponent(thisUrl)+"&text="+encodeURIComponent(snsTitle);
	        window.open(url, "tweetPop", "width=486, height=286,scrollbars=yes");
	    }
	    else if( sns == 'kakaotalk' ) {
	        // 사용할 앱의 JavaScript 키 설정
	        Kakao.init('36e39b3dce6c1f9eab9b68b6fbfd8144');
	        
	        // 카카오링크 버튼 생성
	        Kakao.Link.createDefaultButton({
	            container: '#btnKakao', // HTML에서 작성한 ID값
	            objectType: 'feed',
	            content: {
	            title: "Study With Meow", // 보여질 제목
	            description: "집에서도 카페처럼! 랜선 카페에 어서 오세요~", // 보여질 설명
	            imageUrl: thisUrl, // 콘텐츠 URL
	            link: {
	                mobileWebUrl: thisUrl,
	                webUrl: thisUrl
	            }
	        }
	    });
	}
	}    
</script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="js/main.js"></script>
</head>
<body>
<jsp:useBean id="date" class="java.util.Date"/>
	
<header>
	<div>
		<c:if test="${id != null}">
			<b>${nickname}</b>님 안녕하세요! 오늘은 ${date}입니다.
			<input type="button" value="로그아웃" onclick="location.href='logout'">
		</c:if>
		<c:if test="${id == null}">
			<input type="button" value="로그인" onclick="location.href='login'">
		</c:if>
	</div>
</header>
<br/><br/><br/><br/>

	현재 접속자 수: ${userCount}
	누적 접속자 수: ${totalCount}
	<c:if test="${id != null}">
		<div align="center">
			<input type="button" value="내 방 만들기" onclick="location.href='makeRoom'"/>&nbsp;&nbsp;&nbsp;
			<input type="button" value="방찾기" onclick="location.href='findRoom'"/><br/>
			<input type="button" value="상점" onclick="location.href='shop'"/>&nbsp;&nbsp;&nbsp;
			<input type="button" value="마이페이지" onclick="location.href='myPage?id=${id}'"/><br/>
		</div>
	</c:if>
<br/><br/><br/>

<c:set var="wantF" value="${wantF.list}"/>
<c:if test="${wantF != null}">
	<div id="wantFModal" >
		<c:forEach var="wantF" items="${wantF}">
			<div style="border: 1px solid black; margin: 5px; padding: 5px;">
				${wantF.mid} 님에게서 친구 신청이 왔습니다.	
				수락하시겠습니가?
				<input type="button" value="수락" onclick="location.href='friendOK?fid=${wantF.mid}&mid=${id}&mode=1'">
				<input type="button" value="거절" onclick="location.href='friendOK?fid=${wantF.mid}&mid=${id}&mode=2'">
				<br/>
			</div>
		</c:forEach>
		<input type="button" onclick="modalClose()" value="창 닫기"> 		
	</div>
</c:if>
	<br/><br/><br/><br/><br/>
	
	
<footer>

				<div class="col-sm-3" align="right" style="vertical-align: middle;">
					<span>
				   		<a href="#n" onclick="fn_sendFB('facebook');return false;" class="facebook" target="_self" title="페이스북 새창열림">
				   			<img alt="facebook" src="images/icon-facebook.png">
				   		</a>
					</span>
					<span>
				    	<a href="#n" onclick="fn_sendFB('twitter');return false;" class="twitter" target="_self" title="트위터 새창열림">
				   			<img alt="twitter" src="images/icon-twitter.png">
				    	</a>
					</span>
					<span>
						<a href="#n" id="btnKakao" onclick="fn_sendFB('kakaotalk');return false;" class="kakaotalk" target="_self" title="카카오톡 새창열림">
				   			<img alt="kakao" src="images/icon-kakao.png">
						</a>
					</span>
				</div>
</footer>

</body>
</html>