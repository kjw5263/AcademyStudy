package com.itwillbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet1 extends HttpServlet{
	private int cnt = 0;
	
	
	
	// 페이지에 방문한 방문자수 카운트 서블릿 페이지
	// 페이지 매핑이 안되어있으면 404 에러가 뜬다! -> web.xml 편집
	@Override
	public void init() throws ServletException {
		System.out.println("서블릿 초기화");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get방식 호출 처리");
		cnt++;
		
		// 웹 페이지 구성하기
		resp.setContentType("text/html; charset=utf-8");
		
		// 글쓰는 통로 : OutputStream을 만들어준것과 같음!
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>테스트</title></head>");
		out.println("<body>");
		out.println("<h1>방문자수 : "+cnt+"명 </h1>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost 방식 호출 처리");
	}

	@Override
	public void destroy() {
		System.out.println("서블릿 소멸시 실행~");
	}

	

	
}
