<%@page import="com.itwillsbs.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function clickOn() {
	document.fr.text = "안녕?";
}

</script>
</head>
<body>
 <h1>WebContent/member/joinIDCheck</h1>
 
<%
 	String id = request.getParameter("userid");
 	// DB 객체 생성 -> 체크 메솓 ㅡ
 	
 	MemberDAO mbdao = new MemberDAO();
 	int result = mbdao.idCheck(id);
 
 	if(result == 1){
 		out.print("이미 사용중인 입니다.");
 	} else {
 		out.print("사용가능한 아이디");
 	}
 %> 
 
 <hr>
 <form action="" method="post" name="ofr">
   <input type="text" name="userid" value="<%=id %>">
   <input type="submit" value="사용하기">
 
 
 </form>
 
 
 <form action="" name="fr">
 
 	<input type="button" value="확인" onclick="clickOn()">
 
 	<div class="text" ></div>
 
 </form>
</body>
</html>