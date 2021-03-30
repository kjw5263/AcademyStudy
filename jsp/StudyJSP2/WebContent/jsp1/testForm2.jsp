<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>WebContent/jsp1/testForm2.jsp </h1>
  
  
  <!-- 
  	사용자의 이름, 나이 입력받아서 결과 출력
  	testPro2.jsp 페이지에서 결과 출력	 -->
  	
  <fieldset>
  	<legend> 이름과 나이 입력받기 </legend>
  	<form action="testPro2.jsp" method="post">
  	<!-- 
  		form - get방식 : 한글데이터 전달시 문제 x
  		form - post방식 : 한글데이터 전달시 문제O(인코딩에러) 
  		
  	 -->
  	  이름 : <input type="text" name="myName"> <br>
  	  나이 : <input type="text" name="myAge"> <br>
  	  <input type="submit" >
  	</form> 
  </fieldset>
  
  
</body>
</html>