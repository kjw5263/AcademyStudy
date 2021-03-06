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
	<h1>WebContent/jstl/set2.jsp</h1>
	<%-- <%
	// set1.jsp 에서 전달한 정보 저장 출력
	// model, name, price
	// scope로 넘기는 것은 setAttribute로 저장한 후 넘기는 것이기 때문에,
	// 받을 때 getParameter가 아닌 getAttribute 로 받아야 한다
	String model = (String)request.getAttribute("model");
	String name = (String)request.getAttribute("name");
	int price = Integer.parseInt((String)request.getAttribute("price"));
	// Object 껍데기 안에 String
	
	
	
	%> --%>
	 
	<%-- <%=model %>
	<%=name %>
	<%=price %>
	<hr> --%>
	
	<!-- p512 -->
	<h2> el 표현식으로, 속성(attribute)값을 바로 꺼내서 사용가능</h2>
	<h2> 기본적으로 해당 타입으로 형 변환 </h2>
	
	${model }
	${name }
	${price }
	${price + 10000 } <!-- 알아서 타입까지 변경해줌 -->
	
	<hr>
	<h3> 영역객체의 접근은 생략 가능하다 </h3>
	${requestScope.model }
	
	${model }
	${pageScope.model } <!-- 페이지 컨텍스트는 해당 페이지에서만 사용가능 -->
	
	
	<hr>
	<!-- jsltl 코드를 사용해서 특정 역ㅇ역의 속성을 삭제 -->
	<!-- 속성 명은 동일한 이름을 사용X  -->
	<!-- 내가 영역을 지정하지 않으면 , 돌면서 찾을때까지 페이지를 실행 함  P R S A-->
	<!-- scope="request"를 적지않앗을 때 앞페이지의 model 을 지우ㅠㅓ -->
	<c:remove var="model" scope="request"/>
	${model }
	
	
	
	${tel }
	
	
	<hr>
	<h2> 전달되는 객체 정보 확인 </h2>
	${requestScope.userInfo }<br>
	${requestScope.userInfo.userName } <br>
	${requestScope.userInfo.userGender } <br>
	${userInfo.userEmail } <br>
	
	<br>
	<c:set var="m" value="${requestScope.userInfo}" />
	${m.userName }
	
	<br>
	
	
	
	<c:set var="m1" value="${requestScope.userInfo.userName}" />
	${m1 }
	
	
	
	<h2>jajva 코드에서 전달된 리스트 정보 출력</h2>
	<%-- ${requestScope.memList.userName } : 배열로 넘어와서 어딘지 몰라 에러 남 --%>
	${requestScope.memList[0].userName } <br>
	<c:set var="mName" value="${requestScope.memList[0].userName }"/><br>
	<c:set var="mName1" value="${requestScope.memList[0].userGender }"/><br>
	${mName }
	${mName1 }
	
	
	
	
	
	
	
</body>
</html>