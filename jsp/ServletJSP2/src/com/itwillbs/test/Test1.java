package com.itwillbs.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test1 extends HttpServlet{
	
	
	@Override
	public void init() throws ServletException {
		System.out.println("init() 메소드 실행!");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet() 메소드 실행!");
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost() 메소드 실행");
		
		// 웹 페이지 구성하기
		resp.setContentType("text/html; charset=utf-8");
		
		// 글쓰는 통로 : OutputStream을 만들어준것과 같음!
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>테스트</title></head>");
		out.println("<body>");
		out.println("<h1>JavaResource/Test1.java...안녕!</h1>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

	/*@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("service() 메소드 실행");
	}*/

	
	
	@Override
	public void destroy() {
		System.out.println("destroy() 메소드 실행");
	}

	
	
	
	
}
