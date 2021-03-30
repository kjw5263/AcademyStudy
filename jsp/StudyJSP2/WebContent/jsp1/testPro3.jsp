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
		String name = request.getParameter("myName");
		int age = Integer.parseInt(request.getParameter("myAge"));
		String gender = request.getParameter("gender");
		String classNum = request.getParameter("class");
		
	
	%>
	
	
	
	이름 : <%=name %> <br>
	나이 : <%=age %> <br>
	성별 : <%= gender %> <br>
	강의장 : <%=classNum %> <br>
	취미 : 
	
	<%
		// 취미 (동일한 이름의 파라미터를 처리)
		String[] hobby = request.getParameterValues("myHobby");
	
		if(hobby != null ){
			for(int i=0; i<hobby.length; i++){
				out.print(hobby[i] + " ");
			}
		} else {
			out.print("취미를 선택하지 않았습니다.");
		}
		
	
	%>
	
</body>
</html>