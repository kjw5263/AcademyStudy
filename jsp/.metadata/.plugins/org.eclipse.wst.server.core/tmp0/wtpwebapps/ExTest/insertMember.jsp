<%@page import="DB.MemberDAO"%>
<%@page import="DB.MemberBean"%>
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
		// 안드로이드 앱에서 전달받은 데이터 request 내장 객체 영역에서 꺼내오기
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name= request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		// 안드로이드에서 입력하여 전송한 데이터 출력
		System.out.println("id="+id+", pass="+pass +", name="+name +", phone = "+phone + ", email = "+ email);
		
		// 안드로이드 앱에서 회원가입을 위해 입력후 요청했다면,
		
		if( id != null ){
			MemberBean bean = new MemberBean();
			bean.setId(id);
			bean.setPass(pass);
			bean.setName(name);
			bean.setPhone(phone);
			bean.setEmail(email);
			
			// 실제 입력한 정보를 DB에 insert 하기 위해 호출
			new MemberDAO().insertMember(bean);
		}
	
	%>
</body>
</html>