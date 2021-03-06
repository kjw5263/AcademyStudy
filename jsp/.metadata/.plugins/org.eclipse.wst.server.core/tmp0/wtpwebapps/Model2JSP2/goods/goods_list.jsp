<%@page import="com.admin.goods.db.GoodsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/goods/goods_list.jsp</h1>
	
	<%
		// request.
		List goodsList = (List)request.getAttribute("goodsList");
	
	%>
	
	<table border="1">
		<tr>
			<td>
				<a href="./GoodsList.go">전체</a>
			</td>
			<td>
				<a href="./GoodsList.go?item=best">베스트상품</a>
			</td>
			<td>
				<a href="./GoodsList.go?item=outwear">외투</a>
			</td>
			<td>
				<a href="./GoodsList.go?item=fullwear">정장/신사복</a>
			</td>
			<td>
				<a href="./GoodsList.go?item=Tshirts">티셔츠</a>
			</td>
			<td>
				<a href="./GoodsList.go?item=shirts">와이셔츠</a>
			</td>
			<td>
				<a href="./GoodsList.go?item=pants">바지</a>
			</td>
			<td>
				<a href="./GoodsList.go?item=shoes">신발</a>
			</td>
		</tr>
		
		
		<!-- 한줄에 8개씩 보여주기 로직 -->
		<%
			// 전체 개수
			int size =goodsList.size();
			// 열의 개수
			int col = 8;
			// 행의 개수
			int row = (size/col)+((size%col>0)? 1:0);
			
			
			// 상품 출력 개수
			// <tr> 생성-> 8개 ... 반복
			int num = 0;
			
			// 행 결정
			for(int i=0; i<row; i++){ 
				%>
				<tr>
			<%
				for(int j=0; j<col; j++){
					GoodsDTO dto = (GoodsDTO)goodsList.get(num);
					%>
					<td>
						<img src="./upload/<%=dto.getImage().split(",")[0] %>" width="120" height="120"><br>
 			  		 	<a href="./GoodsDetail.go?num=<%=dto.getNum()%>"><%=dto.getName() %></a><br>
		      			 <%=dto.getPrice() %>  <br>
					</td>
				<%	num++;
					if(size <= num) break;
				}
			 %>
			 </tr>
			 <%
			}
			
			
		
		%>
		
		
 		<%-- <tr>
 			<% for(int i=0; i<goodsList.size()/8; i++){ 
				GoodsDTO dto = (GoodsDTO)goodsList.get(i);
				%>
 			<td>
 			   <img src="./upload/<%=dto.getImage().split(",")[0] %>" width="120" height="120"><br>
 			   <%=dto.getName() %><br>
		       <%=dto.getPrice() %>  <br>
 			</td>
 			<% } %>
 		</tr> --%>
		

	</table>
</body>
</html>