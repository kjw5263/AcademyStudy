<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>WebContent/member/insertForm.jsp</h1>
 
 <h2> 회원 가입 </h2>
 <!-- 아이디, 비밀번호, 이름, 나이, 성별(라디오버튼), 이메일 -->
 
 <form action="insertPro.jsp" method="post">
  아이디 : <input type="text" name="id"> <br>
  비밀번호 : <input type="password" name="pw"> <br> 
  이름 : <input type="text" name="name"> <br>
 나이 : <input type="text" name="age"> <br>
 성별 : <input type="radio" name="gender" value="남" checked> 남
 	  <input type="radio" name="gender" value="여"> 여 <br>
 이메일 : <input type="text" name="email" > <br>
  <hr>
  <input type="submit" value="가입">

 
 </form> 
 
 
</body>
</html>