<%@page import="com.itwill.join.JoinDAO"%>
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
		request.setCharacterEncoding("UTF-8");
		String jumin = request.getParameter("jumin1") + "-";
		jumin += request.getParameter("jumin2");
		String[] arr = request.getParameterValues("hobby");
	  	String hobby = "";
	  	for(int i=0; i<arr.length; i++){
	  		if(i != arr.length-1)  hobby += arr[i] + "/" ;
	  		else if(i == arr.length-1) hobby += arr[i]; 
	  	}
	  	
	%>
	
	 <jsp:useBean id="joinBean" class="com.itwill.join.JoinBean"></jsp:useBean>
  	<jsp:setProperty property="*" name="joinBean"/>
  	
  	<%
  		joinBean.setJumin(jumin);
  		joinBean.setHobby(hobby);
  		
  		JoinDAO jdao = new JoinDAO();
  		
  		int result = jdao.onMemberInsert(joinBean);
  		if(result == 1){
  			%>
  				<script type="text/javascript">
  					alert("정상적으로 가입되었습니다.");
  				</script>
  				
  				<h2> 회원가입 완료 : <%=request.getParameter("name") %></h2>
			  	아이디 : <%=request.getParameter("id") %><br>
				비밀번호 : <%=request.getParameter("pass1") %><br>
				비밀번호 확인 : <%=request.getParameter("pass2") %><br>
				이름 : <%=request.getParameter("name") %><br>
				주민번호 : <%=jumin %><br>
				성별 : <%=request.getParameter("gender") %><br>
				취미 : <%=hobby %><br>
				좋아하는 과목 : <%=request.getParameter("subject") %><br>
				한마디 : <%=request.getParameter("comment") %>
  			<%
  		} else {
  			%>
  			<script type="text/javascript">
				alert("가입실패 했습니다.");
			</script>
			<%
  		}
  	%>
  	
  	
</body>
</html>