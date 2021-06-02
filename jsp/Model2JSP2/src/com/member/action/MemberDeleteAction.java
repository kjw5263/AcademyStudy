package com.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.db.MemberDAO;

public class MemberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M : MemberDeleteAction_execute() 호출 ");
		// 세션 제어
		// 세션 제어, update 에서 한글로 데이터 넘기므로 한글처리 
		HttpSession session = request.getSession();
	
		// 전달된 정보를 저장
		String id = (String)session.getAttribute("id");
		
		
		ActionForward forward = new ActionForward();
		if(id == null){
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		}
		// 전달되는 파라미터값 저장 (id,pass)
		// 비밀번호는 위에 id에서 받았으므로 비번만 받기
		String pass = request.getParameter("pass");
		
		// DAO 객채 생성 - deleteMember(id, pass)
		MemberDAO dao = new MemberDAO();
		int result = dao.deleteMember(id,pass);
		
		
		// 페이지 이동(0,1,-1) -> JS 사용
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(result == 0){
			out.print("<script>");
			out.print("alert('비밀번호 오류!');");
			out.print("history.back();");
			out.print("</script>");
			out.close();
			return null;
		}
		if(result == -1 ){
			out.print("<script>");
			out.print("alert('아이디 없음');");
			out.print("history.back();");
			out.print("</script>");
			out.close();
			return null;
		} 
		
		
		
		// result == 1일 때
		// 세션 초기화 하기 (로그인 정보 초기화_)
		session.invalidate();
		
		out.print("<script>");
		out.print("alert('탈퇴 완료!');");
		out.print("location.href='./Main.me';");
		out.print("</script>");
		out.close();
		return null;
	}
	
}
