package com.itwillbs.myServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test3")
public class TestServlet3 extends HttpServlet {
	
	// 이거 안해주면 405 에러남!
	// alt+shift+s+v
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/test3 호출!");
		
	
		Person kim = new Person();
		kim.setName("김지원");
		
		Dog dog = new Dog();
		dog.setDogName("뽀삐");
		kim.setDog(dog);
		
		
		request.setAttribute("kim", kim);
		// forward 방식 페이지 이동->url은 그대로지만,화면만 변경
		RequestDispatcher dis = request.getRequestDispatcher("/el/BeanTest.jsp");
		dis.forward(request, response);
		
		
	}
}
