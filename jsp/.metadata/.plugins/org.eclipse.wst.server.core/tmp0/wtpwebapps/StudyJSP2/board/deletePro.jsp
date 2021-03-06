<%@page import="com.itwillbs.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>WebContent/board/deletePro.jsp</h1>
 
 <%
 	// 전달정보 저장 - pageNum
 	String pageNum = request.getParameter("pageNum");
 	// 전달정보 저장 - 액션 태그 (자바빈) - num, pass //-> 보드빈으로 하는 이유>??
 	
 	// 
 %>
 
 
 <jsp:useBean id="delBean" class="com.itwillbs.board.BoardBean"/>
 <jsp:setProperty property="*" name="delBean"/>
 
 
 <%
 	System.out.println("삭제정보 : " + delBean);
 	
 
 	// BoardDAO 객체 생성
 	BoardDAO bdao = new BoardDAO();
 	// -> 글 정보 사용해서 글 삭제 기능 메서드() deleteBoard(bb)
 	int check = bdao.deleteBoard(delBean);
 	// 처리 결과를 1(정상처리), 0(오류-비밀번호), -1(오류-글없음) 리턴
 	if(check == 1){
 		%>
 		  <script type="text/javascript">
 		  	alert("성공적으로 삭제되었습니다.");
 		  	location.href="list.jsp?pageNum=<%=pageNum %>";
 		  </script>
 		<%
 	} else if(check == 0){
 		%>
		  <script type="text/javascript">
		  	alert("비밀번호가 맞지 않습니다.");
		  	history.back();
		  </script>
		<%
 	} else if(check == -1){
 		%>
		  <script type="text/javascript">
		  	alert("해당 글이 존재하지 않습니다.");
		  	history.back();
		  </script>
		<%
 	}
 	// 처리 결과에 따른 페이지 이동
 %>
 
</body>
</html>