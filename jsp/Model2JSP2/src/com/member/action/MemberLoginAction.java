package com.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.db.MemberDAO;

public class MemberLoginAction implements Action{
	// Actiond을 상속하면, execute 메소드를 반드시 오버라이딩 해야함
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M : MemberLoginAction_execute() 실행! ");
		
		// COntroller에서 보낸 request,response값들 !
		// 1. 전달된 값 저장하기 (id/pass)
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		// 2. DAO 객체 생성 -> idCheck(id, pass);
		MemberDAO mdao = new MemberDAO();
		int check = mdao.idCheck(id, pass);
		
		// 3. 결과에 따른 페이지 이동
		// 컨트롤러로 가는 것 (로그인 성공-> 다음페이지)
		// => 컨트롤러에는 가지만 페이지 이동 X
		// 컨트롤러로 안가는 것 (로그인 실패 -> 이전 페이지) : 비번오류, 아디없음(js)
		
		
		if(check == 0){ // 비밀번호 오류 - 페이지 뒤로가기
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('비밀번호가 일치하지 않습니다.');");
			out.print("history.back();");
			out.print("</script>");

			out.close();
			return null;
		} else if(check == -1){
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('아이디가 존재하지 않습니다.');");
			out.print("history.back();");
			out.print("</script>");
			
			out.close();
			return null;
		}
		
		
		// 컨드롤러 O - 로그인 성공
		// check == 0
		// -> main 페이지로 이동
		
		// 아이디 정보를 session객체에 저장
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		
		// 페이지 이동 (./Main.me )
		ActionForward forward = new ActionForward();
		forward.setPath("./Main.me");
		forward.setRedirect(true);
		
		return forward;
	}
	 
	
}

