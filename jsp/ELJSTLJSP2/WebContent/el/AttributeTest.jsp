<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>WebContent/el/AttributeTest.jsp</h1>
<%

	// TestServlet1.java에서, request.setAttribute()로 전달한 속성 받기
	int cnt = (Integer)request.getAttribute("cnt");


	// 전달된 세션 객체 정보 출력
	int cnt2 = (Integer)session.getAttribute("cnt");

	out.println("전달된 cnt : " + cnt + "<br>");
	out.println("전달된 cnt22 : " + cnt2 + "<br>");

%>


  <h2> jsp 표현식</h2>
  jsp 표현식( =변수 ) : <%=cnt %> <br>
  jsp 표현식 : <%=cnt2 %> <br>




  <h2> el 표현식</h2>
  전달된 cnt(el)( 속성 ) : ${cnt }<br>
  <!-- 위 int cnt값과 같을까? ㄴㄴ !! el식의 cnt는 
  TestServlet1.java 코드에서 setAttribute 할 때의cnt이다.   -->
  전달된 cnt(el) : ${requestScope.cnt } <br>
  <!-- 이 때의 cnt 는 위의 int cnt와 같나? ㅇㅇ!! -->
  
  
  
  전달된 cnt2(el) : 
  
  
  
  <h3> EL 내장 객체 중에서 (영역객체) 순차적으로 해당 영역을 검색
  해당 데이터가 있을 경우 다음 영역의 검색 X </h3> 
  
  
  <!-- 
  	page 		request		session		application
  	
  				cnt=100		cnt=200
  	
  	${cnt} <== 100! 
  			: 영역이 없을 경우 처음부터 순차적 검색
  	${sessionScorpe.cnt} : 해당 영역만 접근해서 검색 
  		 -->
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
</body>
</html>