package com.member.action;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.member.db.MemberDAO;
import com.member.db.MemberDTO;

public class MemberUpdateProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M : MemberUpdateProAction_execute 호출 ");
		
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
		
		
		request.setCharacterEncoding("UTF-8");
		// DAO 생성 -> updateMember(DTO);
		MemberDTO mdto = new MemberDTO();	// 수정할 정보를 담고있는 객체
		mdto.setAge(Integer.parseInt(request.getParameter("age")));
		mdto.setEmail(request.getParameter("email"));
		mdto.setGender(request.getParameter("gender"));
		mdto.setId(request.getParameter("id"));
		mdto.setName(request.getParameter("name"));
		mdto.setPass(request.getParameter("pass"));
		
		
		System.out.println(mdto.toString());
		MemberDAO mdao = new MemberDAO();
		
		int result = mdao.UpdateMember(mdto);
		// 수정 결과에 따른 페이지 이동 (0: 비밀번호 오류, 1: 정상, -1:아이디없음)
		// => 자바 스크립트 사용하여 이동할 것
		
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
		out.print("<script>");
		out.print("alert('정보 수정완료!');");
		out.print("location.href='./Main.me';");
		out.print("</script>");
		out.close();
		return null;
		
	}
	

}
