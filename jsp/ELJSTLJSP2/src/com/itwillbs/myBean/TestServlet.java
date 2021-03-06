package com.itwillbs.myBean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
// HttpServlet : 추상클래스
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8088/ELJSTLJSP2/test.nhn
// @WebServlet("/test") : 어노테이션 - 특정 기능을 가지고 있는 표현을 나타내는 방식
// => 해당 주소가 실행되어을 때 해당 클래스를 실행한다


@WebServlet("/test")
public class TestServlet extends HttpServlet {
	// 서블릿 : jsp 코드의 표현을 java 코드로 구현한 것

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get 방식으로 전달되는 페이지에 대한 처리하는 메서드 
		System.out.println("doGet() 호출 !" );
		
		// java 코드로 html 화면에 출력
		/*PrintWriter out2 = resp.getWriter();
		out2.write("Hello~");
		out2.close();*/
		
		// 데이터 생성해서 페이지(/jstl/set2.jsp)로 전달하기
		String tel = "010-1234-7896";
		
		// 주소줄? form 태그? attribute 로 지정해주기!
		// 현재 페이지는 java 페이지기 때문에, Jsp 내장 객체는 없음
		// -> HttpServeletRequest req  객체 사용 (jsp-request 객체)
		// request 영역에 저장햇음!! 
		req.setAttribute("tel", tel);
		
		MemberDTO kim = new MemberDTO();
		kim.setUserName("김학생");
		kim.setUserGender("남");
		kim.setUserEmail("kjw5263@naver.com");
		
		// request 영역에 저장
		req.setAttribute("userInfo", kim);
		
		
		// 배열 만들어서 값 넘기기
		ArrayList memList = new ArrayList();
		memList.add(kim);
		
		req.setAttribute("memList", memList);
		
		
		
		
		
		
		/* forward 방식으로 페이지 이동 */
		// <jsp:forward> - 사용불가! : jsp 페이지에서만 사용가능
		
		// 아래 세 줄이 forward와 같은 역할!! 화면은 바뀌고 url은 그대로
		RequestDispatcher dis;
		dis = req.getRequestDispatcher("/jstl/core/set2.jsp");
		dis.forward(req, resp); // 저장한 request tel 이 담겨서 같이 간다 
		
	}
	
	
	
}	
