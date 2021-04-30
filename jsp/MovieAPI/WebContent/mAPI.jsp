<%@page import="com.movie.boxOffice.DailyBoxOffice"%>
<%@page import="java.util.List"%>
<%@page import="com.movie.boxOffice.DailyTopTen"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<!-- 

	<style>
		/* 헤더 영역 : id속성값이(#) header인 아래쪽 <div> 태그 선언하여 스타일 적용 */
		#header{
			background-color : #78b563;
			height : 200px;
			margin-bottom : 20px;
		}
		
		/* 네비 영역 */
		#nav {
			background-color : #eee;
			height : 50px;
			margin-bottom : 20px;
		}
		
		/* content영역 */
		#content {
			background-color : #eee;
			margin-top : 30px;
			margin-bottom : 50px;
		}
		
		/* footer 영역 : 홈페이지 가장 하단 영역 - 회사 정보 등) */
		#footer {
			background-color : #96b58b;
			height : 150px;
		}
	
	</style>
 -->
</head>
<body>

<!-- 
 <div id="header">header</div>
 
 <div id="nav">nav</div>
 
 <div id="content">
 	<div class="section">section</div>
 	<div class="article">article</div>
 	<div class="aside">aside</div>
 </div>
 
 
 <div id="footer"> footer</div>
 -->


<%

	String targetDt = request.getParameter("targetDt")==null?"20120101":request.getParameter("targetDt");
	String itemPerPage = request.getParameter("itemPerPage")==null?"10":request.getParameter("itemPerPage");
	String multiMovieYn = request.getParameter("multiMovieYn")==null?"":request.getParameter("multiMovieYn");
	String repNationCd = request.getParameter("repNationCd")==null?"":request.getParameter("repNationCd");
	String wideAreaCd = request.getParameter("wideAreaCd")==null?"":request.getParameter("wideAreaCd");


	String key = "7ff8dbacefec6686b5f297822ffc7c5b";
	KobisOpenAPIRestService service = new KobisOpenAPIRestService(key);
	
	String dailyResponse = service.getDailyBoxOffice(true, targetDt, itemPerPage, multiMovieYn, repNationCd, wideAreaCd);

	Gson gsonDaily = new Gson();
	DailyTopTen dailytt = gsonDaily.fromJson(dailyResponse, DailyTopTen.class);
	
	for(int i=0; i<dailytt.getBoxOfficeResult().getDailyBoxOfficeList().size(); i++){
		%>
		
		<%=dailytt.getBoxOfficeResult().getDailyBoxOfficeList().get(i).getMovieNm() %><br>
		
		<%
	}
		
	
	
	/* ObjectMapper mapper = new ObjectMapper();
	HashMap<String, Object> dailyResult = mapper.readValue(dailyResponse, HashMap.class);
	request.setAttribute("dailyResult", dailyResult);
	System.out.println("---------------------------------");
	System.out.println(request.getAttribute("dailyResult"));
	
	
	String codeResponse = service.getComCodeList(true, "0105000000");
	HashMap<String, Object> codeResult = mapper.readValue(codeResponse, HashMap.class);
	request.setAttribute("codeResult", codeResult);
	System.out.println("================================");
	System.out.println(request.getAttribute("codeResult"));
	 */
	
	
	
	
%>
 
 
 
 
 
</body>
</html>