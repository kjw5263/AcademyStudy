<%@page import="com.itwillbs.board.BoardBean"%>
<%@page import="com.itwillbs.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>1. writeForm.jsp </title>
</head>
<body>

	<h1>WebContent/member/updateForm.jsp</h1>
	<h2>게시판 수정하기</h2>
	
	<%
		// 전달 방식에 따라서 한글 처리 있으면 한글 처리 하기~(post방식)
		// updateForm.jsp?num=14&pageNum=1
		// 전달된 파라미터 있으면 저장하는게 가장 먼저!
		
		int num = Integer.parseInt(request.getParameter("num")); // 얘는 DB에 접근할것이기 때문에 int로 변환하는거고
		String pageNum = request.getParameter("pageNum"); // 이건 DB접근없기때문에 문자로 받아들여도 상관 ㄴㄴ
		
		// DB에서 글 번호에 해당하는 정보를 가져와서 출력
		
		BoardDAO bdao = new BoardDAO();
		BoardBean bb= bdao.getBoard(num);
		// bdao.getBoard(num).getNum();  (x, 메모리 낭비 심해서 사용권장 X)
		
	%>
	
	<!-- DB에 처리해야하는 데이터 폼태그 안에 저장 (hidden)
		 DB에 처리 안하는 경우 주소줄에 저장 (url) "
	 -->
	<fieldset>
		<form action="updatePro.jsp?num=<%=bb.getNum() %>" method="post">
		<input type="hidden" name="num" value="<%=bb.getNum() %>">

		<!-- pageNum은 DB에서 사용되지 않기 때문에 url로 보내고, num은 DB에 사용되므로 hidden으로 보낸다 -->

		<!-- 글쓴이는 수정하지 못하도록 readonly 속성 준다 -->
		글쓴이 : <input type="text" name="name" value="<%=bb.getName()%>" readonly> <br>
		비밀번호 : <input type="password" name="pass" placeholder="비밀번호를 입력하세요."> <br>
		제목 : <input type="text" name="subject" value="<%=bb.getSubject()%>"> <br>
		내용 : <textarea rows="20" cols="80" name="content"><%=bb.getContent() %></textarea>
		<!-- textArea에는 그..그 뭐야 value 속성이 들어갈 수 없다 -->
		
		
		<hr>
		<input type="submit" value="수정하기">
		
		
		</form>
	</fieldset>
</body>
</html>