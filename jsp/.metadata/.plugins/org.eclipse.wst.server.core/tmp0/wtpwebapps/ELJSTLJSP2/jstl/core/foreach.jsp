<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

// java 코드 이용하여 html 코드 5번 반복하기

	for(int i=0 ;i<=5 ; i++){
		%>
			<h2>hello </h2>
		<%
	}
%>

<hr>

<c:forEach begin="1" end="5" step="1" >
	<h3>HeLLO!@@@</h3>

 </c:forEach>
 
 
 <hr>
 
 <c:forEach begin="1" end="5" step="1" var="i">
	<h3> ${i }</h3>

 </c:forEach>
 
 
   <hr>
   <h2> 토큰기준으로 반복문을 처리  </h2>
<%--   <c:forTokens items="객체/객체명" delims="구분자(토큰)">
          반복할 코드
   </c:forTokens> --%>
   
   <c:forTokens var="data" items="a,b,c,d,e,f,g,h,i,j" delims=",">
   	 반복코드! ${data}<br>
   </c:forTokens>

<hr>

	<c:forTokens var="data" items="안녕하세요 저는 아이티윌 입니다." delims=" ">
   	 반복코드! ${data}<br>
   </c:forTokens>
   
   
   <hr>
   <c:set var="tmp" value="안녕하세요 저는 아이티윌 입니다."/>
   <c:forTokens var="data" items="${tmp }" delims=" ">
   	반복코드 ${data } <br>
   </c:forTokens>
   
   
   
   
   
</body>
</html>