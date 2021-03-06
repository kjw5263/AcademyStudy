<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 직접 JQuery 파일을 추가해서 사용(준비)
<script scr="../js/jquery-3.6.0.js" ></script>
 -->

<!-- 외부 서버(페이지) CDN에서 파일을 전달받아서 사용(준비)
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
 -->
 
<!-- 

https://jquery.com/download/

 >> 얘넨 좀 느린편
https://code.jquery.com
Google CDN
Microsoft CDN

 >> 얘넨 좀 빠른편
CDNJS CDN
jsDelivr CDN

 -->
 
 <!-- 
  * 한번에 여러개의 JQuery 를 사용가능하나, 가능하면 중복사용을 자제
  => 여러개의 JQuery 버전 충돌 가능성이 있음
  => 쌤이 권하는 습관 ? -> JQuery 추가는 한 곳에서 정리하는 것이 좋다!
 -->



<!-- JQuery는 자바 스크립트 라이브러리 입니다. (기능을 모아놓은 형태) -->
<!-- 1. 라이브러리 추가 (파일/CDN) -->
<script src="../js/jquery-3.6.0.js" ></script>

<!-- 2. JQuery 사용준비 -->
<script type="text/javascript">
	/* Js 코드도 실행됨  */
	alert("자바 스크립트! ");
	/* JQery 기본(준비) 형태 */
	// => HTML-body 생성후 호출
	// * 실행순서  Java(jsp)->JS==html->JQuery
	$(document).ready(function() {
		alert('JQuery 실행111 ');
	});
	
	
	$(function() {
		alert('JQuery 실행222 ');
	});
	
	
	jQuery(document).ready(function(){
		alert('JQuery 실행333 ');
	});
	
	jQuery(function(){
		alert('JQuery 실행444 ');
	});

</script>

</head>
<body>

<h1>WebContent/jq/test1</h1>
<!-- JS - JS(Body) - JQuery -->
<script type="text/javascript">
	alert("자바스크립트(body)");
</script>

</body>
</html>