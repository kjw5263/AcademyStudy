<%@page import="com.itwillbs.myServlet.Dog"%>
<%@page import="com.itwillbs.myServlet.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>WebContent/el/BeanTest.jsp</h1>

<h2>전달된 주인의 이름</h2>
<h2> el 표현식 </h2>
<!-- request.setAttribute할 때 kim이라는 이름으로 보냈으므로 받을때도 kim으로 받기 -->
이름  : ${requestScope.kim.name } <br>
강아지 이름 : ${requestScope.kim.dog.dogName } <br>

<%

		
	Person kim = (Person)request.getAttribute("kim");
	// Dog dog = kim.getDog();   이렇게 새로 받아와도 된당!
%>
	이름 : <%=kim.getName() %> <br>
	강아지이름 : <%=kim.getDog().getDogName() %>


	<h3>하나의 JSP 페이지에서 실행되지만, 각각이 실행되는 공간이 다르다 <br>
	스크립틀릿, jstl, el (서버에서 실행) <br>
	자바스크립트 (브라우저에서 실행)  <br>
	<br>
	* 정보가 호출되고 만들어지는 순서가 중요!<br>
	* 코드 실행 순서
	JSP(java) > jstl/el > html > javaScript 
	</h3>
	
	
	


</body>
</html>