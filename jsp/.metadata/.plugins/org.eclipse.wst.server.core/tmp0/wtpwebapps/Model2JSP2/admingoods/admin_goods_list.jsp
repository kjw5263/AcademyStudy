<%@page import="com.admin.goods.db.GoodsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>2. 상품 목록 페이지</title>
</head>
<body>
<h1> WebContent/adminGoods/admin_goods_list.jsp</h1>
<h2>등록 상품 목록</h2>
<h3><a href="./GoodsAdd.ag">상품 등록하기</a></h3>

<!-- setAttribute로 받아온(공유된) list 정보 
 -->
 
 <%
 	// 전달된 정보 (공유된 속성)
 	// request.setAttribute("goodsList", goodsList);
 
 	List goodsList = (List)request.getAttribute("goodsList"); // 다운 캐스팅
 
 	
 %>
 

<table border="1">

	<tr>
	  <td>번호</td>
	  <td>카테고리</td>
	  <td>사진</td>
	  <td>상품명</td>
	  <td>가격</td>
	  <td>수량</td>
	  <td>등록일자</td>
	  <td>수정/삭제</td>
	</tr>

	<% for(int i= 0; i<goodsList.size(); i++){
		GoodsDTO gdto = (GoodsDTO)goodsList.get(i);
		
		%>
			
	
	<tr>
	  <td><%=gdto.getNum() %></td>
	  <td><%=gdto.getCategory() %></td>
	  <td>
	  	<img src="./upload/<%=gdto.getImage().split(",")[0] %>" width="50" height="50">
	  </td>
	  <td><%=gdto.getName() %></td>
	  <td><%=gdto.getPrice() %></td>
	  <td><%=gdto.getAmount() %></td>
	  <td><%=gdto.getDate() %></td>
	  <td>
	  	<a href="./AdminGoodsModify.ag?num=<%=gdto.getNum()%>">수정</a>/<a href="./AdminGoodsDelete.ag?num=<%=gdto.getNum()%>">삭제</a>
	  </td>
	</tr>
	
	<% }%>
	
	
</table>
</body>
</html>