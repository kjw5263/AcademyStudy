<%@page import="com.movie.board.BoardDAO"%>
<%@page import="com.movie.board.ReplyBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String user_id = (String)session.getAttribute("user_id");
	if(user_id == null){
		response.sendRedirect("../member/main.jsp");
		session.invalidate();
	}
	int reply_num = Integer.parseInt(request.getParameter("reply_num"));
	int board_num = Integer.parseInt(request.getParameter("board_num"));
	String pageNum = request.getParameter("pageNum");
	
	
	BoardDAO bdao = new BoardDAO();
	System.out.println("댓글 번호 :"+reply_num);
	ReplyBean reBean = new ReplyBean();
	reBean.setReply_num(reply_num);
	reBean.setUser_id(user_id);
	int result = bdao.replyDelete(reBean);
	
	
	if(result == 1){
		%>
		<script>
			alert("정상적으로 삭제되었습니다.");
			location.href="content.jsp?pageNum=<%=pageNum%>&board_num=<%=board_num%>";
		</script>
	<%
	} else {
		%>
		<script>
			alert("댓글 삭제 권한이 없습니다.");
			history.back();
		</script>
	
	<%
	}

%>
</body>
</html>