<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// WebContent/jq2/json3.json
	
	//1. 드라이버로드
	Class.forName("com.mysql.jdbc.Driver");

	// 2. DB 연결
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdb", "root", "1234");

	// 3, sql
	String sql = "select id, name, email from itwill_member";
	
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	// 4. sql 실행
	ResultSet rs = pstmt.executeQuery();
	
	
	// 5 데이터 처리 -> java를 쓸수있는 jsp와는 달리 html로 보내야하기 때문에 json 파일로 만들기
	
	// JSON 배열 객체
	JSONArray memberList = new JSONArray();
	
	// DB 데이터(반복-rs.next()) -> Object (자바빈) -> Array
	while(rs.next()){
		// 데이터 있을 때 JSONObject() 객체 생성
		JSONObject memberBean = new JSONObject();
		memberBean.put("id", rs.getString("id"));
		memberBean.put("name", rs.getString("name"));
		memberBean.put("email", rs.getString("email"));
		
		
		//배열의 한칸에 객체 하나씩 저장
		memberList.add(memberBean);
	}
	
%>

<%=memberList %>


