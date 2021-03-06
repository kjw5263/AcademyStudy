<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>WebContent/el/paramTestPro1.jsp</h1>

<%

	request.setCharacterEncoding("UTF-8");
	// ID, PW 값을 저장 출력
	String ID = request.getParameter("id");
	String PW = request.getParameter("pw");

%>

아이디 : ${param.id} <br> <!--  내가 넘겨줄 때 파라미터 이름을 적는다  -->
비밀번호 : ${param.pw } <br>


<%
	// 좋아하는 음식 2개 저장 후 출력
	String food1 = request.getParameter("food");
	String food2 = request.getParameter("food");
	
	String[] foods = request.getParameterValues("food");
	// 취미 3개 출력
%>
	음식1 : <%=food1 %> <br>
	음식2 : <%=food2 %> <br>
	음식1 : <%=foods[0] %> <br>
	음식2 : <%=foods[1] %> <br>
	
	<hr>
	취미 : ${param.hobby }<br>
	취미2 : ${param.hobby }<br>
	취미3 : ${param.hobby }<br>
	
	취미 : ${paramValues.hobby[0] }<br>
	취미2 : ${paramValues.hobby[1]}<br>
	취미3 : ${paramValues.hobby[2] }<br>
	
	<hr>
	
<%-- 	<%
		for(int i=0; i<3; i++){
			%>
				취미1 : ${paramValues.hobby[i] }<br>
			<%
		}
	
	%> --%>


  <!-- jstl + el 반복문 사용 -->
<%-- 이렇게 쓰면 에러남 
  <c:forEach begin="0" end="2" step="1" >
      ${paramValues.hobby[${i}] }
  </c:forEach>
 --%>
 <c:forEach begin="0" end="2" step="1" >
      ${paramValues.hobby[i]}
  </c:forEach>
 
 <!-- items속성에 배열의 형태를 전달, 각각의 요소만큼 반복
 	해당 요소는 var 변수에 저장 -> el 표현식으로 반복문에서 사용 가능
  -->
 <c:forEach var="hb" items="${paramValues.hobby }">
 	${hb} <br>
 	
 </c:forEach>
 
 <!-- jstl + jsp 표현식 -->
  <c:forEach var="hb" items='<%=request.getParameter("hobby") %>'>
 	${hb} <br>
 	
 </c:forEach>



</body>
</html>