<%@page import="com.itwillsbs.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">


function idFix() {
	// 아이디 사용하기 버튼 클릭시 실행
	// 1) 중복확인창 닫기  2) 선택한 아이디 정보 전달
	
	// 중복확인창 -> 회원가입창으로 정보 전달
	//document.fr.id.value는 회원가입창(부모)이 아닌 현재 페이지를 말하는것!
	// 팝업창을 열어준 opener(부모)
	// document.fr.id.value=document.ofr.userid.value;
	opener.document.fr.id.value = document.ofr.userid.value;
	
	// 팝업창 닫기
	window.close();
	
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
 		%>
 			<input type="button" value="아이디 사용하기" onclick="idFix()">
 		
 		<%
 	}
 %> 
 
 <hr>
 <form action="joinIDCheck.jsp" method="post" name="ofr">
   <input type="text" name="userid" value="<%=id %>">
   <input type="submit" value="중복체크">
 
 
 </form>

</body>
</html>