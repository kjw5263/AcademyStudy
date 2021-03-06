package com.itwillbs.myServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// http://localhost:8088/ELJSTLJSP2/test1
public class TestServlet1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 이름을 request,response로 바꿈 -> jsp 에서 사용했던 그 객체들과 같은 것임!
		System.out.println("get방식 호출 발생!");
		
		/******* request 객체로 데이터 전달  ******/
		// request 영역에 속성을 저장
		request.setAttribute("cnt", 100);
		//request.setAttribute("cnt", new Integer(100));
		
		
		/******* session 객체로 데이터 전달  ******/
		// session 영역에 속성을 저장하기
 		// session.setAttribute --> 여긴 java라서 jsp 세션 설정 못해줌!-> 세션 객체 만들어야함
		HttpSession session = request.getSession();
		session.setAttribute("cnt", 200);
		
		
		
		// ** 내가 주소를 치면, web.xml이 먼저 실행된다!
		
		// 화면에 표시될 view 페이지 연결-forward 방식 (request,session, application)
		// -> jsp 페이지를 직접 실행하는게 아닌, 간접적으로 실행 함
		RequestDispatcher dis = request.getRequestDispatcher("el/AttributeTest.jsp");
		
		dis.forward(request, response);
	}
	
}
