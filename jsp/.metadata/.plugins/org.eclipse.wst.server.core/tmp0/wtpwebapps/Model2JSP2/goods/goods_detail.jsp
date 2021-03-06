<%@page import="com.admin.goods.db.GoodsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function isBasket() {
		if(document.gfr.amount.value == ""){
			alert(" 구매 수량을 입력하세요. ");
			document.gfr.amount.focus();
			return;
		}
		
		if(document.gfr.size.value==""){
			alert(" 크기를 선택해주세요. ");
			document.gfr.size.focus();
			return;
		}
		
		if(document.gfr.color.value==""){
			alert(" 색상을 선택해주세요. ");
			document.gfr.color.focus();
			return; 
		}
		
		
		var result = confirm("장바구니에 저장하시겠습니까?");
		
		if(result){
			document.gfr.action = "./BasketAdd.ba";
			document.gfr.submit();
		}
	}



</script>
</head>
<body>
	<h1>WebContent/goods/goods_detail.jsp</h1>
	
	<h2> 상품 상세 페이지 </h2>
	
	<%
		// 이전 페이지 -> detailAction.java에서 저장한 attr 값 가져오기
		GoodsDTO dto = (GoodsDTO)request.getAttribute("goods");
	
	
	%>
	<form action="" method="post" name="gfr">
	<!-- 다음 페이지로 전달하는 값
		num, amount, size, color
	 -->
	<input type="hidden" name="num" value="${goods.num }">
	<table border="1">
		<tr>
			<td width="500"><img src="./upload/<%=dto.getImage().split(",")[0]%>" height="400" width="400"></td>
			<td width="500">
			상품명 : <%=dto.getName() %><br>
			판매가 : <%=dto.getPrice() %>원<br>
			구매수량 : <input type="number" name="amount" value="1"><br>
			남은수량 : <%=dto.getAmount() %><br>
			<%-- 옵션-크기 : <%=dto.getSize() %><br> --%>
			옵션-크기 : 
			<select name="size">
				<option value="">크기를 선택하세요.</option>	<!-- JSTL 사용하기!! -> 라이브러리 사용필요 -->
				<c:forTokens var="size" items="${goods.size }" delims=","> <!-- el 표현식은 영역 객체를 바로 불러오기 때문에 attr의 goods를 가져옴 -->
					<option value="${size }">${size }</option>
				</c:forTokens>
			</select> <br>
			<%-- 옵션-색상: <%=dto.getColor() %><br> --%>
			옵션-색상 : 
			<select name="color">
				<option value="">색상을 선택하세요.</option>	<!-- JSTL 사용하기!! -> 라이브러리 사용필요 -->
				<c:forTokens var="color" items="${goods.color }" delims=","> <!-- el 표현식은 영역 객체를 바로 불러오기 때문에 attr의 goods를 가져옴 -->
					<option value="${color }">${color }</option>
				</c:forTokens>
			</select><br>
			<hr>
			<a href="javascript:isBasket();">장바구니 담기</a> <!--a태그에서 js실행하기  -->
			<a href="javascript:isBuy();">주문하기</a>
			
			</td>
		</tr>
		<tr>
			<td colspan="2" height="700">
			<h3> 제품 상세 이미지 </h3>
				<img src="./upload/<%=dto.getImage().split(",")[1] %>">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<h2>QnA/리뷰</h2>
			</td>
		</tr>
	</table>
	
	
	</form>
	
</body>
</html>