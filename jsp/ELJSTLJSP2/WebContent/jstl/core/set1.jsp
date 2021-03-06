<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<h1> WebConetnt/jstl/set1.jsp</h1>
	<h2> 변수 선언 </h2>
	
	
	
	<%
		// 현재 페이지 set1.jsp 에서만 사용가능한 변수 ( 사용 종속적이다! )
		int num1 = 10;
		int num2 = 20;
		
		int sum = num1 + num2 ;
	
	%>
	
	합  : <%= sum %> <br>
	
	<hr>
	<!-- JSTL 사용변수 선언 : EL 표현식으로 사용해서 변수 호출/사용 -->
	<!-- jstl을 이용해서 변수 선언한것!!! -->
	<c:set var="num3" value="100"/>
	<c:set var="num4" value="200"/>
	
	<c:set var="sum2" value="num3+num4"/>
	<c:set var="sum3" value="${num3+num4 }"/>
	
	<c:out value="sum2"/> <br>
	<c:out value="${sum2}"/> <br>
	<c:out value="${sum3}"/> <br>

	<!-- JSP 표현식으로 사용 X -->
	<%-- <c:out value="<%=sum3 %>"/> <br> --%>
	${num3 } + ${num4 } = ${sum3 } <br>
	
	
	<!-- 내장 객체 : page, request, session, application
		 jstl 변수 선언 -> JSP 코드의 내장객체 속성(attribute) 선언과 같다 
	 -->
	 
	 <c:set var="a" value="100"/>
	 <%
	 	pageContext.setAttribute("a", 100);
	 %>
	 
	 
	 <hr>
	 <!-- scope를 page로 정해주면 , 페이지 영역에 저장 (이 페이지에서만 쓸 수 있도록 하겠다) -->
<%-- 	 <c:set value="" var="" scope="page"/> --%>
	 
	 <!-- requset 영역에 속성 3개를 저장 -->
	 <c:set var="model" value="samsung" scope="request"/>
	 <c:set var="name" value="s21"  scope="request"/>
	 <c:set var="price" value="100"  scope="request"/>
	 
	 모델명 : ${model} <br>
	 상품명 : ${name } <br>
	 가격 : ${price } <br>
	 
	 
	 <!-- request 영역의 데이터를 전다라기 위해서 액션태그 (forward) 사용,
	 	주소는 변경되지 않는다 (주소 set1.jsp) 화면은 변경됨 (set2.jsp)
	 	(+request, response 객체 정보 전달)
	  -->
	 	
	 <jsp:forward page="set2.jsp"/>
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	
	
</body>
</html>