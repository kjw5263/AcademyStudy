<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String filename = request.getParameter("filename");
		String oFileName = request.getParameter("oFileName");
		
		
	
	%>
	
	
	<h2> 파일 업로드 및 전달정보 </h2>
	이름 : <%=name %><br>
	제목 : <%=subject %> <br>
	파일이름 (서버에 저장된 이름 ) : <a href="file_down.jsp?filename=<%=filename %>"> <%=filename %> </a> <br>
	파일이름 (파일 원본이름) : <%=oFileName %><br>
	
</body>
</html>