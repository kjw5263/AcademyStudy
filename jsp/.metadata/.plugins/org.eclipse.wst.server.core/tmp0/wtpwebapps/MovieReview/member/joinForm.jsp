<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마뮤다 회원가입</title>
</head>
<body>
	
	<h2> 회원가입 </h2>
	<form action="joinPro.jsp" method="post">
	
	<input type="text" name="user_id" placeholder="아이디"><br>
	<input type="name" name="name" placeholder="성명"><br>
	<input type="text" name="nickname" placeholder="닉네임"><br>
	<input type="password" name="pw" placeholder="비밀번호"><br>
	<input type="password" name="pw_check" placeholder="비밀번호 확인"><br>
	<input type="text" name="email" placeholder="이메일"><br><br>
	
	
	<input type="button" value="취소" onclick="location.href='loginForm.jsp'"> 
	<input type="submit" value="가입하기">
	
	
	</form>
	
</body>
</html>