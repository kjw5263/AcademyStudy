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
<h1>WebContent/jstl/if.jsp</h1>
<!-- test="" 속성 : 조건문을 작성(el 표현식 사용) -->
<%-- 
	<c:if test="${조건문}">
		<!-- 실행문(html코드) --> 
	</c:if>
 --%>

<c:if test="${1==2 }">
	1은 1이다.


</c:if>
<!-- form 태그 사용 해당페이지 (if.jsp) 호출
	파라미터값 2개 전달

 -->
 <!--  -->
 <hr>
 <form action="if.jsp" method="get">
  <input type="text" name="data1"><br>
  <input type="text" name="data2">
  
  <input type="submit" value="데이터" >
 
 </form>
 
 
 <%
 	String data1 = request.getParameter("data1");
 
 %>
 <%=data1 %>
 
 
 <h3>el 표현식 사용 </h3>
 ${param.data2 }
 
 
 <hr>
 <h3> 전달되는 두개의 데이터 크기 비교 하기</h3>
 <c:if test="${ param.data1 > param.data2}">
 	1번 데이터가 더 크다
 
 </c:if>
	
 <c:if test="${ param.data1 < param.data2}">
 	2번 데이터가 더 크다
 
 </c:if>
 
 
 
<%--  <c:choose>
   <c:when test="${조건문 }">
      	실행문 
   </c:when>
   <c:when test="${조건문 }">
      	실행문 
   </c:when>
   <c:otherwise>
   		위 조건문을 모두 만족하지 않은 상태
   </c:otherwise>
 </c:choose> --%>

<c:choose>
  <c:when test="${param.data1 > param.data2 }">
  	1번이 크다! <br>
  </c:when>
  <c:when test="${param.data1 < param.data2 }">
  	2번이 크다
  </c:when>
  <c:otherwise>
     <c:if test="${param.data1 != null }">
     	동일한 값
     </c:if>   
  </c:otherwise>
</c:choose>


</body>
</html>