<%@page import="DB.MemberBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="DB.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDAO mDAO = new MemberDAO();

	Iterator<MemberBean> it = mDAO.getAllMember();
	
	MemberBean bean = null;
	
	
%>


<member>
	<%while(it.hasNext()) { %>
		<% bean = it.next(); %>
		<item>
			<id><%=bean.getId() %></id>
			<pass><%=bean.getPass() %></pass>
			<name><%=bean.getName() %></name>
			<phone><%=bean.getPhone() %></phone>
			<email><%=bean.getEmail() %></email>
		</item>
	<% } %>
</member>