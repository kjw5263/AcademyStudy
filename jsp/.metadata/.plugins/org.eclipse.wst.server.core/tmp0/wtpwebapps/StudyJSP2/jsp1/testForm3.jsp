<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> WebContent/jsp1/testForm1.jsp </h1>
	<!-- 이름, 나이, 성별(radio), 강의장(select), 취미(checkbox) -->
	
	<fieldset>
	<legend> 소개 폼 </legend>
	<form action="testPro3.jsp" method="get">
		이름 : <input type="text" name="myName"> <br>
		나이 : <input type="text" name="myAge"> <br>
		성별 : <input type="radio" name="gender" value="남"> 남 
			<input type="radio" name="gender" value="여"> 여  <br>
		강의장 : 
			<select name="class">
			 <option value="1">1강의장</option>
			 <option value="2">2강의장</option>
			 <option value="3">3강의장</option>
			 <option value="4">4강의장</option>
			</select> <br>
		취미 :
		<input type="checkbox" name="myHobby" value="노래">노래
		<input type="checkbox" name="myHobby" value="요리">요리
		<input type="checkbox" name="myHobby" value="등산">등산
		<input type="checkbox" name="myHobby" value="영화">영화
		 <br>

	<input type="submit">
	</form>
	</fieldset>
	
	
</body>
</html>