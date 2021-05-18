package com.itwillbs.myServlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get 방식 출력했습니다!!!");
		
		// request 객체에 정보 저장
		String[] subjects = {"java", "jsp", "python", "DB", "WEB"};
		request.setAttribute("subjects", subjects);
		
		// 형태를 지정하지 않고, 사용할 때 타입을 정해주면
		// 지정할 수 있는 데이터 타입의 유형을 월등히 줄여준다
		ArrayList<String> movie = new ArrayList<>();
		movie.add("어벤져스");
		movie.add("겨울왕국");
		movie.add("아이언맨");
		movie.add("토르");
		movie.add("헐크");
		
		request.setAttribute("movie", movie);
		
		// forward방식으로 페이지 처리 -> url은 그대로지만, 화면만 바뀜
		// array_collection.jsp 페이지 이동
		RequestDispatcher dis = request.getRequestDispatcher("el/array_collection.jsp");
		dis.forward(request, response);
	}
}
