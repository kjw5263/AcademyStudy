<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>WebContent/fileupload/file_down.jsp </h1>
 
 
 <!-- 파일 다운로드 하려면? 1.서버에 저장된 파일 저장폴더를 접근해서, 2.파일을 찾아 꺼내와서, 3.화면에 download로 나타내주기 -->
 
 <%
 	// 파라미터값 저장 (filename)
 	String filename = request.getParameter("filename");
 
 	// 서버에 업로드 된 파일명생성 -> 실제 경로 필요해요
 	
 	// 업로드한 가상 경로
 	String savePath = "upload";
 	
 	// 파일이 업로드 된 경로
 	ServletContext ctx = getServletContext();
 	String sDownloadPath = ctx.getRealPath(savePath);
 	// 서블릿 컨텍스트가 뭔데? 쉽게말하면, 프로젝트 정보
 			
 			
 	System.out.println("upload 폴더의 실제 주소(서버 안에 있는 실제 주소 ) " + sDownloadPath);
 	
 	// 서버에 업로드된 파일명 생성
 	String sFilePath = sDownloadPath + "\\" + filename;
 	
 	System.out.println("다운로드할 파일 주소 : " + sFilePath);
 	
 	////////////////////////////////////////////////////
 	// * 자바/웹 파일을 업로드, 다운로드 시 파일의 확장자는 중요하지 않음
 	//	=> 스트림으로 데이터를 주고받기 때문에 => 해당 파일을 웹에서 표현하는 방식: MIME타입
 	
 	// 파일 업로드 
 	
 	// 파일을 한번에 읽고 쓰기 하는 배열 (버퍼)
 	byte[] b = new byte[4096];
 	
 	// 파일 입력 스트림 객체 ( 서버에 저장된 파일을 불러오기 )- 파일에 가져오는 것도 Input 
 	FileInputStream fis = new FileInputStream(sFilePath);
 	
 	// 다운로드할 파일의 MIME 타입을 가져오기
 	// * MIME 타입 : 클라이언트에게 전성된 문서의 다양성을 표현하기 위한 메커니즘
 	String sMimeType = getServletContext().getMimeType(sFilePath);
 	
 	//
 	System.out.println("sMimeType= >> " + sMimeType);
 	
 	
 	
 	// Mime 타입이 없을 경우 기본값으로 지정
 	if(sMimeType == null){
 		sMimeType = "application/octet-stream";
 	}
 	
 	
 	// 응답할 페이지에 MIME 타입을 지정 (jsp MIME 타입 -> 다운로드 파일 MIME 타입으로 변경)
 	response.setContentType(sMimeType);
 	
 	
 	///////////////// * 사용자의 브라우저를 확인 (IE 여부) /////////////////////////
 	// ie : 다운로드 시 한글파일의 이름이 깨짐, 공백문자가 "+" => 파일 처리
 	// 
 	
 	String agent = request.getHeader("User-Agent");
 	
 	System.out.println("사용자 정보 : " + agent);
 	
 	// 사용자 정보안에 "MSIE", "Trident" 둘 중 하나라도 있을 경우
 	boolean ieBrowser = (agent.indexOf("MSIE")>-1 || agent.indexOf("Trident")>-1);
 	
 	
 	// IE 브라우저 일때, 한글이 깨지므로 인코딩 해주기, 웹에서 공백 표시 (%20)
 	if(ieBrowser){
 		filename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");  
 	} else {
 		// 모든 브라우저들 한글 깨짐 방지 (인코딩 방식 변경)
 		filename = new String(filename.getBytes("UTF-8"), "iso-8859-1");
 		
 	}
 	
 	
 	
 	
 	
 	///////////////////////////////////////////////////
 	// 모든 파일이 다운로드 형태로 처리되도록 설정
 	// => 브라우저에서 해석되는 파일도 다운로드처럼 처리하기 위한 설정
 	// "Content-Disposition", "attachment;" => 파일 다운로드 설정
 	response.setHeader("Content-Disposition", "attachment; filename= " + filename);
 	
 	
 	// 다운로드
 	ServletOutputStream out2 = response.getOutputStream();   // 여기는 jsp, out이라는 객체가 있어서중복!
 	
 	int numRead;
 	
 	
 	// -1은 파일의 끝 (입력의 끝 )
 	while((numRead = fis.read(b,0,b.length)) != -1) {
 		out2.write(b, 0, numRead);
 	}
 	out2.flush();	// 버퍼의 빈 공백을 채워서 데이터 전달하는 방법
 	out2.close();
 	fis.close();
 	
 	
 	
 	
 	
 	
 	
 	
 	
 
 %>
</body>
</html>