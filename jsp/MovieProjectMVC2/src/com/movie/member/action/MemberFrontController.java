package com.movie.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8088/MovieProjectMVC2/*.me
public class MemberFrontController extends HttpServlet{

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" >>> doProcess() 호출");
		
		/**************************** 1. 페이지 주소 파싱 *****************************/
		// 0. 전체 URI 주소 받기
		String requestURI = request.getRequestURI();
		//System.out.println("[MemberFrontController] URI >>> " + requestURI);
		//String requestURL = request.getRequestURL().toString();
		//System.out.println("URL >> " + requestURL);
		
		// 1. 프로젝트명 받아오기
		String contextPath = request.getContextPath();
		System.out.println("[MemberFrontController] 프로젝트 >>> " + contextPath);
		
		// 2. 가상주소 얻기
		String command = requestURI.substring(contextPath.length());
		System.out.println("[MemberFrontController] 가상주소 >>> " + command);
		
		/* 
		 * URI 주소 : /MovieProjectMVC2/*.me
		 * 프로젝트 : /MovieProjectMVC2
		 * 가상주소 : /*.me
		 */
		
		/**************************** 1. 페이지 주소 파싱 *****************************/
		
		
		
		/**************************** 2. 페이지 주소 매핑(연결) *****************************/
		
		
		/**************************** 2. 페이지 주소 매핑(연결) *****************************/
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("[MemberFrontController] doGet() 접속");
		doProcess(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("[MemberFrontController] doPost() 접속");
		doProcess(request,response);
	}
	
	
	
	
}
