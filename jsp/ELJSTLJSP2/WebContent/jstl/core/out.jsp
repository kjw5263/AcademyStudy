<%@page import="java.lang.reflect.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSP 디렉티브를 사용해서 JSTL을 설정 (필수) -->    
<!-- 해당 라이브러리를 사용하기 위해서 접두사 (prefix)를 c로 지정
	=> core의 약자 c를 사용(다른 접두사 사용가능)
	
 	해당 라이브러리를 접근하기 위한 주소 (uri)를 [~/jsp/jstl/core]지정 -->
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 액션태그 : 태그지만 JSP 동작 처리 -->
<%-- <jsp:useBean id=""></jsp:useBean> --%>

	<h4>글쓰기에는 여러 방법이 있어요.</h4>
	html : 안녕하세요. <br>
	<%
		out.println("JSP: 안녕하세요<br>");
	%>
	JSP 표현식 : <%= "안녕하세요." %> <br>
	<c:out value="안녕하세요."></c:out>

<hr>

	* JSP 표현식 대신해서 사용한다, <br>
	EL 표현식 : ${"아녕하세요"}  <br>
	EL 표현식이 컴파일 에러가 나타날 수 있지만, 일단 실행부터 돌려봐! <br>
	
	<hr>
	<!-- 2*3의 결과를 출력하시오 -->
	html : 2*3 <br>
	<%
		double result = 2*3;
		out.println("JSP : " + (2*3) + "<br>");
	%>
	JSP 표현식 : <%=2*3 %> <%=result %> <br>
	<!-- 표현식이 애초에 자바코드를 실행할 수 있또록 하는 것이기 떄문에 이렇게 실행됨 -->
	core : <c:out value="2*3"></c:out> <br>
	EL : ${2*3} ${result} <br>
	
	core_el 표현식 : <c:out value="${2*3}"/> <br>
	
	core_JSP 표현식 : <c:out value="<%=2*3 %>"/><br>
	
	<hr>
	
	<%-- <%=member.getName() %> --%>
	<%-- <%
		Member member = null;
	%>
	<%= member.getName() %> --%>
	
	<c:out value="member.getName()"/> <br>
	<!-- core_el 은 null값이어도 error가 아닌 공백으로 출력함  -->
	<c:out value="${member.getName() }"/> <br>
	
	<!-- core_jsp 이 null이면 컴파일 자체가 안되기 떄문에 에러   -->
	<%-- <c:out value="<%=member.getName() %>"/> --%>
	
	<!-- core_el : default 속성으로 null값일 때 원하는 값 출력 가능  -->
	<c:out value="${member.getName()}" default="문제 발생!"></c:out>
	<c:out value="${member.getName() }" default="${'문제발생'}"></c:out>
	<!-- jsp 사용 불가  -->
	<%-- <c:out value="${member.getName()}" default="<%=result %>"></c:out> --%>
	
	<hr><hr>
	
	<!-- el 표현식 사용해서 <태그를 변경했음 -->
	&lt;abc>는 abc 태그 입니다. <br>
	
	<!-- JSTL을 사용해서 일반 태그 출력 -->
	<c:out value="<abc>는 abc 태그 입니다."/> <br>
	
	
	
	
	
	
</body>
</html>