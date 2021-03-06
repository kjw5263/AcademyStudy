package com.member.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.db.MemberDAO;
import com.member.db.MemberDTO;

public class MemberUpdateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberUpdateAction_execute() 호출!");
		
		// 세션 정보 제어
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		// Forward  객체 생성 && 세션 제어
		ActionForward forward = new ActionForward();
		
		if(id == null){
			System.out.println("M : MemberUpdateAction 로그인 세션 만료");
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true); // url 바뀌어야 하므로 
			return forward;
		}
		
		
		// DAO 객체 생성 - getMember(id)
		MemberDAO mdao = new MemberDAO();
		MemberDTO mdto = mdao.getMember(id);
		
		// DB 에서 가져온 정보를 request 영역에 저장
		request.setAttribute("mdto", mdto);
		
		// view 페이지로 이동 (./member/updateForm.jsp);
		forward.setPath("./member/updateForm.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
	
}
