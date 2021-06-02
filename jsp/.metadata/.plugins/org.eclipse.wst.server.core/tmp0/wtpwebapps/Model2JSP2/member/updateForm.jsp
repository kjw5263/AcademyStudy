<%@page import="com.member.db.MemberDTO"%>
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
 <%
 	//request.getAttribute("mdto", mdto);
 	MemberDTO mdto = (MemberDTO)request.getAttribute("mdto");
 
 
 %> 
 
 
 
 <h2> 회원 정보 수정</h2>
 <!-- 아이디, 비밀번호, 이름, 나이, 성별(라디오버튼), 이메일 -->
 
 <form action="./MemberUpdateProAction.me" method="post">
  아이디 : <input type="text" name="id" value="<%=mdto.getId()%>" readonly> <br>
  비밀번호 : <input type="password" name="pass" placeholder="비밀번호를 입력하세요"> <br> 
  이름 : <input type="text" name="name" value="${mdto.name }"> <br>
 나이 : <input type="text" name="age" value="${mdto.age }"> <br>
 성별 : <input type="radio" name="gender" value="남" 
         <% 
           if(mdto.getGender().equals("남")) {
       	 %> 
        	 checked="checked" 
       	 <% 
       	   } 
       	 %>
         > 남
      <input type="radio" name="gender" value="여" 
        <% 
           if(mdto.getGender().equals("여")) {
       	 %> 
        	 checked="checked" 
       	 <% 
       	   } 
       	 %>
      > 여  <br>
 이메일 : <input type="text" name="email" value="${mdto.email }"> <br>
  <hr>
  <input type="submit" value="회원 정보 수정 ">

 
 </form> 
 
 
</body>
</html>